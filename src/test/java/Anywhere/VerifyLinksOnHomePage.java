package Anywhere;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

		public class VerifyLinksOnHomePage {
		    public static void main(String[] args) throws InterruptedException {
		        // Set path to chromedriver executable
		    	WebDriver driver = new ChromeDriver();
				driver.get("https://www.automationanywhere.com/");
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//*[text()=\"Accept All Cookies\"]")).click();
		        // Maximize browser window
		        driver.manage().window().maximize();
		        // Verify and click on each link
		        String[] links = {"Products", "Solutions", "Resources", "Customers"};
		        Thread.sleep(3000);
		        for (String linkText : links) {
		        	Thread.sleep(3000);
		            WebElement link = driver.findElement(By.xpath("//*[(text()= '" + linkText + "')]"));
		            Thread.sleep(3000);
		            if (link.isDisplayed()) {
		            	Thread.sleep(5000);
		                System.out.println("'" + linkText + "' link is present.");
		                Thread.sleep(5000);
		                link.click();
		                System.out.println("Navigated to: " + driver.getCurrentUrl());
		                // Add verification logic for each page if needed
		                // For simplicity, we are just printing the current URL
		                driver.navigate().back(); // Navigate back to the homepage
		            } else {
		                System.out.println("'" + linkText + "' link is not present.");
		            }
		        }
		        // Close the browser
		        driver.quit();
		    }
	
}
