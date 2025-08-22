
package Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5part5 {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.findElement(By.linkText("My Account")).click();

        driver.findElement(By.linkText("Register")).click();
        

        driver.findElement(By.id("input-firstname")).sendKeys("Kalyan");
        driver.findElement(By.id("input-lastname")).sendKeys("Venkata");
        driver.findElement(By.id("input-email")).sendKeys("kalyanvenkata@mail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
        driver.findElement(By.id("input-password")).sendKeys("Kalyan@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Kalyan@123");

        driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String successMsg = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")).getText();
        System.out.println("Success Message Verified: " + successMsg);

        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        driver.findElement(By.linkText("View your order history")).click();
        System.out.println("Order history page opened successfully.");

        driver.quit();
    }
}
