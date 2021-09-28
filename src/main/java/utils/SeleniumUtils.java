package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

public class SeleniumUtils {
    public static WebDriver driver;

    public SeleniumUtils() {

    }

public static String getDriverPath() {
    String OS = System.getProperty("os.name");
    String browser = System.getProperty("browserOption");
    if (browser.contains("firefox")) {
        if (OS.contains("Window")) {
            return "driver/geckodriver.exe";
        } else if (OS.contains("Mac")) {
            return "driver/geckodriver_mac";
        } else {
            return "driver/geckodriver_linux";
        }
    }
    else if (browser.contains("safari")) {
        if (OS.contains("mac")) {
            return "";
        } else {
            return "driver/chromedriver.exe";
        }
    }
    else {
        if (OS.contains("Window")) {
            return "driver/chromedriver.exe";
        } else if (OS.contains("Mac")) {
            return "driver/chromedriver_mac";
        } else {
            return "driver/chromedriver_linux";
        }
    }
}
    public static WebDriver startDriver() {
        String browser = System.getProperty("browserOption");

        if (browser.contains("firefox")){
            System.setProperty("webdriver.gecko.driver", getDriverPath());
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;
        }
        else if (browser.contains("safari")){
            WebDriver driver = new SafariDriver();
            driver.manage().window().maximize();
            return driver;
        }
        else if (browser.contains("chrome")){
            System.setProperty("webdriver.chrome.driver", getDriverPath());
            ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-gpu");
            options.addArguments("window-size=1400,800");

            WebDriver driver = new ChromeDriver(options);
            return driver;
        }
        else {
            return null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
