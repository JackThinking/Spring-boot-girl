package com.citrix.girl.exception;


import com.citrix.girl.enums.ResultEnum;

/**
 * Created by Citrix on 2018/4/29.
 */
//继承的是runtime的exception因为spring不会对一般的exception进行回滚
public class GirlException extends RuntimeException{
    private Integer code;


    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
