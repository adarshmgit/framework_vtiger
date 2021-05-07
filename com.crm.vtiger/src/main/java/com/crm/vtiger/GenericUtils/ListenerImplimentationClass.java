package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplimentationClass implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		String failedTestName=result.getMethod().getMethodName();
		String currentDate=new Date().toString().replace(":","_").replace(" ","_");
		EventFiringWebDriver ed=new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile=ed.getScreenshotAs(OutputType.FILE);
		File destFile=new File("./screenshot/"+failedTestName+"_"+currentDate+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
	

}
