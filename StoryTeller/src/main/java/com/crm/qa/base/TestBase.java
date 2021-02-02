package com.crm.qa.base;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.jsoup.Connection.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static Logger log;

	
	public TestBase() {	
		
         log =LogManager.getLogger(Base.class.getName());
		String Homedir = System.getProperty("user.dir");
	String log4jConfPath = Homedir+"\\log4j2.properties";
	PropertyConfigurator.configure(log4jConfPath);
	
	
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("../StoryTeller/src/main/java/com/crm/qa/config/ConfigQA.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void intilization() {
		
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Browser has been launched");
		} 
		else if(browsername.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Selenium-java-3.14\\geckodriver-v0.21.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      
        wait = new WebDriverWait (driver, 20);
       
		driver.get(prop.getProperty("Tenant_URL"));
		
	}

	


}
