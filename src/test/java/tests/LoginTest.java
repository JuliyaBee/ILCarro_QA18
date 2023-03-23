package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class LoginTest extends TestBase {

    String correctEmail = "juliya@gmail.com";
    String correctPassword = "Pass@word1";
    String incorrectEmail1 = "juliyagmailcom";
    String incorrectEmail2 = "jul@gmail.com";

    String incorrectPassword = "pass@word1";


@BeforeMethod
public void precondition(){
    if(app.getUser().isLogged()){
        app.getUser().logOut();
    }
}


    @Test
    public void loginPositiveTest() {
       User user = User.builder().
               email(correctEmail).
               password(correctPassword).
               build();;
        app.getUser().openLoginForm();
       // app.getUser().fillLoginForm(correctEmail, correctPassword);
        app.getUser().fillLoginForm(user);
        app.getUser().submitForm();
      Assert.assertTrue(app.getUser().isLoggedSuccess());
    }
     @Test
     public void loginWrongPasswordNegativeTest() {
    User user=User.builder().
            email(correctEmail).
            password(incorrectPassword).
            build();
         app.getUser().openLoginForm();
        // app.getUser().fillLoginForm(correctEmail, incorrectPassword);
         app.getUser().fillLoginForm(user);
         app.getUser().submitForm();
         Assert.assertTrue(app.getUser().isLoggedFailWrongPassword());
     }
    @Test
    public void loginWrongEmail1NegativeTest() {
    User user  = User.builder().
            email(incorrectEmail1).
            password(correctPassword).
            build();
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        // app.getUser().submitForm();
        Assert.assertTrue(app.getUser().isLoggedFailWrongEmail1());
           }
        @Test
        public void loginWrongEmail2NegativeTest(){
    User user = User.builder().
            email(incorrectEmail2).
            password(correctPassword).
            build();;
    app.getUser().openLoginForm();
    app.getUser().fillLoginForm(user);
    app.getUser().submitForm();
    Assert.assertTrue(app.getUser().isLoggedFailWrongEmail2());

        }

               @AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
    }
}

