package automation.starboard;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import general.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


public class po_invoice_quote 
{
	static DesiredCapabilities cap = new DesiredCapabilities();
	
	static AndroidDriver<MobileElement> driver;

	@Test(priority=1)	
	public static void main(String[]args) throws MalformedURLException, InterruptedException {

	DesiredCapabilities cap = new DesiredCapabilities();
		
		//cap.setCapability("ignoreHiddenApiPolicyError", true);
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		
		cap.setCapability(MobileCapabilityType.NO_RESET,true); // It will always clear the caches
		
		//cap.setCapability("app","/home/purvish/Downloads/Starboard-debug-1.5.1-20-03-2023.apk");
		//cap.setCapability("id","com.impossible_research.sandbox.starboard:id/navigation_bar_item_large_label_view");
		//cap.setCapability("appPackage", "com.impossible_research.sandbox.starboard");
		//cap.setCapability("appActivity", "com.impossible_research.sandbox.starboard.ui.splash.view.SplashActivity");  
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"R9ZRA09AK2M");
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME,"a1e5e8e3");
					
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
			
		Thread.sleep(5000);
		
		driver.startActivity(new Activity("com.impossible_research.sandbox.starboard","com.impossible_research.sandbox.starboard.ui.splash.view.SplashActivity"));
		
		Thread.sleep(1000);
		
		System.out.println("installed App found");
		Thread.sleep(5000);
		
	try 
	{
		
		if (driver.findElement(By.xpath("//android.widget.TextView[@text='Sign in using your 5 digit pin.']")).isDisplayed())
		{
			
			System.out.println("Set PIN screen Found");
			Thread.sleep(1000);
			
			//Click on 1
			driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
			System.out.println(" 1 pressed");
			
			//Click on 2
			driver.findElement(By.xpath("//android.widget.TextView[@text='2']")).click();
			System.out.println(" 2 pressed");
			
			//Click on 3
			driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
			System.out.println(" 3 pressed");
			
			//Click on 4
			driver.findElement(By.xpath("//android.widget.TextView[@text='4']")).click();
			System.out.println(" 4 pressed");
			
			//Click on 5
			driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();
			System.out.println(" 5 pressed");
			
			
			//wait till home page is loaded
			
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			
			//Click on Home button
			WebElement div = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Home']")));
			
			// Confirm that You are on Home page
			System.out.println(div.getText());
			
			//Click on More button
			 driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();
			 Thread.sleep(1000);
			 
			 
			 //Confirm that You are on More screen if you are getting text as POs 
			 System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='POs']")).getText());
			 Thread.sleep(1000);
			 
			 //Click on POs
			 driver.findElement(By.xpath("//android.widget.TextView[@text='POs']")).click();
			 Thread.sleep(1000);
			
			 //Confirm that You are on Add POs screen if you are getting text as Add 
			 System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt'] ")).getText());
			 Thread.sleep(1000);
			 
			 //Click on Add PO button
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt'] ")).click();
			 Thread.sleep(2000);
			 
			 //Add PO name
			 driver.findElement(By.xpath("//android.widget.EditText[@text='Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//android.widget.EditText[@text='Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']")).sendKeys("PO added by auto");
			 System.out.println("PO name has given");
			 Thread.sleep(1000);
			 
			 //Click on Supplier
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Supplier']")).click();
			 System.out.println("Clicked on Supplier ");
			 Thread.sleep(1000);
			 
			 //Selected on 1st supplier
			 driver.findElement(By.xpath("(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")).click();
			 System.out.println("Selected on 1st supplier ");
			 Thread.sleep(2000);
			 
			 //Clicked on save button
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
			 System.out.println("Clicked on Save");
			 Thread.sleep(2000);
			 
			 //Click on Currency
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Currency']")).click();
			 System.out.println("Clicked on Currency");
			 Thread.sleep(2000);
			 
			 //Selected 1st currency
			 driver.findElement(By.xpath("//android.widget.TextView[@text='GBP']")).click();
			 System.out.println("Selected 1st Currency ");
			 Thread.sleep(1000);
			 
			 //Clicked on Done
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
			 System.out.println("Clicked on Done");
			 Thread.sleep(1000);
			 
			 //clicked on Total
			 driver.findElement(By.xpath("//android.widget.EditText[@text='0.00']")).click();
			 //driver.findElement(By.xpath("//android.widget.EditText[@text='Total' and @resource-id='com.impossible_research.sandbox.starboard:id/total_blank']")).click();
			 System.out.println("Clicked on Total");
			 Thread.sleep(2000);
			 
			 //Total amount is entered as 99
			 driver.findElement(By.xpath("//android.widget.EditText[@text='0.00']")).sendKeys("99");
			 //driver.findElement(By.xpath("//android.widget.EditText[@text='Total' and @resource-id='com.impossible_research.sandbox.starboard:id/total_blank']")).sendKeys("99");
			 System.out.println("Total ammount is entered as 99");
			 Thread.sleep(1000);
			 
			 //Clicked on Final save button
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
			 System.out.println("Clicked on Final save");
			 Thread.sleep(2000);
			 
			 if (driver.findElement(By.xpath("//android.widget.TextView[@text='POs']")).isDisplayed())
				{
					
					System.out.println("PO added successfully");
					Thread.sleep(1000);
				}
			 else 
			 	
			 {
				 System.out.println("PO not added successfully");
			 }
			 
			 			 

		}
		
	}
	
	catch(Exception e){
        
			System.out.println("Hi");
 
			System.out.println("You are on Home screen");
			
			//wait till home page is loaded
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			
			//Click on Home button
			WebElement div = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Home']")));
			
			// Confirm that You are on Home page
			System.out.println(div.getText());
			
			//Click on More button
			 driver.findElement(By.xpath("//android.widget.TextView[@text='More']")).click();
			 Thread.sleep(1000);
			 
			 
			 //Confirm that You are on More screen if you are getting text as POs 
			 System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='POs']")).getText());
			 Thread.sleep(1000);
			 
			 //Click on POs
			 driver.findElement(By.xpath("//android.widget.TextView[@text='POs']")).click();
			 Thread.sleep(1000);
			
			//Confirm that You are on Add POs screen if you are getting text as Add 
			 System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt'] ")).getText());
			 Thread.sleep(1000);
			 
			 //Click on Add PO button
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Add' and @resource-id='com.impossible_research.sandbox.starboard:id/end_btn_txt'] ")).click();
			 Thread.sleep(2000);
			 
			 //Add PO name
			 driver.findElement(By.xpath("//android.widget.EditText[@text='Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//android.widget.EditText[@text='Name' and @resource-id='com.impossible_research.sandbox.starboard:id/name_blank']")).sendKeys("PO added by auto");
			 System.out.println("PO name has given");
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Supplier']")).click();
			 System.out.println("Clicked on Supplier ");
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath("(//android.widget.Switch[@resource-id='com.impossible_research.sandbox.starboard:id/category_toggle'] ) [1]")).click();
			 System.out.println("Selected on 1st supplier ");
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
			 System.out.println("Clicked on Save");
			 Thread.sleep(2000);
			 
			//Click on Currency
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Currency']")).click();
			 System.out.println("Clicked on Currency");
			 Thread.sleep(2000);
			 
			 //Selected 1st currency
			 driver.findElement(By.xpath("//android.widget.TextView[@text='GBP']")).click();
			 System.out.println("Selected 1st Currency ");
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Done']")).click();
			 System.out.println("Click on Done");
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//android.widget.EditText[@text='0.00']")).click();			 
			 //driver.findElement(By.xpath("//android.widget.EditText[@text='Total' and @resource-id='com.impossible_research.sandbox.starboard:id/total_blank']")).click();
			 System.out.println("Clicked on Total");
			 Thread.sleep(1000);
			 
			 driver.findElement(By.xpath("//android.widget.EditText[@text='0.00']")).sendKeys("99");
			 //driver.findElement(By.xpath("//android.widget.EditText[@text='Total' and @resource-id='com.impossible_research.sandbox.starboard:id/total_blank']")).sendKeys("99");
			 System.out.println("Total ammount is entered as 99");
			 Thread.sleep(2000);
			 
			 driver.findElement(By.xpath("//android.widget.TextView[@text='Save']")).click();
			 System.out.println("Clicked on save");
			 Thread.sleep(2000);
			 
			 if (driver.findElement(By.xpath("//android.widget.TextView[@text='POs']")).isDisplayed())
				{
					
					System.out.println("PO added successfully");
					Thread.sleep(1000);
				}
			 else 
			 	
			 {
				 System.out.println("PO not added successfully");
			 }
			 
			 driver.closeApp();

			 driver.quit();


			}
		}


	}
	

