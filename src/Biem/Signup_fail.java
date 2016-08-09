package Biem;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class Signup_fail {

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
		capabilities.setCapability("name", "Sign up fail test");

		wd = new IOSDriver(new URL("http://misieksr:3d40011a-fd26-40c0-9a0b-0f0c108f0a42@ondemand.saucelabs.com:80/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	@Test
	public void signup_fail_test() throws InterruptedException
	{
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[3]")).click();;
		System.out.println("Sign up button clicked");
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATextField[1]"))).setValue("testname");
		
		System.out.println("Name");
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATextField[2]"))).setValue("testlastname");
		
		System.out.println("Lastname");
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATextField[3]"))).setValue("testmail@gmail.com");
		wd.hideKeyboard("Return");
		System.out.println("E-mail");
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIATextField[4]"))).setValue("791641290");
		wd.swipe(158, 313, 158, 178, 1);
		System.out.println("Phonenumber");
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIASecureTextField[1]"))).setValue("password");
		wd.hideKeyboard("Return");
		System.out.println("Password");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAElement[1]")).click();
		System.out.println("Birthdate");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[1]")).sendKeys("April");
		System.out.println("Day");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[2]")).sendKeys("20");
		System.out.println("Month");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPicker[1]/UIAPickerWheel[3]")).sendKeys("2010");
		System.out.println("Year");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[5]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAStaticText[4]")).click();
		System.out.println("Gender");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAActionSheet[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAButton[1]")).click();
		System.out.println("Choose gender");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIASwitch[1]")).click();
		System.out.println("Remember account");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAElement[2]")).click();
		System.out.println("Create account");
		WebElement signup = wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAElement[2]"));
		if (signup.isDisplayed()){
			signup.click();
			Reporter.log("Signup button clicked");
			System.out.println("Signup button clicked");
		}
		try {
			signup = wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAElement[2]"));
			Reporter.log("Sign up failed");
			System.out.println("Sign up failed");
		}
		 catch (Exception e) {
			    Reporter.log("Sign up successfully");
			    System.out.println("Sign up successfully");
		}
		wd.quit(); // Always quit, if you don't, next test session will fail
	}
}