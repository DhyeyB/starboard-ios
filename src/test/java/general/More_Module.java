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

public class More_Module extends Login_test
//public class More_Module extends Base

{

	@Test(priority = 1)
	public static void Supplier() throws Exception

	{
		try {

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement more_supplier = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='More']")));

			// Click on More
			driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Suppliers']")));

			// Click on Suppliers
			driver.findElement(By.xpath("//android.widget.TextView[@text='Suppliers']")).click();

			// Confirm that You are on Add Supplier screen if you are getting text as Add
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Add']")));

			// Click on Add Supplier button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Add']")).click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Add Category name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='Supplier Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name']")))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='Supplier Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name']"))
					.sendKeys("Supplier" + " " + timestamp);

			// Link Expense Category
			driver.findElement(By.xpath("//android.widget.TextView[@text='Expense Category']")).click();

			// Click on first Exp category
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Click on Save Button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Add Supplier Address
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='' and @resource-id='com.impossible_research.sandbox.starboard:id/address']")))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='' and @resource-id='com.impossible_research.sandbox.starboard:id/address']"))
					.sendKeys("Ahmedabad");

			driver.hideKeyboard();

			// Click on Email address field
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='' and @resource-id='com.impossible_research.sandbox.starboard:id/email']")))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='' and @resource-id='com.impossible_research.sandbox.starboard:id/email']"))
					.sendKeys("pandyapurvish7@gmail.com");

			driver.hideKeyboard();

			// click on Tel
			driver.findElement(By.xpath("//android.widget.TextView[@text='']")).click();

			// Select Country Code
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();

			// Click on Done
			driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();

			// Add Mobile number
			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='' and @resource-id='com.impossible_research.sandbox.starboard:id/phone']"))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='' and @resource-id='com.impossible_research.sandbox.starboard:id/phone']"))
					.sendKeys("7990446150");

			driver.hideKeyboard();

			// Clicked on Final save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Suppliers']")));

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 2)
	public static void Purchase_Orders() throws Exception

	{
		try

		{

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement more_PO = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='More']")));

			// Click on More
			driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Purchase')]")));

			// Click on POs
			driver.findElement(By.xpath("//*[contains(@text,'Purchase')]")).click();

			// Confirm that You are on Add POs screen if you are getting text as Add
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt'] ")));

			// Add PO button
			driver.findElement(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt'] "))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Add PO title name

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='PO Title' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']")))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='PO Title' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']"))
					.sendKeys("PO" + " " + timestamp);

			driver.hideKeyboard();

			// Click on Link Supplier
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Supplier']"))).click();

			// Selected on 1st supplier
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Clicked on save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Click on Currency
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Currency']"))).click();

			// Selected 1st currency
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();

			// Clicked on Done
			driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();

			// clicked on Total
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='0.00']")))
					.click();

			// Total amount is entered as 99
			driver.findElement(By.xpath("//android.widget.EditText[@text='0.00']")).sendKeys("99");
			driver.hideKeyboard();

			// Clicked on Final save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Purchase')]")));

		}

		catch (Exception e)

		{

			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());
		}

	}

	@Test(priority = 3)
	public static void Invoices() throws Exception

	{
		try {

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement more_Invoice = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='More']")));

			// Click on More
			driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();

			// Print Invoices
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Invoices']")));

			// Click on Invoice
			driver.findElement(By.xpath("//android.widget.TextView[@text='Invoices']")).click();

			// Confirm that You are on Add Invoice screen if you are getting text as Add
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt']")));

			// Click on Add Invoice button
			driver.findElement(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt'] "))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Add Invoice name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='Invoice Name' and @resource-id='com.impossible_research.sandbox.starboard:id/invoice_name_txt']")))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='Invoice Name' and @resource-id='com.impossible_research.sandbox.starboard:id/invoice_name_txt']"))
					.sendKeys("INV" + " " + timestamp);

			// Add Invoice number
			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='####' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']"))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='####' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']"))
					.sendKeys("12" + " " + timestamp);

			driver.hideKeyboard();

			// Link Supplier
			driver.findElement(By.xpath("//android.widget.TextView[@text='Supplier']")).click();

			// Selected on 1st supplier
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Clicked on save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Click on Currency
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Currency']"))).click();

			// Selected 1st currency
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();

			// Clicked on Done
			driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();

			// clicked on Total
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='0.00']")))
					.click();

			// Total amount is entered as 99
			driver.findElement(By.xpath("//android.widget.EditText[@text='0.00']")).sendKeys("99");

			driver.hideKeyboard();

			// Clicked on Final save button
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

	@Test(priority = 4)
	public static void Quotes() throws Exception

	{
		try

		{
			Home();

			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement more_Quotes = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='More']")));

			// Click on More
			driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();

			// Print Quotes
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Quotes']")));

			driver.findElement(By.xpath("//android.widget.TextView[@text='Quotes']")).click();

			// Confirm that You are on Add Quotes screen if you are getting text as Add
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt']")));

			// Click on Add Quotes button
			driver.findElement(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt'] "))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Add Quotes name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='Quote Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']")))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='Quote Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']"))
					.sendKeys("QT" + " " + timestamp);

			driver.hideKeyboard();

			// Link Supplier
			driver.findElement(By.xpath("//android.widget.TextView[@text='Supplier']")).click();

			// Selected on 1st supplier
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Clicked on save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Click on Currency
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Currency']"))).click();

			// Selected 1st currency
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();

			// Clicked on Done
			driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();

			// clicked on Total
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='0.00']")))
					.click();

			// Total amount is entered as 99
			driver.findElement(By.xpath("//android.widget.EditText[@text='0.00']")).sendKeys("99");
			driver.hideKeyboard();

			// Clicked on Final save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Quotes']")));

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

	@Test(priority = 5)
	public static void Projects() throws Exception

	{
		try

		{
			Home();

			WebDriverWait wait = new WebDriverWait(driver, 10);

			WebElement more_Projects = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='More']")));

			// Click on More
			driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();

			// Print Projects
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Projects']")));

			// Click on Projects
			driver.findElement(By.xpath("//android.widget.TextView[@text='Projects']")).click();

			// Confirm that You are on Add Projects screen if you are getting text as Add
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt']")));

			// Click on Add Projects button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt']")))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Add Projects name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='Name*' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']")))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='Name*' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']"))
					.sendKeys("PJ" + " " + timestamp);

			driver.hideKeyboard();

			// Click onDescription
			driver.findElement(By.xpath("//android.widget.TextView[@text='Description']")).click();

			// Description added
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='Description' and @resource-id='com.impossible_research.sandbox.starboard:id/desc']")));

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='Description' and @resource-id='com.impossible_research.sandbox.starboard:id/desc']"))
					.sendKeys("Project Description added by scrpit");
			driver.hideKeyboard();

			// Clicked on save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Click on Project Category
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Project Category']")))
					.click();

			// Selected on 1st projects Category
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Clicked on save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Clicked on Final save button
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Save']")))
					.click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Projects']"))).click();

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());
		}

	}

	@Test(priority = 6)

	public static void Reports() throws Exception

	{
		try

		{
			Home();

			WebDriverWait wait = new WebDriverWait(driver, 30);

			WebElement more_Reports = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='More']")));

			// Click on More
			driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();

			// Print Projects text
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Reports']")));

			// Click on Reports
			driver.findElement(By.xpath("//android.widget.TextView[@text='Reports']")).click();

			// Confirm that You are on Add Projects screen if you are getting text as Add
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt']")))
					.click();

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			// Add Report name
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.EditText[@text='Report Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']")))
					.click();

			driver.findElement(By.xpath(
					"//android.widget.EditText[@text='Report Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']"))
					.sendKeys("Report" + " " + timestamp);
			driver.hideKeyboard();

			// Click on Time Period
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Time Period']"))).click();

			// Select 7 days time period
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@index='1'])[1]"))).click();

			// Clicked on Done button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();

			// Clicked on Projects
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Projects']"))).click();

			// Click on 1st project from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Clicked on project save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Clicked on Expense Category
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Expense Category']")))
					.click();

			// Click on 1st Expense Category from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Clicked on Expense Category save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Clicked on Suppliers to link with reports
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Suppliers']"))).click();

			// Click on 1st Supplier from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Clicked on Supplier save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Clicked on Crew Member
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Crew Member']"))).click();

			// Click on 1st Crew Member from list
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")))
					.click();

			// Clicked on Crew Member save button
			driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();

			// Clicked on Run Report button
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Run Report']"))).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'None Found')]")));

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}

}
