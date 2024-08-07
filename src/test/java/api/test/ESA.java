package api.test;

import com.aventstack.extentreports.gherkin.model.Given;
import com.jayway.jsonpath.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class ESA {

    public static String geturl= "https://reqres.in/api/users?page=2";
    public static String posturl= "https://reqres.in/api/users";
    Map<String, String> mh= new HashMap<>();

    @Test
    public void testGetAutoComplete(){


                        when().get(geturl).
                        then().body("data[4].first_name",equalTo( "George"));

    }

    @Test
    public void testPostRest(){
        mh.put("name", "morpheus");
        mh.put("job", "leader");
        given().body(mh).
                when().post(posturl).
              then().//body("id",equalTo(725)).
                log().all();

    }
}
