package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LibraryPage extends TestBase{
	
	@FindBy(xpath="//*[@class='binHead']")
	WebElement Binicon;
	
	@FindBy(xpath="//*[@id='AdavncedSearchButton']")
	WebElement Searchicon;
	
	@FindBy(id="txtCurrentSearchText")
	WebElement Serachtextbox;

	@FindBy(xpath="//*[@class='infinite-tree-title' and text()='Automation Project']")
	WebElement ProjectClick;
	
	@FindBy(xpath="(//div[@dmguid])[1]")
	WebElement Fileid;
	
	@FindBy(xpath="//*[@class='Bin']")
	WebElement Binarea;
	
	@FindBy(xpath="(//*[@class='thumbnailContainer'])[1]")
	WebElement File;
	
	@FindBy(xpath= "//*[@class='binActionsText']")
	WebElement MoreIcon;
	
	@FindBy(xpath="//*[@id='ST_A']")
	WebElement StoryTellerIcon;
	
	
JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public LibraryPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	 public void ClickonBin()
	 {
		 TestUtil.waitUntilLoadingSymbolGoesOff();
		 	js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", Binicon);
			 Binicon.click();
			js.executeScript("arguments[0].setAttribute('style', 'border: 0px solid none;');", Binicon);
	
	 }
	
	
	public void DragandDropFile(String File1) 
	{
		
		TestUtil.WaitUntilElementVisible(Searchicon);
		Searchicon.click();
		Serachtextbox.click();
		Serachtextbox.clear();
		Serachtextbox.sendKeys(File1 ,Keys.ENTER);
		wait.until(ExpectedConditions.attributeContains(Fileid, "title", File1));
		TestUtil.WaitUntilElementVisible(File);
		File.click();
		Actions a = new Actions(driver);
		a.dragAndDrop(File, Binarea).build().perform();
		
	}
	
	public StoryTellerPage ClickOnStoryTellericon()
	 {
		
		MoreIcon.click();
		TestUtil.WaitUntilElementVisible(StoryTellerIcon);
		boolean CheckforStoryTellerIcon = StoryTellerIcon.isDisplayed();
		
		 if(CheckforStoryTellerIcon == true)
		 {
			 System.out.println("Story teller icon is displaying entered if condition");
			 //TestUtil.Wait();
			js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid yellow;');", StoryTellerIcon);
			StoryTellerIcon.click();
			js.executeScript("arguments[0].setAttribute('style', 'border: 0px solid none;');", StoryTellerIcon);
			 log.info("Clicked on StoryTeller Icon ");
			 TestUtil.waitUntilLoadingSymbolGoesOff();
		 }
		 else
		 {
			 log.info("Not able to Click on StoryTeller Icon . Please check the icon is avaliable to click");
		 }
		 
	     return new StoryTellerPage();
		 
	 }
}
