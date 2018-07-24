package com.dumiduh.appiumpoc.appiumpoc;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollandSeekbar extends Base{

	@Test
	public void seekBarTestcase() throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Seek Bar\"));");
		driver.findElementByAccessibilityId("Seek Bar").click();
		Thread.sleep(3000);
		WebElement slider = driver.findElementByXPath("//android.widget.SeekBar");
		int xAxisStartPoint = slider.getLocation().getX();
		int xAxisEndPoint = xAxisStartPoint + slider.getSize().getWidth();
		int yAxis = slider.getLocation().getY();
		TouchAction act=new TouchAction(driver);
		act.press(xAxisStartPoint,yAxis).waitAction(Duration.ofSeconds(2)).moveTo(((xAxisEndPoint/100)*75),yAxis).release().perform();
		driver.quit();
		
		
	
	}
}
