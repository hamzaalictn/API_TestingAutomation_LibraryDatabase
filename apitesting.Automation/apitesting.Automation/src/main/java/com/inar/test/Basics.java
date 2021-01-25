package com.inar.test;

import com.inar.files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {
    public static void main(String[] args) {
       // Validate if Add place API is working as expected
        // given - all input details
        // when - submit the API
        // Then - validate the response
    //---------------------------------------------------

        /*
        * All input details should be part of a given method
        * @given
        * */
        RestAssured.baseURI="https://rahulshettyacademy.com";
        // provide query parameters
        String response =given().log().all().queryParam("key","qclikc123").header("Content-Type","application/json").
                body(Payload.Addplace()).when().log().all().post("maps/api/place/add/json").then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
        System.out.println(response);

        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");
        System.out.println(placeId);

        String newAddress= "Summer Walk , Africa";


        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(Payload.updatePlace(placeId,newAddress)).when().
                put("maps/api/place/update/json").then().assertThat().statusCode(200).body("msg",equalTo("Address succesfully updated"));



        String getPlaceResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id","placeId").when().get("maps/api/place/get/json")
        .then().statusCode(200).extract().response().asString();
        JsonPath js1 = new JsonPath(getPlaceResponse);

        String actualAdress = js1.getString("address");
        System.out.println(actualAdress);
        Assert.assertEquals(actualAdress,newAddress);



    }

}
