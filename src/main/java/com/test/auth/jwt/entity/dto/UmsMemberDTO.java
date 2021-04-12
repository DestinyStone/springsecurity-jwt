package com.test.auth.jwt.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 10:20
 * @description:
 **/
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsMemberDTO {
    private String id;

    @NotBlank
    private String username;
    private String nickName;
    private String phone;
    private String email;
    private String headPortraitUrl;
}
    