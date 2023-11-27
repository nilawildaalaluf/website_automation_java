package TestJava;

import org.junit.jupiter.api.Test;
import  config.env_target;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login extends env_target {
    @Test
    public void main(){
        System.setProperty("webdriver.crome.driver", "src\\main\\resources\\drivers\\chromedriver.dmg");
        driver = new ChromeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrl);

        Duration time= Duration.ofSeconds(10);

        WebDriverWait wait = new WebDriverWait(driver, 100);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping_cart_container']"))
        );
        driver.quit();
    }

    @Test
    public void invalidPassword(){
        System.setProperty("webdriver.crome.driver", "src\\main\\resources\\drivers\\chromedriver.dmg");
        driver = new ChromeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrl);

        Duration time= Duration.ofSeconds(10);

        WebDriverWait wait = new WebDriverWait(driver, 100);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_user");
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]"))
        );
        driver.quit();
    }

}
