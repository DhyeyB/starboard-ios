
package general;

import com.codeborne.selenide.testng.TextReport;
import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.ByteArrayInputStream;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.qameta.allure.Allure;

public class Base

{
	public TextReport report = new TextReport();

	public static DesiredCapabilities cap = new DesiredCapabilities();

	public static IOSDriver<MobileElement> driver;

	public static void Home() throws Exception

	{
		// Confirm that you are on Home screen
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// Wait to load the screen For Home
		WebElement div = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Home\"]")));
		// Print that You are on Home screen
		div.click();
	}

	@BeforeSuite
	public void LoginTOApplication() throws Exception {

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
		cap.setCapability("automationName", "XCUITest");			
		cap.setCapability("udid", "704210AC-CBDA-470A-AAEA-46F68DD733EB");
		// cap.setCapability("udid", "0211057B-AA02-4ECC-970A-C1E80B9EC0BC");
		cap.setCapability("app", "../../../app/Starboard.app");
		System.out.println("**********----------     application installed    **********----------");
		cap.setCapability(MobileCapabilityType.NO_RESET, true); // It will always clear the cachess
		
		driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/"), cap);
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		
		driver.activateApp("com.impossible-research.sandbox.Starboard");
		
		System.out.println("**********----------     Starboard app opened    **********----------");
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"Allow\"]"))).click();
		
		//System.out.println("**********----------  Clicked on Allow    **********----------");
		
		// Close starboard app
		//driver.terminateApp("com.impossible-research.sandbox.Starboard");
		
		//System.out.println("**********----------     Starboard app Closed    **********----------");
				
		try {

			System.out.println("Installed App found");
			
			WebElement div1 = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//XCUIElementTypeStaticText[@name=\"Enter your 5 digit pin.\"]")));
			
			System.out.println("**********----------  Got the set pin screen    **********----------");


			if (div1.isDisplayed()) {
				
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]"))).click();
				
				//System.out.println("**********----------  Clicked on ok for fgace id   **********----------");
				
		        driver.executeScript("mobile:enrollBiometric", ImmutableMap.of("isEnabled", true));
		       		        
		        driver.executeScript("mobile:sendBiometricMatch", ImmutableMap.of("type", "faceId", "match", true));

				System.out.println("**********----------  face id machted done   **********----------");

				WebElement div = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//XCUIElementTypeButton[@name=\"Home\"]")));

			}
		}

		catch (Exception e)

		{
			System.out.println(e);
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}

		Home();
	}

	@AfterSuite
	public void TearDown() throws Exception

	{

		//driver.terminateApp("com.impossible_research.sandbox.starboard");

		Reporter.log("==========Application closed==========", true);

	}

}
