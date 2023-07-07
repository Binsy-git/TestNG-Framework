package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseHooks {
	
	public ChromeDriver driver;
	
	

	@BeforeMethod
	
	public void beforeMethod() {
			
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		
        options.addArguments("--remote-allow-origins=*");
        
        options.addArguments("--disable-notifications");
        
        driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
		

	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if(!result.isSuccess()) {
		       File source = driver.getScreenshotAs(OutputType.FILE);
		     
		       File dest = new File("./screenshots/snap1.png");
		       try {
				FileUtils.copyFile(source,dest);
			} catch (IOException e) {
				
				System.err.println("Input Output Error captured while Taking Screenshot");
			}
		       
			}
		driver.close();
	}

}
