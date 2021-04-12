package com.test.auth.jwt.controller;

import com.test.auth.jwt.api.CommonResult;
import com.test.auth.jwt.api.Result;
import com.test.auth.jwt.entity.properties.JWTTokenProperties;
import com.test.auth.jwt.entity.security.BasicUserDetails;
import com.test.auth.jwt.utils.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 15:12
 * @description:
 **/

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProperties jwtTokenProperties;

    @GetMapping("/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        String jwtToken = JWTTokenUtil.generateToken((UserDetails) authenticate.getPrincipal());
        System.out.println(jwtTokenProperties.getHeader() + " " + jwtToken);
        response.addHeader(jwtTokenProperties.getHead(), jwtTokenProperties.getHeader() + " " + jwtToken);
        return Result.success();
    }

    @GetMapping("/loginStatus")
    public Result loginStatus(@AuthenticationPrincipal BasicUserDetails userDetails) {
        return CommonResult.success(userDetails.getUmsMemberDTO());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/getResource")
    public Result getResource() {
        return CommonResult.success((Object)"333");
    }

    @PreAuthorize("hasAnyRole('role')")
    @GetMapping("/getRoleResource")
    public Result getRoleResource() {
        return CommonResult.success((Object)"role_333");
    }

}
    