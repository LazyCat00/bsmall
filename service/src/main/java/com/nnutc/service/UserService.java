package com.nnutc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nnutc.common.vo.UserQueryVo;
import com.nnutc.entity.User;

/**
 * @author admin
 */
public interface UserService extends IService<User> {

//    条件分页查询
    IPage<User> selectPage(Page<User> pageParam, UserQueryVo userQueryVo);
}
