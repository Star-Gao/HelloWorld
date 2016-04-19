package com.test.dao.base;
/**
 * 通用的DAO
 */
public interface BaseDao {
    
    /**
     * 持久化实体
     * @param entity
     */
    void save(Object entity);
    
    /**
     * 根据主键查询实体
     * @param <T>
     * @param clazz  实体类
     * @param id     主键
     * @return
     */
    <T> T getById(Class<T> clazz,Object id);
}