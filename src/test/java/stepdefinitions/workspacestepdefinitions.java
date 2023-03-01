package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.BaseUrl;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class workspacestepdefinitions  {

    Response response;
    @Given("User sends a GET Request to the url")
    public void userSendsAGETRequestToTheUrl() {

        String endpoint="https://api.octoperf.com/workspaces/member-of";
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken()).when().get(endpoint);
        response.prettyPrint();

    }

    @And("User HTTP Status Code should be ikiyuz")
    public void userHTTPStatusCodeShouldBeIkiyuz() {

        Assert.assertEquals(200,response.getStatusCode());
    }

    @And("User  response verified")
    public void userResponseVerified() {
       response.then().body("id[0]",equalTo("RDEP84UBlv3TG6sydqoO"));
    }



}
