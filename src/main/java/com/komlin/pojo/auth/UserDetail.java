package com.komlin.pojo.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author : JoeTao
 * createAt: 2018/9/14
 */
public class UserDetail implements UserDetails {
    private long id;
    private String mobile;
    private String password;
    private Boolean isSuper;
    private String role;
    private Date lastPasswordResetDate;

    public UserDetail(
            long id,
            String mobile,
            String role,
            String password) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.role = role;
    }

    public UserDetail(String mobile, String password, String role) {
        this.mobile = mobile;
        this.password = password;
        this.role = role;
    }

    public UserDetail(long id, String mobile, String password) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
    }

    public UserDetail(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public UserDetail(long id, String mobile, String password, Boolean isSuper) {
        this.id = id;
        this.mobile = mobile;
        this.password = password;
        this.isSuper = isSuper;
    }

    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return mobile;
    }

    /**
     * 账户是否未过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否未锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否激活
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Boolean getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(Boolean aSuper) {
        isSuper = aSuper;
    }
}
