package apiTestingUtils;

import com.github.javafaker.Company;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.json.JSONObject;

public class CreateBodyContent {

    public static String getBodyContentUsers(){
        JSONObject body = new JSONObject();
        Faker faker = new Faker();
        Name name = faker.name();
        String firstName = name.firstName();
        String lastName = name.lastName();
        String userName = name.username();
        String email = faker.internet().emailAddress();

        body.put("username",userName);
        body.put("firstname",firstName);
        body.put("lastname",lastName);
        body.put("email",email);

        return body.toString();
    }

    public static String getBodyContentCompanies(){
        JSONObject body = new JSONObject();
        Faker faker = new Faker();
        Company company = faker.company();

        body.put("companyname",company.name());
        body.put("street",faker.address().city());
        body.put("phonenumber",faker.phoneNumber().extension());

        return body.toString();
    }
}
