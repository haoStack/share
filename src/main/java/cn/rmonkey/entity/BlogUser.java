package cn.rmonkey.entity;

import cn.rmonkey.commons.blogenum.BlogEnum;
import cn.rmonkey.commons.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/12 14:44
 */
@Alias("blogUser")
@Data
@NoArgsConstructor
@TableName("blog_user")
public class BlogUser extends BaseEntity {
    @TableField(value = "openid",exist = true)
    private String openid;

    //condition;if this property not null use the condition in where statement
    @TableField(value = "nickname",exist = true,condition = SqlCondition.LIKE)
    private String nickname;

    //whereStrategy; if you don't want to use this property to be a condition in where statements.
    //select; if you don't want to show the property ,please use this annotaion to avoid.
    @TableField(value = "pwd", exist = true ,whereStrategy = FieldStrategy.IGNORED,select = false)
    private String password;

    @TableField("head_img")
    private String headImg;

    @TableField("introduce")
    private String introduce;

    @TableField(value = "sex")
    private BlogEnum.SexEnum sex;
    //insertStrategy; if the property is not null,will be inserted,otherwise ,will not be inserted
    @TableField(value = "city", exist = true,insertStrategy = FieldStrategy.NOT_NULL)
    private String city;


}
