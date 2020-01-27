package com.lits.sohanskyy.assignment.BookTests;

import com.lits.sohanskyy.assignment.Models.BookModel;
import com.lits.sohanskyy.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetBookByISBN extends UserService {

    @Test()
    public void getBookBbyISBN(){

        //Get user token after login
        String userToken = userLogin(passwordFromEmail_, email_)
                .getR().getAccess_token();

        //Get book via isbn
        BookModel book = getBookByISBN(userToken);

        //Verify response
        Assert.assertEquals(book.getIsbn(), isbn);
        Assert.assertEquals(book.getAuthor(), "J. K. Rowling");
        Assert.assertEquals(book.getDescription(), "Harry Potter is a series of fantasy novels written by British author J. K. Rowling.");
        Assert.assertEquals(book.getPublishDate(), "1997");
    }
}
