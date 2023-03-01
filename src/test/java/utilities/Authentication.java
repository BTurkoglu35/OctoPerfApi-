package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {



    public static String generateToken() {
        String username ="forjmeter@outlook.com";
        String password ="abcdmr";

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password",password);
        map.put("rememberme","true");

        String endPoint = "https://api.octoperf.com/public/users/login?username=forjmeter@outlook.com&password=abcdmr";

        Response response1 = given().contentType(ContentType.JSON).post(endPoint);

        JsonPath token = response1.jsonPath();

        return token.getString("token");
    }
}
