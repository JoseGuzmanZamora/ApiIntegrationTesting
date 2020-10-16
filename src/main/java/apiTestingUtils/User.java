package apiTestingUtils;

import com.google.gson.Gson;
import org.json.JSONArray;

import java.util.ArrayList;

public class User {
    public Integer id;
    public String username;
    public String firstname;
    public String lastname;
    public String email;

    public static ArrayList<User> fromJsonArray(JSONArray users){
        Gson gson = new Gson();
        ArrayList<User> result = new ArrayList<User>();
        for (Object user:
             users) {
            result.add(gson.fromJson(user.toString(), User.class));
        }
        return result;
    }
}
