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

        baseURI = "https://reqres.in/";
        given().
                get("/api/users?page=2")
                .then().
                assertThat().body(matchesJsonSchemaInClasspath("Json_Schema.json"))
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

