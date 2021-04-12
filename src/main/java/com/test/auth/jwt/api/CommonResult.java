package com.test.auth.jwt.api;

/**
 * @author: zhouxiaofeng
 * @create: 2021-04-12 10:02
 * @description:
 **/
public class CommonResult<T> extends Result {
    private T data;

    public CommonResult() {
        super();
    }

    public CommonResult(long code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultType.SUCCESS.code, ResultType.SUCCESS.message, data);
    }

    public static <T> CommonResult<T> success(String message, T data) {
        return new CommonResult<T>(ResultType.SUCCESS.code, message, data);
    }

    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<T>(ResultType.FAILED.code, ResultType.FAILED.message, data);
    }

    public static <T> CommonResult<T> failed(String message, T data) {
        return new CommonResult<T>(ResultType.FAILED.code, message, data);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
    