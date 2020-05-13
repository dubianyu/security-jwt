package com.komlin.service.impl;

import com.google.common.collect.Lists;
import com.komlin.entity.SysUser;
import com.komlin.entity.SysUserRole;
import com.komlin.exception.CustomException;
import com.komlin.jwt.JwtUtils;
import com.komlin.mapper.SysUserMapper;
import com.komlin.mapper.SysUserRoleMapper;
import com.komlin.pojo.ResultCode;
import com.komlin.pojo.ResultJson;
import com.komlin.pojo.auth.ResponseUserToken;
import com.komlin.pojo.auth.Role;
import com.komlin.pojo.auth.UserDetail;
import com.komlin.service.SysUserRoleService;
import com.komlin.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yb123
 * @since 2020-05-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Qualifier("CustomUserDetailsService")
    @Autowired
    private  UserDetailsService userDetailsService;
    @Autowired
    private JwtUtils jwtTokenUtil;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Override
    public SysUser getUserByMobile(String mobile) {
        SysUser sysUser = new SysUser();
        sysUser.setMobile(mobile);
        return baseMapper.selectOne(sysUser);
    }

    @Override
    public ResponseUserToken login(String mobile, String password) {
        //用户验证
        final Authentication authentication = authenticate(mobile, password);
        //存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //生成token
        final UserDetail userDetail = (UserDetail) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateAccessToken(userDetail);
        //存储token
        jwtTokenUtil.putToken(mobile, token);
        return new ResponseUserToken(token, userDetail);
    }

    @Override
    @Transactional
    public UserDetail register(UserDetail userDetail) {
        final String username = userDetail.getUsername();
        if(getUserByMobile(username)!=null) {
            throw new CustomException(ResultJson.failure(ResultCode.BAD_REQUEST, "用户已存在"));
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userDetail.getPassword();
        userDetail.setPassword(encoder.encode(rawPassword));
        userDetail.setLastPasswordResetDate(new Date());
        SysUser sysUser = new SysUser();
        sysUser.setMobile(username);
        sysUser.setPassword(encoder.encode(rawPassword));
        sysUser.setModifyTime(new Date());
        sysUser.setStatus(1);
        baseMapper.insert(sysUser);
        userDetail.setRole("user");
        return userDetail;
    }

    @Override
    public UserDetail getUserByToken(String token) {
        token = token.substring(tokenHead.length());
        return jwtTokenUtil.getUserFromToken(token);
    }

    private Authentication authenticate(String mobile, String password) {
        try {
            //该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mobile, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new CustomException(ResultJson.failure(ResultCode.LOGIN_ERROR, e.getMessage()));
        }
    }
}
