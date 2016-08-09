package Biem;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;

public class Swipe {

	private IOSDriver wd;
	
	
	@BeforeTest
	public void SetCapability() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();	

		//local simulator capabilities
		//capabilities.setCapability("platformName","iOS");
		//capabilities.setCapability("platformVersion","9.3");
		//capabilities.setCapability("deviceName","iPhone 5s");
		//capabilities.setCapability("autoAcceptAlerts", true);
		//capabilities.setCapability("app", "/Users/misiek/Library/Developer/Xcode/DerivedData/snowflake-hchuoihtrlyazzffhpmkgxniqxoa/Build/Products/Debug-iphonesimulator/biemSimulator.app");
		//capabilities.setCapability("newCommandTimeout", 7200);
		
		capabilities.setCapability("appiumVersion", "1.5.3");
		capabilities.setCapability("deviceName","iPhone 5s");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("platformVersion","9.2");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("browserName", "");
		capabilities.setCapability("app","sauce-storage:biemsim.zip");
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("name", "Swipe test");

		wd = new IOSDriver(new URL("http://misieksr:3d40011a-fd26-40c0-9a0b-0f0c108f0a42@ondemand.saucelabs.com:80/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	@Test
	public void swipe_test() throws InterruptedException
	{
		wd.swipe(300, 300, 25, 300, 500);
		System.out.println("Swipe 1");
		Thread.sleep(1000);
		wd.swipe(300, 300, 25, 300, 500);
		System.out.println("Swipe 2");
		Thread.sleep(1000);
		wd.swipe(300, 300, 25, 300, 500);
		System.out.println("Swipe 3");
		
		wd.swipe(25, 300, 300, 300, 500);
		System.out.println("Swipe back 1");
		Thread.sleep(1000);
		wd.swipe(25, 300, 300, 300, 500);
		System.out.println("Swipe back 2");
		Thread.sleep(1000);
		wd.swipe(25, 300, 300, 300, 500);
		System.out.println("Swipe back 3");	


    	wd.quit(); // Always quit, if you don't, next test session will fail
    }
}