package top.itblacklist.service.service.impl;

import top.itblacklist.service.dao.IUserDao;
import top.itblacklist.service.service.IUserService;

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
