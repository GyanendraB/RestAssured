package api.test;

import api.endpoints.EndpointsUser;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class UserTest {

    Faker faker;
    User userPayload;

    @BeforeTest
    public void setupData() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setFirstName(faker.name().username());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setUsername(faker.name().username());
    }

    @Test(priority = 0)
    public void testPostUser(ITestContext user) {
        Response response = EndpointsUser.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        user.setAttribute("userid",userPayload.getId());
    }

    @Test(priority = 1)
    public void
    testGetUserByName(ITestContext user){
        Response response = EndpointsUser.readUser(String.valueOf((user.getAttribute("userid"))))   ;
        ResponseBody responseBody= response.getBody();
        String responceString= responseBody.asString();
        response.then().log().all();
        //Assert.assertTrue(responceString.contains("sofia.gusikowski"));
    }

    @Test(priority = 2)
    public void testUpdateUser(){

        userPayload.setFirstName(faker.name().username());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        Response response = EndpointsUser.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }


    @Test(priority = 3)
    public void testDeleteUser(){
        Response response = EndpointsUser.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

}