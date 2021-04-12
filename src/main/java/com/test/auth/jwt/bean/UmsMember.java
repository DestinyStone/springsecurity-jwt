package com.test.auth.jwt.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 10:09
 * @description:
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsMember {
    private String id;
    private String username;
    private String password;
    private String nickName;
    private String phone;
    private String email;
    private Integer resourceType;
    private String headPortraitUrl;

    public static UmsMember get() {
        return UmsMember.builder()
                .id("1")
                .username("destonystone")
                .password("$2a$10$PN1JS9kFv7F9mJaSH6HhB.MAg7rMAa78ptgZq07QmuURaJYItnUgW")
                .nickName("destinystone")
                .phone("18320565406")
                .email("2777679537@qq.com")
                .resourceType(0)
                .headPortraitUrl("url")
                .build();
    }
}
    