package Biem;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Login_fail {

	private IOSDriver wd;
	
	
	@BeforeTest
	public void SetCapability() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();	

		//local simulator capabilities
//		capabilities.setCapability("platformName","iOS");
//		capabilities.setCapability("platformVersion","9.3");
//		capabilities.setCapability("deviceName","iPhone 5s");
//		capabilities.setCapability("autoAcceptAlerts", true);
//		capabilities.setCapability("app", "/Users/misiek/Library/Developer/Xcode/DerivedData/snowflake-hchuoihtrlyazzffhpmkgxniqxoa/Build/Products/Debug-iphonesimulator/biemSimulator.app");
//		capabilities.setCapability("newCommandTimeout", 7200);
//		wd = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		capabilities.setCapability("appiumVersion", "1.5.3");
		capabilities.setCapability("deviceName","iPhone 5s");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("platformVersion","9.2");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("browserName", "");
		capabilities.setCapability("app","sauce-storage:biemsim.zip");
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("name", "Login fail test");

		wd = new IOSDriver(new URL("http://misieksr:3d40011a-fd26-40c0-9a0b-0f0c108f0a42@ondemand.saucelabs.com:80/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	@Test
	public void login_fail_test() throws InterruptedException
	{
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]")).click();
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIATextField[1]"))).setValue("testmail1@gmail.com");
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIASecureTextField[1]"))).setValue("osim88888");
		wd.hideKeyboard("Return");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIASwitch[1]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIAElement[1]")).click();
		
		WebElement done = wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIAElement[1]"));
		if (done.isDisplayed()){
			done.click();
			Reporter.log("Login button clicked");
			System.out.println("Login button clicked");
		}
		try {
			done = wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIAElement[1]"));
			Reporter.log("Login failed");
			System.out.println("Login failed");
		}
		 catch (Exception e) {
			    Reporter.log("Login successfull");
			    System.out.println("Login successfull");
		}
		wd.quit(); // Always quit, if you don't, next test session will fail
	}
		

}