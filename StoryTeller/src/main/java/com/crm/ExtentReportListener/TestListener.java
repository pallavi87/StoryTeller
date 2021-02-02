package com.crm.ExtentReportListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crm.qa.base.TestBase;


public class TestListener implements ITestListener{
	ExtentHtmlReporter htmlReporter;

	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getDescription() + "..."));
		ExtentTestManager.startTest(result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getDescription() + " test successfully...");
		
			ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getDescription()+" test case is passed",ExtentColor.GREEN));
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getDescription() + " failed...");
		
		
		try {
			
			ExtentTestManager.getTest().fail(result.getThrowable());
			ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getDescription()+" test case is Failed",ExtentColor.RED));
			ExtentTestManager.getTest().log(Status.FAIL, result.getMethod().getDescription()+" test case is Failed", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.getScreenShot(TestBase.driver,  result.getMethod().getDescription())).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getDescription() + " skipped...");
		
			ExtentTestManager.getTest().log(Status.SKIP,  MarkupHelper.createLabel(result.getMethod().getDescription()+"test case Skipped",ExtentColor.YELLOW));
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getDescription());
	}
	
}
