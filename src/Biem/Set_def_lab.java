package Biem;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class Set_def_lab {

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
		capabilities.setCapability("name", "Set default lab test");

		wd = new IOSDriver(new URL("http://misieksr:3d40011a-fd26-40c0-9a0b-0f0c108f0a42@ondemand.saucelabs.com:80/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void set_def_lab_test() throws InterruptedException
	{
		//logowanie start
		
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]")).click();
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIATextField[1]"))).setValue("testmail1@gmail.com");
		((IOSElement) wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIASecureTextField[1]"))).setValue("osim8888");
		wd.hideKeyboard("Return");
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIASwitch[1]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIAElement[1]")).click();
		System.out.println("Login success");
		//logowanie koniec
		
		WebDriverWait wait = new WebDriverWait(wd, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]")));
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]")).click();//tap hamburger
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAElement[1]")).click();//tap settings
		wd.swipe(130, 470, 130, 170, 1);
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAScrollView[1]/UIAElement[8]")).click();//set def lab
		WebDriverWait wait1 = new WebDriverWait(wd, 30);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]")));//change def lab
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]")).click();
		WebDriverWait wait2 = new WebDriverWait(wd, 30);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[3]")));//near me or list
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[3]")).click();
		WebDriverWait wait3 = new WebDriverWait(wd, 30);
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAElement[1]")));//choose from list
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[2]/UIAElement[1]")).click();
		wd.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAElement[2]")).click();
		System.out.println("Set default lab success");
		wd.quit(); // Always quit, if you don't, next test session will fail
	}
	}