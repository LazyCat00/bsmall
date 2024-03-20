package com.nnutc.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nnutc.common.Result;
import com.nnutc.common.vo.UserQueryVo;
import com.nnutc.entity.User;
import com.nnutc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //    查询所有的记录
    @GetMapping("findAll")
    public Result findAllUser() {
        List<User> list = userService.list();
        return Result.ok(list);
    }

    //    逻辑删除
    @DeleteMapping("remove/{id}")
    public Result removeUser(@PathVariable Long id) {
        boolean flag = userService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //    条件分页查询
    @GetMapping("{page}/{limit}")
    public Result findQueryUser(@PathVariable Long page, @PathVariable Long limit, UserQueryVo userQueryVo) {

//        创建Page对象
        Page<User> pageParam = new Page<>(page, limit);
        IPage<User> pageModel = userService.selectPage(pageParam, userQueryVo);
        return Result.ok(pageModel);
    }


    //    添加角色
//    RequestBody不能用get请求
    @PostMapping("save")
    public Result saveUser(@RequestBody User user) {
        boolean flag = userService.save(user);
        if (flag){
            return Result.ok();
        }else {
            return Result.fail();
        }

    }
}
