package com.test.auth.jwt.entity.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 14:30
 * @description:
 **/
public class JWTToken extends AbstractAuthenticationToken {

    private Object principal;

    public JWTToken(Object principal) {
        super((Collection)null);
        this.principal = principal;
    }


    public JWTToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        // 设置用户已登录
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
    