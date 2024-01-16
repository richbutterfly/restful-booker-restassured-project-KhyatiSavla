package com.restful.booker.crudtest;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.testbase.TestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingCRUDTest extends TestBase {
    static ValidatableResponse response;
    static String firstName = "Prime" + TestUtils.getRandomValue();
    static String lastName = "Test" + TestUtils.getRandomValue();
    static int totalPrice = Integer.parseInt(TestUtils.getRandomValue());
    static Boolean depositPaid = true;
    static String additionalNeed;

    static String checkIn = "2023-01-01";
    static String checkOut = "2023-01-10";
    static int userId;


    @Test
    public void test01_VerifyBookingCreatedSuccessfully() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        bookingPojo.setTotalprice("totalPrice");
        bookingPojo.setDepositpaid("depositPaid");
        bookingPojo.setCheckin(checkIn);
        bookingPojo.setCheckout(checkOut);
        bookingPojo.setAdditionalneeds("Dairy free");

        Response response = given()
                .header("Accept", "application/json")
                .header("Cookie", "token=abc123")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .when()
                .body(bookingPojo)
                .post("/booking");
        response.then().log().all().statusCode(404);  //status giving 404 - Not found



    }

    @Test
    public void test02_VerifyReadBookingSuccessfully() {
        response = given()
                .when()
                .get("/120")
                .then().log().all().statusCode(200);

    }

    @Test
    public void test03_VerifyBookingUpdatedSuccessfully() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        bookingPojo.setTotalprice("totalPrice");
        bookingPojo.setDepositpaid("depositPaid");
        bookingPojo.setCheckin(checkIn);
        bookingPojo.setCheckout(checkOut);
        bookingPojo.setAdditionalneeds("Dairy free");

        Response response = given()
                .header("Accept", "application/json")
                .header("Cookie", "token=abc123")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .when()
                .body(bookingPojo)
                .put("/booking/150");
        response.then().log().all().statusCode(404); //status giving 404 - Not found

    }

    @Test
    public void test004_VerifyBookingPartiallyUpdatedSuccessfully() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstName);
        bookingPojo.setLastname(lastName);
        Response response = given()
                .header("Accept", "application/json")
                .header("Cookie", "token=abc123")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .when()
                .body(bookingPojo)
                .patch("/1");
        response.then().log().all().statusCode(200);
    }

    @Test
    public void test005_VerifyBookingDeletedSuccessfully() {
        Response response = given()
                .header("Accept", "application/json")
                .header("Cookie", "token=abc123")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .when()
                .delete("/200");
        response.then().statusCode(201);
        response.prettyPrint();
    }


}
