package com.example;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson {
    @Test
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().header("Content-Type","application/json").
        body(payload.AddBook("abssdf", "123s423")).
        when().post("/Library/Addbook.php").
        then().assertThat().statusCode(200)
        .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
        String id = js.getString("ID");
        System.out.println(id);
    }
    
}
