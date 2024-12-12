package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sis.testbase.BaseClass;

public class HomePageElements {

	@FindBy(xpath="//span[contains(text(),'Announcements')]")
	public WebElement announcements;
	
	@FindBy(id="Header1_imgSchoolLogo")
	public WebElement homePageLogo;
	
	
	
	public HomePageElements() {
		
		PageFactory.initElements(BaseClass.driver, this);
	}
}
