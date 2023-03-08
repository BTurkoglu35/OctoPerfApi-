package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.WorkSpacePojo;
import utilities.ObjectMapperUtilities;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static utilities.Authentication.generateToken;

public class workspacestepdefinitions {

    Response response;
    String endpoint;
    WorkSpacePojo data;


    @Given("User sends a GET Request to the url")
    public void userSendsAGETRequestToTheUrl() {

        endpoint = "https://api.octoperf.com/workspaces/member-of";
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken()).when().get(endpoint);
        response.prettyPrint();

    }


    @And("User  response verified")
    public void userResponseVerified() {
        response.then().body("id[0]", equalTo("Gdz5nIYBhM3oiEdLW1y6"),
                "name[0]", equalTo("01"));
    }


    @Given("User sends a GET Request with id to the url")
    public void userSendsAGETRequestWithIdToTheUrl() {
        endpoint = "https://api.octoperf.com/workspaces/Gdz5nIYBhM3oiEdLW1y6";
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken()).when().get(endpoint);
        response.prettyPrint();

    }

    @And("User id  verified")
    public void userIdVerified() {
        WorkSpacePojo expectedData = new WorkSpacePojo("1677670833084", "", "Gdz5nIYBhM3oiEdLW1y6",
                "1677670833081", "01", "J6GdpIMBhF7Bujyxc_7t");
        WorkSpacePojo actualData = ObjectMapperUtilities.convertJsonToJava(response.asString(), WorkSpacePojo.class);
        Assert.assertEquals(expectedData.getCreated(), actualData.getCreated());
        Assert.assertEquals(expectedData.getDescription(), actualData.getDescription());
        Assert.assertEquals(expectedData.getUserId(), actualData.getUserId());
        Assert.assertEquals(expectedData.getName(), actualData.getName());
        Assert.assertEquals(expectedData.getId(), actualData.getId());
        Assert.assertEquals(expectedData.getLastModified(), actualData.getLastModified());
    }



    @Then("User HTTP Status Code should be {int}")
    public void userHTTPStatusCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @When("User sends a Delete Request  the url")
    public void userSendsADeleteRequestTheUrl() {
    }

    @And("User verified response body")
    public void userVerifiedResponseBody() {
        
    }

    @Given("User enters put request")
    public void userEntersPutRequest() {
    }
}
