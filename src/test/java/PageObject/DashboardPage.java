package test.java.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement title;

    @FindBy(xpath = "(//div[contains(., 'NopCommerce News')])[11]")
    WebElement nopCommerceNews;

    @FindBy(xpath = "(//div[contains(., 'NopCommerce News')])[11]/../div/button/i[@class='fa fa-minus']")
    WebElement minusIcon;

    @FindBy(xpath = "(//i[@class='fa fa-plus'])[1]")
    WebElement plusIcon;

    public void verifyTitle()
    {
        Assert.assertTrue(title.isDisplayed());
        Reporter.log("Verify page title is displayed");
    }

    public void verifyNopCommerceNewsIsDisplay()
    {
        Assert.assertTrue(nopCommerceNews.isDisplayed());
        Reporter.log("Verify Nop Commerce News section is displayed");
    }

    public void verifyPlusIconIsDisplay()
    {
        Assert.assertTrue(plusIcon.isDisplayed());
        Reporter.log("Verify plus icon is displayed");
    }

    public void clickOnMinusIcon()
    {
        if(!minusIcon.isDisplayed()){
            plusIcon.click();
        }
        minusIcon.click();
        Reporter.log("Click on minus icon");

    }



}
