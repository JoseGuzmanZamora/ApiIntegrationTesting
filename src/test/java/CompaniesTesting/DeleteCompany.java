package CompaniesTesting;

import apiTestingUtils.ApiRequests;
import apiTestingUtils.Company;
import apiTestingUtils.User;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DeleteCompany {
    @Test(groups = {"all", "deleteMethods", "deleteCompanies"}, description = "Delete Companies", dataProvider = "deleteOddCompanies")
    public void deleteCompanies(String ids){
        String url = "http://localhost:5000/companies/removebyid/" + ids;
        String responseString = ApiRequests.makeDeleteRequest(url).asString();
        JSONObject jsonResponse = new JSONObject(responseString);
        System.out.println(jsonResponse.toString(10));
    }

    @DataProvider(name = "deleteOddCompanies", parallel = true)
    private Iterator<Object[]> deleteOddCompanies(){
        JSONArray companies = GetCompany.getCompanies();
        ArrayList<Company> actualCompanies = Company.fromJsonArray(companies);

        // Iterate and add even numbers
        Collection<Object[]> data = new ArrayList<Object[]>();
        for (Company company:actualCompanies) {
            if(company.id % 2 != 0){
                data.add(new Object[] {company.id.toString()});
            }
        }
        return data.iterator();
    }
}
