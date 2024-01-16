package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BookingAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking/100")
                .then().statusCode(200);
    }
    @Test
    public void test001() {
        response.body("firstname", equalTo("John"));

    }
    @Test
    public void test002(){
        response.body("lastname", equalTo("Smith"));
    }
    @Test
    public void test003(){
        response.body("totalprice", equalTo(111));
    }
    @Test
    public void test004(){
        response.body("depositpaid", equalTo(true));
    }
    @Test
    public void test005(){
        response.body("bookingdates.checkin", equalTo("2018-01-01"));
    }
    @Test
    public void test006(){
        response.body("bookingdates.checkout", equalTo("2019-01-01"));
    }
    @Test
    public void test007(){
        response.body("additionalneeds", equalTo("Breakfast"));
    }

}
