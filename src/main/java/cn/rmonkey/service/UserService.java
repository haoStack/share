package cn.rmonkey.service;

import cn.rmonkey.commons.response.RespResult;
import cn.rmonkey.entity.BlogUser;

import java.util.List;
import java.util.Map;

/**
 * @Author Zhaozihao (Zack)
 * @Description
 * @date 2022/5/12 16:04
 */
public interface UserService {
    /**
     * 根据openid 查询用户
     * @param openid
     * @return
     */
    BlogUser findUserByOpenid(String openid);

    /**
     * 查询符合条件的用户
     * @param conditions
     * @return
     */
    RespResult findUserList(Map<String, Object> conditions);

    /**
     * 注册用户
     * @param user
     * @return
     */
    RespResult insertUser(BlogUser user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    RespResult updateUser(BlogUser user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    RespResult deleteUser(BlogUser user);
}
