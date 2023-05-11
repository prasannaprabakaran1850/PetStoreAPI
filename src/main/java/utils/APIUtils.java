package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;


public class APIUtils {

    public static Response post(String path, String token, Object requestPayload){
        return given().
                contentType(ContentType.JSON).
                body(requestPayload).
        when().post(path).
        then().
                extract().
                response();
    }


    public static Response get(String path, String token){
        return given().
        when().get(path).
        then().
                extract().
                response();
    }

    public static Response update(String path, String token, Object requestPlaylist){
        return given().
                contentType(ContentType.JSON).
                auth().oauth2(token).
                body(requestPlaylist).
        when().put(path).
        then().
                extract().
                response();
    }
}