
package Pac1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5part1 {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 1: Launch Application
        driver.get("https://tutorialsninja.com/demo/index.php?");
        

        driver.findElement(By.linkText("My Account")).click();
        

        driver.findElement(By.linkText("Register")).click();
        System.out.println("Page Title is: " + driver.getTitle());

        String heading = driver.findElement(By.xpath("//h1[contains(text(),'Register Account')]")
        	).getText();

        	System.out.println("Heading Verified: " + heading);



        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String warning = driver.findElement(
        	    By.xpath("//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]")
        	).getText();

        	System.out.println("Warning Verified: " + warning);

        driver.quit();
    }
}
