package practise.com;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PractiseTest {


    // @Test
    public void testt() {

        baseURI = "https://reqres.in/api";

        given().get("users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"));

        System.out.println(given().get("users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George")));

    }

    @Test
    public void posttt() {

        ////        Map<String, Object> map = new HashMap<>();
        ////        map.put("name", "morpheus");
        ////        map.put("job", "leader");
        //        System.out.println(map);
        JSONObject request = new JSONObject();
        request.put("name", "morpheus");
        request.put("job", "leader");
        baseURI = "https://reqres.in/api";
        given().body(request.toJSONString()).when().post("/users?page=2").then().statusCode(201).log().all();
    }

}


//commenting code for testing

