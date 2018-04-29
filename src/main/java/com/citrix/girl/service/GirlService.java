package com.citrix.girl.service;

import com.citrix.girl.enums.ResultEnum;
import com.citrix.girl.exception.GirlException;
import com.citrix.girl.repository.GirlResponsitory;
import com.citrix.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlResponsitory girlResponsitory;
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlResponsitory.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(19);
        girlResponsitory.save(girlB);
    }

    
    public void getAge(Integer id) throws Exception{
        Girl girl = girlResponsitory.findById(id).get();
        Integer age = girl.getAge();
        if(age<10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }
        else if(age>10 && age<16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
