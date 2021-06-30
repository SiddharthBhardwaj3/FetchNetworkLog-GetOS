package testcase;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

@Test
public class FetchNetworkLogs {
	WebDriver driver;
	
	
  public void f() 
  {
	    System.setProperty("webdriver.chrome.driver","H:\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);	
			driver.get("http://www.google.com");  
			driver.findElement(By.name("q")).sendKeys("Siddharth" + Keys.ENTER);
			
			
		String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
		String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
		System.out.println(netData);
		
		  
		try {
			
			 PrintStream myconsole = new PrintStream("H://NetworkLog.txt");
			
			   myconsole.print(netData);
			   
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		driver.close();
  }
	
	
 
 
	  
}
