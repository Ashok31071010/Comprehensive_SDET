package date1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SelectDateRange {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
       // System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Launch the website containing the date dropdowns
        driver.get("https://example.com");

        // Find the "From" date dropdown element
        WebElement fromDateDropdown = driver.findElement(By.id("from-date-dropdown"));

        // Find the "To" date dropdown element
        WebElement toDateDropdown = driver.findElement(By.id("to-date-dropdown"));

        // Create Select objects to interact with the dropdowns
        Select selectFromDate = new Select(fromDateDropdown);
        Select selectToDate = new Select(toDateDropdown);

        // Get the current system date
        LocalDate currentDate = LocalDate.now();

        // Get the current date as a string in the desired format (assuming the dropdowns accept date in this format)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String fromDate = currentDate.format(formatter);

        // Calculate the "To" date as +5 days from the current date
        LocalDate toDate = currentDate.plusDays(5);
        String toDateStr = toDate.format(formatter);

        // Select the "From" date in the dropdown
        selectFromDate.selectByValue(fromDate);

        // Select the "To" date in the dropdown
        selectToDate.selectByValue(toDateStr);

        // Close the browser
        driver.quit();
    }
}
