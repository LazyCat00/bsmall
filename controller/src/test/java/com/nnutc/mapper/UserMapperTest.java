package com.nnutc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nnutc.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    //    添加操作
    @Test
    public void addUser() {
        User user = new User();
        user.setUserName("admin");
        user.setPassWord("123456");
        user.setEmail("9533511@qq.com");
//      Preparing: INSERT INTO t_user ( id, username, password, email ) VALUES ( ?, ?, ?, ? )
        int rows = userMapper.insert(user);
        System.out.println(rows);
    }

    //    id删除
    @Test
    public void deleteUser() {
//        UPDATE t_user SET is_deleted=1 WHERE id=? AND is_deleted=0
        int row = userMapper.deleteById(10001);
    }

    //    批量删除
    @Test
    public void BatchDelete() {
        int row = userMapper.deleteBatchIds(Arrays.asList(10001, 10002));
    }
    //    条件删除
    @Test
    public void ConditionDelete() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username","lost");
        int row = userMapper.delete(wrapper);
    }
    //    修改操作
    @Test
    public void updateUser() {
//        1.根据id查询

        User user = userMapper.selectById(10001);
        user.setUserName("dzl");
        int row = userMapper.updateById(user);
    }

    //    查询表所有记录
    @Test
    public void findAll() {
//      SELECT id,username,password,email,create_time,update_time,is_deleted FROM t_user WHERE is_deleted=0
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }

    }

    //    条件查询
    @Test
    public void testSelect() {
//        创建条件构造器对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        设置条件
        wrapper.eq("username", "lost");
//        SELECT id,username,password,email,create_time,update_time,is_deleted FROM t_user WHERE is_deleted=0 AND (username = ?)
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
    //    模糊查询
    @Test
    public void testFuzzySearch() {
//        创建条件构造器对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        设置条件
        wrapper.like("username", "ost");
//        Preparing: SELECT id,username,password,email,create_time,update_time,is_deleted FROM t_user WHERE is_deleted=0 AND (username LIKE ?)
//        ==> Parameters: %ost%(String)
        List<User> users = userMapper.selectList(wrapper);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
