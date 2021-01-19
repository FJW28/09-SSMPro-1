package com.tledu.cn.service.impl;

import com.tledu.cn.dao.UserMapper;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    /**
     * 检验用户名
     * @param username
     * @return
     */
    @Override
    public boolean checkUsername(String username) {
        boolean result=true;
        User user=userMapper.checkUsername(username);
//        System.out.println(user);
        if (user!=null){
            result=false;
        }

        return result;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        boolean result =false;
        user.setId(UUID.randomUUID().toString());
        int b=1/0;
        int i=userMapper.regist(user);
        System.out.println(i+"regist");
        if(i>0){
            result=true;
        }
        return result;
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public boolean findUser(User user) {
        boolean result=false;
        User user1=userMapper.login(user);

        if(user1!=null){
            result=true;
        }
        return result;
    }
}
