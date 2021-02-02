package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;


public class StoryTellerPage extends TestBase {

	
	@FindBy(xpath="//*[@id='segmentesList']//*[@class='content pft-catalogmarkerlist'][3]")
	WebElement CatalogSegment;
	
	
	@FindBy(xpath="//*[@class='content pft-catalogmarkerlist']//*/td[5]/div/div[@class='clear-addC linked catAddtoBin  pft-catalogmarkerlist']")
	WebElement CatalogSegAddtoBin;
	
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 
	 public StoryTellerPage()  {
	 PageFactory.initElements(driver, this);
	 }
	 
	 public void AddCatalogSegment()
	 {
		 TestUtil.waitUntilLoadingSymbolGoesOff();
		 Actions movetoCatalogSegment = new Actions(driver);
		 movetoCatalogSegment.moveToElement(CatalogSegment).build().perform();
		 
		 CatalogSegAddtoBin.click();
			 
			
	
	 }
}
