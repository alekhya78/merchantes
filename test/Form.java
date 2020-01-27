import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //navigate to our page
        driver.get("http://qainterview.merchante-solutions.com:8080/admin");

        //click on the users menu
        driver.findElement(By.id("users")).click();

        //wait until the users screen loads
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement newUser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"titlebar_right\"]/div/span/a")));

        //click on the new user button
        driver.findElement(By.xpath("//*[@id=\"titlebar_right\"]/div/span/a")).click();

        //wait until the new user screen loads
        wait = new WebDriverWait(driver,10);
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_username")));

        //fill the form
        driver.findElement(By.id("user_username")).sendKeys("alekhya");
        driver.findElement(By.id("user_password")).sendKeys("mypassword");
        driver.findElement(By.id("user_email")).sendKeys("malekhya@gmail.com");

        //submit the form
        driver.findElement(By.name("commit")).click();

        //wait until confirmation page
        wait = new WebDriverWait(driver,10);
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("flash")));

        //retrieve the confirmation message
        String flashText = flash.getText();

        //test that the confirmation message is equal to the expected message
        //assertEquals("bla bla bla.",flashText);
        assertEquals("User was successfully created.",flashText);

        //finally close the browser
        driver.quit();
    }
}
