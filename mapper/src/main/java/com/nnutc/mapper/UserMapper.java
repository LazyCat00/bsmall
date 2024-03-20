package com.nnutc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nnutc.common.vo.UserQueryVo;
import com.nnutc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @author admin
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
//    条件分页查询
    IPage<User> selectPage(Page<User> pageParam,@Param("vo") UserQueryVo userQueryVo);
}
