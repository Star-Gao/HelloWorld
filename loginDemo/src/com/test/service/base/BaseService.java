package com.test.service.base;

/**
 * ͨ��ҵ��ӿ�
 */
public interface BaseService {
    
    /**
     * ����ʵ��
     * @param entity
     */
    void save(Object entity);
    
    /**
     * ����������ȡ����
     * @param <T>
     * @param clazz ʵ����
     * @param id    ����
     * @return
     */
    <T> T getById(Class<T> clazz,Object id);
}