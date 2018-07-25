package com.dumiduh.appiumpoc.appiumpoc;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Swipe extends Base{

	@Test
	public void swipe() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		TouchAction action = new TouchAction(driver);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		action.press(driver.findElementByXPath("//*[@content-desc='15']")).waitAction(Duration.ofSeconds(2)).moveTo(driver.findElementByXPath("//*[@content-desc='45']")).release().perform();
		driver.quit();
	}
}
