package ApiTesting;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetUsers {
    @Test(groups = {"all", "getMethods", "getAllUsers"}, description = "Get Users")
    public void getAllUsers(){
        String url = "http://localhost:5000/users/all";
        Response response = given()
                .header("Content-Type" , "application/json")
                .when()
                .get(url)
                .then()
                .assertThat().statusCode(200)
                .extract().response();
        String responseString = response.asString();
        JSONArray jsonResponse = new JSONArray(responseString);
        System.out.println(jsonResponse.toString(10));
    }
}
