package com.citrix.girl.util;

import javax.xml.transform.Result;

public class ResultUtil {
    public static com.citrix.girl.domain.Result success(Object object){
        com.citrix.girl.domain.Result result = new com.citrix.girl.domain.Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;

    }
    public static com.citrix.girl.domain.Result success(){
        return success(null);

    }
    public static com.citrix.girl.domain.Result error(Integer code,String msg){
        com.citrix.girl.domain.Result result = new com.citrix.girl.domain.Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
