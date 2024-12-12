package com.sis.testbase;

import com.neotech.pages.HomePageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.WrongUrlPageElements;

public class PageInitializer extends BaseClass{

	public static LoginPageElements loginPage;
	public static WrongUrlPageElements wrongURLPage;
	public static HomePageElements homePage;
	
	public static void initialize() {
		
		loginPage = new LoginPageElements();
		wrongURLPage = new WrongUrlPageElements();
		homePage = new HomePageElements();
		
	}
}
