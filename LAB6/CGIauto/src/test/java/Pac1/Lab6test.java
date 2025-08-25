package Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class Lab6test {
    public static void main(String[] args) {
        // Set up the ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Using implicit wait as a workaround

        // 1. Navigate to the website and log in
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("kalyanvenkata@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Kach@123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // 2. Go to 'Components' and select 'Monitors'
        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Monitors')]")).click();

        // 3. Select '25' from 'Show' dropdown
        Select show = new Select(driver.findElement(By.id("input-limit")));
        show.selectByVisibleText("25");

        // 4. Click on 'Apple Cinema 30"' (first item) and verify specification
        WebElement firstProductLink = driver.findElement(By.xpath("(//div[contains(@class,'product-thumb')])[1]//div[@class='caption']//a"));
        String firstProductName = firstProductLink.getText();
        firstProductLink.click();
        
        driver.findElement(By.xpath("//a[normalize-space()='Specification']")).click();
        String specText = driver.findElement(By.id("tab-specification")).getText();
        System.out.println("Specification present for: " + firstProductName);
        System.out.println(specText);

        // 5. Add the item to wish list and verify the message
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
        String wishMsg = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        System.out.println("Wish List Message: " + wishMsg);

        // 6. Navigate directly to the homepage to perform a new search for 'Mobile'
        driver.get("https://tutorialsninja.com/demo/");
        
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Mobile");
        // The search button on the homepage does not have an ID, so we use XPath.
        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

        // 7. Click on 'Search in product descriptions' checkbox
        WebElement descriptionCheckbox = driver.findElement(By.id("description"));
        if (!descriptionCheckbox.isSelected()) {
            descriptionCheckbox.click();
        }

        // 8. Click the Search button again. This one is on the search results page and has an ID.
        driver.findElement(By.id("button-search")).click();

        // 9. Click on 'HTC Touch HD' link
        driver.findElement(By.linkText("HTC Touch HD")).click();

        // 10. Update the quantity and add to cart
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");
        driver.findElement(By.id("button-cart")).click();
        
        // 11. Verify the 'Add to Cart' success message
        String cartMsg = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        System.out.println("Cart Message: " + cartMsg);

        // 14. Logout and verify the heading
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();
        String logout = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]")).getText();
        System.out.println("Logout Verified: " + logout);

        // 15. Click 'Continue'
        driver.findElement(By.linkText("Continue")).click();
        
        driver.quit();
    }
}
