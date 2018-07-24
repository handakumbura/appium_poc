package com.dumiduh.appiumpoc.appiumpoc;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Longpress extends Base{

	@Test
	public void logPress() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		
		TouchAction action = new TouchAction(driver);
		action.tap(driver.findElementByXPath("//android.widget.TextView[@text='Views']")).perform();
		driver.findElementByAccessibilityId("Expandable Lists").click();
		driver.findElementByAccessibilityId("1. Custom Adapter").click();
		action.longPress(driver.findElementByXPath("//android.widget.TextView[@text='People Names']")).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='Sample action']").click(); 
		driver.quit();
	}
}
