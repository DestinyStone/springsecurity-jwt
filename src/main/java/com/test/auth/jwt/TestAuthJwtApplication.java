package com.test.auth.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 10:13
 * @description:
 **/
@SpringBootApplication
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TestAuthJwtApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestAuthJwtApplication.class, args);
    }
}
    