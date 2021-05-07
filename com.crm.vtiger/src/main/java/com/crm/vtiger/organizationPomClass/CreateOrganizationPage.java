package com.crm.vtiger.organizationPomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationPage {
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="emailoptout")
	private WebElement emailCheckBox;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignedToDropDown;
	
	@FindBy(xpath="//input[@name='assigntype' and @value='T']")
	private WebElement groupRadioButton;
	
	
	public WebElement getAssignedToDropDown() {
		return assignedToDropDown;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}

	public WebElement getEmailCheckBox() {
		return emailCheckBox;
	}

	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	/**
	 * method to create an organization
	 * @author Adarsh
	 * @param organisationName
	 */
	public void createorg(String organisationName) {
		organizationTextField.sendKeys(organisationName);
		saveButton.click();
	}
	/**
	 * method to create an organization with industry
	 * @author Adarsh
	 * @param organisationName
	 * @param industry
	 */
	public void createOrgWithIndustry(String organisationName,String industry) {
		organizationTextField.sendKeys(organisationName);
		Select s=new Select(industryDropDown);
		s.selectByValue(industry);	
		saveButton.click();
	}
	/**
	 * method to create an organization with type
	 * @author Adarsh
	 * @param organisationName
	 * @param type
	 */
	public void createOrgWithType(String organisationName,String type) {
		organizationTextField.sendKeys(organisationName);
		Select s=new Select(typeDropDown);
		s.selectByValue(type);	
		saveButton.click();
	}
	/**
	 * method to create organization with email option
	 * @author Adarsh
	 * @param organisationName
	 */
	public void createOrgWithEmail(String organisationName ) {
		organizationTextField.sendKeys(organisationName);
		emailCheckBox.click();
		saveButton.click();

	}
	public void createOrgWithGroup(String organisationName,String group) {
		organizationTextField.sendKeys(organisationName);
		groupRadioButton.click();
		assignedToDropDown.click();
		assignedToDropDown.sendKeys(group);
		saveButton.click();
		
	}
}
