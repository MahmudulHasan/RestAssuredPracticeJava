package com.example;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static org.hamcrest.Matchers.*;

public class App 
{
    public static void main( String[] args )
    {  
       RestAssured.baseURI = "https://rahulshettyacademy.com";
       String response = given().queryParam("key","qaclick123").header("Content-Type","application/json")
        .body(payload.AddPlace())
        .when().post("maps/api/place/add/json")
        .then().assertThat().statusCode(200)
        .body("scope",equalTo("APP"))
        .header("Server", "Apache/2.4.52 (Ubuntu)").extract().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String placeID = js.getString("place_id");
        System.out.println(placeID);

        // Update place
        String newAddress = "Summer Walk, Africa";
        given().queryParam("key","qaclick123").header("Content-Type","application/json")
        .body("{\r\n" + 
            "\"place_id\":\""+placeID+"\",\r\n" + 
            "\"address\":\""+newAddress+"\",\r\n" + 
            "\"key\":\"qaclick123\"\r\n" + 
            "}\r\n")
        .when().put("maps/api/place/update/json")
        .then().assertThat().log().all().statusCode(200)
        .body("msg",equalTo("Address successfully updated"));

        // Get place
        String getPlaceResponse = given().queryParam("key","qaclick123").queryParam("place_id",placeID)
        .when().get("maps/api/place/get/json")
        .then().assertThat().statusCode(200).extract().asString();
        JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, newAddress);
    }
}
