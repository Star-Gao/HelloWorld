package com.test.service.privilege;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.ehcache.annotations.TriggersRemove;
import com.googlecode.ehcache.annotations.Cacheable;
import com.test.dao.privilege.UserDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * User Service Implement
 */

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserDao userDao;
    
    @Cacheable(cacheName="userCache")//»º´æÊý¾Ý
    public <T> T getById(Class<T> clazz, Object id) {
        return userDao.getById(clazz, id);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @TriggersRemove(cacheName="userCache",removeAll=true)//Çå³ý»º´æ
    public void save(Object entity) {
        userDao.save(entity);
    }
    
}