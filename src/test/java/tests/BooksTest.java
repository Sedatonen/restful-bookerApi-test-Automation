package tests;

import io.restassured.response.Response;
import models.request.Bookingdates;
import models.request.CreateBooking;
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

    @Test(priority = 2)
    public void successCreateBookingTest() {
        Bookingdates bookingdates=Bookingdates.builder()
                .checkin("2018-01-01")
                .checkout("2019-01-01").build();
        CreateBooking createBooking=CreateBooking.builder()
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(111)
                .depositpaid("true")
                .bookingdates(bookingdates)
                .additionalneeds("Breakfast")
                .build();
        Response response = bookerService.createBooking(createBooking, requestSpecification());
        System.out.println(response.asPrettyString());
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        System.out.println(response.asPrettyString());
    }


}
