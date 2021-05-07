package com.crm.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organisationLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	

	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public WebElement getOrganisationLink() {
		return organisationLink;
	}
	public WebElement getContactsLink() {
		return opportunitiesLink;
	}
	/**
	 * sign out from application
	 * @author Adarsh
	 */
	public void signOut() {
		mouseOver(driver, administratorImg);
		logoutLink.click();
	}
	/**
	 * click on organisation link
	 * @author Adarsh
	 */
	public void clickOrganisation() {
		organisationLink.click();
	}
	/**
	 * click on contact link
	 * @author Adarsh
	 */
	public void clickContacts() {
		opportunitiesLink.click();
		
	}
	
	
	
	
	
	
	
	
	
}
