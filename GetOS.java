package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@Test
public class GetOS {
  public void CheckBrowserOS() {
	  
	  System.setProperty("webdriver.chrome.driver","H:\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
		  //Get Browser name and version.
		  Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		  String browserName = caps.getBrowserName();
		  String browserVersion = caps.getVersion();
		  driver.close();
		  
		  //Get OS name.
		  String os = System.getProperty("os.name").toLowerCase();
		  System.out.println("OS = " + os + ", Browser = " + browserName + " "+ browserVersion);
		 } 
	  
  }

