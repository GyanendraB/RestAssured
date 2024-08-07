package api.test;

import api.endpoints.EndpointsPet;
import api.payload.Pet;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PetTest {

     Faker faker;
     Pet payload;


    @BeforeTest
    public void setup(){
        faker = new Faker();
        payload = new Pet();
        payload.setId(faker.idNumber().hashCode());
        payload.setName(faker.name().firstName());

    }
    @Test
    public void testPostPet(){
        Response response = EndpointsPet.createPet(payload);
        response.then().log().all().statusCode(200);
    }

    @Test
    public void testReadPet(){
        Response response= EndpointsPet.readUser();
        response.then().log().all().statusCode(200);
    }

}