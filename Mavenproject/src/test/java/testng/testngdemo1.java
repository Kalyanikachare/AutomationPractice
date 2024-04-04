package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testngdemo1 {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void login() {
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();

	}

	@AfterMethod
	public void logout() {
		System.out.println("************Logout from the application***********************");
		driver.findElement(By.cssSelector(".oxd-userdropdown-icon")).click();
		driver.findElement(By.xpath("//*[@href='/web/index.php/auth/logout']")).click();
		
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("************Close the browser instance***********************");
		driver.close();
	}

	@Test
	public void test_OrangeHRM_PIM_Creation() {
		System.out.println("Write a code to create PIM");
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.cssSelector(".oxd-button-icon")).click();
		driver.findElement(By.name("firstName")).sendKeys("Kalyani");		
		driver.findElement(By.name("lastName")).sendKeys("Mache");	
		driver.findElement(By.cssSelector(".orangehrm-left-space")).click();
		
	}

	@Test
	public void test_OrangeHRM_PIM_Update() {
		System.out.println("Write a code to update PIM");
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.xpath("//div[@class='oxd-table-cell-actions'][1]/button[2]//i)")).click();
		driver.findElement(By.name("firstName")).sendKeys("ABC");
		driver.findElement(By.name("lastName")).sendKeys("DEF");
		driver.findElement(By.xpath("//div[label[text()='Marital Status']]/following-sibling::div//i")).click();
	}

	@Test
	public void test_OrangeHRM_PIM_Delete() {
		System.out.println("Write a code to delete PIM");
	}

	@BeforeTest
	public void openBrowser() {
		System.out.println("************Open browser and enter OrangeHRM URL***********************");
		System.out.println("************Login with valid data***********************");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
	}

}
