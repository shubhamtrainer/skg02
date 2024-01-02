package extent_reports;

import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToAddScreenshot_ExtentReport {
	
	
	@Test
	public void screenshot()
	{
		Reporter.log("hello screenshot",true);
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String screen = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = LocalDateTime.now().toString().replace(":", "-");
		
		//step1: create instance for ExtentsparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/extentReports-"+time+".html");
		
		//step 2: create instance of ExetntReports
		ExtentReports reports=new ExtentReports();
		
		//step3: attach spark to ExtentReports
		
		reports.attachReporter(spark);
		
		//step4: create instance of ExtentTest
		ExtentTest test = reports.createTest("screenshot");
		
		//step 5: call log method to write in ExtentReport
		test.log(Status.INFO,"added in extent report");   
		
		test.addScreenCaptureFromBase64String(screen,"bug");
		
		//step6: call flush() to write in destination
		reports.flush();
		
	}
	
	
	
	

}
