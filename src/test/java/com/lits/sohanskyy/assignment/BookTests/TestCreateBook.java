package com.lits.sohanskyy.assignment.BookTests;

import com.lits.sohanskyy.assignment.Models.BookModel;
import com.lits.sohanskyy.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateBook extends UserService {

    @Test()
    public void createBook(){

        //Get user token after login
        String userToken = userLogin(passwordFromEmail_, email_)
                .getR().getAccess_token();

        //Get response after create book
        BookModel book = createBook(userToken);

        //Verify ibsn
        Assert.assertEquals(book.getIsbn(), isbnRandom);
    }
}
