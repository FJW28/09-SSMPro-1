package com.tledu.cn.controller;

import com.tledu.cn.dao.AccountMapper;
import com.tledu.cn.pojo.Account;
import com.tledu.cn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/transfer")
    @ResponseBody
    public void transfer(){
        Account[] accounts=new Account[2];
        Account account1=new Account();
        account1.setId(1);
        account1.setMoney(100);
        accounts[0]=account1;
        Account account2=new Account();
        account2.setId(2);
        account2.setMoney(100);
        accounts[1]=account2;
        accountService.transfer( accounts);
    }

}
