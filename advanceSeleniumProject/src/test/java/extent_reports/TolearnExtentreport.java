package extent_reports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TolearnExtentreport {
	@Test
	public void report()
	{
		
		String time = LocalDateTime.now().toString().replace(":", "-");
		
		//step 1: create instance of ExtentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/extentReports-"+time+".html");
		
		//step2: create instance of ExtentReports
		ExtentReports reports=new ExtentReports();
		
		//step3: attach ExtentSparkReporter to ExtentReports
		reports.attachReporter(spark);
		
		//step4: create instance of ExtentTest
		ExtentTest test = reports.createTest("report");
		
		//step5: call log methods to write messages in Extent Reports
		test.log(Status.PASS,"added to exetnt reports");
		
		//step6: call flush method to write information to destination
		
		reports.flush();
		
		
		
		
		
		
		
		
		
	}

}
