package test.java.Tests;

import test.java.Commons.*;

public class Test extends InitBrowser {


    @org.testng.annotations.Test
    public void loginwithIdPassword()
    {
        login.loginwithValidCredentials();
        pause(3);
        dashBoard.verifyTitle();
        pause(2);
    }

    @org.testng.annotations.Test
    public void verifyNopCommerceNewsSection()
    {
        login.loginwithValidCredentials();
        pause(3);
        dashBoard.verifyTitle();

        dashBoard.verifyNopCommerceNewsIsDisplay();
        dashBoard.clickOnMinusIcon();
        dashBoard.verifyPlusIconIsDisplay();
        pause(2);
    }


}
