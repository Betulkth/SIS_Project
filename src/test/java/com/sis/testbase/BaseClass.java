package com.sis.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sis.utils.ConfigsReader;
import com.sis.utils.Constants;

public class BaseClass {

	public static WebDriver driver;

	public static void setUp() {

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String browser = ConfigsReader.getProperty("browser");

		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("127");

		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver(co);
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			throw new RuntimeException("Unsupported Browser");

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));

		String url = ConfigsReader.getProperty("url");
		driver.get(url);

		PageInitializer.initialize();

	}

	public static void tearDown() {

		if (driver != null)

			driver.quit();
	}

}
