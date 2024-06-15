package Anywhere;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Automation_anywhere_request_demo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.automationanywhere.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()=\"Accept All Cookies\"]")).click();
       
		        // Maximize browser window
		        driver.manage().window().maximize();
		        // Verify Automation Anywhere logo is present
		        WebElement logo = driver.findElement(By.xpath("//*[contains(@class, 'header-logo')]/img"));
		        if (logo.isDisplayed()) {
		            System.out.println("Automation Anywhere logo is present.");
		        } else {
		            System.out.println("Automation Anywhere logo is not present.");
		        }
		        // Verify Request demo button is present and clickable
		        
		        Thread.sleep(10000);
		        WebElement requestDemoButton = driver.findElement(By.xpath("//a[text()='Request Demo']"));
		        if (requestDemoButton.isDisplayed() && requestDemoButton.isEnabled()) {
		            System.out.println("Request demo button is present and clickable.");
		        } else {
		            System.out.println("Request demo button is not present or not clickable.");
		        }
		        // Close the browser
		        driver.quit();
		    }
	}


