package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BookingExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        response = given()
                .when()
                .get("/booking/22")
                .then().statusCode(200);
    }
    // Extract the first name
    @Test
    public void test001() {
        String firstName = response.extract().path("firstname");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The First Name is : " + firstName);
        System.out.println("------------------End of Test---------------------------");
    }
    // Extract the last name
    @Test
    public void test002() {
        String lastName = response.extract().path("lastname");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Last Name is : " + lastName);
        System.out.println("------------------End of Test---------------------------");
    }
    // Extract the total price
    @Test
    public void test003() {
        int totalPrice = response.extract().path("totalprice");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total price is : " + totalPrice);
        System.out.println("------------------End of Test---------------------------");
    }
    // Extract the deposit paid
    @Test
    public void test004() {
        boolean depositPaid = response.extract().path("depositpaid");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The deposit paid is : " + depositPaid);
        System.out.println("------------------End of Test---------------------------");
    }
    // Extract the booking dates
    @Test
    public void test005() {
        HashMap<String, Object> bookingDates = response.extract().path("bookingdates");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The booking dates are : " + bookingDates);
        System.out.println("------------------End of Test---------------------------");
    }
    // Extract the additional needs
    @Test
    public void test006() {
        String additionalNeeds = response.extract().path("additionalneeds");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The additional needs are : " + additionalNeeds);
        System.out.println("------------------End of Test---------------------------");
    }
    // Extract the total numbner of booking ids
    @Test
    public void test007() {
        List<Integer> bookingIds = response.extract().path("bookingid");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total numbner of booking ids is : " + bookingIds);
        System.out.println("------------------End of Test---------------------------");
    }
}
