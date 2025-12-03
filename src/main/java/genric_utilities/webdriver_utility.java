package genric_utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class webdriver_utility {
	public static void takesScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		File location = new File("./src/test/resources/screenshots/dws_wd"+java_utility.getname()+".png");
		org.openqa.selenium.io.FileHandler.copy(screen, location);
	}
	public static void takeScreenshot(WebElement element) throws IOException {
		File screen = element.getScreenshotAs(OutputType.FILE);
		File location = new File("./src/test/resources/screenshots/dws_wd"+java_utility.getname()+".png");
		org.openqa.selenium.io.FileHandler.copy(screen, location);
	}
	public static void scrollToEnd(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public static void selectoption(WebElement element, String option) {
		Select sel = new Select(element);
		sel.selectByVisibleText(option);
	}
}
