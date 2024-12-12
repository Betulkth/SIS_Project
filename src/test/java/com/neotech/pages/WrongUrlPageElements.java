package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.testbase.BaseClass;

public class WrongUrlPageElements {

	@FindBy(xpath="//h2[text()='404 - File or directory not found.']")
	public WebElement errorMsg;
	
	public WrongUrlPageElements() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}
}
