package com.nnutc.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nnutc.common.vo.UserQueryVo;
import com.nnutc.entity.User;
import com.nnutc.mapper.UserMapper;
import com.nnutc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public IPage<User> selectPage(Page<User> pageParam, UserQueryVo userQueryVo) {
        IPage<User> pageModel = baseMapper.selectPage(pageParam, userQueryVo);
        return pageModel;
    }
}
