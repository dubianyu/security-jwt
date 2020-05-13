package com.komlin.mapper;

import com.komlin.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.komlin.pojo.auth.UserDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yb123
 * @since 2020-05-07
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    UserDetail findUserByMobile(@Param("mobile") String mobile);
}
