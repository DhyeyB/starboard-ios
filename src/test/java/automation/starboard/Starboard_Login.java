package automation.starboard;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

@Test(priority=1)
public class Starboard_Login {
	public static void main(String[]args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//cap.setCapability("ignoreHiddenApiPolicyError", true);
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		
		cap.setCapability("app","/home/purvish/Downloads/Starboard-debug-1.5.1-20-03-2023.apk");
		//cap.setCapability("appium:systemPort", 6);		
			
			AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
			
		Thread.sleep(5000);
		//click on skip button
		driver.findElement(By.id("com.impossible_research.sandbox.starboard:id/skip_btn")).click();
		//click on sign in button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Sign in\"]")).click();
		//click on email textbox
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@index='0']")).sendKeys("purvish.pandya+scowner@bombaysoftwares.com");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Send Magic Link']")).click();
		Thread.sleep(11000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();
		Thread.sleep(1000);
		driver.closeApp();
		
		// to open gmail and click on thye link
		driver.activateApp("com.google.android.gm");

		driver.navigate().refresh();
	
		driver.findElement(By.xpath("//android.widget.TextView[@text='Magic link to sign in to the app.']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.view.View[@content-desc='Login to Starboard']")).click();
		
		driver.closeApp();
		
		driver.quit();


	}

	
}
