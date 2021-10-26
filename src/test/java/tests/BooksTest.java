package tests;

import constants.RequestSpec;
import io.restassured.response.Response;
import models.request.CreateBooking;
import models.request.GetToken;

import models.response.CreateResponse;
import org.testng.annotations.Test;
import service.BookerService;

import static constants.RequestSpec.*;
import static org.testng.Assert.*;

public class BooksTest {

    BookerService bookerService = new BookerService();

    //step ->1
    @Test(priority = 1)
    public void successGetTokenTest() {
        GetToken getToken = GetToken.builder().build();
        Response response = bookerService.getToken(getToken, requestSpecification());
        System.out.println(response.asPrettyString());
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        String auth_token = response.path("token");
        String token = "token=" + auth_token;
        System.out.println("auth_token = " + auth_token);
        System.out.println("token = " + token);
    }

    //step ->2
    @Test(priority = 2)
    public void successCreateBookingTest() {
        CreateBooking createBooking = CreateBooking.builder().build();
        Response response = bookerService.createBooking(createBooking, RequestSpec.requestSpecification());

        int id = response.path("bookingid");

        System.out.println(response.asPrettyString());
        System.out.println("response.getStatusCode() = " + response.getStatusCode());

        System.out.println("id = " + id);

        assertNotNull(response.path("booking.firstname"));
        assertNotNull(response.path("booking.lastname"));
        assertNotNull(response.path("booking.totalprice"));
        assertNotNull(response.path("booking.depositpaid"));
        assertNotNull(response.path("booking.bookingdates.checkin"));
        assertNotNull(response.path("booking.bookingdates.checkout"));
        assertNotNull(response.path("booking.additionalneeds"));
    }

    //step ->3
    @Test(priority = 3)
    public void successCreateBookingWithBaseClassTest() {
        CreateBooking createBooking = CreateBooking.builder().build();
        CreateResponse createResponse = bookerService.createBooking(createBooking, RequestSpec.requestSpecification()).as(CreateResponse.class);
        System.out.println("Firstname = " + createResponse.getBooking().getFirstname());
        System.out.println("Lastname = " + createResponse.getBooking().getLastname());
        System.out.println("TotalPrice = " + createResponse.getBooking().getTotalprice());
        System.out.println("DepositPaid = " + createResponse.getBooking().isDepositpaid());
        System.out.println("Bookingdates = " + createResponse.getBooking().getBookingdates());
        System.out.println("Additionalneeds = " + createResponse.getBooking().getAdditionalneeds());
        System.out.println("Bookingid = " + createResponse.getBookingid());
    }

    //step ->4 and 5
    @Test(priority = 4)
    public void successGetBookingTest() {
        CreateBooking createBooking = CreateBooking.builder().build();
        Response response = bookerService.createBooking(createBooking, RequestSpec.requestSpecification());

        System.out.println("createStatusCode() = " + response.getStatusCode());
        System.out.println("response.asPrettyString() = " + response.asPrettyString());
        int id = response.path("bookingid");

        Response getBookResponse = bookerService.getBookingById(id, requestSpecification());

        System.out.println("getStatusCode = " + getBookResponse.statusCode());
        System.out.println("getBookResponse.asPrettyString() = " + getBookResponse.asPrettyString());

        String createFirstname = response.path("booking.firstname");
        String getFirstname = getBookResponse.path("firstname");
        //verify one data
        assertEquals(createFirstname, getFirstname);
    }

    //step ->6
    @Test(priority = 5)
    public void successUpdateBookingTest() {
        GetToken getToken = GetToken.builder().build();
        Response response = bookerService.getToken(getToken, requestSpecification());
        String token = response.path("token");

        CreateBooking createBooking = CreateBooking.builder().build();
        Response response1 = bookerService.createBooking(createBooking, RequestSpec.requestSpecification());

        System.out.println("createStatusCode() = " + response1.getStatusCode());

        int id = response1.path("bookingid");

        Response response2 = bookerService.uptadeBookingById(id, token, createBooking, requestSpecification());

        System.out.println("response2.getStatusCode() = " + response2.getStatusCode());

        Response response3 = bookerService.getBookingById(id, requestSpecification());

        System.out.println("response3.getStatusCode() = " + response3.getStatusCode());

        //verify data
        assertEquals(response2.asPrettyString(), response3.asPrettyString());
    }
}