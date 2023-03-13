package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    String correctEmail = "juliya@gmail.com";
    String correctPassword = "Pass@word1";
    String incorrectEmail = "juliyagmailcom";
    String incorrectPassword = "pass@word1";
    String emptyEmail = "";
    String emptyPassword = "";







    @Test
    public void loginPositiveTest() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(correctEmail, correctPassword);
        app.getUser().submitLogin();

      Assert.assertTrue(app.getUser().isElementPresent(By.linkText("Delete account") ));
    }
     @Test
     public void passwordNegativeTest(){
app.getUser().openLoginForm();
app.getUser().fillLoginForm(correctEmail,incorrectPassword);
app.getUser().submitLogin();
Assert.assertFalse(app.getUser().isElementPresent(By.linkText("Delete account")));
     }
    @Test
    public void loginNegativeTest(){
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(incorrectEmail, correctPassword);
        app.getUser().submitLogin();
        Assert.assertFalse(app.getUser().isElementPresent(By.linkText("Delete account")));
    }
}

