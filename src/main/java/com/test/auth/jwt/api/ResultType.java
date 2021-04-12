package com.test.auth.jwt.api;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 09:58
 * @description:
 **/
public enum  ResultType {

    SUCCESS(200, "操作成功"),
    FAILED(500, "无效的操作"),
    VALIDATE_FAILD(401, "参数错误");

    long code;
    String message;

    ResultType(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
    