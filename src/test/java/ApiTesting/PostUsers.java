package ApiTesting;

import apiTestingUtils.ApiRequests;
import apiTestingUtils.CreateBodyContent;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class PostUsers {
    @Test(groups = {"all", "postMethods", "createUser"}, description = "Get Users", dataProvider = "getBodyContent")
    public void createUser(String bodyContent){
        String url = "http://localhost:5000/users/add";
        String responseString = ApiRequests.makePost(url, bodyContent).asString();
        JSONObject jsonResponse = new JSONObject(responseString);
        System.out.println(jsonResponse.toString(10));
    }

    @DataProvider(name = "getBodyContent", parallel = true)
    private Iterator<Object[]> getBodyContent(){
        Collection<Object[]> data = new ArrayList<Object[]>();
        for(int i = 0; i < 500; i++){
            JSONObject newUser = new JSONObject(CreateBodyContent.getBodyContentUsers());
            data.add(new Object[] {newUser.toString()});
        }
        return data.iterator();
    }
}
