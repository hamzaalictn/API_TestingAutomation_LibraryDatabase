package com.inar.files;

public class Payload {

    public static String Addplace() {
        return "{\n \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Inar Academy : User 1  \",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"serdivan \",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://rahulshettyacademy.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}";
    }

    public static String updatePlace(String place_id, String adress) {
        return "{\n" +
                "\"place_id\":\"" + place_id + "\",\n" +
                "\"address\": \"" + adress + "\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }

    public static String CoursePrice() {

        return "{\r\n" +
                "  \"dashboard\": {\r\n" +
                "    \"purchaseAmount\": 1162,\r\n" +
                "    \"website\": \"rahulshettyacademy.com\"\r\n" +
                "  },\r\n" +
                "  \"courses\": [\r\n" +
                "    {\r\n" +
                "      \"title\": \"Selenium Python\",\r\n" +
                "      \"price\": 50,\r\n" +
                "      \"copies\": 6\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"Cypress\",\r\n" +
                "      \"price\": 40,\r\n" +
                "      \"copies\": 4\r\n" +
                "    },\r\n" +
                "    {\r\n" +
                "      \"title\": \"RPA\",\r\n" +
                "      \"price\": 45,\r\n" +
                "      \"copies\": 10\r\n" +
                "    },\r\n" +
                "     {\r\n" +
                "      \"title\": \"Appium\",\r\n" +
                "      \"price\": 36,\r\n" +
                "      \"copies\": 7\r\n" +
                "    }\r\n" +
                "    \r\n" +
                "    \r\n" +
                "    \r\n" +
                "  ]\r\n" +
                "}\r\n" +
                "";
    }

    public static String  Addbook (){
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java : version 1 \",\n" +
                "\"isbn\":\"bcd123\",\n" +
                "\"aisle\":\"22722\",\n" +
                "\"author\":\"John foe2\"\n" +
                "}";
    }
}
