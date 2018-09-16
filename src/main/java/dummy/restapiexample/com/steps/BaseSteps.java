package dummy.restapiexample.com.steps;

import dummy.restapiexample.com.datamodel.Employee;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import static dummy.restapiexample.com.utils.Util.getValue;
import static dummy.restapiexample.com.utils.Util.setEmployeeProfile;
import static io.restassured.RestAssured.given;

/**
 * Created by udit on 16/09/18.
 */
public class BaseSteps {
    protected static RequestSpecification request;
    protected ValidatableResponse responseJson;
    protected ResponseBody responseBody;
    protected static Response response;
    protected static Employee employee;

    protected RequestSpecification createNewUserRequest(String name){
        employee = setEmployeeProfile(name);
        request = given()
                .contentType("application/json")
                .body(employee.toString());
        return request;
    }

    protected Response sendNewUserRequest(RequestSpecification request){
        response = request.when().post(getValue("create.uri"));
        return response;
    }

    protected void verifyNewUserCreated(Response response){
        response.then().statusCode(200);
        responseBody = response.getBody();
        employee.setEmployeeId(response.jsonPath().get("id"));
        verifyUserExist(employee.getEmployeeId());
    }

    protected void verifyUserExist(String employeeId) {
        given().when()
                .get(getValue("employee.uri")+"/"+ employeeId)
                .then().statusCode(200);
    }

    protected RequestSpecification createDeleteUserRequest(String user, boolean userShouldExist){
        employee = setEmployeeProfile(user);
        if(userShouldExist && employee.getEmployeeId().isEmpty()){
            createEmployee(employee);
        }
        employee = setEmployeeProfile(user);
        request = given();
        return request;
    }

    private void createEmployee(Employee employee) {
        responseJson = given()
                .contentType("application/json")
                .body(employee.toString())
                .when().post(getValue("create.uri"))
                .then().statusCode(200);
        String employeeId = responseJson.extract().body().jsonPath().get("id");
        employee.setEmployeeId(employeeId);
    }


    protected Response sendDeleteUserRequest(RequestSpecification request) {
        response = request.when().delete(getValue("delete.uri")+"/"+ employee.getEmployeeId());
        return response;
    }

    protected void verifyUserDeleted(Response response) {
        response.then().statusCode(200);
    }

    protected void verifyJsonResponseMessage(String result, String expectedMessage) {
        String actualMessage = response.jsonPath().get(result).toString();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

}
