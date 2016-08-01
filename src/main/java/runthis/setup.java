package runthis;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class setup {
	public static AndroidDriver<MobileElement> driver;
	
	@BeforeSuite
	public void setcap() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setCapability("VERSION","5.0");
		cap.setCapability("deviceName","LGH818817f4eaf");
		//cap.setCapability("platformName","Android");
		cap.setCapability("appPackage", "com.grofers.customerapp");
		cap.setCapability("appActivity","com.grofers.customerapp.activities.ActivitySplashScreen");    
		System.out.println("Going to initialize driver");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("Driver initialized");
	
        
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@AfterSuite
	public void tearDown() {
	    if (driver != null) {
	    	System.out.println("quit driver");
	        driver.quit();
	    }
	}
	
	
}
