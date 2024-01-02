package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavenParameter {
	
	@Test
	public void recieve_data()
	{
		Reporter.log("parameters executed",true);
		WebDriver driver=new ChromeDriver();
		String URL = System.getProperty("url");
		
		driver.get(URL);
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		String un = System.getProperty("username");
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(un);
		
		String pwd = System.getProperty("password");
		
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
		
		
		
	}

}
