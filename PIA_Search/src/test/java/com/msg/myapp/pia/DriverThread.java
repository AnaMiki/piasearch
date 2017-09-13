package com.msg.myapp.pia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;

/**
 * Base Class Thread
 * @category Base Class Thread
 * @author alexander lavado
 *
 */

public class DriverThread {
	
	private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<WebDriver>();
	
	public static void setUpThread(ITestContext context) throws Exception{
		String browser = context.getCurrentXmlTest().getParameter("browser");
		WebDriver driver = null;
		if(browser.equals("firefox")){
			//load the Firefox Driver
			driver = new FirefoxDriver();			
		}
		else if(browser.equals("chrome")){
			String chromeDriverPath = context.getCurrentXmlTest().getParameter("chromeDriverPath");
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			//load the Google Chrome driver			
			driver = new ChromeDriver();
		}
		else if(browser.equals("ie11")){
			String IE11DriverPath = context.getCurrentXmlTest().getParameter("IE11DriverPath");
			System.setProperty("webdriver.ie.driver", IE11DriverPath);
			
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer(); caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("nativeEvents",false);
			
			//load the IE driver			
			driver = new InternetExplorerDriver(caps);
		}
		setDriverThread(driver);		
	}
	
	private static void setDriverThread(WebDriver driver){
		THREAD_LOCAL.set(driver);
	}
	
	public static WebDriver getDriverThread(){
		return THREAD_LOCAL.get();
	}
}
