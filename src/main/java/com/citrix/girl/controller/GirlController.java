package com.citrix.girl.controller;

import com.citrix.girl.aspect.HttpAspect;
import com.citrix.girl.domain.Girl;
import com.citrix.girl.domain.Result;
import com.citrix.girl.repository.GirlResponsitory;
import com.citrix.girl.service.GirlService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlResponsitory girlResponsitory;
    @Autowired
    private GirlService girlService;
    /*
    * 查询女生列表
    * @return
    * */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlResponsitory.findAll();
    }
    /*
    * 添加一个女生
    * */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
//                          @RequestParam("age") Integer age) {

        //Girl girl = new Girl();
        if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(girlResponsitory.save(girl));
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());
        return result;
    }
    /*
    * 查询一个女生
    * */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){

        return girlResponsitory.findById(id).get();
    }
    /*
    * 更新一个女生
    * */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age
                           ){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlResponsitory.save(girl);
    }
    /*
    * 删除一个女生
    * */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlResponsitory.deleteById(id);
    }
    /*
    * 根据年龄来查找女生列表
    * */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlResponsitory.findByAge(age);
    }
    /*
    *
    * */
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
}


