package companies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TcsTest {
	
	@Test(groups="smoke")
	public void tcs_company()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.tcs.com/");
		Reporter.log("tcs executes",true);
	}


}
