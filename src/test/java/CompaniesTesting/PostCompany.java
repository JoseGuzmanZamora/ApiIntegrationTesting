package CompaniesTesting;

import apiTestingUtils.ApiRequests;
import apiTestingUtils.CreateBodyContent;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class PostCompany {
    @Test(groups = {"all", "postMethods", "createCompany"}, description = "Create Companies", dataProvider = "getBodyContent")
    public void createCompany(String bodyContent){
        String url = "http://localhost:5000/companies/add";
        String responseString = ApiRequests.makePost(url, bodyContent).asString();
        JSONObject jsonResponse = new JSONObject(responseString);
        System.out.println(jsonResponse.toString(10));
    }

    @DataProvider(name = "getBodyContent", parallel = true)
    private Iterator<Object[]> getBodyContent(){
        Collection<Object[]> data = new ArrayList<Object[]>();
        for(int i = 0; i < 500; i++){
            JSONObject newCompany = new JSONObject(CreateBodyContent.getBodyContentCompanies());
            data.add(new Object[] {newCompany.toString()});
        }
        return data.iterator();
    }
}
