package dummy.restapiexample.com.steps;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

import static dummy.restapiexample.com.utils.Config.buildUrl;
import static io.restassured.RestAssured.given;

/**
 * Created by udit on 11/09/18.
 */
public class TestSteps {


    @BeforeClass
    public static void setup() {

//
//            RestAssured.port = Integer.valueOf(8080);
//            basePath = "/rest-garage-sample/";
//        RestAssured.basePath = basePath;
//
//        String baseHost = System.getProperty("server.host");
//        if(baseHost==null){
//            baseHost = "http://localhost";
//        }
//        RestAssured.baseURI = baseHost;

    }

    @Given("^I run my test$")
    public void i_run_my_test() {
        System.out.print(buildUrl("employee")+"/17330");
        given().when().get(buildUrl("employee")+"/17330").then().statusCode(200);
    }

}
