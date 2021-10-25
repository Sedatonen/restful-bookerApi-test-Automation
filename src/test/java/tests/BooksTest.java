package tests;

import io.restassured.response.Response;
import models.request.GetToken;
import org.testng.annotations.Test;
import service.BookerService;

import static constants.RequestSpec.*;

public class BooksTest {

    BookerService bookerService = new BookerService();

    @Test(priority = 1)
    public void successGetTokenTest() {
        GetToken getToken = GetToken.builder().build();
        Response response = bookerService.getToken(getToken, requestSpecification());
        System.out.println(response.asPrettyString());
        System.out.println("response.getStatusCode() = " + response.getStatusCode());


    }
}
