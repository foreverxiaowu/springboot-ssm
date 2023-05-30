package com.itheima.controller;

//import com.itheima.daomain.Book;
import com.itheima.daomain.User;
import com.itheima.service.UserInfoService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;
import java.util.UUID;

@RequestMapping("/students")
@RestController
public class Bookcontroller {
    @Autowired
    private UserService userService;
    @Value("${file.upload-path}")
    private String pictureurl;
    @Resource
    private UserInfoService userInfoService;

    @PostMapping
    public Result save(@RequestBody User user){
//        final boolean flag = userService.save(book);
//        final User id = userService.getById(book.getSno());
//        System.out.println(id.getId());
//        System.out.println(book);

         return userService.save(user);

//        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,user) ;
    }
    @PostMapping("/image")
    public Result saveImage(MultipartFile file){
        System.out.println(file);

        File saveFile = new File(pictureurl);
        if (!saveFile.exists()) {
            //若不存在该目录，则创建目录
            saveFile.mkdir();
        }
        //拼接url，采用随机数，保证每个图片的url不同
        UUID uuid = UUID.randomUUID();
        String imageName=uuid+file.getOriginalFilename();
        //拼接后的url
        String url ="../image/"+ uuid+file.getOriginalFilename();

//        String url=pictureurl + imageName;
        try {
            //将文件保存指定目录
            file.transferTo(new File(pictureurl + imageName));
            System.out.println(pictureurl + imageName);
            System.out.println("将文件保存指定目录");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return new Result(200,url);
        }


    }
   @DeleteMapping("/{id}")
       public Result delete( @PathVariable Integer id){
       final boolean flag = userService.delete(id);
       return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
   }

   @PutMapping
    public Result update(@RequestBody User book){
       System.out.println(book);
       final boolean flag = userService.update(book);
       System.out.println(flag);
       return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
   }
   @GetMapping("/{id}")
    public Result getByID(@PathVariable Integer id){
       System.out.println("学号"+id);
       final User book = userService.getById(id);
       System.out.println("结果");
       Integer code=book != null ? Code.GET_OK:Code.GET_ERR;
       String msg= book != null ? "":"数据查询失败！";
       System.out.println(book);
       return new Result(code,book,msg);

   }
   @GetMapping
    public Result getAll(){
       final List<User> booklist = userService.getALl();
       Integer code=booklist != null ? Code.GET_OK:Code.GET_ERR;
       String msg= booklist != null ? "":"数据查询失败！";
       return new Result(code,booklist,msg);

   }
   @GetMapping("/singIn/{studentNum}")
   public Result singIn( @PathVariable  String studentNum){

       final List<User> books = userService.singName(Integer.valueOf(studentNum));
       System.out.println(studentNum);
       Integer code=books != null ? Code.GET_OK:Code.GET_ERR;
       String msg= books != null ? "":"数据查询失败！";
       return new Result(code,books,msg);
   }
   //学生考勤信息
    @PostMapping("/info")
    public Result studentInfo(@RequestBody User user){

        return userInfoService.saveInfo(user);
    }

}
