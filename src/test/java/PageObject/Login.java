package test.java.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="Email")
    WebElement emailTextbox;

    @FindBy(id="Password")
    WebElement passwordTextBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement  loginBnt;



    public void loginwithValidCredentials()
    {
        emailTextbox.sendKeys("admin@yourstore.com");
        Reporter.log("Enter 'admin@yourstore.com' in to email textbox");
        passwordTextBox.sendKeys("admin");
        Reporter.log("Enter password in to password textbox");
        loginBnt.click();
        Reporter.log("Click on login button");
    }
}
