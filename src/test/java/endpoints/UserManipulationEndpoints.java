package endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserManipulationEndpoints {
    static String dummyTestBaseURI = System.getProperty("sys.demo.dummyBaseURI");

    public static Response listUsers(Integer page) {
        return given().contentType("application/json")
                .queryParam("page", page)
                .when().get(dummyTestBaseURI+ "/api/users");
    }

    public static Response singleUser(Integer Id) {
        return given().contentType("application/json")
                .pathParam("id", Id)
                .when().get(dummyTestBaseURI+ "/api/users/{id}");
    }

    public static Response singleUserGoRest(Integer Id) {
        return given().contentType("application/json")
                .pathParam("id", Id)
                .when().get("https://jsonplaceholder.typicode.com/posts/{id}");
    }

    public static Response createUser(String json) {
        RequestSpecification req = given().contentType("application/json");
        if (json != null) {
            req.body(json);
        }
        return req.when().post("https://jsonplaceholder.typicode.com/posts/");
    }

    public static Response getData() {
        return given().when().get("https://httpstat.us/503");
    }
}
