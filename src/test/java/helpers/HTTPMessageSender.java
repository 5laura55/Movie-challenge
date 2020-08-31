package helpers;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.*;

public class HTTPMessageSender {
    private static RequestSpecification requestSpec;

    public HTTPMessageSender(String url) {

        requestSpec = new RequestSpecBuilder().setBaseUri(url).setContentType(ContentType.JSON).build();
    }

    public Response getRequest(String endpoint) {
        return given().spec(requestSpec).
                when().get(endpoint).andReturn();
    }

    public Response postRequest(String endpoint, String json) {
        return given().spec(requestSpec).
                when().body(json).post(endpoint).andReturn();
    }

    public Response deleteRequest(String endpoint, String json) {
        return given().spec(requestSpec).
                when().body(json).delete(endpoint).andReturn();
    }
}
