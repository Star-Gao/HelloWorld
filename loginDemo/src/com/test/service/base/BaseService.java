package com.test.service.base;

/**
 * 通用业务接口
 */
public interface BaseService {
    
    /**
     * 保存实体
     * @param entity
     */
    void save(Object entity);
    
    /**
     * 根据主键获取对象
     * @param <T>
     * @param clazz 实体类
     * @param id    主键
     * @return
     */
    <T> T getById(Class<T> clazz,Object id);
}