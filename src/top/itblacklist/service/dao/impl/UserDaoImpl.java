package top.itblacklist.service.dao.impl;

import top.itblacklist.service.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

    @Override
    public void save() {
        System.out.printf("我保存了");
    }
}