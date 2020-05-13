package com.komlin.service;

import com.komlin.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;
import com.komlin.pojo.auth.ResponseUserToken;
import com.komlin.pojo.auth.UserDetail;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yb123
 * @since 2020-05-07
 */
public interface SysUserService extends IService<SysUser> {

    SysUser getUserByMobile(String mobile);

    ResponseUserToken login(String mobile, String password);

    UserDetail register(UserDetail userDetail);

    UserDetail getUserByToken(String token);
}
