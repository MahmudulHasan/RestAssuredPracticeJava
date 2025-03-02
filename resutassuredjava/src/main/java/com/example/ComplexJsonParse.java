package com.example;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {
        String jsonResponse = payload.CoursePrice();
        
        JsonPath js = new JsonPath(jsonResponse);

        String courseName = js.getString("courses[0].title");
        int coursePrice = js.getInt("courses[0].price");
        
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Price: " + coursePrice);

        int courseCount = js.getInt("courses.size()");
        System.out.println("Total number of courses: " + courseCount);
        
        for (int i = 0; i < courseCount; i++) {
            String title = js.getString("courses[" + i + "].title");
            int price = js.getInt("courses[" + i + "].price");
            System.out.println("Course " + (i + 1) + " Title: " + title);
            System.out.println("Course " + (i + 1) + " Price: " + price);
        }      
    }
}
