package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.WorkSpacePojo;
import utilities.BaseUrl;
import utilities.ObjectMapperUtilities;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class workspacestepdefinitions  {

    Response response;
    String endpoint;



    @Given("User sends a GET Request to the url")
    public void userSendsAGETRequestToTheUrl() {

        endpoint="https://api.octoperf.com/workspaces/member-of";
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken()).when().get(endpoint);
        response.prettyPrint();

    }

    @And("User HTTP Status Code should be twohundred")
    public void userHTTPStatusCodeShouldBetwohundred() {

        Assert.assertEquals(200,response.getStatusCode());
    }

    @And("User  response verified")
    public void userResponseVerified() {
       response.then().body("id[0]",equalTo("RDEP84UBlv3TG6sydqoO"),
              "name[1]",equalTo("01") );
    }


    @Given("User sends a GET Request with id to the url")
    public void userSendsAGETRequestWithIdToTheUrl() {
        endpoint="https://api.octoperf.com/workspaces/RDEP84UBlv3TG6sydqoO";
        response= given().headers(
                "Authorization",
                "Bearer " + generateToken()).when().get(endpoint);

    }

    @And("User id  verified")
    public void userIdVerified() {
        WorkSpacePojo expectedData=new WorkSpacePojo("1674816813549","ilkUpdateDenmesi","RDEP84UBlv3TG6sydqoO",
                "1674820650572","AlumniQA","J6GdpIMBhF7Bujyxc_7t");
        WorkSpacePojo actualData= ObjectMapperUtilities.convertJsonToJava(response.asString(),WorkSpacePojo.class);
        Assert.assertEquals(expectedData.getCreated(),actualData.getCreated());
        Assert.assertEquals(expectedData.getDescription(),actualData.getDescription());
        Assert.assertEquals(expectedData.getUserId(),actualData.getUserId());
        Assert.assertEquals(expectedData.getName(),actualData.getName());
        Assert.assertEquals(expectedData.getId(),actualData.getId());
        Assert.assertEquals(expectedData.getLastModified(),actualData.getLastModified());
    }
}
