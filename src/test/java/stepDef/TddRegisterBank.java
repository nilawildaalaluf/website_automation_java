package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class TddRegisterBank extends env_target{

    @Given("User see parabank homepage")
    public void userSeeParabankHomepage() {
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

    @When("User can click register link button")
    public void userCanClickRegisterLinkButton() {
        driver.findElement(By.xpath("//a[contains(@href, 'register')]")).click();
    }

    @Then("User see register page")
    public void userSeeRegisterPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Signing up is easy!')]"))
        );
    }

    @When("User input name for bank account")
    public void userInputNameForBankAccount() {

        driver.findElement(By.id("customer.firstName")).sendKeys("MyName");
        driver.findElement(By.name("customer.lastName")).sendKeys("Indo");
    }

    @And("User input address detail account")
    public void userInputAddressDetailAccount() {
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

    @When("User click Register button account")
    public void userClickRegisterButtonAccount() {
        driver.findElement(By.xpath("//*[@class='button'][@value='Register']")).click();
    }

    @And("^User can input(.*) and (.*)$")
    public void userCanInputUsernameAndPassword( String username, String password) {

        Random rand = new Random();
        int userRand = rand.nextInt(10000);
        //Input Username
        driver.findElement(By.id("customer.username")).sendKeys(username+userRand);
        //Input password
        driver.findElement(By.id("customer.password")).sendKeys(password);
    }

    @And("^User can input (.*) confirmation$")
    public void userCanInputRePasswordConfirmation(String rePassword) {
        driver.findElement(By.id("repeatedPassword")).sendKeys(rePassword);
    }

    @Then("^User bank get verify login (.*)$")
    public void userBankGetVerifyLoginResult(String result) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        if(result.equals("Passed")){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your account was created successfully. You are now logged in.')]"))
            );
            driver.quit();
        }else {

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Passwords did not match.')]"))
            );
        driver.quit();
        }
    }

}


