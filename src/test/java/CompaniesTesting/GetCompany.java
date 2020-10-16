package CompaniesTesting;

import apiTestingUtils.ApiRequests;
import org.json.JSONArray;
import org.testng.annotations.Test;

public class GetCompany {
    @Test(groups = {"all", "getMethods", "getCompany"}, description = "Get Companies")
    public void getAllCompanies(){
        JSONArray jsonResponse = getCompanies();
        System.out.println(jsonResponse.toString(10));
    }

    public static JSONArray getCompanies(){
        String url = "http://localhost:5000/companies/all";
        String responseString = ApiRequests.makeGetRequest(url).asString();
        JSONArray jsonResponse = new JSONArray(responseString);
        return  jsonResponse;
    }
}
