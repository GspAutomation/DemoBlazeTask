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



public class DemoBlazeTask1 {
	static WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");
		driver=new ChromeDriver();//1.open the browser

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


		String url="https://www.demoblaze.com/index.html";//2.go to the link
		driver.get(url);
		String expectedUrl=driver.getCurrentUrl();
		Assert.assertEquals(url, expectedUrl);

	}


	//SignUp
	@Test
	public void signup() throws InterruptedException
	{
		Thread.sleep(2000);
		SoftAssert sassert=new SoftAssert();
		driver.findElement(By.id("signin2")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement signup_firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
		Thread.sleep(2000);

		signup_firstname.sendKeys("admin");
		Thread.sleep(2000);

		driver.findElement(By.id("sign-password")).sendKeys("12345");
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//span[.='×'])[2]")).click();



		//Login
		driver.findElement(By.id("login2")).click();
		Thread.sleep(2000);

		WebElement signin_firstname = wait.until
				(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
		signin_firstname.sendKeys("firstname");//Username

		driver.findElement(By.id("loginpassword")).sendKeys("Password@123");//Password
		Thread.sleep(2000);

		//*[@id="logInModal"]/div/div/div[3]/button[2]
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();



		//Logout
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))).click();;
		sassert.assertAll();

	}
	@AfterMethod
	public void tearDown()

	{
		driver.quit();

	}


}
