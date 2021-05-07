package com.crm.vtiger.organizationPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
     private WebElement organizationInfoText;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement organizationNameText;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryFieldText;
	
	@FindBy(id="mouseArea_Type")
	private WebElement typeFieldText;
	
	@FindBy(id="mouseArea_Email Opt Out")
	private WebElement emailOptText;
	
	@FindBy(id="mouseArea_Assigned To")
	private WebElement assignedToText;
	

	public WebElement getAssignedToText() {
		return assignedToText;
	}

	public WebElement getEmailOptText() {
		return emailOptText;
	}

	public WebElement getIndustryFieldText() {
		return industryFieldText;
	}

	public WebElement getTypeFieldText() {
		return typeFieldText;
	}

	public WebElement getOrganizationInfoText() {
		return organizationInfoText;
	}

	public WebElement getOrganizationNameText() {
		return organizationNameText;
	}
	/**
	 * method will return organisation information text
	 * @author Adarsh
	 * @return
	 */
	public String getOrgInfoText() {
		return organizationInfoText.getText();
		
	}
	/**
	 * method will return organization name text
	 * @author Adarsh
	 * @return
	 */
	public String getOrgNameText() {
		return organizationNameText.getText();
	}
	/**
	 * method will return industry text field text
	 * @author Adarsh
	 * @return
	 */
	public String getIndustryText() {
		return industryFieldText.getText();
	}
	/**
	 * method will return type text field text
	 * @author Adarsh
	 * @return
	 */
	public String getTypeText() {
		return typeFieldText.getText();
	}
	/**
	 * method will return email option text field
	 * @author Adarsh
	 * @return
	 */
	public String getEmailText() {
		return emailOptText.getText();
	}
	public String getAssignedTFText() {
		return assignedToText.getText();
	}
}
