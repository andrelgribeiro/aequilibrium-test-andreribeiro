package selenium.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;


public abstract class BasePage {
	public static String baseURL = "https://www.saucedemo.com/";
	public static WebDriver driver;

	public static WebElement waitUntilVisible(By element, Integer time){
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}



}