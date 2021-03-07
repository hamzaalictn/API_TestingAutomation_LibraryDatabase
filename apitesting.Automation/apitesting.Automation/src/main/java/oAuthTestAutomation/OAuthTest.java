package oAuthTestAutomation;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.given;

public class OAuthTest {
    public static void main(String[] args) throws InterruptedException {
        // integration Web UI Automation to generate Authorization code  >> to work on browser, we need to use Selenium
        System.setProperty("webdriver.chrome.driver", "/Users/hamzaalicetin/Desktop/Meterials/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://accounts.google.com/o/oauth2/v2/auth...");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("inar@gmail.com");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password123");
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();

        // Take the query parameter of the whole url by splitting the string {Java Method}
        String partialCode = url.split("code=")[1];
        String code = partialCode.split("&scope")[0];


        // get access Token parameter
        String accessTokenResponse =given().urlEncodingEnabled(false)
                .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W ")
                .queryParam("redirect_url","https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type","authorization_code")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath jsonPath = new JsonPath(accessTokenResponse);
        String accessToken = jsonPath.getString("access_token");


        String response = given().queryParam("access_token",accessToken).
                when().log().all()
                .get("https://rahulshettyacademy.com/getCourse.php")
                .asString();

        System.out.println(response);

    }

}
