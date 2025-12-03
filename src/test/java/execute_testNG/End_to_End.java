package execute_testNG;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class End_to_End {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("sathish2025@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Smart12345@");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
		driver.findElement(By.name("q")).sendKeys("laptop");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		driver.findElement(By.linkText("Shopping cart")).click();
		WebElement qty = driver.findElement(By.xpath("//*[contains(@name,'itemquantity')]"));
		qty.clear();
		qty.sendKeys("5");
		
		WebElement County = driver.findElement(By.id("CountryId"));
		Select sCounty=new Select(County);
		sCounty.selectByContainsVisibleText("India");
		
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[1]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[2]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[3]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[4]")).click();
		driver.findElement(By.xpath("(//input[@value='Continue'])[5]")).click();
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		driver.quit();
		
		
	}
}
