package com.gitbhub.listerners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.github.utils.ExtentReportsUtility;

public class TestEventListenersUtility implements ITestListener {
	private static ExtentReportsUtility extentUtilityObject;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentUtilityObject.startSingleTestReport(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentUtilityObject.logTestpassed(result.getMethod().getMethodName()+" is passed");	

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentUtilityObject.logTestFailed(result.getMethod().getMethodName()+" is failed");
		extentUtilityObject.logTestFailedWithException(result.getThrowable());	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		extentUtilityObject=ExtentReportsUtility.getInstance();
		System.out.println("report utility object created="+extentUtilityObject.toString());
		extentUtilityObject.startExtentReport();
		
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentUtilityObject.endReport();	}
	
	
}
