package in.key2selenium.newtour1.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserSelection {
	
private static WebDriver driver=null;
	
	public static WebDriver OpenBrowsers(String browserName)
	{
		
		
		if (browserName.equalsIgnoreCase("FireFox")) {
			
			//System.setProperty("webdriver.gecko.driver", "./AllBrowsers/geckodriver.exe");
			driver=new FirefoxDriver();
			
					
		}
		
		else if (browserName.equalsIgnoreCase("Chrome")) {
						
			//System.setProperty("webdriver.chrome.driver", "./AllBrowsers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("user-data-dir=C:/Users/TITU/AppData/Local/Google/Chrome/User Data/Default");
			driver=new ChromeDriver();
			
			
		}
		
		else {
			
			//System.setProperty("phantomjs.binary.path", "./AllBrowsers/phantomjs.exe");
			driver=new PhantomJSDriver();
			
			
		}
		
		return driver;

	}
	
	public static WebDriver getGridBrowsers(String browserName)
	{
		
		
		if (browserName.equalsIgnoreCase("FireFox")) {
			
			//System.setProperty("webdriver.gecko.driver", "./AllBrowsers/geckodriver.exe");
			driver=new FirefoxDriver();
			
					
		}
		
		else if (browserName.equalsIgnoreCase("Chrome")) {
						
			//System.setProperty("webdriver.chrome.driver", "./AllBrowsers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("user-data-dir=C:/Users/TITU/AppData/Local/Google/Chrome/User Data/Default");
			DesiredCapabilities dc=DesiredCapabilities.chrome();
			dc.setBrowserName("gc");
			dc.setPlatform(Platform.WINDOWS);
			
			driver=new ChromeDriver();
			
			
		}
		
		else {
			
			//System.setProperty("phantomjs.binary.path", "./AllBrowsers/phantomjs.exe");
			driver=new PhantomJSDriver();
			
			
		}
		
		return driver;

	}
	
	
	public static void openURL(String url)
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static String getCurrentDate()
	{
		Date date = new Date();
		 System.out.println("Today's Date is  :: "+date);
		 String date_patteren="MM_dd_yyyy hh:mm:ss";
		 SimpleDateFormat formatted_ins=new SimpleDateFormat(date_patteren);
		 return formatted_ins.format(date);
		 
	}
	
	public static void getScreenshot() throws IOException
	{
		String destination = "C:\\Temp\\"+getCurrentDate()+" "+driver.getTitle().replace(":", "_").replace("\\", "_");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File(destination));
		
	}

}
