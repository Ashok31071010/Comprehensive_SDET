package Anywhere;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class Testng {
	WebDriver driver = new ChromeDriver();
		    @BeforeClass
		    public void setUp() {
		        // Set path to chromedriver executable
		    	driver.get("https://www.automationanywhere.com/");
		    	// Maximize browser window
		        driver.manage().window().maximize();
		    }
		    @Test(priority = 1)
		    public void Testng1() {
		        // Navigate to Automation Anywhere homepage
		        //driver.get("https://www.automationanywhere.com/");

		        // Verify Automation Anywhere logo is present
		        WebElement logo = driver.findElement(By.xpath("//*[contains(@class, 'header-logo')]/img"));
		        Assert.assertTrue(logo.isDisplayed(), "Automation Anywhere logo should be present.");
		    }
		    @Test(priority = 2, enabled = true)
		    public void Testng() {
		        // Navigate to Automation Anywhere homepage (can be skipped as already navigated)
		        // driver.get("https://www.automationanywhere.com/");
		        // Verify Request demo button is present and clickable
		    	WebElement requestDemoButton = driver.findElement(By.xpath("//a[text()='Request Demo']"));
		        Assert.assertTrue(requestDemoButton.isDisplayed(), "Request demo button should be present.");
		        Assert.assertTrue(requestDemoButton.isEnabled(), "Request demo button should be clickable.");
		    }
		    @AfterClass
		    public void tearDown() {
		        // Close the browser
		        if (driver != null) {
		            driver.quit();
		        }
		    }
	
}
