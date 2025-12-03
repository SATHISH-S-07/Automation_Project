package execute_testNG;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genric_utilities.Basemethod;
import genric_utilities.webdriver_utility;

public class AddressTest extends Basemethod {
	public String firstname = "Sathish";
	public String lastname = "S";
	public String concat = firstname.concat(" " + lastname);

	@Test(priority = 1, groups = "smoke")
	public void AddaddressTest() throws IOException {
		webdriver_utility.scrollToEnd(driver);
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//input[@value='Add new']")).click();
		driver.findElement(By.id("Address_FirstName")).sendKeys(firstname);
		driver.findElement(By.id("Address_LastName")).sendKeys(lastname);
		driver.findElement(By.id("Address_Email")).sendKeys("sathish2025@gmail.com");
		WebElement element = driver.findElement(By.id("Address_CountryId"));
		webdriver_utility.selectoption(element, "India");
		driver.findElement(By.id("Address_City")).sendKeys("chennai");
		driver.findElement(By.id("Address_Address1")).sendKeys("no.420");
		driver.findElement(By.id("Address_ZipPostalCode")).sendKeys("307");
		driver.findElement(By.id("Address_PhoneNumber")).sendKeys("9242812125");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		WebElement element2 = driver.findElement(By.xpath("//strong[text()='" + concat + "']/ancestor::div[@class='section address-item']"));
		webdriver_utility.takeScreenshot(element2);
	}

	@Test(priority = 2, groups = "functionls")
	public void updateAddtessTest() throws IOException {
		webdriver_utility.scrollToEnd(driver);
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//strong[text()='" + concat+ "']/ancestor::div[@class='section address-item']/descendant::input[@class='button-2 edit-address-button']")).click();
		driver.findElement(By.id("Address_City")).clear();
		driver.findElement(By.id("Address_City")).sendKeys("kanchipuram");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		WebElement element2 = driver.findElement(By.xpath("//strong[text()='" + concat + "']/ancestor::div[@class='section address-item']"));
		webdriver_utility.takeScreenshot(element2);

	}

	@Test(priority = 3, groups = "regretions")
	public void deleteAddress() throws InterruptedException, IOException {
		webdriver_utility.scrollToEnd(driver);
		driver.findElement(By.linkText("Addresses")).click();
		driver.findElement(By.xpath("//strong[text()='" + concat+ "']/ancestor::div[@class='section address-item']/descendant::input[@class='button-2 delete-address-button']")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(10000);
		webdriver_utility.takesScreenshot(driver);

	}

}
