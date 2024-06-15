package Anywhere;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Testng_allLinks {
	WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void setUp() {
	        // Set path to chromedriver executable
	    	driver.get("https://www.automationanywhere.com/");
	    	
	    	 driver.findElement(By.xpath("//*[text()=\"Accept All Cookies\"]")).click();
	    	// Maximize browser window
	        driver.manage().window().maximize();
	    }
    @Test(priority = 1)
    public void verifyProductsLinkNavigation() {
        verifyLinkNavigation("Products");
    }

    @Test(priority = 2)
    public void verifySolutionsLinkNavigation() {
        verifyLinkNavigation("Solutions");
    }

    @Test(priority = 3)
    public void verifyResourcesLinkNavigation() {
        verifyLinkNavigation("Resources");
    }
    
    private void verifyLinkNavigation(String linkText) {
        // Navigate to Automation Anywhere homepage
        driver.get("https://www.automationanywhere.com/");

        // Locate and click on the link
        WebElement link = driver.findElement(By.xpath("//*[(text()= '" + linkText + "')]"));
        Assert.assertTrue(link.isDisplayed(), "'" + linkText + "' link should be present.");
        link.click();

        // Verify navigation to the correct page (check URL or title as per requirement)
        Assert.assertTrue(driver.getCurrentUrl().contains(linkText.toLowerCase()),
                "Expected to navigate to '" + linkText + "' page.");
        // Optionally navigate back to the homepage
        driver.navigate().back();
    }
    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
