package cn.rmonkey.service;

import cn.rmonkey.commons.response.RespResult;
import cn.rmonkey.entity.BlogUser;

import java.util.List;
import java.util.Map;

/**
 * @Author Zhaozihao (Zack)
 * @Descriptio
 * @date 2022/5/12 16:06
 */
public interface BaseService <T>{
    /**
     *根据条件查询用户
     * @param conditions
     * @return
     */
    T selectEntity(Map<String ,Object> conditions);

    /**
     *根据条件查询所有用户
     * @param conditions
     * @return
     */
    RespResult selectEntities(Map<String,Object> conditions);

    /**
     *注册用户
     * @param entity
     */
    RespResult insertEntity(T entity);

    /**
     * 更新用户
     * @param entity
     * @return
     */
    RespResult updateEntity(T entity);

    /**
     * 删除用户-软删除
     * @param entity
     * @return
     */
    RespResult deleteEntity(T entity);

}
