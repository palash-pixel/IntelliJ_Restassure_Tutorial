package Tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class LocalApi_test {

    //@Test
    public void post() {

        JSONObject request = new JSONObject();

        // body data//
        request.put("firstName", "yahoo");
        request.put("lastName", "Google");
        request.put("title","Plumber");

        baseURI = "http://localhost:3000";
        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString()).
                when()
                .post("/users")
        .then()
                .statusCode(201)
                .log().all();
    }

    //@Test
    public void put() {

        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstName", "Lion");
        request.put("lastName", "Mooon");
        request.put("title","Dishwasher");
        request.put("email","moon@qmail.com");

        given().contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/10")
                .then().statusCode(200)
               .log().all();
    }

    @Test
    public void delete() {
        baseURI = "http://localhost:3000";
        when().delete("/users/4").then().statusCode(200);





    }
}

