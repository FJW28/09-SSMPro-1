package com.tledu.cn.service;

import com.tledu.cn.pojo.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public void addUser(User user);

    public boolean checkUsername(String username);

    public boolean regist(User user);

    public boolean findUser(User user);
}
