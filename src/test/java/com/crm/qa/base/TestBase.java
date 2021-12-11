package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//constructor method
	//creating FileInputStream for reading data from config.properties
	public TestBase() {
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\Mandeep\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
	
	public static void initialization() {
		//identifying browser and setting browser property accordingly
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();			
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//creating object of EventFiringWebDriver class
		e_driver = new EventFiringWebDriver(driver); 
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		//doing some initial browser setup and launching URL
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
