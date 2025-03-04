package com.example;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;

public class DynamicJson {
    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().header("Content-Type","application/json").
        body(payload.AddBook(isbn, aisle)).
        when().post("/Library/Addbook.php").
        then().assertThat().statusCode(200)
        .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
        String id = js.getString("ID");
        System.out.println(id);
    }

    @DataProvider(name = "BooksData")
    public Object[][] getData() {
        return new Object[][] {{"asdf", "1234"}, {"qwer", "5678"}, {"zxcv", "9012"}};
    }
    
}
