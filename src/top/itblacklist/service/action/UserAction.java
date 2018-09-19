package top.itblacklist.service.action;

import top.itblacklist.service.service.IUserService;

public class UserAction{
    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void save(){
        userService.save();
    }
}
