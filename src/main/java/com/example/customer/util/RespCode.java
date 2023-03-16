package com.example.customer.util;

/**
* @Description: 返回code的封装
* @author FJJ
*/
public enum RespCode {
    SUCCESS(20000, "操作成功"),
    ERROR(50000, "操作失败");
    private Integer code;
    private String message;

    RespCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
