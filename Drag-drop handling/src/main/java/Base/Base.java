package Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
