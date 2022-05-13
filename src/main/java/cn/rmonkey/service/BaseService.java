package cn.rmonkey.service;

import java.util.List;
import java.util.Map;

/**
 * @Author Zhaozihao (Zack)
 * @Descriptio
 * @date 2022/5/12 16:06
 */
public interface BaseService <T>{
    /**
     *
     * @param conditions
     * @return
     */
    T selectEntity(Map<String ,Object> conditions);

    /**
     *
     * @param conditions
     * @return
     */
    List<T> selectEntities(Map<String,Object> conditions);

    /**
     *
     * @param entity
     */
    void insertEntity(T entity);
}
