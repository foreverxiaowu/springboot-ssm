package com.itheima.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.controller.Result;
import com.itheima.daomain.User;
import com.itheima.daomain.UserInfo;

public interface UserInfoService extends IService<UserInfo> {

    Result saveInfo(User user);
}
