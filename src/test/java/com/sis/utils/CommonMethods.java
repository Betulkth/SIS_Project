package com.sis.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sis.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);
	}

	public static void clickRadioOrCheckBox(List<WebElement> elementList, String selectValue) {

		for (WebElement el : elementList) {

			String elementValue = el.getAttribute("value").trim();

			if (elementValue.equals(selectValue) && el.isEnabled()) {

				el.click();
				break;

			}
		}
	}

	public static void wait(int seconds) {

		try {

			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void selectDropdown(WebElement element, String visibleText) {

		try {

			Select sl = new Select(element);
			sl.selectByVisibleText(visibleText);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void selectDropdown(WebElement element, int index) {

		try {

			Select sl = new Select(element);
			sl.selectByIndex(index);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void clickOnElement(List<WebElement> list, String value) {

		for (WebElement option : list) {

			if (option.getText().equals(value)) {

				click(option);
				break;
			}

		}

	}

	public static void selectCalendarDate(List<WebElement> elements, String date) {

		for (WebElement day : elements) {

			if (day.getText().equals(date)) {

				click(day);
				break;

			} else {
				System.out.println("This day is not enabled!!");
				break;
			}

		}

	}

	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();
		}

	}

	public static void dismissAlert() {

		try {

			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}

	}

	public static void sendAlertText(String text) {

		try {

			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);

		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}

	}

	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	public static void switchToFrame(String nameOrId) {

		try {

			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();

		}
	}

	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);

		} catch (NoSuchFrameException e) {

			e.printStackTrace();
		}

	}

	public static void switchToFrame(int index) {

		try {

			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {

			e.printStackTrace();
		}

	}

	public static void switchToChildWindow() {

		String mainWindow = driver.getWindowHandle();

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!mainWindow.equals(handle)) {
				driver.switchTo().window(handle);

			}

		}

	}

	public static WebDriverWait getWaitObject() {

		return new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

	}

	public static WebDriverWait getWaitObject(int secondsToWait) {

		return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
	}

	public static WebElement waitForVisibility(By locator) {

		return getWaitObject().until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));

	}

	public static void click(WebElement element) {

		waitForClickability(element);
		element.click();
	}

	public static JavascriptExecutor getJSObject() {

		return (JavascriptExecutor) driver;
	}

	public static void jsClick(WebElement element) {

		getJSObject().executeScript("arguments[0].click()", element);

	}

	public static void scrollToElement(WebElement element) {

		getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public static void scrollUp(int pixel) {

		getJSObject().executeAsyncScript("window.scrollBy(0,-" + pixel + ")");
	}

	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	public static String getTimeStamp() {

		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HH_mm_SS");

		return sdf.format(date);
	}

	public static byte[] takeScreenShot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File screenShot = ts.getScreenshotAs(OutputType.FILE);

		String destination = Constants.SCREENSHOT_FILEPATH + fileName + getTimeStamp() + ".png";

		try {

			FileUtils.copyFile(screenShot, new File(destination));

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Unable to save the screenshot!!");
		}

		byte[] toReturn = ts.getScreenshotAs(OutputType.BYTES);

		return toReturn;

	}

}
