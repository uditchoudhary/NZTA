package dummy.restapiexample.com.steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dummy.restapiexample.com.datamodel.Employee;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;


import static dummy.restapiexample.com.utils.Util.buildUrl;
import static dummy.restapiexample.com.utils.Util.getValue;
import static dummy.restapiexample.com.utils.Util.setEmployeeProfile;
import static io.restassured.RestAssured.given;

/**
 * Created by udit on 11/09/18.
 */
public class TestSteps {
    private RequestSpecification request;
    private ValidatableResponse responseJson;
    private ResponseBody body;
    private Response response;
    private Employee emp;

    @Before
    public static void setup() {

        RestAssured.baseURI = buildUrl();

    }

    @Given("^I run my test$")
    public void i_run_my_test() {
        System.out.print("employee"+"/17330");
        given().when().get("/employee"+"/17330").then().statusCode(200);
    }

    @Given("^a new employee has joined with name \"([^\"]*)\"$")
    public void aNewEmployeeHasJoinedWithName(String user) {
        emp = setEmployeeProfile(user);
        request = given()
                .contentType("application/json")
                .body(emp.toString());
    }

    @When("^admin creates new profile$")
    public void adminCreatesNewProfile() {
        response = request.when().post(getValue("create.uri"));
    }

    @Then("^it should be created$")
    public void itShouldBeCreated() {
        response.then().statusCode(200);
        ResponseBody body = response.getBody();
        emp.setEmployeeId(response);

        System.out.print(emp.toString());
    }

    @Given("^\"([^\"]*)\" has left the company$")
    public void hasLeftTheCompany(String user) {
        emp = setEmployeeProfile(user);
        request = given();
    }

    @When("^admin deletes the profile$")
    public void adminDeletesTheProfile() {
        response = request.when().delete(getValue("delete.uri")+"/"+emp.getEmployeeId());
    }

    @Then("^it should be deleted$")
    public void itShouldBeDeleted() {
        response.then().statusCode(200);

    }

    @And("^admin should see following message$$")
    public void adminShouldSeeFollowingMessage(String expectedMessage){

        String actualMessage = response.jsonPath().get("success").toString();
        System.out.print(expectedMessage + ": "+actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}
