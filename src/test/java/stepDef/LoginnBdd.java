package stepDef;

import  config.env_target;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginnBdd extends env_target {
    @Given("User is on Login page")
    public void userIsOnLoginPage() {
        System.setProperty("webdriver.crome.driver", "src\\main\\resources\\drivers\\chromedriver.dmg");
        driver = new ChromeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrl);


        WebDriverWait wait = new WebDriverWait(driver, 100);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit'][@data-test='login-button']"))
        );


    }

    @When("User fill username and password")
    public void userFillUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("User click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit'][@data-test='login-button']")).click();
    }

    @Then("User verify login result")
    public void userVerifyLoginResult() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping_cart_container']"))
        );
        driver.quit();
    }

    @When("User fill invalid username and password")
    public void userFillInvalidUsernameAndPassword() {
        driver.findElement(By.name("user-name")).sendKeys("standard_usera");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @Then("User get error message")
    public void userGetErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]"))
        );
        driver.quit();
    }

//TDD code
    @When("^User fill (.*) and (.*)$")
    public void userFillUsernameAndPassword( String username, String password) {

        driver.findElement(By.name("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

    }

    @Then("^User get verify login (.*)$")
    public void userGetVerifyLoginResult( String result) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        if(result.equals("Passed")){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping_cart_container']"))
            );
            driver.quit();
        } else if (result.equals("Failed")){

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_button_container']/div/form/div[3]"))
            );
            driver.quit();
        }

    }
}
