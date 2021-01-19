package com.tledu.cn.service.impl;

import com.tledu.cn.dao.AccountMapper;
import com.tledu.cn.pojo.Account;
import com.tledu.cn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void transfer(Account[] accounts) {
        accountMapper.subMoney(accounts[0]);
//        int b=1/0;
        accountMapper.addMoney(accounts[1]);

    }
}
