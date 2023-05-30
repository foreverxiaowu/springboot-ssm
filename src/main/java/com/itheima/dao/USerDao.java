package com.itheima.dao;

import com.itheima.daomain.User;
//import com.itheima.daomain.Usr;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface USerDao {

//    @Insert("insert into tbl_student values (null, #{type},#{name },#{description})")
//    public int save(Book book);
//    @Delete("delete from  tbl_student where id=#{id}")
//    public int delete(Integer id);
//    @Update("update tbl_student set type=#{type }, name=#{name},description=#{description }where id=#{id} ")
//    public int update(Book book);
//    @Select("select * from tbl_student where id =#{id}")
//    public Book getById(Integer id);
//    @Select("select * from tbl_student")
//    public List<Book> getALl();
//    @Select("SELECT * FROM tbl_student ORDER BY RAND() LIMIT 1")
//    public List<Book> singName();
     @Insert("insert into tbl_student values (null, #{name},#{sno },#{remark},#{avatar})")
    public int save(User book);
    @Delete("delete from  tbl_student where id =#{id}")
    public int delete(Integer id);
    @Update("update tbl_student set name=#{name }, sno=#{sno},remark=#{remark} where id=#{id} ")
    public int update(User book);
    @Select("select * from tbl_student where sno=#{sno}")
    public User getById(Integer sno);
    @Select("select * from tbl_student")
    public List<User> getALl();
    @Select("SELECT * FROM tbl_student ORDER BY RAND() LIMIT #{studentNum}")
    public List<User> singName(Integer studentNum);
}
