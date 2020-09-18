package com.example.swagger2.util;



/**
 * 返回状态码枚举
 * @author LIFULIN
 * @className Constant
 * @description TODO
 * @date 2020/9/7-9:21
 */
public enum Constant {

    SUCCESS(200, "请求成功"),
    ERROR(201, "请求失败"),
    Unknown_Exception(520, "未知异常")
    ;


    /**
     * 状态码
     */
    private int code;


    /**
     * 提示消息
     */
    private String message;

    Constant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return 获取状态码
     */
    public int getCode() {
        return code;
    }

    /**
     * @return 获取提示信息
     */
    public String getMessage() {
        return message;
    }


}

