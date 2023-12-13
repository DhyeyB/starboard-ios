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

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;

import java.sql.Timestamp;

public class Linking_Transactions extends Login_test {
//public class Linking_Transactions extends Base {

	@Test(priority = 1)
	private static void Link_Invoice() throws Exception {

		try {

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 30);

			WebElement Link_Invoice = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Transactions']")));

			// Click on Transactions
			driver.findElement(By.xpath("//android.widget.TextView[@text='Transactions']")).click();

			// Confirm that You are on Transactions screen if you are getting text as
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='TRANSACTIONS']")));

			// Click on 1st transaction from the list
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/transaction']) [1]")))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Confirm that You are on Transactions details screen: Name that Transaction
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/payment_title']) [1]")));

			// Click on Link
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Link']")))
					.click();

			// Click & Print on invoice
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Invoices']")));

			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/head']) [2]")));

			driver.findElement(By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/head']) [2]"))
					.click();

			// Select & Print 1st invoice to link
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/category_name']) [1]")));

			driver.findElement(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]"))
					.click();

			// Click on Save Linked invoice
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Save']")));

			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Invoices']")));

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 2)
	private static void Link_Expense_Categories() throws Exception {
		try

		{

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 30);

			WebElement Link_Expense_Categories = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Transactions']")));

			// Click on Transactions
			driver.findElement(By.xpath("//android.widget.TextView[@text='Transactions']")).click();

			// Confirm that You are on Transactions screen if you are getting text as //
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='TRANSACTIONS']")));

			// Click on 1st transaction from the list
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/transaction']) [1]")))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Confirm that You are on Transactions details screen: Name that Transaction
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/payment_title']) [1]")));

			// Click on Link
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Link']")))
					.click();

			// wait for Expense Categories
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Expense Categories']")));

			// Scroll and Click on Expense Categories
			MobileElement ele = driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"com.impossible_research.sandbox.starboard:id/head\").instance(4));"));
			ele.click();

			// Select 1st Expense Category to link
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Click on Save Linked Expense Categories
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Save']")));

			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Expense Categories']")));

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 3)
	private static void Notes_Add() throws Exception {

		try

		{

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 30);

			WebElement Note_Add = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Transactions']")));

			// Print Transactions

			// Click on Transactions
			driver.findElement(By.xpath("//android.widget.TextView[@text='Transactions']")).click();

			// Confirm that You are on Transactions screen if you are getting text as //
			// TRANSACTIONS
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='TRANSACTIONS']")));

			// Click on 1st transaction from the list
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/transaction']) [1]")));
			driver.findElement(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/transaction']) [1]"))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Confirm that You are on Transactions details screen: Name that Transaction
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[@resource-id='com.impossible_research.sandbox.starboard:id/payment_title']) [1]")));

			// Click on Notes
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Notes']")))
					.click();

			// Click & Print Add
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Add']")))
					.click();

			// Add notes Title
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Note Title']"))).click();

			driver.findElement(By.xpath("//android.widget.EditText[@text='Note Title']"))
					.sendKeys("Note Title" + " " + timestamp);

			driver.hideKeyboard();

			// Clear Pre-filled data and update it with time stamp notes
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@resource-id='com.impossible_research.sandbox.starboard:id/desc']")));
			driver.findElement(By.xpath("//*[@resource-id='com.impossible_research.sandbox.starboard:id/desc']"))
					.clear();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='Description' and @resource-id='com.impossible_research.sandbox.starboard:id/desc']"))
					.sendKeys("BS" + " " + timestamp);

			driver.hideKeyboard();

			// Click on Save button
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Save']")))
					.click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Transactions']")));

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

}
