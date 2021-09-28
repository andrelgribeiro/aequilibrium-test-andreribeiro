package selenium.pages;

import cucumber.api.Scenario; 
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import utils.SeleniumUtils;



public class MasterHooks  extends BasePage {

    @Before
    public void setup() {
            driver = SeleniumUtils.startDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}