package com.restful.booker.crudtest;

import com.restful.booker.model.AuthPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AuthCRUDTest extends TestBase {
    static String id;
    static String username;
    static String password;

    @Test
    public void test01_PostAuthCreation() {
        AuthPojo authPojo = new AuthPojo();
        authPojo.setUsername("admin");
        authPojo.setPassword("password123");

        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(authPojo)
                .post(baseURI + "/auth");
        response.then().log().all().statusCode(200);


    }
}
