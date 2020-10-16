package ApiTesting;

import apiTestingUtils.ApiRequests;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetUsers {
    @Test(groups = {"all", "getMethods", "getAllUsers"}, description = "Get Users")
    public void getAllUsers(){
        String url = "http://localhost:5000/users/all";
        String responseString = ApiRequests.makeGetRequest(url).asString();
        JSONArray jsonResponse = new JSONArray(responseString);
        System.out.println(jsonResponse.toString(10));
    }
}
