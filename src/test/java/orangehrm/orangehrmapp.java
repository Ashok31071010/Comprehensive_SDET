package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class orangehrmapp {
	
	public static WebDriver driver;
	
	public void login() {
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	
	public void username() throws Exception {
           
		Thread.sleep(3000);
		
		 driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		 driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		 driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		 
	}

	/*public void changepass() throws Exception {
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//header[@class='oxd-topbar']/div[1]/div[2]/ul/li/span/i")).click();
		driver.findElement(By.xpath("//header[@class='oxd-topbar']/div[1]/div[2]/ul/li/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//input[@class='oxd-input oxd-input--active']")).sendKeys("abc123");
		
	} */
	
	public void adminpage() throws Exception {
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//nav[@class='oxd-navbar-nav']/div[2]/ul/li[1]/a")).click();
		
		
	}
		
		public static void main(String[] arg) throws Exception {
			
			orangehrmapp p=new orangehrmapp();
			p.login();
			p.username();
			//p.changepass();
			p.adminpage();
			
		}
		
	
	}
