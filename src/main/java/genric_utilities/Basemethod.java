package genric_utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Basemethod {

	public WebDriver driver;
	public static WebDriver sDriver;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demowebshop.tricentis.com/");
	}

	@BeforeMethod(alwaysRun = true)
	public void login() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("sathish2025@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Smart12345@");
		driver.findElement(By.className("login-button")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	}

	@AfterClass(alwaysRun = true)
	public void closebrowser() {
		driver.quit();
	}

}
