package api.endpoints;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class EndpointsPet {

    static ResourceBundle rb = ResourceBundle.getBundle("routes");
    static String baseUrl = rb.getString("baseUrl");
    static String postUrl = baseUrl+"/pet";



    public static Response createPet(Pet payload){

        Response response =
                given().accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        body(payload).
                when().
                        post(postUrl);
        return response;
    }
    public static Response readUser(){

        Response response =
                given().accept(ContentType.JSON).
                        pathParam("status","findByStatus").
                        queryParams("status","available").
                when().get(postUrl+"/{status}");

        return response;
    }
}
