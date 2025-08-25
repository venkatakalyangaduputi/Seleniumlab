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
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("kalyanvenkata@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Kach@123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        driver.findElement(By.linkText("Components")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Monitors')]")).click();

        Select show = new Select(driver.findElement(By.id("input-limit")));
        show.selectByVisibleText("25");

        WebElement firstProductLink = driver.findElement(By.xpath("(//div[contains(@class,'product-thumb')])[1]//div[@class='caption']//a"));
        String firstProductName = firstProductLink.getText();
        firstProductLink.click();
        
        driver.findElement(By.xpath("//a[normalize-space()='Specification']")).click();
        String specText = driver.findElement(By.id("tab-specification")).getText();
        System.out.println("Specification present for: " + firstProductName);
        System.out.println(specText);

        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();
        String wishMsg = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        System.out.println("Wish List Message: " + wishMsg);

        driver.get("https://tutorialsninja.com/demo/");
        
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Mobile");
        driver.findElement(By.xpath("//div[@id='search']/span/button")).click();

        WebElement descriptionCheckbox = driver.findElement(By.id("description"));
        if (!descriptionCheckbox.isSelected()) {
            descriptionCheckbox.click();
        }

        driver.findElement(By.id("button-search")).click();

        driver.findElement(By.linkText("HTC Touch HD")).click();

        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");
        driver.findElement(By.id("button-cart")).click();
        
        String cartMsg = driver.findElement(By.cssSelector(".alert.alert-success")).getText();
        System.out.println("Cart Message: " + cartMsg);

        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();
        String logout = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]")).getText();
        System.out.println("Logout Verified: " + logout);

        driver.findElement(By.linkText("Continue")).click();
        
        driver.quit();
    }
}
