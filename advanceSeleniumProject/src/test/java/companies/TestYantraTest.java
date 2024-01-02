package companies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestYantraTest {
	
	@Test(groups="sanity")
	public void testyantra_company()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.testyantra.com/");
		Reporter.log("testyantra executes",true);
	}

}
