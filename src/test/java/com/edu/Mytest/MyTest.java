package com.edu.Mytest;

import com.pojo.User;
import com.service.user.Iuserservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ld on 2019/3/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MyTest {
    @Resource
    Iuserservice iuserservice;
    @Test
    public void test(){
        List<User> users=new ArrayList<>();
        for(int i=1;i<=100;i++){
            User user=new User();
            user.setLoginId("u"+i);
            user.setSex(1);
            user.setPhone("144"+i);
            user.setName("n"+i);
            user.setEmail("456"+i);
            user.setBirthday(new Date());
            user.setAddress("address"+i);
            user.setIsDel(1);
            user.setPassword("45"+i);
            users.add(user);
        }
        System.out.println(iuserservice.batch(users));
    }
}
