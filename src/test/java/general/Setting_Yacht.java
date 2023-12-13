package general;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codeborne.selenide.testng.TextReport;
import io.qameta.allure.Allure;

import org.testng.Assert;

public class Setting_Yacht extends Login_test
//public class Setting_Yacht extends Base 
{
	public TextReport report = new TextReport();

	@Test(priority = 1)
	private static void Sync_data() throws Exception

	{
		try

		{

			Home();

			WebDriverWait wait = new WebDriverWait(driver, 20);

			WebElement Sync_data = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Settings']")));

			// Click on Settings
			driver.findElement(By.xpath("//android.widget.TextView[@text='Settings']")).click();

			// Confirm that you are on Settings page
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//android.widget.TextView[@text='Settings' and @resource-id='com.impossible_research.sandbox.starboard:id/head_txt']")));

			// Print Yacht settings
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Yacht Settings']"))).click();

			// Confirm that you are on Yacht setting page by clicking on Sync Data
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Sync Data']"))).click();

			// Confirm that you are on Sync Data page
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Sync Data']")));

			// Click on Sync All button to Sync Data
			WebElement Sync_data1 = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Sync All Data']")));
			String ActualTitle = Sync_data1.getText();

			Sync_data1.click();

			WebDriverWait wait_sync = new WebDriverWait(driver, 20);

			WebElement Sync_data2 = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='0 second ago']")));

		}

		catch (Exception e)

		{
			Allure.addAttachment("AllureSelenide",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
			Assert.fail(e.getMessage());

		}

	}
}
