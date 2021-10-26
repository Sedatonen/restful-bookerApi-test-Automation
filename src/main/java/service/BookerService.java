package service;

import io.restassured.response.Response;
import io.restassured.specification.*;
import models.request.CreateBooking;
import models.request.GetToken;

import static io.restassured.RestAssured.*;

public class BookerService {
    public static final String BOOKS_TOKEN_PATH = "/auth";

    public static final String BOOKS_BASE_PATH = "/booking";

    public Response getToken(GetToken getToken, RequestSpecification requestSpec) {
        return given()
                .spec(requestSpec)
                .basePath(BOOKS_TOKEN_PATH)
                .body(getToken)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }

    public Response createBooking(CreateBooking createBooking,RequestSpecification requestSpec){
        return given()
                .spec(requestSpec)
                .basePath(BOOKS_BASE_PATH)
                .body(createBooking)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }

    public Response getBookingById(int bookId,RequestSpecification requestSpec){
        return given()
                .spec(requestSpec)
                .basePath(BOOKS_BASE_PATH)
                .pathParam("bookId",bookId)
                .when()
                .get("/{bookId}")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }

    public Response uptadeBookingById(int bookId,String token,CreateBooking createBooking,RequestSpecification requestSpec){
        return given()
                .spec(requestSpec)
                .basePath(BOOKS_BASE_PATH)
                .body(createBooking)
                .pathParam("bookId",bookId)
                .header("Cookie","token="+token)
                .when()
                .put("/{bookId}")
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }
}
