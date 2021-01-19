package com.tledu.cn.dao;

import com.tledu.cn.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    public List<User> findAll();

    public void addUser(User user);

    public User checkUsername(String username);

    public int regist(User user);

    public User login(User user);
}
