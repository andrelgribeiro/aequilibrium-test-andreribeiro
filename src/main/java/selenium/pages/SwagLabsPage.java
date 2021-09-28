package selenium.pages;

import java.io.IOException; 
import selenium.elements.SwagLabsElements;
import org.openqa.selenium.support.FindBy;
import java.util.NoSuchElementException;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;



public class SwagLabsPage extends BasePage {
    private static JavascriptExecutor jse = (JavascriptExecutor)driver;
    private static String ENDPOINT = "";


    public static void load() throws Exception {
        driver.get(baseURL + ENDPOINT);
    }

    public static void logIn(String name, String passw) throws Exception{
        waitUntilVisible(SwagLabsElements.inputUsername, 15);
        driver.findElement(SwagLabsElements.inputUsername).sendKeys(name);
        driver.findElement(SwagLabsElements.inputPassword).sendKeys(passw);        
        driver.findElement(SwagLabsElements.buttonEnviar).click();
        waitUntilVisible(SwagLabsElements.menuLogged, 15);
    }
    public static void attemptLogIn(String name, String passw) throws Exception{
        waitUntilVisible(SwagLabsElements.inputUsername, 15);
        driver.findElement(SwagLabsElements.inputUsername).sendKeys(name);
        driver.findElement(SwagLabsElements.inputPassword).sendKeys(passw);        
        driver.findElement(SwagLabsElements.buttonEnviar).click();
    }    

    public static boolean menuLoggedIsVisible() throws Exception{ 
        Boolean gotReturn = false;  
        List<WebElement> elements = driver.findElements(SwagLabsElements.menuLogged);
        if (elements.size() > 0) {
            gotReturn = true;
        } 
        else {
            gotReturn = false;
        }
        return gotReturn;
    }    
    
    public static String getErrorMessage() throws Exception {
        return driver.findElement(SwagLabsElements.errorMessage).getText();
    }


}
