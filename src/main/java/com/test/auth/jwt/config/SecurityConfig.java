package com.test.auth.jwt.config;

import com.test.auth.jwt.entity.security.BasicUserDetailsService;
import com.test.auth.jwt.entity.security.JWTTokenFilter;
import com.test.auth.jwt.entity.security.JWTTokenProvider;
import com.test.auth.jwt.utils.JWTTokenUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 11:25
 * @description:
 **/
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(jwtTokenProvider())
                .userDetailsService(basicUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        // 禁用掉session
        http .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public JWTTokenUtil jwtTokenUtil() {
        return new JWTTokenUtil();
    }

    @Bean
    public JWTTokenProvider jwtTokenProvider() {
        return new JWTTokenProvider();
    }

    @Bean
    public BasicUserDetailsService basicUserDetailsService() {
        return new BasicUserDetailsService();
    }

    @Bean
    public JWTTokenFilter jwtTokenFilter() {
        return new JWTTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
    