package Tests;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

public class Json_Schema_Validfation {

    @Test
    public void Schema_test() {

        baseURI = "http://localhost:3000";
        given().
                get("/users")
                .then().
                assertThat().body(matchesJsonSchemaInClasspath("Schema.json"))
                .statusCode(200);

    }


    @Test
    public void test_get() {
        baseURI = ("https://reqres.in/api");

        given().
                get("/users?page=2").
                then().statusCode(200).
                body("data[0].email", equalTo("michael.lawson@reqres.in")).and().
                body("data[1].id", equalTo(8))
                .log().all();



    }


}

