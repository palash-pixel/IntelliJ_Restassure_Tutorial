package Tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tests_New {

    //@Test
    public void get1(){

        Response response = get("https://reqres.in/");




        System.out.println(response.getTime());
       System.out.println(response.getStatusCode());}

//    @Test
    void test_2() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");


        System.out.println(response.getTime());
        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        System.out.println(response.contentType());
        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void test_get(){
        baseURI =("https://reqres.in/api");

        given().
                get("/users?page=2").
                    then().statusCode(200).
                body("data[0].email",equalTo("michael.lawson@reqres.in")).and().
                body("data[1].id",equalTo(8)).log().all();


    }

    @Test

    public void test_post() {
        baseURI =("https://reqres.in/api");
        JSONObject request = new JSONObject();
        request.put("name","Adrika");
        request.put("job","student");
        System.out.println(request.toJSONString());

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().statusCode(201).
                log().all();
        Assert.assertEquals("Adrika","Adrika");



    }
}
