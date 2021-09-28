package selenium.pages;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java8.En;
import org.json.simple.JSONObject;
import java.lang.Math;
import selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;
import selenium.pages.SwagLabsPage;
import java.io.FileInputStream;
import java.util.Properties;
import selenium.elements.SwagLabsElements;





import java.util.UUID;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;



public class SwagLabsSteps extends BasePage implements En {


    public SwagLabsSteps() {
        Properties loadPropsUsers = new Properties();

        Given("the user navigates to the login page", () -> {
            // Load Settings
            loadPropsUsers.loadFromXML(new FileInputStream("./src/test/resources/dataTests/users.xml"));
            SwagLabsPage.load();           
        });      


        When("the user inform the correct username and password", () -> {
            String userName = loadPropsUsers.getProperty("standardUsername");
            String password = loadPropsUsers.getProperty("standardPassword");            
            SwagLabsPage.logIn(userName, password); 
        });

        Then("the system logs in successfully", () -> {
            assertTrue("The user Menu is shown", SwagLabsPage.menuLoggedIsVisible());
        });

        When("the user inform the invalid username", () -> {
            String userName = "invalid_user";
            String password = loadPropsUsers.getProperty("standardPassword");            
            SwagLabsPage.attemptLogIn(userName, password); 
        });

        Then("the system does not perform user login", () -> {
            assertFalse("The user Menu is NOT shown", SwagLabsPage.menuLoggedIsVisible());
            assertTrue("Error message should inform something wrong with the user or password", SwagLabsPage.getErrorMessage().contains("do not match any user"));
        });

        When("the user inform the correct username and wrong password", () -> {
            String userName = loadPropsUsers.getProperty("standardUsername");
            String password = "wrong";
            SwagLabsPage.attemptLogIn(userName, password); 
        });

        When("the user does not inform the username but entering the password", () -> {
            String userName = "";
            String password = loadPropsUsers.getProperty("standardPassword");            
            SwagLabsPage.attemptLogIn(userName, password); 
        });

        Then("the system inform the user about empty fields", () -> {
            assertTrue("Error message should inform the empty fields", SwagLabsPage.getErrorMessage().contains("required"));

        });

        When("the user does not inform the password but entering the username", () -> {
            String userName = loadPropsUsers.getProperty("standardUsername");
            String password = "";
            SwagLabsPage.attemptLogIn(userName, password); 
        });
        
        When("inform a locked user in login page", () -> {
            String userName = loadPropsUsers.getProperty("lockedUsername");
            String password = loadPropsUsers.getProperty("lockedPassword"); 
            SwagLabsPage.attemptLogIn(userName, password); 
        });

        Then("the system inform that the user is locked", () -> {
            assertTrue("Error message should inform about the locked User", SwagLabsPage.getErrorMessage().contains("locked"));
        });


    }
}