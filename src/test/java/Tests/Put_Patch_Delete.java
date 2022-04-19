package Tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class Put_Patch_Delete {

    @Test

    public void testPut() {
        baseURI =("https://reqres.in");
        JSONObject request = new JSONObject();
        request.put("name","Adrika");
        request.put("job","student");
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/api/users/2").
                then().statusCode(200).
                log().all();
        Assert.assertEquals("Adrika","Adrika");

    }
    @Test
    public void testPatch() {
        baseURI =("https://reqres.in");
        JSONObject request = new JSONObject();
        request.put("name","Adrika");
        request.put("job","student");
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().statusCode(200).
                log().all();
        Assert.assertEquals("Adrika","Adrika");

    }
    @Test
    public void testDelete() {
        baseURI =("https://reqres.in");

                when().
                        delete("/api/users/2").
                then().statusCode(204).
                log().all();

    }


}
