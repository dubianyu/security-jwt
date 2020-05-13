package com.komlin.service.impl;

import com.komlin.mapper.AuthMapper;
import com.komlin.mapper.SysRoleMapper;
import com.komlin.mapper.SysUserMapper;
import com.komlin.pojo.auth.Role;
import com.komlin.pojo.auth.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 登陆身份认证
 *
 * @author: JoeTao
 * createAt: 2018/9/14
 */
@Component(value = "CustomUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    private final SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;


    public CustomUserDetailsServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public UserDetail loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDetail userDetail = sysUserMapper.findUserByMobile(name);
        if (userDetail == null) {
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", name));
        }
        if (userDetail.getIsSuper()) {
            userDetail.setRole("admin");
        }else {
            userDetail.setRole("user");
        }
        return userDetail;
    }
}
