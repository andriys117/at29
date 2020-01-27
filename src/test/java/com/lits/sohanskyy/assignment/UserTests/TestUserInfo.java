package com.lits.sohanskyy.assignment.UserTests;

import com.lits.sohanskyy.assignment.Models.UserModel;
import com.lits.sohanskyy.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserInfo extends UserService {

    @Test()
    public void getUserInfo(){

        //Get token
        String userToken = userLogin(passwordFromEmail_, email_).getR().getAccess_token();

        //Get Info
        UserModel.UserInfoModel userInfo = getUserInfo(userToken);

        //Verify user info
        Assert.assertEquals(userInfo.getFirstName(), "John");
        Assert.assertEquals(userInfo.getLastName(), "Dou");
        Assert.assertEquals(userInfo.getEmail(), email_);
        Assert.assertEquals(userInfo.getId(), idUser_);
    }
}
