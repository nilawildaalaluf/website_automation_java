package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class BtnObj {
    WebDriver driver;
    SeleniumHelpers selenium;

    public BtnObj(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }
    @FindBy(xpath = "//*[@id='form_hitung_harga']/div[1]/div[1]/input")
    private WebElement inputTotal;

    @FindBy(xpath = "//*[@id='form_hitung_harga']/div[1]/div[2]/input")
    private WebElement inputPengeluaran;

    @FindBy(id = "hitung_harga_button")
    private WebElement buttonHitung;

    @FindBy(xpath = "//*[@id='harga_hasil']/h3")
    private WebElement hitungSuccess;

    @FindBy(xpath = "//*[@id='form_hitung_harga']/div[1]/div[3]")
    private WebElement openSelectWaktu;

    @FindBy(xpath = "//*[@id='waktu']/option[6]")
    private WebElement selectOptionWaktu;

    public void enterTotal(String total){
        selenium.enterText(inputTotal, total,true);
    }

    public void enterPengeluaran(String pengeluaran){
        selenium.enterText(inputPengeluaran, pengeluaran,true);
    }
    public void clickOnButtonHitung() throws InterruptedException {
        selenium.clickOn(buttonHitung);
    }

    public   void selectOptionWaktu() throws InterruptedException{
//        selenium.clickOn(openSelectWaktu);
        selenium.clickOn(selectOptionWaktu);
    }

    public String getSuccess() {
        return selenium.getText(hitungSuccess);
    }

}
