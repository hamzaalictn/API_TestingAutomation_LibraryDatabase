package jiraRestAssured;

public class APIRequest {



    public static String getCommentBody(){
        return "{\n" +
                "    \"body\": \"Automation comment\",\n" +
                "    \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "    }\n" +
                "}";
    }
    public static String getLoginBody() {
    return "{ \"username\": \"sheldoncooper0303\", \"password\": \"iq4jarfk\" }";
    }

}
