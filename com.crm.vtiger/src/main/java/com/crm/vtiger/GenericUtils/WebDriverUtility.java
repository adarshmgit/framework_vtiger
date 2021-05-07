package com.crm.vtiger.GenericUtils;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/* This is implicitly wait, this method wait for 20sec for page loading
	 * @Adarsh
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/*This method will give the explicitWait
	 * @Adarsh
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/*This method will wait for element and click the element
	 * @Adarsh
	 * 
	 */
	public void waitAndClick(WebElement element) throws Throwable {
		int count=0;
		while(count<40) {
			try {
				element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(5000);
				count++;
			}
		}
	}
	/*This method will select a option using visible text
	 * @Adarsh
	 */
	public void SelectOption(WebElement element,String option) {
		Select select=new Select(element);
		select.deselectByVisibleText(option);
	}
	/*This method will select a option by index 
	 * @Adarsh
	 */
	public void SelectOption(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/*This method is used to do the mouse overing options
	 * @Adarsh
	 */
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();

	}
	/* This method will swicth driver controller to next window
	 * @Adarsh
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> iterator = window.iterator();
		while(iterator.hasNext()) {
			String winId = iterator.next();
			String title= driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle)) {
				break;
			}
		}
	}
	/*To accept the alert
	 * @Adarsh
	 */
	public void acceptalert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/*To dismiss the alert
	 * @Adarsh
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/*This method is to perform scrolling action
	 * @Adarsh
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	/* This method will perform switching to a frame
	 * @Adarsh
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/*This method perform taking screenshot action
	 * @Adarsh
	 */
	public void takeScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(source, dest);
	}
	public void pressEnterKey(KeyEvent key) throws Throwable {
		Robot rc=new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);

	}


}
