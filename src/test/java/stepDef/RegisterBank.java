package stepDef;

import  config.env_target;
import pages.homePage;
import pages.registerPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegisterBank extends env_target {
    @Given("User is on parabank homepage")
    public void userIsOnParabankHomepage() {
        System.setProperty("webdriver.crome.driver", "src\\main\\resources\\drivers\\chromedriver.dmg");
        driver = new ChromeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrlBank);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='leftPanel']/h2"))
        );
    }

    @When("User click register link button")
    public void userClickRegisterLinkButton() {

        //POM
       homePage registerButton = new homePage(driver);
       registerButton.clickRegister();
    }

    @Then("User is in register page")
    public void userIsInRegisterPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Signing up is easy!')]"))
        );
    }

    @When("User input name")
    public void userInputName() {
//        driver.findElement(By.id("customer.firstName")).sendKeys("MyName");
//        driver.findElement(By.name("customer.lastName")).sendKeys("Indo");

        //POM
        registerPages InputName = new registerPages(driver);
        InputName.inputNameData("MyName","Indo");;
    }

    @And("User input address detail")
    public void userInputAddressDetail() {
        //User input Address
        driver.findElement(By.id("customer.address.street")).sendKeys("Sweet Home");
        //User input City
        driver.findElement(By.xpath("//*[@class=\"input\"][@id=\"customer.address.city\"]")).sendKeys("Kota");
        //User input State
        driver.findElement(By.cssSelector("#customer\\.address\\.state")).sendKeys("Negara");
        //User input ZipCode
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/form/table/tbody/tr[6]/td[2]/input")).sendKeys("112321");
        //User input Phone#
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123873431");
        //User input SSN
        driver.findElement(By.id("customer.ssn")).sendKeys("158843458");
    }

    @And("User input valid username and password")
    public void userInputValidUsernameAndPassword() {
        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        //Input Username
        driver.findElement(By.id("customer.username")).sendKeys("user"+userRand);
        //Input password
        driver.findElement(By.id("customer.password")).sendKeys("12345");
    }

    @And("User input password confirmation")
    public void userInputPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("12345");
    }

    @When("User click Register button")
    public void userClickRegisterButton() {
        driver.findElement(By.xpath("//*[@class='button'][@value='Register']")).click();
    }

    @Then("User register successfully")
    public void userRegisterSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your account was created successfully. You are now logged in.')]"))
        );
        driver.quit();
    }

    @And("user input invalid password confirmation")
    public void userInputInvalidPasswordConfirmation() {
        driver.findElement(By.id("repeatedPassword")).sendKeys("11111");
    }

    @Then("user get error password did not match")
    public void userGetErrorPasswordDidNotMatch() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Passwords did not match.')]"))
        );
        driver.quit();
    }

}
