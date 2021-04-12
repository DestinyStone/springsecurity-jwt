package com.test.auth.jwt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 12:11
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginParam {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
    