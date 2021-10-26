package constants;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static constants.Url.BOOKS_API_URL;

public class RequestSpec {

    private RequestSpec() {

    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder().build()
                //.accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .baseUri(BOOKS_API_URL);
    }


}
