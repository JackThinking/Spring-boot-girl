package com.citrix.girl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

import java.util.List;

public interface GirlResponsitory extends JpaRepository<Girl,Integer>{
//    通过年龄来查询
    public List<Girl> findByAge(Integer age);

}
