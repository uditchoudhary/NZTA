package dummy.restapiexample.com.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;

import static dummy.restapiexample.com.utils.Util.buildUrl;

/**
 * Created by udit on 11/09/18.
 */
public class TestSteps extends BaseSteps{

    @Before
    public static void setup() {

        RestAssured.baseURI = buildUrl();

    }

    @Given("^a new employee has joined with name \"([^\"]*)\"$")
    public void aNewEmployeeHasJoinedWithName(String user) {
        createNewUserRequest(user);
    }

    @When("^admin creates new profile$")
    public void adminCreatesNewProfile() {
        sendNewUserRequest(request);
    }

    @Then("^it should be created$")
    public void itShouldBeCreated() {
        verifyNewUserCreated(response);
    }

    @Given("^\"([^\"]*)\" has left the company$")
    public void hasLeftTheCompany(String user) {
        createDeleteUserRequest(user,true);
    }

    @When("^admin deletes the profile$")
    public void adminDeletesTheProfile() {
        sendDeleteUserRequest(request);
    }


    @Then("^it should be deleted$")
    public void itShouldBeDeleted() {
        verifyUserDeleted(response);
    }


    @And("^admin should see following \"([^\"]*)\" message$")
    public void adminShouldSeeFollowingMessage(String result, String expectedMessage) {
        verifyJsonResponseMessage(result,expectedMessage);
    }

}
