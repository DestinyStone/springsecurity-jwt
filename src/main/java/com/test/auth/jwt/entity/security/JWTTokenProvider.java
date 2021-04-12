package com.test.auth.jwt.entity.security;

import com.test.auth.jwt.utils.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 14:34
 * @description:
 **/
public class JWTTokenProvider implements AuthenticationProvider {

    @Autowired
    private BasicUserDetailsService basicUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 在jwt字符串中获取token
        Object jwtStr = authentication.getPrincipal();
        String username = JWTTokenUtil.getUserNameFromToken(jwtStr + "");
        if (username == null) {
            throw new BadCredentialsException("无效的jwt token");
        }
        // 获取userDetails对象
        UserDetails userDetails = basicUserDetailsService.loadUserByUsername(username);

        // 封装token
        JWTToken jwtToken = new JWTToken(userDetails, userDetails.getAuthorities());
        jwtToken.setDetails(userDetails);
        return jwtToken;
    }

    /**
     * @param authentication
     * @return true 调用 authenticate()
     */
    @Override
    public boolean supports(Class<?> authentication) {
        // 判断 传过来的是否属于JWTToken 或者是 JWTToken的一个子类
        return JWTToken.class.isAssignableFrom(authentication);
    }
}
    