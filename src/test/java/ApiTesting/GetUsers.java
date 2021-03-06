package ApiTesting;

import apiTestingUtils.ApiRequests;
import org.json.JSONArray;
import org.testng.annotations.Test;

public class GetUsers {
    @Test(groups = {"all", "getMethods", "getAllUsers"}, description = "Get Users")
    public void getAllUsers(){
        JSONArray jsonResponse = getUsersInformation();
        System.out.println(jsonResponse.toString(10));
    }

    public static JSONArray getUsersInformation(){
        String url = "http://localhost:5000/users/all";
        String responseString = ApiRequests.makeGetRequest(url).asString();
        JSONArray jsonResponse = new JSONArray(responseString);
        return  jsonResponse;
    }
}
