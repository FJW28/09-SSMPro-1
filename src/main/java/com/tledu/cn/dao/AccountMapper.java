package com.tledu.cn.dao;


import com.tledu.cn.pojo.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {



    public void subMoney(Account account);

    public void addMoney(Account account);
}
