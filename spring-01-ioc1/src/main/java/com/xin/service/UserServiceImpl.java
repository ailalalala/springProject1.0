package com.xin.service;

import com.xin.dao.UserDao;
import com.xin.dao.UserDaoImpl;
import com.xin.dao.UserDaoMysqlImpl;
import com.xin.dao.UserDaoOracleImpl;

public class UserServiceImpl implements UserService{

    //方式比较死板，用户进行改变的时候需要繁琐的修改
//    private UserDao userDao = new UserDaoImpl();
//    private UserDao userDao = new UserDaoMysqlImpl();
//    private UserDao userDao = new UserDaoOracleImpl();
    private UserDao userDao;

    //利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
