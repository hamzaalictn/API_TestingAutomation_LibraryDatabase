package jiraRestAssured;

import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JiraTest {
    public static void main(String[] args) {
        SessionFilter sessionFilter = new SessionFilter();
        //Login Scenario
        String response = given().relaxedHTTPSValidation().log().all().header("Content-Type", "application/json").body(APIRequest.getLoginBody()).log().all().filter(sessionFilter).when().post("/rest/auth/1/session").then().log().all().extract().response().asString();
        ;

        String expectedMessage = "Automation comment";

        // Add comment
        String addCommentResponse = given().pathParam("key", "10020").log().all().header("Content-Type", "application/json").body(APIRequest.getCommentBody()).filter(sessionFilter).when().post("/rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
        JsonPath js = new JsonPath(addCommentResponse);
        String commentID = js.getString("id");

        // Add Attachment
        given().header("X-Atlassian-Token", "no-check").filter(sessionFilter).pathParam("key", "10020").header("Content-Type", "multipart/form-data").multiPart("file", new File("jira.txt")).when().post("/rest/api/2/issue/{key}/attachments").then().log().all().statusCode(200);


        // Get issue
        String issueDetails = given().filter(sessionFilter).pathParam("key", "10020").queryParam("fields", "comment").when().get("/rest/api/2/issue/{key}/comment").then().log().all().extract().response().asString();
        System.out.println(issueDetails);
        JsonPath js1 = new JsonPath(issueDetails);
        int commentsCount = js1.getInt("comments.size()");
        for (int i = 0; i < commentsCount; i++) {
            String commentIdIssue = js1.get("comments[" + i + "].id").toString();
            if (commentIdIssue.equalsIgnoreCase(commentID)) {
                String actualMessage = js1.get("comments[" + i + "].body").toString();
                System.out.println(actualMessage);
                System.out.println(expectedMessage);
                Assert.assertEquals(actualMessage, expectedMessage);
            }
        }

    }

}
