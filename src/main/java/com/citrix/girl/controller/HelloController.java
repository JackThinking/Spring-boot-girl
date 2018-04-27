package com.citrix.girl.controller;

import com.citrix.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;
//    @RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
//    public String say(@PathVariable("id") Integer id){
//        return "id" + id;
//    }

//    @RequestMapping(value = "/say/",method = RequestMethod.GET)
    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myid){
        return "id" + myid;
//        return girlProperties.getCupSize();
    }
}
