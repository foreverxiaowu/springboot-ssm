package com.itheima.serviceImpl;

import com.itheima.controller.Result;
import com.itheima.dao.USerDao;
//import com.itheima.daomain.Book;
import com.itheima.daomain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private USerDao USerDao;
    @Value("${file.upload-path}")
    private String pictureurl;
    @Override
    public Result save(User user) {
        final int save = USerDao.save(user);
        if (save>0){
            return new Result(20011,user);
        }else
            return new Result(555,null,"保存失败");


    }

    @Override
    public boolean delete(Integer id) {
        return USerDao.delete(id)>0;
    }

    @Override
    public boolean update(User book) {
        System.out.println("serverce"+book);

        return USerDao.update(book)>0;
    }

    @Override
    public User getById(Integer id) {
//        if(id<0){
//
//            throw new BusinessException("请输入正确数据",Code.BUSIN_ERR);
//
//        }
        return USerDao.getById(id);
    }

    @Override
    public List<User> getALl() {

        return USerDao.getALl();
    }
    @Override
    public List<User> singName(Integer studentNum){

        return USerDao.singName(studentNum);
    }
}
