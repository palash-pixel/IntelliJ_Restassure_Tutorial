package Tests;
import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class SoapXmlRequest {

    @Test(priority = 0)
    public void ValidateSoapXml_add() throws IOException {
        File file_add = new File("./Soap_Request/add.xml");
        FileInputStream fileInputStream = new FileInputStream(file_add);

        if (file_add.exists())
            System.out.println(">>>>> File exists");

        String requestbody = IOUtils.toString(fileInputStream,"UTF-8");

        baseURI = "http://www.dneonline.com";
        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestbody).
                when()
                .post("/calculator.asmx").then()
                .statusCode(200).and()
                .body("//*:AddResult.text()",equalTo("15"))
                //.assertThat().body(matchesXsdInClasspath("Soap_Schema.xml"))
                .log().all();
    }

    //@Test(priority = 1)
    public void ValidateSoapXml_divide() throws IOException {
        File file_divide = new File("./Soap_Request/divide.xml");
        FileInputStream fileInputStream1 = new FileInputStream(file_divide);
        if (file_divide.exists())
            System.out.println("   >>>>>> File exists");
                    else
            System.out.println("   >>>>>> File Not exists");


        String requestbody1 = IOUtils.toString(fileInputStream1,"UTF-8");
        baseURI = "http://www.dneonline.com";
        given()
                .contentType("text/xml").accept(ContentType.XML)
                .body(requestbody1)
                .when()
                .post("/calculator.asmx?op=Divide")
                .then().statusCode(200).body("//*:DivideResult.text()",equalTo("25"))

                .log().all();



    }
}
