package ApiTesting;

import apiTestingUtils.ApiRequests;
import apiTestingUtils.User;
import com.google.gson.Gson;
import io.restassured.internal.mapping.GsonMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DeleteUsers {
    @Test(groups = {"all", "deleteMethods", "deleteUsers"}, description = "Delete Users", dataProvider = "deleteEvenUsers")
    public void deleteUsers(String ids){
        String url = "http://localhost:5000/users/removebyid/" + ids;
        String responseString = ApiRequests.makeDeleteRequest(url).asString();
        JSONObject jsonResponse = new JSONObject(responseString);
        System.out.println(jsonResponse.toString(10));
    }

    @DataProvider(name = "deleteEvenUsers", parallel = true)
    private Iterator<Object[]> deleteEvenUsers(){
        // Get user count
        GetUsers userInformation = new GetUsers();
        JSONArray users = userInformation.getAllUsers();
        ArrayList<User> actualUsers = User.fromJsonArray(users);

        // Iterate and add even numbers
        Collection<Object[]> data = new ArrayList<Object[]>();
        for (User user:actualUsers) {
            if(user.id % 2 == 0){
                data.add(new Object[] {user.id.toString()});
            }
        }
        return data.iterator();
    }
}
