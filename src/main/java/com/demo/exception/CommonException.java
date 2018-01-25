package com.demo.exception;

import com.demo.enums.CommonEnums;

public class CommonException extends RuntimeException {

    private Integer code;

    public CommonException(CommonEnums commonEnums) {

        super(commonEnums.getMsg());
        this.code = commonEnums.getCode();
    }

    public Integer getCode() {

        return code;
    }

    public void setCode(Integer code) {

        this.code = code;
    }
}
