package com.example;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
    public static JsonPath rawToJson(String response) {
        // Add code here
        JsonPath js1 = new JsonPath(response);
        return js1;
    }
}
