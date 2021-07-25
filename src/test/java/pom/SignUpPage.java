package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends CommonActions{

    WebDriver driver;
    WebDriverWait webDriverWait;

    public SignUpPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Uloguj se']/..")
    WebElement login;
    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    WebElement cookie;
    @FindBy(xpath = "//a[@class=\"btn btn-block btn-action btn-register\"]")
    WebElement signUpButton;
    @FindBy(xpath = "//button[@class=\"btn btn-action join-sc__button\"]")
    WebElement customerType;
    @FindBy(xpath = "//input[@name=\"firstname\"]")
    WebElement firstName;
    @FindBy(xpath = "//input[@name=\"lastname\"]")
    WebElement lastName;
    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement email;
    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElement password;
    @FindBy(xpath = "//input[@name=\"confirmpassword\"]")
    WebElement confirmPassword;
    @FindBy(xpath = "//input[@name=\"birthDay\"]")
    WebElement birthDay;
    @FindBy(xpath = "//div[@class=\"ng-select-container\"]")
    WebElement birthMonth; //na ovo polje kliknuti a onda iz padajuceg menija izabrati vrednost
    @FindBy(xpath = "//div[@class=\"ng-option\"]/span[@class=\"ng-option-label\"]/span[contains(text(),'Avgust')]")
    WebElement selectMonth; //klik na mesec
    @FindBy(xpath = "//label[contains(text(),'Muško')]")
    WebElement gender;
    @FindBy(xpath = "//label/span[contains(text(),'Pročitao/la sam i prihvatam Shoppster')]")
    WebElement confirmation;
    @FindBy(xpath = "//button[@type=\"submit\" and contains(text(), 'Registruj se')]")
    WebElement submit;

    //Asertacija povratak na pocetnu stranu


    public void acceptCookies(){
        try {
            clickElement(driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")));
        }catch (Exception e){
            System.out.println("No cookies :(");
        }
    }
    public void clickLoginButton() throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//span[text()='Uloguj se']/..")));
    }
    public void clickSignUpButton() throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//a[@class=\"btn btn-block btn-action btn-register\"]")));
    }

}
