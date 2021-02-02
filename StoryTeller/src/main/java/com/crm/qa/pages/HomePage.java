package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{

	Properties obj = new Properties(); 
	
	@FindBy(xpath = "//*[@role='presentation'  and contains(@title ,'Library')]")
	WebElement Libraryicon;
	
	By Locator = By.xpath("//*[@role='presentation'  and contains(@title ,'Library')]");
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 
public HomePage()  {
PageFactory.initElements(driver, this);
}


public void Navigate_handle()
{
	
	js.executeScript("arguments[0].scrollIntoView();", Libraryicon);	
}

public  LibraryPage ClickonLibrary() throws InterruptedException {
		
	TestUtil.waitUntilLoadingSymbolGoesOff();
	
	js.executeScript("arguments[0].scrollIntoView();", Libraryicon);
	js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", Libraryicon);
	//Libraryicon.click();
	TestUtil.waituntilvisibilityofelementLocated(Locator);
	//TestUtil.visibilityOfElementLocated(Libraryicon);
	js.executeScript("arguments[0].setAttribute('style', 'border: 0px solid none;');", Libraryicon);
	log.info("Clicked on the Library Panel");
	
	return new LibraryPage();
}


}
