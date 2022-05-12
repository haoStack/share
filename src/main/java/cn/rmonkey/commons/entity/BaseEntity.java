package cn.rmonkey.commons.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/12 14:51
 */
@Data
public abstract class BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    protected Long id;

    @TableField(value = "status", exist = true)
    //logical delete
    @TableLogic(value = "alive", delval = "destroy")
    protected String status;

    @TableField("created_time")
    protected Date createdTime;

    @TableField("modified_time")
    protected Date modifiedTime;

    @TableField("modified_by")
    protected Long modifiedBy;

    //when you use the update statement,this property will increment
    @TableField(value = "modifyTimes", exist = true, update = "%s+1")
    protected Integer modifyTimes;
}
