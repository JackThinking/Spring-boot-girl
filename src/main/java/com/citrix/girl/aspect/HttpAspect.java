package com.citrix.girl.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HttpAspect {
//这边有代码冗余
   /* @Before("execution(public * com.citrix.girl.controller.GirlController.*(..))")
    public void log(){
        System.out.println(11111111);
    }*/
    @Pointcut("execution(public * com.citrix.girl.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void doBefore(){
        System.out.println(11111111);
    }

    @After("log()")
    public void doAfter(){
        System.out.println(22222222);
    }
}
