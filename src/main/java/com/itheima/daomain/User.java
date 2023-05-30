package com.itheima.daomain;

import lombok.Data;

import javax.persistence.Transient;
import java.io.File;

@Data
public class User {
//    private Integer id;
//    private String type;
//    private String name;
//    private String description;
//
//    @Override
//    public String toString() {
//        return "Book{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
    private Integer id;
    private String name;
    private Integer sno;
    private  String remark;
    private  String avatar;
@Transient
    private Integer signInfo;




}
