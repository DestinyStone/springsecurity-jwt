package com.test.auth.jwt.entity.security;

import com.test.auth.jwt.entity.dto.UmsMemberDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 14:48
 * @description:
 **/
public class BasicUserDetails implements UserDetails {

    private UmsMemberDTO umsMemberDTO;
    private String password;
    private final Set<GrantedAuthority> authorities;

    public BasicUserDetails(UmsMemberDTO umsMemberDTO, String password, Set<GrantedAuthority> authorities) {
        this.umsMemberDTO = umsMemberDTO;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return umsMemberDTO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UmsMemberDTO getUmsMemberDTO() {
        return umsMemberDTO;
    }
}
    