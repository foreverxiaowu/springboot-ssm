package com.itheima.daomain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@TableName("student_info")
public class UserInfo {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
   @TableField("studentId")
    private  Integer studentId;
    private Integer late;
    private Integer absent;

    private Integer qingjia;
    @TableField("createTime")
    private LocalDateTime createTime;
}
