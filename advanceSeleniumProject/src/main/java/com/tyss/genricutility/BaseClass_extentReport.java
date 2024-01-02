package com.tyss.genricutility;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass_extentReport {
	public static ExtentReports reports;
	public static WebDriver driver;
	public static ExtentTest test;
	
	@BeforeSuite
	public void configReport()
	
	{
		
String time = LocalDateTime.now().toString().replace(":", "-");
		
		//step1: create instance for ExtentsparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/extentReports-"+time+".html");
		
		//step 2: create instance of ExetntReports
		reports=new ExtentReports();
		
		//step3: attach spark to ExtentReports
		
		reports.attachReporter(spark);
		
		
	}
	
	@BeforeClass
	public void launch()
	{
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.get("https://demowebshop.tricentis.com/");
	}
	
	
	@BeforeMethod
	public void login(Method method)
	{
		 test = reports.createTest(method.getName());
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("skg11@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("testing");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
	
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void backupReport()
	{
		reports.flush();
	}
	
	
	
	
	
}
