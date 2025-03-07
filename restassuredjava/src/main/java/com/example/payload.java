package com.example;
public class payload {
    public static String AddPlace() {
        return "{\r\n" +
                "\"location\":{\r\n" +
                "\"lat\" : -38.383494,\r\n" +
                "\"lng\" : 33.427362\r\n" +
                "},\r\n" +
                "\"accuracy\":50,\r\n" +
                "\"name\":\"Frontline house\",\r\n" +
                "\"phone_number\":\"(+91) 983 893 3937\",\r\n" +
                "\"address\" : \"29, side layout, cohen 09\",\r\n" +
                "\"types\": [\"shoe park\",\"shop\"],\r\n" +
                "\"website\" : \"http://google.com\",\r\n" +
                "\"language\" : \"French-IN\"\r\n" +
                "}\r\n";
    }

    public static String CoursePrice() {
        return "{\r\n" +
                "\"dashboard\": {\r\n" +
                "\"purchaseAmount\": 910,\r\n" +
                "\"website\": \"rahulshettyacademy.com\"\r\n" +
                "},\r\n" +
                "\"courses\": [\r\n" +
                "{\r\n" +
                "\"title\": \"Selenium Python\",\r\n" +
                "\"price\": 50,\r\n" +
                "\"copies\": 6\r\n" +
                "},\r\n" +
                "{\r\n" +
                "\"title\": \"Cypress\",\r\n" +
                "\"price\": 40,\r\n" +
                "\"copies\": 4\r\n" +
                "},\r\n" +
                "{\r\n" +
                "\"title\": \"RPA\",\r\n" +
                "\"price\": 45,\r\n" +
                "\"copies\": 10\r\n" +
                "}\r\n" +
                "]\r\n" +
                "}\r\n";
    }
    public static String AddBook(String isbn, String aisle) {
        return "{\r\n" +
                "\"name\":\"Learn Appium Automation with Java\",\r\n" +
                "\"isbn\":\"" + isbn + "\",\r\n" +
                "\"aisle\":\"" + aisle + "\",\r\n" +
                "\"author\":\"John foe\"\r\n" +
                "}";
    }
    public static String DeleteBook(String id) {
        return "{\r\n" +
                "\"ID\" : \"" + id + "\"\r\n" +
                "}";
    }
    public static String UpdateBook(String id, String isbn, String aisle) {
        return "{\r\n" +
                "\"ID\" : \"" + id + "\",\r\n" +
                "\"aisle\":\"" + aisle + "\",\r\n" +
                "\"isbn\":\"" + isbn + "\"\r\n" +
                "}";
    }
}
