package com.lits.sohanskyy.assignment.UserTests;

import com.lits.sohanskyy.assignment.Models.UserModel;
import com.lits.sohanskyy.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserLogin extends UserService {


    @Test
    public void testUserLogin(){

        //Login
        UserModel user = userLogin(passwordFromEmail_, email_);

//Not empty
        Assert.assertFalse(user.getR().getAccess_token().isEmpty());
    }
}
