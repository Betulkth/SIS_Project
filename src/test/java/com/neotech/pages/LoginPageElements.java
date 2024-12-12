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
	
	@FindBy(xpath="//form[1]//tr[1]/td[@class='titleMid']")
	public WebElement usernameHeader; 
	
	@FindBy(xpath="//form[1]//tr[2]/td[@class='titleMid']")
	public WebElement passwordHeader;
	
	@FindBy(xpath="//form[1]//tr[3]/td[@class='titleMid']")
	public WebElement academicYearHeader;
	
	@FindBy(id="bLogin")
	public WebElement loginBtn;
	
	public LoginPageElements() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
