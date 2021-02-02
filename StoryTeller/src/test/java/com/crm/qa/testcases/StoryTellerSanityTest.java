package com.crm.qa.testcases;
import java.awt.AWTException;

import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ExtentReportListener.TestListener;
import com.crm.qa.base.TestBase;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LibraryPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StoryTellerPage;
import com.crm.qa.util.TestUtil;

@Listeners(TestListener.class)
public class StoryTellerSanityTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	LibraryPage libraryPage;
	StoryTellerPage storytellerpage;
	
	@BeforeSuite
	public void SanityStart() {
		System.out.println("================SANITY REPORT START =================");
		log.info("Automation Testing Start Running !!!");
	}
	
	@BeforeTest(enabled=true)
	public void Login() throws InterruptedException {
		intilization();
		loginpage = new LoginPage(driver);
	}
	
	@Test(enabled=true,priority = 1,description = "Login with valid Credentials")
	public void VaildateUserLogin() throws InterruptedException {
	       homepage= loginpage.login(prop.getProperty("Username"), prop.getProperty("Pwd"));
		
	}
	
	@Test(enabled=true,priority = 2,description = "Navigate To LibraryPage")
	public void NavigateToLibraryPage() throws InterruptedException {

		libraryPage = homepage.ClickonLibrary();
		
	}

	@Test(enabled=true,priority = 3,description = "DragandDropTheAssets")
	public void DragandDropTheAssets() throws InterruptedException {
	
		libraryPage.ClickonBin();
		libraryPage.DragandDropFile(prop.getProperty("VideoFile1"));
		libraryPage.DragandDropFile(prop.getProperty("VideoFile2"));
		
	}
	
	@Test(enabled=true,priority = 4,description = "StoryTellerLaunch")
	public void StoryTellerLaunch() throws InterruptedException {

		storytellerpage = libraryPage.ClickOnStoryTellericon();
		
	}
	
	@Test(enabled=true,priority = 5,description = "AddSegments")
	public void AddSegments() throws InterruptedException {

		storytellerpage.AddCatalogSegment();
		
	}

}
