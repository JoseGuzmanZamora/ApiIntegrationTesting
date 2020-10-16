package apiTestingUtils;

import com.google.gson.Gson;
import org.json.JSONArray;

import java.util.ArrayList;

public class Company {
    public Integer id;
    public String companyname;
    public String street;
    public String phonenumber;

    public static ArrayList<Company> fromJsonArray(JSONArray companies){
        Gson gson = new Gson();
        ArrayList<Company> result = new ArrayList<Company>();
        for (Object company:
                companies) {
            result.add(gson.fromJson(company.toString(), Company.class));
        }
        return result;
    }
}
