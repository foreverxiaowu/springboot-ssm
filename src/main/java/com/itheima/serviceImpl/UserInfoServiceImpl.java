package com.itheima.serviceImpl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.Mapper.UserInfoMapper;
import com.itheima.controller.Code;
import com.itheima.controller.Result;
import com.itheima.daomain.User;
import com.itheima.daomain.UserInfo;
import com.itheima.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public Result saveInfo(User user) {
        UserInfo userInfo=new UserInfo();
        Integer info=user.getSignInfo();
        LocalDateTime dateTime = LocalDateTime.now();
        userInfo.setCreateTime(dateTime);
        userInfo.setStudentId(user.getSno());


        if(info==null){
             return new Result(Code.SAVE_OK,null,"没有违规情况记录");
         }else if(info==3){
          userInfo.setAbsent(1);
         }else if (info==9){
            userInfo.setLate(1);
        }else if(info==4){
            userInfo.setQingjia(1);

        }
        System.out.println(userInfo);
         boolean flag = save(userInfo);
        if (flag){
            return new Result(Code.SAVE_OK,userInfo,"保存成功！");
        }
        return new Result(Code.SAVE_ERR,null,"保存失败！");
    }
}
