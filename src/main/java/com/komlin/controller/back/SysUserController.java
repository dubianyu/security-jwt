package com.komlin.controller.back;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.komlin.entity.SysUser;
import com.komlin.pojo.ResultCode;
import com.komlin.pojo.ResultJson;
import com.komlin.pojo.auth.ResponseUserToken;
import com.komlin.pojo.auth.User;
import com.komlin.pojo.auth.UserDetail;
import com.komlin.service.SysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yb123
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/api/back/user")
public class SysUserController {

    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private SysUserService sysUserService;


    @PostMapping(value = "/login")
    @ApiOperation(value = "登陆", notes = "登陆成功返回token,登陆之前请先注册账号")
    public ResultJson<ResponseUserToken> login(
            @Valid @RequestBody User user){
        final ResponseUserToken response = sysUserService.login(user.getMobile(), user.getPassword());
        return ResultJson.ok(response);
    }

    @PostMapping(value = "/sign")
    @ApiOperation(value = "用户注册")
    public ResultJson sign(@RequestBody User user) {
        if (StringUtils.isAnyBlank(user.getMobile(), user.getPassword())) {
            return ResultJson.failure(ResultCode.BAD_REQUEST);
        }
        UserDetail userDetail = new UserDetail(user.getMobile(), user.getPassword());
        return ResultJson.ok(sysUserService.register(userDetail));
    }

    @GetMapping(value = "/getUser")
    @ApiOperation(value = "根据token获取用户信息", notes = "根据token获取用户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    public ResultJson getUser(HttpServletRequest request){
        String token = request.getHeader(tokenHeader);
        if (token == null) {
            return ResultJson.failure(ResultCode.UNAUTHORIZED);
        }
        UserDetail userDetail = sysUserService.getUserByToken(token);
        return ResultJson.ok(userDetail);
    }

    @GetMapping(value = "/getUserList")
    @ApiOperation(value = "根据token获取用户信息", notes = "根据token获取用户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    public ResultJson getUserList(){
        PageHelper.startPage(1,8);
        List<SysUser> list= sysUserService.selectList(new EntityWrapper<>());

        return ResultJson.ok( new PageInfo<>(list));
    }
}

