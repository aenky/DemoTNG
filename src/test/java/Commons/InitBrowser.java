package test.java.Commons;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import test.java.PageObject.DashboardPage;
import test.java.PageObject.Login;


public class InitBrowser {

   public WebDriver driver;
   public Login login ;
   public DashboardPage dashBoard;

    @BeforeMethod
    public void initBrowser(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        Reporter.log("Open 'https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F'");

         login = new Login(driver);
         dashBoard = new DashboardPage(driver);
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
        Reporter.log("Close the Browser!!!");
    }

    public void pause(int sec) {

        try {
            Reporter.log("Wait for "+sec+" sec.");
            Thread.sleep(1000*sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
