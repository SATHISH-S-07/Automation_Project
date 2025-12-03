package execute_testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Register {
@DataProvider
public String[][] registerDataProvidor(){
	String[][] data = new String[2][6];
	data[0][0]="male";
	data[0][1]="sathish";
	data[0][2]="smart";
	data[0][3]="sathish07@gmail.com";
	data[0][4]="Sathish@123";
	data[0][5]="Sathish@123";
	
	data[1][0]="female";
	data[1][1]="Roja";
	data[1][2]="flower";
	data[1][3]="roja@gmail.com";
	data[1][4]="roja@1234";
	data[1][5]="roja@1234";
	
	return data;
}

@Test(dataProvider = "registerDataProvidor")
public void loginTest(String gender,String first,String last,String email, String pass, String cpass) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://demowebshop.tricentis.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.linkText("Register")).click();
	driver.findElement(By.xpath("//input[@id='gender-"+gender+"']")).click();
	driver.findElement(By.id("FirstName")).sendKeys(first);
	driver.findElement(By.id("LastName")).sendKeys(last);
	driver.findElement(By.id("Email")).sendKeys(email);
	driver.findElement(By.id("Password")).sendKeys(pass);
	driver.findElement(By.id("ConfirmPassword")).sendKeys(cpass);
	driver.findElement(By.id("register-button")).click();
	Thread.sleep(3000);
	driver.quit();
	
}
}
