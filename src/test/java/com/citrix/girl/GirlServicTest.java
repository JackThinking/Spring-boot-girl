package com.citrix.girl;

import com.citrix.girl.domain.Girl;
import com.citrix.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by Citrix on 2018/4/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServicTest {

    @Autowired
    private GirlService girlService;


    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(17);
        Assert.assertEquals(new Integer(22),girl.getAge());
    }
}
