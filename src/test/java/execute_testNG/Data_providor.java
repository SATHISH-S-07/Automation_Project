	package execute_testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Data_providor {
	@DataProvider
	public String[][] loginDataProvider() {

		String[][] data = new String[3][2];

		data[0][0] = "nikhil26@gmail.com";
		data[0][1] = "nikhil123";
		data[1][0] = "karthi1329@gmail.com";
		data[1][1] = "123456789";
		data[2][0] = "iamkannan@gmail.com";
		data[2][1] = "kannan123";

		return data;
	}

	@Test(dataProvider = "loginDataProvider")
	public void loginTest(String Email, String Password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
