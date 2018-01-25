package com.demo.handle;

import com.demo.aspect.httpAspect;
import com.demo.enums.CommonEnums;
import com.demo.exception.CommonException;
import com.demo.utils.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(httpAspect.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult allExceptionHandle(Exception e) {

        if(e instanceof CommonException) {
            CommonException commonException = (CommonException) e;

            return CommonResult.error(commonException.getCode(), commonException.getMessage());
        } else {
            logger.info("【系统异常】:{}", e.toString());

            return CommonResult.error(CommonEnums.ERROR.getCode(), e.toString());
        }
    }

}
