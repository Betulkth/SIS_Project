package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.testbase.BaseClass;

public class LoginPageElements {

	@FindBy(xpath="//font[text()='Student Information System']")
	public WebElement SIStitle;
	
	@FindBy(id="topLogo")
	public WebElement logo;
	
	@FindBy(xpath="//td[contains(text(), 'Username')]")
	public WebElement usernameHeader; 
	
	@FindBy(xpath="//td[contains(text(), 'Password')]")
	public WebElement passwordHeader;
	
	@FindBy(xpath="//td[contains(text(), 'Academic Year')]")
	public WebElement academicYearHeader;
	
	@FindBy(id="bLogin")
	public WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='tUsername']")
	public WebElement usernameBox;
	
	@FindBy(xpath="//input[@id='tPassword']")
	public WebElement passwordBox;
	
	public LoginPageElements() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
