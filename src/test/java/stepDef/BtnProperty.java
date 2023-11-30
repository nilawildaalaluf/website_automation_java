package stepDef;
import  config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.BtnObj;
import utilities.ThreadManager;

public class BtnProperty extends env_target {

    @Given("User is on calculate property prices page")
    public void userIsOnCalculatePropertyPricesPage() {
        driver = new ChromeDriver();
        //maximize driver
        driver.manage().window().maximize();
        //set url
        driver.get(baseUrlBtn);


        WebDriverWait wait = new WebDriverWait(driver, 100);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form_hitung_harga']/div[1]/div[1]/input"))
        );
    }

    @When("user fill Penghasilan Total and pengeluaran")
    public void userFillPenghasilanTotalAndPengeluaran() {
        BtnObj inputTotal = new BtnObj(driver);
        inputTotal.enterTotal("10000000");

        BtnObj inputPengeluaran = new BtnObj(driver);
        inputPengeluaran.enterPengeluaran("3000000");
//        driver.findElement(By.xpath("//*[@id='form_hitung_harga']/div[1]/div[1]/input")).sendKeys("10000000");
//        driver.findElement(By.xpath("//*[@id='form_hitung_harga']/div[1]/div[2]/input")).sendKeys("3000000");
    }

    @And("User Select Jangka waktu")
    public void userSelectJangkaWaktu() throws InterruptedException {
        BtnObj btnSelect = new BtnObj(driver);
        btnSelect.selectOptionWaktu();
    }

    @And("User click button Hitung")
    public void userClickButtonHitung() throws InterruptedException {
        BtnObj btnHitung = new BtnObj(driver);
        btnHitung.clickOnButtonHitung();
    }

    @Then("User get calculate property prices")
    public void userGetCalculatePropertyPrices() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='harga_hasil']/h3"))
        );
        driver.quit();


    }

    @When("^user fill penghasilan (.*) and (.*)$")
    public void userFillPenghasilanTotalAndPengeluaran(String total, String pengeluaran) {
        BtnObj inputTotal = new BtnObj(driver);
        inputTotal.enterTotal(total);

        BtnObj inputPengeluaran = new BtnObj(driver);
        inputPengeluaran.enterPengeluaran(pengeluaran);
//        driver.findElement(By.xpath("//*[@id='form_hitung_harga']/div[1]/div[1]/input")).sendKeys(total);
//        driver.findElement(By.xpath("//*[@id='form_hitung_harga']/div[1]/div[2]/input")).sendKeys(pengeluaran);

    }

    @Then("^User get calculate (.*) property prices$")
    public void userGetCalculateResultPropertyPrices( String result) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        if(result.equals("Passed")){
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='harga_hasil']/h3"))
            );
            driver.quit();
        }else {

            WebElement textError = driver.findElement(By.xpath("//*[@id='form_hitung_harga']/div[1]/p"));
            String actualElementText = textError.getText();
            actualElementText.equals("Isi kurang dari nilai sebelumnya");

            driver.quit();
        }
    }
}
