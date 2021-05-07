package com.crm.vtiger.objectrepository;
/**
 * @author Adarsh
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;

	public WebElement getUserNameTF() {
		return userNameTextField;
	}
	public WebElement getPasswordTF() {
		return passwordTextField;
	}
	public WebElement getSubmitButton() {
		return submitButton;
	}
	/**
	 * this method is used for application login
	 * @author Adarsh
	 * @param username
	 * @param password
	 */
	public void login(String username,String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitButton.click();	
	}
}
