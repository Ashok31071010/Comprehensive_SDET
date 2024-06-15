package CTOSCID;

import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class Signup {
	
	private static final String RandomStringUtils = null;
	public static WebDriver driver;
	//private String rnd="";
	private String num="";
	//private String UUID="";
	private String mobile="";
	
	
		
	public void launchbrowser()
	{
	 
     driver=new ChromeDriver();
     driver.get("https://uat-ctosid.ctos.com.my/ctosid_new/LoginPage?");
     driver.manage().window().maximize();
     
}
	public void signupbutton()
	{
		driver.findElement(By.xpath("//button[@class='btn-outline-ctos-secondary']")).click();
	}
	
	public void signupform()
	{
		WebElement value = driver.findElement(By.xpath("//select[@id='identityGrp']"));
		Select dd=new Select(value);
		dd.selectByIndex(1);
	}
	
	@SuppressWarnings("deprecation")
	public void randomname1() throws Exception {
		Faker faker = new Faker();
		String name = faker.name().firstName();
		String email = name.toLowerCase()+"@yopmail.com";				
		
	// TODO Auto-generated method stub
	//rnd="promo"+new Random().nextInt(10000);	
			
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(name);	
		
		num="8701112"+new Random().nextLong(100000000);
		
		driver.findElement(By.xpath("//input[@id='signupCid']")).sendKeys(num);
		driver.findElement(By.xpath("//input[@id='inputEmail3']")).sendKeys(email);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		WebElement Lan=driver.findElement(By.xpath("//select[@id='inputLanguage3']"));
		js.executeScript("arguments[0].scrollIntoView();", Lan);		
		Thread.sleep(4000);
				
		Select dd=new Select(Lan);
		dd.selectByIndex(1);
		
		mobile="0111"+new Random().nextLong(1000000000);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(mobile);
		driver.findElement(By.xpath("//*[@id='grouphone']/span[2]/a")).click();
		Thread.sleep(3000);
		String OTP=driver.findElement(By.xpath("//fieldset/p[3]/strong[1]")).getText();
		driver.findElement(By.xpath("//button[@class='close']")).click();
		//String OTP=driver.findElement(By.xpath("//*[@id='requestTacBody']/fieldset/p[3]/strong")).getAttribute("value");
		driver.findElement(By.xpath("//input[@name='tacCode']")).sendKeys(OTP);
		driver.findElement(By.xpath("//button[@class='btn-ctos-primary btn-confirm-new']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn-ctos-primary']")).click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js.executeScript("window. scrollBy(0,600)");
		
		Thread.sleep(4000);
		WebElement target =	driver.findElement(By.xpath("//input[@id='inputPass3']"));
				
		js1.executeScript("arguments[0].scrollIntoView();", target);
		
		
	    Actions act=new Actions(driver);
		act.moveToElement(target).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"inputPass3\"]")).sendKeys("abc123");
		driver.findElement(By.xpath("//input[@name='myKadAddress1']")).sendKeys("MY");
		driver.findElement(By.xpath("//input[@name='myKadPostCode']")).sendKeys("56778");
		driver.findElement(By.xpath("//input[@name='myKadCity']")).sendKeys("KL");
		WebElement state=driver.findElement(By.xpath("//select[@name='myKadState']"));
		Select ss=new Select(state);
		ss.selectByIndex(2);
			
		//driver.findElement(By.id("btn_Browse")).click();āśāśāāāā
		//driver.findElement(By.id("logo")).sendKeys("c:\\ Imaāśāśāāāāge.jpg");
		driver.findElement(By.xpath("//button[@class='fileBrowseEmpty']")).sendKeys("C:\\Users\\Jayakumar Gajendaran\\Todate.png");
		Thread.sleep(2000);
				
		/*Thread.sleep(2000);
		String filepath = "C:\\Users\\Jayakumar Gajendaran\\4397.PNG";	

		WebElement upload_file = driver.findElement(By.xpath("//button[@class='fileBrowseEmpty']"));
		upload_file.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Jayakumar Gajendaran\\4397.PNG");
		Actions act1=new Actions(driver);
		act1.doubleClick(upload_file).click().build().perform();
		//upload_file.sendKeys(filepath);
		Thread.sleep(2000);
		*/
				
		driver.findElement(By.xpath("//input[@name='differentMyKadAddress']")).click();
		
	}
	
    
	public static void main (String[] args) throws Exception {
		
			
			

		Signup p=new Signup();
		p.launchbrowser();
		p.signupbutton();
		p.signupform();
		p.randomname1();
	}
	
}
