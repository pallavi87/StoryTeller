package com.crm.qa.util;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.crm.qa.base.TestBase;
import com.aventstack.extentreports.Status;
import com.crm.ExtentReportListener.*;

public class TestUtil extends TestBase {

	public static   WebDriver driver ;
	public static long IMPLICIT_WAIT = 50;
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//public static WebDriverWait wait ;
	
	public static SoftAssert softAssert = new SoftAssert();
	

	public static  void Wait() throws InterruptedException
	{  
		Thread.sleep(4000);
	}
	public static void Softasset(String actual ,String expected,String message )
	{
		softAssert.assertEquals(actual, expected , message);
		softAssert.assertAll();
	}
	public static void AssertTrue(boolean verify , String Message)
	{
		softAssert.assertTrue(verify, Message);
		softAssert.assertAll();
	}
	public static void AsserFalse(boolean verify , String Message)
	{
		softAssert.assertFalse(verify, Message);
		softAssert.assertAll();
	}
	
	public static String AlertPopup() {
		
		Alert Validate_Popup = driver.switchTo().alert();
		String Alert_text = Validate_Popup.getText();
		return  Alert_text;
	}
	public static void Explictwait(WebElement Locator)
	{
		
		WebElement Locator_Idenity = wait.until(ExpectedConditions.elementToBeClickable(Locator));
		Locator_Idenity.click();
	}

	public static void  Refresh()
	{
		driver.navigate().refresh();
	}
	public static void javaScriptScrool(WebElement ScroolId)
	{
		js.executeScript("arguments[0].scrollIntoView();", ScroolId);
	}
	public static void WaitUntilElementVisible(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	public static void WaitUntilElementClickable(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	public static void WaitUntilElementInvisible(WebElement el) {
		wait.until(ExpectedConditions.invisibilityOf(el));
	}
	public static void Explicitwait(WebElement el) {
		try {	
			wait.until(ExpectedConditions.visibilityOf(el));
		} catch (NoSuchElementException e){
			e.printStackTrace();
		}
	}
	public static void waitUntilLoadingSymbolGoesOff() {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("globalWaiting")));
			//log.info("Waiting due to Page is loading");		
	}
	public static void waituntilvisibilityofelementLocated(By locator) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void visibilityofAllElements(WebElement deletePublish) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOfAllElements(deletePublish));
	}
	public static void waitUntilLoading() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("text() = 'loading...'")));
		
	}
	public static void info(String message) {
       // log.info(message);
        ExtentTestManager.getTest().log(Status.INFO, message);
    }
    public static void debug(String message) {
       // log.debug(message);
        ExtentTestManager.getTest().log(Status.DEBUG, message);
    }
    public static void fatal(Exception e) {
       // log.fatal(e);
        ExtentTestManager.getTest().log(Status.INFO, e.getStackTrace().toString());
    }
	public static void error(String string) {
		
		//log.debug(string);
		 ExtentTestManager.getTest().log(Status.ERROR, string);
	}

	
}
