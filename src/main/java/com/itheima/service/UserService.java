package com.itheima.service;


import com.itheima.controller.Result;
import com.itheima.daomain.User;


import java.util.List;

public interface UserService {

    public Result save(User book);

    public boolean delete(Integer id);

    public boolean update(User book);

    public User getById(Integer id);

//    Book getById(String type);

    public List<User> getALl();

    public List<User> singName(Integer studentNum);
}
