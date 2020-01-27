package com.lits.sohanskyy.assignment;

import com.lits.sohanskyy.assignment.Models.BookModel;
import com.lits.sohanskyy.assignment.Models.SearchBookModel;
import com.lits.sohanskyy.assignment.Models.UserModel;
import com.lits.sohanskyy.litsHTTPClient.LitsHTTPClient;
import okhttp3.Headers;
import okhttp3.Response;
import org.testng.Assert;

import java.util.HashMap;

public class UserService extends LitsHTTPClient {

    //User
    public static final String email_ = "asohanskyy@gmail.com";
    public static final String passwordFromEmail_ = "Qwerty123456";
    public static final String idUser_ = "t1H9j4w2246tvZmG5Xc2";

    //Book
    public static final String isbn = "3457789";
    public static final String isbnRandom = "name_random" + Math.random();


    public UserModel userLogin(String userPassword, String userEmail) {

        //Body
        HashMap<String, String> body = new HashMap<>();
        body.put("email", userEmail);
        body.put("password", userPassword);

        //Send login POST
        Response userLogin = POST(baseUrl + pathUser, Headers.of(), body);

        //Sstatus code
        Assert.assertEquals(userLogin.code(), 200);

        //Response
        return convert(userLogin, UserModel.class);
    }

    public UserModel.UserInfoModel getUserInfo(String userToken){

        //GET user info
        System.out.println(baseUrl + pathUserInfo + idUser_);
        Response userInfo = GET(baseUrl + pathUserInfo + idUser_, Headers.of(createHeaders(userToken)));

        //Verify status code
        Assert.assertEquals(userInfo.code(), 200);

        //Get response
        return convert(userInfo, UserModel.UserInfoModel.class);
    }

    public HashMap createHeaders (String userToken){
        //Create headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + userToken);
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public BookModel createBook(String userToken) {

        //Create body
        HashMap<String, String> body = new HashMap<>();
        body.put("isbn", isbnRandom);
        body.put("name", "Harry potter");
        body.put("description", "Harry Potter is a series of fantasy novels written by British author J. K. Rowling. ");
        body.put("author", "J. K. Rowling");
        body.put("publishDate", "1997");
        body.put("publisher", "Bloomsbury Publishing");

        //Send POST for login
        System.out.println(baseUrl + pathBook);
        Response userLogin = POST(baseUrl + pathBook, Headers.of(createHeaders(userToken)), body);

        //Verify status code
        Assert.assertEquals(userLogin.code(), 200);

        //Get response
        return convert(userLogin, BookModel.class);
    }

    public BookModel getBookByISBN(String userToken){

        //GET book info
        Response bookInfo = GET(baseUrl + pathBook + pathBookISBN, Headers.of(createHeaders(userToken)));

        //Verify status code
        Assert.assertEquals(bookInfo.code(), 200);

        //Get response
        return convert(bookInfo, BookModel.class);
    }

    public SearchBookModel searchBook(String userToken, String searchKey){

        //GET book info
        Response bookInfo = GET(baseUrl + pathSearchBook + searchKey, Headers.of(createHeaders(userToken)));

        //Verify status code
        Assert.assertEquals(bookInfo.code(), 200);

        //Get response
        return convert(bookInfo, SearchBookModel.class);
    }
}
