package com.tledu.cn.controller;


import com.tledu.cn.pojo.User;
import com.tledu.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

    /**
     *检验用户名是否存在
     * @param username
     * @return
     */
    @RequestMapping("/checkUsername")
    @ResponseBody
    public Boolean checkUsername( String username){
        boolean flag=userService.checkUsername(username);
        if(flag){
            return true;
        }else {
            return false;
        }
    }

    /**注册
     * formdata数据
     * @param user
     * @return
     */
    @RequestMapping("/regist")
    @ResponseBody
    public void regsit(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println(user);
        boolean flag=userService.regist(user);
        if(flag){
            request.getRequestDispatcher("login2.html").forward(request,response);
        }else{
            response.sendRedirect("register.html");
        }
    }

    /**登录
     * json格式字符串
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String,Object> login(@RequestBody User user){
//        System.out.println(user);
        HashMap<String,Object> result=new HashMap<>();
        boolean falg=userService.findUser(user);
        if(falg){
            result.put("mark","1");
        }else {
            result.put("mark","0");
        }
        return result;
    }













    @RequestMapping("work1")
    @ResponseBody
    public void work1(){
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("controller执行了");

    }

    @RequestMapping("work2")
    @ResponseBody
    public void work2(){
        User user=new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("superMan");
        user.setPassword("123456");
        user.setName("超人");
        user.setEmail("superMan@qq.com");
        user.setTel("110");
        userService.addUser(user);
        System.out.println("controller执行了");

    }


    @RequestMapping("/work3")
    @ResponseBody
    public void work3( String name,String password){
        System.out.println(name+password);

    }

}
