package com.gapstar.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gapstar.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try 
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\it17145930\\GapstarWorkspace\\GapstarAssignment\\src\\main\\java\\com\\gapstar\\config\\config.properties");
			prop.load(fis);
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\it17145930\\GapstarWorkspace\\browserDrivers\\chromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\it17145930\\GapstarWorkspace\\browserDrivers\\gechoDriver\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("ie"))
		{
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			System.setProperty("webdriver.ie.driver", "C:\\Users\\it17145930\\GapstarWorkspace\\browserDrivers\\IEDriver\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(caps);
			
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		}
}
