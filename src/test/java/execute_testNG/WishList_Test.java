package execute_testNG;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import genric_utilities.Basemethod;

public class WishList_Test extends Basemethod {
	@Test(priority = 1, groups = "smoke")
	public void addtowishlistTest() throws IOException {
		driver.findElement(By.partialLinkText("Apparel")).click();
		driver.findElement(By.linkText("Blue and green Sneaker")).click();
		driver.findElement(By.xpath("//input[contains(@id,'add-to-wishlist-button')]")).click();
		driver.findElement(By.xpath("(//span[@class='cart-label'])[2]")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File location = new File("./src/test/resources/screenshots/addtowishlistTest.png");
		FileHandler.copy(screenshotAs, location);
	}
	@Test(priority = 2, groups = "functionls")
	public void incresecountinwishlistTest() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='cart-label'])[2]")).click();
		driver.findElement(By.xpath("//input[contains(@name,'itemquantity')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'itemquantity')]")).sendKeys("5");
		driver.findElement(By.name("updatecart")).click();
	}
	@Test(priority = 3, groups = "regrettions")
	public void wishlisttocartTest() throws IOException {
		driver.findElement(By.xpath("(//span[@class='cart-label'])[2]")).click();
		driver.findElement(By.name("addtocart")).click();
		driver.findElement(By.name("addtocartbutton")).click();
		driver.findElement(By.linkText("Shopping cart")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("./src/test/resources/screenshots/wishlisttocartTest.png");
		FileHandler.copy(screenshotAs, file);
		
	}
	@Test(enabled = false)
	public void removefromwishlistTest() throws IOException {
		driver.findElement(By.xpath("(//span[@class='cart-label'])[2]")).click();
		driver.findElement(By.name("removefromcart")).click();
		driver.findElement(By.name("updatecart")).click();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File location = new File("./src/test/resources/screenshots/removefromwishlistTest.png");
		org.openqa.selenium.io.FileHandler.copy(screenshotAs, location);
	}
	@Test(priority = 4, groups = "regrettions")
	public void emailtofriendTest() throws IOException {
		driver.findElement(By.partialLinkText("Apparel")).click();
		driver.findElement(By.linkText("Blue and green Sneaker")).click();
		driver.findElement(By.xpath("//input[contains(@id,'add-to-wishlist-button')]")).click();
		driver.findElement(By.xpath("(//span[@class='cart-label'])[2]")).click();
		driver.findElement(By.xpath("//input[@value='Email a friend']")).click();
		driver.findElement(By.xpath("//input[@class='friend-email']")).sendKeys("smartsathish2019@gmail.com");
		driver.findElement(By.xpath("//textarea[@class='personal-message']")).sendKeys("you soon get a 50LPA job");
		driver.findElement(By.xpath("//input[@name='send-email']")).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='page-body']"));
		File screenshotAs = element.getScreenshotAs(OutputType.FILE);
		File file = new File("./src/test/resources/screenshots/emailtofriendTest.png");
		FileHandler.copy(screenshotAs, file);
	}
}
