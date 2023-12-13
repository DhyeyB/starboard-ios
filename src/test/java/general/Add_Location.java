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

import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;

import java.sql.Timestamp;

public class Add_Location extends Login_test {
//public class Add_Location extends Base {

	@Test(priority = 1)
	private static void Update_location() throws Exception {
		try {

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 20);

			WebElement Update_Location = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Transactions\"]")));
			
			// Click on Transactions
			driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Transactions\"]")).click();
			
			System.out.println("**********---------- Clicked on Transactions    **********----------");


			// Confirm that You are on Transactions screen if you are getting text as
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Transactions\"]")));

			// Click on 1st transaction from the list
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/transaction']) [1]")))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Confirm that You are on Transactions details screen: Name that Transaction
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/payment_title']) [1]")));

			// Click on Add/Edit Location
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Add/Edit Location']")))
					.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/name']) [1]")));
			MobileElement company_field = driver.findElement(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/name']) [1]"));
			String test = driver
					.findElement(
							By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/name']) [1]"))
					.getText();

			if (!test.equals("Company Name")) {

				// Clear Pre-filled data and update it with time stamp
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/name']) [1]")))
						.clear();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//android.widget.EditText[@text='Company Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name']")));
				driver.findElement(By.xpath(
						"//android.widget.EditText[@text='Company Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name']"))
						.sendKeys("BS" + " " + timestamp);

				driver.hideKeyboard();

				// Clicked on Final save button
				driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Export']")));

			}

			else

			{

				// Fill the Location form
				// Company Name
				WebElement Add_Location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//android.widget.EditText[@text='Company Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name']")));
				driver.findElement(By.xpath(
						"//android.widget.EditText[@text='Company Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name']"))
						.sendKeys("BS" + " " + timestamp);

				driver.hideKeyboard();

				// Address 1
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//android.widget.EditText[@text='Address 1' and @resource-id='com.impossible_research.sandbox.starboard:id/address1']")));
				driver.findElement(By.xpath(
						"//android.widget.EditText[@text='Address 1' and @resource-id='com.impossible_research.sandbox.starboard:id/address1']"))
						.sendKeys("SP1" + " " + timestamp);

				driver.hideKeyboard();

				// Address 2
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"//android.widget.EditText[@text='Address 2' and @resource-id='com.impossible_research.sandbox.starboard:id/address2']")));
				driver.findElement(By.xpath(
						"//android.widget.EditText[@text='Address 2' and @resource-id='com.impossible_research.sandbox.starboard:id/address2']"))
						.sendKeys("Vasna Area");

				driver.hideKeyboard();

				// City
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='City']")));
				driver.findElement(By.xpath("//android.widget.EditText[@text='City']")).sendKeys("Ahmebabad");

				driver.hideKeyboard();

				// Country
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Country']")));
				driver.findElement(By.xpath("//android.widget.EditText[@text='Country']")).sendKeys("India");

				driver.hideKeyboard();

				// Zip/Postal Code
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Zip/Postal Code']")));
				driver.findElement(By.xpath("//android.widget.EditText[@text='Zip/Postal Code']")).sendKeys("380007");

				driver.hideKeyboard();

				// Clicked on Final save button
				driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Export']")));

			}
		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

}
