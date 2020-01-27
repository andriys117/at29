package com.lits.sohanskyy.litsHTTPClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;

public class LitsHTTPClient {

    //Url User Constants
    public static final String baseUrl = "https://europe-west2-search-app-263e2.cloudfunctions.net/webapp";
    public static final String pathUser = "/api/auth/login";
    public static final String pathUserInfo = "/api/v1/users/";

    //Url Book Constants
    public static final String pathBook = "/api/v1/books";
    public static final String pathBookISBN = "/webapp/api/v1/books";
    public static final String pathSearchBook = "/api/v1/search?q=";


    public static <T>T convert(Response response, Class<T> c){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

        try{
            return objectMapper.readValue(response.body().string(), c);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private OkHttpClient okHttpClient = new OkHttpClient();
    private ObjectMapper objectMapper;

    public LitsHTTPClient() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    }

    public Response GET(String url){
        return GET(url, Headers.of());
    }

    public Response GET(String url, Headers headers){

        final Request request = new Request.Builder()
                .url(url).headers(headers).build();

        try{
            return okHttpClient.newCall(request).execute();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public Response POST(String url, Object o){
        return POST(url, Headers.of(), o);
    }

    public Response POST(String url, Headers headers, Object o){

        String bodyString = "";
        try {
            bodyString = objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody
                .create(bodyString,
                        MediaType.parse("application/json"));

        final Request request = new Request.Builder()
                .method("POST", body)
                .url(url)
                .headers(headers)
                .post(body)
                .build();
        try{
            return okHttpClient.newCall(request).execute();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
