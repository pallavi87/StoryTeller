package com.crm.ExtentReportListener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.BasicFileConfiguration;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.base.TestBase;

public class ExtentManager extends TestBase{
		// TODO Auto-generated method stub
		private static ExtentReports extent;
		private static String reportFileName="Test-Automaton-Report"+prop.getProperty("environment")+".html";		
	    private static String fileSeperator = System.getProperty("file.separator");
	    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
	    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
	  
	    
	    public static ExtentReports getInstance() {
	        if (extent == null)
	            createInstance();
	        return extent;
	    }
	 
	    //Create an extent report instance
	    public static ExtentReports createInstance() {
	        String fileName = getReportPath(reportFilepath);
	        
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(reportFileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(reportFileName);
	        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	        
	        extent = new ExtentReports();        
	        extent.attachReporter(htmlReporter);
	      
	        //Set environment details
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("AUT", "QA");
			
	        return extent;
	    }
	     
	    //Create the report path
	    private static String getReportPath (String path) {
	    	File testDirectory = new File(path);
	        if (!testDirectory.exists()) {
	        	if (testDirectory.mkdir()) {
	                System.out.println("Directory: " + path + " is created!" );
	                return reportFileLocation;
	            } else {
	                System.out.println("Failed to create directory: " + path);
	                return System.getProperty("user.dir");
	            }
	        } else {
	            System.out.println("Directory already exists: " + path);
	        }
			return reportFileLocation;
	    }
	    

		public static String getScreenShot(WebDriver driver,String ScreenshotName) throws IOException {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			String dest = System.getProperty("user.dir")+"/ErrorScreenshot/"+ScreenshotName+".png";
			File destination = new File(dest);
			FileUtils.copyFile(Source, destination);
			
			return dest;
		}
	    
}
	 

	


