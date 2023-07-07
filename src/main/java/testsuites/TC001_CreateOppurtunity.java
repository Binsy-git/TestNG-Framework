package testsuites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseHooks;
import utils.ExcelUtility;

public class TC001_CreateOppurtunity extends BaseHooks{

	@Test(dataProvider="fetchData",dataProviderClass=ExcelUtility.class)
	
	public void CreateOppurtunity(String username, String password,String Amount,String Date,String stage) throws InterruptedException {
		// TODO Auto-generated method stub

		driver.findElement(By.id("username")).sendKeys(username);
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//div[@class='slds-r3']/following-sibling::div[1]")).click();
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		
		// Click View All Key Deals in Key Deals 
		
		WebElement wekeydeals = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
		
		driver.executeScript("arguments[0].scrollIntoView(true);",wekeydeals);
		
		wekeydeals.click();
		
		driver.findElement(By.xpath("//span[text()='Recently Viewed']")).click();
		
		driver.findElement(By.xpath("(//span[text()='All Opportunities']/../..)[1]")).click();
		
        Thread.sleep(3000);
       
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		Thread.sleep(5000);
		
		String oppname = "SRM Steels";
		
		driver.findElement(By.xpath("//label[text()='Opportunity Name']/following::input[1]"))
		                            .sendKeys(oppname);
		
		WebElement weAccountName =driver.findElement(By.xpath("//label[text()='Account Name']"));
		
		driver.executeScript("arguments[0].scrollIntoView(true);", weAccountName);
				
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).click();
		
		Thread.sleep(2000);
				
		driver.findElement(By.xpath("//*[text()='Recent Accounts']/following::li[2]")).click();
		
		WebElement weType = driver.findElement(By.xpath("//*[text()='Type']/following::button[1]"));
		
		driver.executeScript("arguments[0].scrollIntoView(true);", weType);
		
		weType.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='New Customer']")).click();
		
		driver.findElement(By.xpath("//label[text()='Lead Source']/following::button[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()='Partner Referral']")).click();
		
		Thread.sleep(2000);
		
		WebElement weamount= driver.findElement(By.xpath("(//label[text()='Amount']/following::input)[1]"));
		
		driver.executeScript("arguments[0].scrollIntoView(true)", weamount);
		
		weamount.sendKeys(Amount);
		
		WebElement weLabelCloseDate = driver.findElement(By.xpath("//label[text()='Close Date']"));
		
        Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//label[text()='Close Date']/following::input)[1]")).click();
		
		WebElement we = driver.findElement(By.xpath("//button[@title='Next Month']"));
		
		we.click();
		
		String dt =Date;
		
		driver.findElement(By.xpath("//span[text()='"+ dt +"']")).click();
		
        driver.findElement(By.xpath("(//label[text()='Stage']/following::*)[1]")).click();
		
		Thread.sleep(2000);
		
		
		WebElement weSelect =driver.findElement(By.xpath("//*[@data-value='"+stage+"']"));
		
		weSelect.click();
		
        Thread.sleep(2000);
        
        WebElement weprimarycamp = driver.findElement(By.xpath("(//label[text()='Primary Campaign Source']/following::input)[1]"));
        
        weprimarycamp.click();
        
        WebElement werecentcamp = driver.findElement(By.xpath("(//*[@title='Recent Campaigns']/following::*)[1]"));
        
        werecentcamp.click();
        
        driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		Thread.sleep(5000);
		
		WebElement webOppName= driver.findElement(By.xpath("(//*[text()='Opportunity']/following::lightning-formatted-text)[1]"));
		
		String oppnameresult=webOppName.getText();
				
		System.out.println("Oppurtunity Name - "+oppnameresult);
		
		driver.close();
		

	}

}
