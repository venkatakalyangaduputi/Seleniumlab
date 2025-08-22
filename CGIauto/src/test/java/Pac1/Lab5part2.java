package Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5part2 {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?");
        System.out.println("Page Title is: " + driver.getTitle());

        driver.findElement(By.linkText("My Account")).click();

        driver.findElement(By.linkText("Register")).click();

        String heading = driver.findElement(
            By.xpath("//h1[contains(text(),'Register Account')]")
        ).getText();
        System.out.println("Heading Verified: " + heading);

        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String warning = driver.findElement(
            By.xpath("//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]")
        ).getText();
        System.out.println("Warning Verified: " + warning);

        String firstName33 = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG";
        driver.findElement(By.id("input-firstname")).sendKeys(firstName33);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String firstNameError = driver.findElement(
            By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
        ).getText();
        System.out.println("First Name Error Verified: " + firstNameError);

        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Kalyan");

        String lastName33 = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFG";
        driver.findElement(By.id("input-lastname")).sendKeys(lastName33);
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String lastNameError = driver.findElement(
            By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
        ).getText();
        System.out.println("Last Name Error Verified: " + lastNameError);

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Venkata");

        driver.findElement(By.id("input-email")).sendKeys("test123@gmail.com");

        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");

        System.out.println("Personal Details entered successfully.");
        driver.quit();
    }
}
