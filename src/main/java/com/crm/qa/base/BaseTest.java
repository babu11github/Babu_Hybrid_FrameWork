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

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver efwb;
	public static WebEventListener eventListener;
	public BaseTest()
	{
		try {
		prop = new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\purushotham\\eclipse-workspace\\FrameWork\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
	    prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
	      e.printStackTrace();
		}
	}
		
	public static void Initialization() {
	String	browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("ff"))
	{
		System.setProperty("webdriver.gecko.driver","D:\\selenium\\Lib\\bin\\geckodriver.exe");
	    driver=new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("chome"))
	{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\Lib\\bin\\chromedriver.exe");
	    driver=new ChromeDriver();
	}
		
	efwb = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	efwb.register(eventListener);
	driver = efwb;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}

}
