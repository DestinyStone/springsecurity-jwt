package com.test.auth.jwt.entity.security;

import com.test.auth.jwt.entity.properties.JWTTokenProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 14:52
 * @description:
 **/
public class JWTTokenFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProperties jwtTokenProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 从httpServletRequest中获取token
        String authentication = request.getHeader("authentication");

        // 不存在合法请求头 直接放行
        if (!StringUtils.startsWith(authentication, jwtTokenProperties.getHeader())) {
            filterChain.doFilter(request, response);
            return;
        }

        // 前面已近存在过滤器 导致用户已近登录了， 直接放行
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }

        // 存在jwt token 封装token进行提交登录
        JWTToken jwtToken = new JWTToken(authentication.substring(jwtTokenProperties.getHeader().length()));
        Authentication authenticate = authenticationManager.authenticate(jwtToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        filterChain.doFilter(request, response);
    }
}
    