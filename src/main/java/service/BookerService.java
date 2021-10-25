package service;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.request.GetToken;

import static io.restassured.RestAssured.*;

public class BookerService {

    public static final String BOOKS_BASE_PATH = "/";

    public Response getToken(GetToken getToken, RequestSpecification requestSpec){
        return given()
                .spec(requestSpec)
                .basePath("/auth")
                .body(getToken)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .extract().response();
    }
}
