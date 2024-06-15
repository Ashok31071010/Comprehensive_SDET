package CTOSCID;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class cidadmin {
	
	private static final date.DateExample dateExample = new date.DateExample();
	public static WebDriver driver;
	private String promo="";
	/*@Test */
	public void launchbrowser()
	{
	 
     driver=new ChromeDriver();
     driver.get("https://uat-ctosid.ctos.com.my/ctosid_new/LoginPage?");
     driver.manage().window().maximize();
     
	}
	
	@SuppressWarnings("deprecation")
	public void login() throws Exception
	{
		//driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='usernameLogin']")).sendKeys("administrator");
		
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("abc123");
		
		this.takeSnapShot(driver, "C:\\Results/Login.png");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	//	driver.findElement(By.xpath("//*[@id=\"navbar-main\"]/div[2]/center[1]/div/button")).click();
		
	
	}
	
	public void promocreation() throws Exception
	{
		
		/*
		driver.findElement(By.xpath("//input[@id='usernameLogin']")).sendKeys("administrator");
		this.takeSnapShot(driver, "C:\\Results/Login.png");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();   */
		this.takeSnapShot(driver, "C:\\Results/Dashboard.png");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window. scrollBy(0,600)");
		
		Thread.sleep(4000);
		WebElement target =driver.findElement(By.xpath("//table[@id='menuTableLayout']/tbody/tr[37]/td/a"));
		
		js.executeScript("arguments[0].scrollIntoView();", target);
		
		
	    Actions act=new Actions(driver);
		act.moveToElement(target).click().build().perform();
		Thread.sleep(1000);
		//WebElement NRIC=driver.findElement(By.xpath("//Select[@name='searchType']"));
		//Select dd=new Select(NRIC);
		//dd.selectByIndex(2);
		driver.findElement(By.xpath("//input[@name='action:PromotionCodeModule-add']")).click();
		
		promo="promo"+new Random().nextInt(10000);
		driver.findElement(By.xpath("//input[@name='promoCode']")).sendKeys(promo);
		
		WebElement value=driver.findElement(By.xpath("//Select[@id='itemCodeId']"));
		Select dd=new Select(value);
		dd.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='active']")).click();
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("10");	
		driver.findElement(By.xpath("//input[@name='myCtosScore']")).click();
		driver.findElement(By.xpath("//input[@name='ch1']")).click();
		driver.findElement(By.xpath("//input[@name='ch2']")).click();
		driver.findElement(By.xpath("//input[@name='ch3']")).click();
		driver.findElement(By.xpath("//input[@id='startDatePicker']")).click();
		
		//wait.until(ExpectedConditions.visibilityOf(d-->));
		
		WebElement calender=driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']"));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	    wait.until(ExpectedConditions.visibilityOf(calender));
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[2]/a")).click();
		driver.findElement(By.xpath("//input[@id='endDatePicker']")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[3]/a")).click();
		
		this.takeSnapShot(driver, "C:\\Results/Promo.png");
		
		driver.findElement(By.xpath("//input[@id='PromotionCodeModule-add_PromotionCodeModule-addState1']")).click();
		
		this.takeSnapShot(driver, "C:\\Results/PromoCreated.png");
		
	}
	
	public void promosearch() throws Exception
	{
		driver.findElement(By.xpath("//input[@name='startDate']")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[1]/a")).click();
		driver.findElement(By.xpath("//input[@name='endDate']")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[4]/a")).click();
		driver.findElement(By.xpath("//input[@name='promotionCode']")).sendKeys(promo);
		driver.findElement(By.xpath("//input[@id='PromotionCodeModule-addState1_PromotionCodeModule-searchState1']")).click();
		
		this.takeSnapShot(driver, "C:\\Results/Promosearch.png");
		
		
	}
	
	
public void promoupdate() throws Exception
	
	{
		
		driver.findElement(By.xpath("//table[@id='result']/tbody/tr[1]/td[14]/a")).click();
		driver.findElement(By.xpath("//div[@class ='ui-dialog-buttonset']/button[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='ch3']")).click();
		this.takeSnapShot(driver, "C:\\Results/ChangedPromo.png");
		driver.findElement(By.xpath("//input[@name='action:PromotionCodeModule-updateState1']")).click();

		this.takeSnapShot(driver, "C:\\Results/Newupdate.png");
		
		
	
	}

public void logout() throws Exception

{
	
	driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/font[2]/a")).click();
	this.takeSnapShot(driver, "C:\\Results/Logout.png");
	driver.quit();
	

}
		public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		//Convert web driver object to TakeScreenshot
		
		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
				    
		File DestFile=new File(fileWithPath);
		//Copy file at destination
		Files.copy(SrcFile, DestFile); 
		}
		
		
	public  void freeccris () throws Exception 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window. scrollBy(0,600)");
		
		Thread.sleep(4000);
		WebElement target =driver.findElement(By.xpath("//table[@id='menuTableLayout']/tbody/tr[39]/td/a"));
		
		js.executeScript("arguments[0].scrollIntoView();", target);
		
		
	    Actions act=new Actions(driver);
		act.moveToElement(target).click().build().perform();
		Thread.sleep(1000);
		
		this.takeSnapShot(driver, "C:\\Results/freeccris.png");
		
		driver.findElement(By.xpath("//input[@id='CtosFreeReport-search_CtosFreeReport-add']")).click();
		//driver.findElement(By.xpath("//input[@name='action:PromotionCodeModule-add']")).click();
		
		this.takeSnapShot(driver, "C:\\Results/addpage.png");
		
		
	}
 
	public void addcamp () throws Exception 
	{
		promo="promo"+new Random().nextInt(10000);
		
		driver.findElement(By.xpath("//input[@id='campaignId']")).sendKeys(promo);
		driver.findElement(By.xpath("//input[@name='campaignFromDate']")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[4]/a")).click();
		
		//*[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[2]/a
		
		driver.findElement(By.xpath("//input[@name='campaignToDate']")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[6]/a")).click();
		driver.findElement(By.xpath("//input[@id='limitId']")).sendKeys("10");
		driver.findElement(By.xpath("//input[@id='partnerUrl']")).sendKeys(promo);
		driver.findElement(By.xpath("//input[@id='reportTypeId0']")).click();
		driver.findElement(By.xpath("//input[@id='existUserId']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='buyerId']")).click();
		driver.findElement(By.xpath("//input[@id='nonBuyerId']")).click();
		this.takeSnapShot(driver, "C:\\Results/adduser.png");
		driver.findElement(By.xpath("//input[@id='CtosFreeReport-add_CtosFreeReport-saveFreeCampaign']")).click();
		this.takeSnapShot(driver, "C:\\Results/addedcamp.png");
		
	}
	
	public void searchcamp () throws Exception
	{
		/* Date format check
		 * driver.findElement(By.xpath("//input[@id='campaignFromDateId']")).sendKeys("");
		 
	driver.findElement(By.xpath("//input[@id='campaignFromDateId']")).sendKeys(dateExample.getCurrentDate(0));
	driver.findElement(By.xpath("//input[@id='campaignTODateId']")).sendKeys("");
	driver.findElement(By.xpath("//input[@id='campaignTODateId']")).sendKeys(dateExample.getCurrentDate(5)); */
	//.click();
	
		driver.findElement(By.xpath("//input[@id='campaignFromDateId']")).click();
	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[4]/a")).click();
	
	driver.findElement(By.xpath("//input[@id='campaignToDateId']")).click();
	
	driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[4]/a")).click();
	
	driver.findElement(By.xpath("//input[@name='promotionCode']")).sendKeys(promo);
	driver.findElement(By.xpath("//input[@id='CtosFreeReport-saveFreeCampaign_CtosFreeReport-searchFreeCampaign']")).click();
	this.takeSnapShot(driver, "C:\\Results/searchcamp.png");
	
	}
public static void main(String[] args) throws Exception {
		
		cidadmin p=new cidadmin();
		p.launchbrowser();
		p.login();
		//p.promocreation();
		//p.promosearch();
		//p.promoupdate();
		p.freeccris();
		p.addcamp();
		p.searchcamp();
		p.DateExample();

		
		
		
	}

private void DateExample() {
	// TODO Auto-generated method stub
	
}

}

 
