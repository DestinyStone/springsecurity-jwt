package com.test.auth.jwt.api;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 09:57
 * @description:
 **/
public class Result {
    private long code;
    private String message;

    public Result() {

    }

    public Result(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Result success() {
        return new Result(ResultType.SUCCESS.code, ResultType.SUCCESS.message);
    }

    public static Result success(String message) {
        return new Result(ResultType.SUCCESS.code, message);
    }

    public static Result failed() {
        return new Result(ResultType.FAILED.code, ResultType.FAILED.message);
    }

    public static Result failed(String message) {
        return new Result(ResultType.FAILED.code, message);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
    