package com.nnutc.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @author admin
 */
@Data
public class BaseEntity {

    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableLogic
    @TableField("is_deleted")
//    逻辑删除
//    默认为0，未删除
//    1代表已经删除
    private Integer isDeleted;

}
