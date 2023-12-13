package automation.starboard;

import java.io.File;


import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
	
	
	public static AppiumDriverLocalService Service ;
	
	public static String NodeExePath = "/usr/bin/node";
	 
	public static String AppiumMainJsPath = "/home/linuxbrew/.linuxbrew/lib/node_modules/appium/lib/main.js";
	//public static String AppiumMainJsPath = "/usr/local/lib/node_modules/appium/build/lib/main.js";
	public static String ServerAddress = "127.0.0.1";
	
	
	
	@BeforeTest
	public void StartAppiumServer() 
	
	
	{
		Service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File (NodeExePath)).withAppiumJS(new File(AppiumMainJsPath)).withIPAddress(ServerAddress) 
				.withArgument(GeneralServerFlag.BASEPATH,"/wd/hub").usingPort(4723).withLogFile(new File ("/home/purvish/Desktop/AppiumServerLog.txt")));
		
		System.out.println("Starting Appium Server......");
		
		Service.start();
	}
	
	@Test
	
		public void LunchApp() throws MalformedURLException
	
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			
			cap.setCapability(MobileCapabilityType.NO_RESET,true); // It will always clear the caches
						
			cap.setCapability(MobileCapabilityType.DEVICE_NAME,"R9ZRA09AK2M");
			 
			cap.setCapability("platformVersion", "12");

		AndroidDriver<MobileElement>  driver = new AndroidDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		driver.startActivity(new Activity("com.impossible_research.sandbox.starboard","com.impossible_research.sandbox.starboard.ui.splash.view.SplashActivity"));
		
				
	}
	
	@AfterTest
	
	public void TearDown() 
	
	{
		if(Service.isRunning() ==true ) 
		
		{
			Service.stop();
			
			System.out.println("Appium Server is Stopped......");
		}
		
	
	}
	
}

