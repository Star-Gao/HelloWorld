package com.test.dao.base;
/**
 * ͨ�õ�DAO
 */
public interface BaseDao {
    
    /**
     * �־û�ʵ��
     * @param entity
     */
    void save(Object entity);
    
    /**
     * ����������ѯʵ��
     * @param <T>
     * @param clazz  ʵ����
     * @param id     ����
     * @return
     */
    <T> T getById(Class<T> clazz,Object id);
}