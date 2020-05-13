package com.komlin.mapper;

import com.komlin.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.komlin.pojo.auth.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 后台用户角色表 Mapper 接口
 * </p>
 *
 * @author yubin123
 * @since 2020-05-12
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<Role> getUserRoleByUserId(@Param("userId") Long userId);
}
