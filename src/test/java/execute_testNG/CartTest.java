package execute_testNG;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genric_utilities.Basemethod;
import genric_utilities.webdriver_utility;

public class CartTest extends Basemethod {
	
	@Test(priority = 1)
	public void addtocartTest() throws IOException, InterruptedException {
		
		driver.findElement(By.id("small-searchterms")).sendKeys("laptop", Keys.ENTER);
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		driver.findElement(By.linkText("Shopping cart")).click();
		Thread.sleep(1000);
		webdriver_utility.takesScreenshot(driver);
	}

	@Test(priority = 2)
	public void increseproduct() {
		driver.findElement(By.linkText("Shopping cart")).click();
		WebElement element = driver.findElement(By.xpath("//input[@class='qty-input']"));
		element.clear();
		element.sendKeys("5");
	}

	@Test(priority = 3)
	public void removefromcartTest() throws IOException, InterruptedException {
		driver.findElement(By.linkText("Shopping cart")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("removefromcart")).click();
		driver.findElement(By.name("updatecart")).click();
		webdriver_utility.takesScreenshot(driver);
	}

}
