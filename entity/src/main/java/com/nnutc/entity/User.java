package com.nnutc.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigInteger;


/**
 * @author admin
 */
@Data
@TableName("t_user")
public class User extends BaseEntity{
//    private static final long serialVersionUID = 1L;
//  MyBatis Plus 提供的一个注解，用于指定实体类的主键生成策略。
//  IdType.AUTO 表示使用数据库自增主键的方式来生成主键值。
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("username")
    private String userName;
    @TableField("password")
    private String passWord;
    private String email;

}
