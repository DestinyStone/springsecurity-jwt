package com.test.auth.jwt.entity.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 14:53
 * @description:
 **/
@Configuration
@ConfigurationProperties(
        prefix = "jwt.token"
)
public class JWTTokenProperties {
    private String head = "authentication";
    private String header = "Bearer";
    private long expried = 604800L;
    private String secret = "11111111111111111111111111";

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public long getExpried() {
        return expried;
    }

    public void setExpried(long expried) {
        this.expried = expried;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
    