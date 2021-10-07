package com.demoblaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoBlazeTask2 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {


		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");
		driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		String url="https://www.demoblaze.com/index.html";
		driver.get(url);
		String expectedUrl=driver.getCurrentUrl();
		Assert.assertEquals(url, expectedUrl);

	}
	@Test
	public void task() throws InterruptedException {
		//login
		SoftAssert sassert=new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.findElement(By.id("login2")).click();

		WebElement signin_firstname = wait.until
				(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
		signin_firstname.sendKeys("firstname");

		driver.findElement(By.id("loginpassword")).sendKeys("Password@123");

		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		//logged in



		//Contact us 
		Thread.sleep(2000);

		wait.until(ExpectedConditions.
				elementToBeClickable(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.id("recipient-email"))).sendKeys("abc@gmail.com");

		driver.findElement(By.id("recipient-name")).sendKeys("my name");

		driver.findElement(By.id("message-text")).sendKeys("Sample message text blah blah");

		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());		
		alert.accept();


		//Verify Categories
		driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[4]")).click();

		//		/html/body/div[5]/div/div[2]/div/div[2]/div/div/h4/a


		//Verify product
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a/img"))).click();


		//adding into cart
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"))).click();
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());		
		alert1.accept();



		//checking cart

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("/html/body/nav/div/div/ul/li[4]/a"))).click();



		//place order button
		driver.findElement
		(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.id("name"))).sendKeys("MyName");

		driver.findElement(By.id("country")).sendKeys("India");

		driver.findElement(By.id("city")).sendKeys("Pune");

		driver.findElement(By.id("card")).sendKeys("1111 1111 1111 1111");

		driver.findElement(By.id("month")).sendKeys("May");

		driver.findElement(By.id("year")).sendKeys("2025");

		Thread.sleep(2000);


		//clicking purchase
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("/html/body/div[10]/div[7]/div/button"))).click();


		//logout
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))).click();
		sassert.assertAll();
	}




	@AfterMethod
	public void tearDown()

	{
		driver.quit();

	}

}
