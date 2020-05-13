package com.komlin.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yubin123
 * @since 2020-05-12
 */
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户姓名--例如张三
     */
    @TableField("real_name")
    private String realName;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 登陆密码
     */
    private String password;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否超级管理员
     */
    @TableField("is_super")
    private Boolean isSuper;
    /**
     * 用户状态0删除1正常2禁用
     */
    private Integer status;
    /**
     * 身份证
     */
    @TableField("card_id")
    private String cardId;
    /**
     * 修改时间
     */
    @TableField("modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getSuper() {
        return isSuper;
    }

    public void setSuper(Boolean isSuper) {
        this.isSuper = isSuper;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        ", id=" + id +
        ", realName=" + realName +
        ", mobile=" + mobile +
        ", password=" + password +
        ", remark=" + remark +
        ", isSuper=" + isSuper +
        ", status=" + status +
        ", cardId=" + cardId +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
