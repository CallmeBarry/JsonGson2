package com.qqdemo.administrator.jsongson;

import java.util.List;

/**
 * Created by yls on 2017/3/2.
 */

public class Student {
    int id;
    String name;
    int age;
//    快捷键 ALT+Insert
    List<Student> stuList;

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    public Student(int id, String name, int age){
        this.id =id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




}
