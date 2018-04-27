package com.citrix.girl.repository;

import com.citrix.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlResponsitory extends JpaRepository<Girl,Integer>{
//    通过年龄来查询
    public List<Girl> findByAge(Integer age);

}
