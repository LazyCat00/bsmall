package com.nnutc.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nnutc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
//    查询所有
    @Test
    public void findAll(){
        List<User> list = userService.list();
        for (User user:list){
            System.out.println(user);
        }
    }
    //    添加
    @Test
    public void add(){
        User user = new User();
        user.setUserName("yummy");
        user.setPassWord("123456");
        user.setEmail("9533511@qq.com");
        userService.save(user);
    }
//    修改
@Test
public void update(){
    User user = userService.getById(10001);
    user.setPassWord("66666");
    boolean flag = userService.updateById(user);
    System.out.println(flag);
}

//删除
    @Test
public void remove(){
    boolean flag = userService.removeById(10001);
    System.out.println(flag);

}
//条件查询
    @Test
     public void select(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username","admin");
        List<User> list = userService.list(wrapper);
        System.out.println(list);
    }
}

