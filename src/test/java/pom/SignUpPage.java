package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

//    public void acceptCookies(){
//        try {
//            clickElement(driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")));
//        }catch (Exception e){
//            System.out.println("No cookies :(");
//        }
//    }
//    public void clickLoginButton() throws InterruptedException {
//        clickElement(driver.findElement(By.xpath("//span[text()='Uloguj se']/..")));
//    }
    public void clickSignUpButton() throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//a[@class=\"btn btn-block btn-action btn-register\"]")));
    }
    public void selectCustomerType() throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//button[@class=\"btn btn-action join-sc__button\"]")));
    }
    public void insertFirstName(String ime) throws InterruptedException {
        typeText(driver.findElement(By.xpath("//input[@name=\"firstname\"]")), ime);
    }
    public void insertLastName(String prezime) throws InterruptedException {
        typeText(driver.findElement(By.xpath("//input[@name=\"lastname\"]")), prezime);
    }
    public void insertEmail(String email) throws InterruptedException {
        typeText(driver.findElement(By.xpath("//input[@name=\"email\"]")), email+System.currentTimeMillis()+"@test.com");
    }
    public void insertPassword(String password) throws InterruptedException {
        typeText(driver.findElement(By.xpath("//input[@name=\"password\"]")), password);
    }
    public void confirmPassword(String password) throws InterruptedException {
        typeText(driver.findElement(By.xpath("//input[@name=\"confirmpassword\"]")), password);
    }
    public void insertBirthDay(String birthDay) throws InterruptedException {
        typeText(driver.findElement(By.xpath("//input[@name=\"birthDay\"]")), birthDay);
    }
    public void clickMonth() throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//div[@class=\"ng-select-container\"]")));
    }
    public void selectMonth(String birthMonth) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//div[@class=\"ng-option\"]/span[@class=\"ng-option-label\"]/span[contains(text(),'"+birthMonth+"')]")));
    }
    public void insertYear(String birthYear) throws InterruptedException {
        typeText(driver.findElement(By.xpath("//input[@name=\"birthYear\"]")), birthYear);
    }
    public void selectGender(String gender) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//label[contains(text(),'"+gender+"')]")));
    }
    public void confirm(String confirmation) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//label/span[contains(text(),'"+confirmation+"')]")));
    }
    public void submit() throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//button[@type=\"submit\" and contains(text(), 'Registruj se')]")));
    }

}
