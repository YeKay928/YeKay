package com.example.exam.controller;
import com.example.exam.entity.User;
import com.example.exam.mapper.UserMapper;
import com.example.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CUser {

    @Autowired
    private UserService userService;
    @RequestMapping("login")
    public String Login(){
        System.out.println("login请求被调用");
        return "login";
    }
    @RequestMapping("index")
    public String Index(){
        System.out.println("Index请求被调用");
        return "index";
    }
    @RequestMapping("admin")
    public String Admin(){
        System.out.println("admin请求被调用");
        return "admin";
    }
    @RequestMapping("student")
    public String Student(){
        System.out.println("student请求被调用");
        return "student";
    }
    @RequestMapping("teacher")
    public String Teacher(){
        System.out.println("teacher请求被调用");
        return "teacher";
    }
    @RequestMapping("show_register")
    public String showRegister(){
        System.out.println("show_register请求被调用了");
        return "register";
    }
    @RequestMapping(value = "check_login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String checkLogin(HttpServletRequest request){
        System.out.println("check_login被调用");
        String userName=request.getParameter("user_name");
        String userPwd=request.getParameter("user_pwd");
        String userType=request.getParameter("user_type");
        System.out.println(userName+" "+userPwd+" "+userType);
        User user=null;
        if(userType.equals("1")==true){
            user=userService.checkSLogin(userName,userPwd);
            if(user!=null){
                User suser=null;
                suser=userService.showSName(userName);
                System.out.println("考生："+suser.getStudent_name()+"\n登录成功");
                return "student";
            }else{
                System.out.println("error");
                return "error";
            }
        }else if(userType.equals("2")==true){
            user=userService.checkTLogin(userName,userPwd);
            if(user!=null){
                User tuser=null;
                tuser=userService.showTName(userName);
                System.out.println("考务人员："+tuser.getTeacher_name()+"\n登录成功");
                return "teacher";
            }else{
                System.out.println("error");
                return "error";
            }
        }else if(userType.equals("3")==true) {
            user=userService.checkALogin(userName,userPwd);
            if(user!=null){
                System.out.println("管理员：登录成功");
                return "admin";
            }else{
                return "error";
            }
        }else{
            return "error";
        }
    }
    @RequestMapping("register")
//    @ResponseBody
    public String Register(HttpServletRequest request){
        System.out.println("register请求被调用");
        String userId=request.getParameter("user_id");
        String userName=request.getParameter("user_name");
        String userPwd=request.getParameter("user_pwd");
        String userSex=request.getParameter("user_sex");
        String userAge=request.getParameter("user_age");
        int age=Integer.parseInt(userAge);
        String userPhone=request.getParameter("user_phone");
        String userType=request.getParameter("lander");
        System.out.println(userId+" "+userName+" "+userPwd+" "+userType+" "+userSex+" "+userAge+" "+userPhone);
        User user=null;
        if(userType.equals("1")==true){
            user=userService.showSName(userName);
            if(user==null){
                userService.registerS("userId","userName","userPwd",
                        "userSex", "userAge","userPhone");
                return "redirect:login";
            }else {
                System.out.println("考生已存在");
            }
        }else if(userType.equals("2")==true){
            user=userService.showTName(userName);
            if(user==null){
                userService.registerT("userId","userName","userPwd",
                        "userSex", "userAge","userPhone");
                return "redirect:login";
            }else {
                System.out.println("考务人员已存在");
            }
        }
        return "error";
    }
}
