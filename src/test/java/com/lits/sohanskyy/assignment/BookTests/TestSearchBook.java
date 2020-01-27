package com.lits.sohanskyy.assignment.BookTests;

import com.lits.sohanskyy.assignment.Models.SearchBookModel;
import com.lits.sohanskyy.assignment.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSearchBook extends UserService {

    @Test
    public void searchBookTest(){

        //Get token
        String userToken = userLogin(passwordFromEmail_, email_).getR().getAccess_token();

        //Search
        SearchBookModel bookSearch = searchBook(userToken, "Harry potter");

       //Params ver
        Assert.assertEquals(bookSearch.getHits().get(0).getAuthor(),"J. K. Rowling");
        Assert.assertEquals(bookSearch.getHits().get(0).getObjectID(),"3457789");
        Assert.assertEquals(bookSearch.getHits().get(0).getHighlightResult().getAuthor().getMatchedWords().get(0),"Harry potter");
        Assert.assertEquals(bookSearch.getHits().get(0).getHighlightResult().getIsbn().getValue(),"3457789");
    }
}