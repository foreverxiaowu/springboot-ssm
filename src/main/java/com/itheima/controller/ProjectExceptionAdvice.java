package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//用于标识当前类为REST风格对应的异常处理器
public class ProjectExceptionAdvice {
   @ExceptionHandler
    public Result SystemException(SystemException e){
       //记录日志
       //发送消息给运维
       //发送邮件给开发人员,ex对象发送给开发人员

       return new Result(e.getCode(),null,e.getMessage());

   }
   @ExceptionHandler
    public Result BusinessException(BusinessException e){


       return new Result(e.getCode(),null,e.getMessage());
   }
   @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception e){
       //记录日志
       //发送消息给运维
       //发送邮件给开发人员,e对象发送给开发人员
       System.out.println(e);
       return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统异常！请联系后台人员");
   }
}
