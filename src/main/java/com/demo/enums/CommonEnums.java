package com.demo.enums;

public enum CommonEnums {
    ERROR(500, "未知错误"),
    SUCCESS(200, "success"),
    NULL(404, "未查询到数据")
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {

        return code;
    }

    public String getMsg() {

        return msg;
    }

    CommonEnums(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }
}
