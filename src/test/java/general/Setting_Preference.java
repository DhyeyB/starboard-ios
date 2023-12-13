package general;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;

import java.sql.Timestamp;

public class Setting_Preference extends Login_test {
//public class Setting_Preference extends Base {

	@Test(priority = 1)
	private static void Preference() throws Exception

	{
		try

		{
			Home();

			WebDriverWait wait = new WebDriverWait(driver, 30);

			WebElement Preference = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Settings']")));

			// Click on Settings
			driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();

			// Confirm that you are on Settings page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Settings' and @resource-id='com.impossible_research.sandbox.starboard:id/head_txt']")));

			// Click on Preferences
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Preferences']"))).click();

			// Confirm that you are on Preferences page : By printing System
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='System']")));
			// Print Date Format button
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Date Format']")));
			// Click on Date Format button to update
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Date Format']"))).click();

			// Print Date Format to confirm that you are on edit screen of Date format
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index='1'])[1]")));

			// Click on MM:DD:YYYY Format
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();

			// Click on Done
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Done']")))
					.click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Preferences']"))).click();
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 2)
	private static void Update_mydetails() throws Exception

	{
		try

		{

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 30);

			WebElement Update_mydetails = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Settings']")));

			// Click on Settings
			driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();

			// Confirm that you are on Settings page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Settings' and @resource-id='com.impossible_research.sandbox.starboard:id/head_txt']")));

			// Print My Details
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='My Details']"))).click();

			// Confirm that you are on My Details page
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Name']")));

			// Print Edit button
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Edit']")))
					.click();

			// Print Address Label to confirm that you are on edit screen of my details
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Address']")));

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Click on Address to update

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/address']) [1]")));

			driver.findElement(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/address']) [1]")).clear();

			driver.findElement(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/address']) [1]"))
					.sendKeys("Ahmedabad" + " " + timestamp);

			// Click on Save
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Save']")))
					.click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='My Details']")));
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

			Assert.fail(e.getMessage());

		}
	}

}
