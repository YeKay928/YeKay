package com.example.exam.service;

import com.example.exam.entity.User;
import com.example.exam.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User checkSLogin(String Student_id,String Student_pwd){
        return userMapper.checkSLogin(Student_id,Student_pwd);
    }
    public User showSName(String Student_id){
        return userMapper.showSName(Student_id);
    }
    public User checkTLogin(String Teacher_id,String Teacher_pwd){
        return userMapper.checkTLogin(Teacher_id,Teacher_pwd);
    }
    public User showTName(String Teacher_id){
        return userMapper.showTName(Teacher_id);
    }
    public User checkALogin(String admin_id,String admin_pwd){
        return userMapper.checkALogin(admin_id,admin_pwd);
    }
    public int registerS(String Student_id,String Student_name,String Student_pwd
            ,String Student_sex,String Student_age,String Student_phone){
        return userMapper.insertSUser(Student_id,Student_name,Student_pwd,Student_sex,Student_age,Student_phone);
    }
    public int registerT(String Teacher_id,String Teacher_name,String Teacher_pwd
            ,String Teacher_sex,String Teacher_age,String Teacher_phone){
        return userMapper.insertTUser(Teacher_id,Teacher_name,Teacher_pwd,Teacher_sex,Teacher_age,Teacher_phone);
    }
}
