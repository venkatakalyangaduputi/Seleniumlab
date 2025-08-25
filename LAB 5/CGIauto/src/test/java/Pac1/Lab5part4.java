
package Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5part4 {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.findElement(By.linkText("My Account")).click();

        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("input-password")).sendKeys("abc");
        driver.findElement(By.id("input-confirm")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String passwordError = driver.findElement(
            By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")
        ).getText();
        System.out.println("Password Error Verified: " + passwordError);

        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-confirm")).clear();

        driver.findElement(By.id("input-password")).sendKeys("Kalyan@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Kalyan@123");

        System.out.println("Password and Confirm Password entered successfully.");

        driver.quit();
    }
}
