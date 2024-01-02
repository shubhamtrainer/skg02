package com.tyss.genricutility;

import org.openqa.selenium.By;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Script  extends BaseClass_extentReport{
	
	@Test
	public void test_method()
	{
		
		driver.findElement(By.partialLinkText("BOOKS")).click();
		
//		Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Books","books page is not displayed");
		
		
		test.log(Status.INFO,"added in extent report");
		
	}
	

}
