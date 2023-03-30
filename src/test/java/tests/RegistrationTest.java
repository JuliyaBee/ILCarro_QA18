package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
    WebDriver wd;

    int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
   String correctEmail = "juliya"+i+"@gmail.com";
   String correctPassword = "Pass@word1";

    String incorrectEmail1 = "juliya@gmail.com";
    String incorrectEmail2 = "julgmail.com";
    String incorrectPassword = "password";




    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }
    @Test
    public void registrationPositiveTest(){
//        app.getUser().openRegistrationForm();
//        app.getUser().fillRegistrationForm("Aaa", "Bbb",

//                correctEmail , "Pass@word1");
//        app.getUser().clickCheckBox();
//        app.getUser().submitForm();
//       Assert.assertTrue(app.getUser().isRegistrationSuccess());


      User user =User.builder().
             name("Aaa").
             lastName("Bbb").
              email(correctEmail).
              password(correctPassword).
               build();
      logger.info("registrationPositiveTest starts with: "+user.getEmail()+" & "+user.getPassword());
      app.getUser().openRegistrationForm();
      app.getUser().fillRegistrationForm(user);
      app.getUser().clickCheckBox();
      app.getUser().submitForm();

        logger.info("registrationPositiveTest completed");
      Assert.assertTrue(app.getUser().isRegistratedSuccess());

    }
@Test
    public void registrationExistingEmailNegativeTest() {
        User user = User.builder().
                name("Aaa").
                lastName("Bbb").
                email(incorrectEmail1).
                password(correctPassword).
                build();
    app.getUser().openRegistrationForm();
    app.getUser().fillRegistrationForm(user);
    app.getUser().clickCheckBox();
    app.getUser().submitForm();
    Assert.assertTrue(app.getUser().isRegistrationUnSuccess());
}
   @Test
   public void registrationWrongPasswordNegativeTest(){
        User user=User.builder().
                name("Aaa").
                lastName("Bbb").
                email(correctEmail).
                password(incorrectPassword).
                build();
        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickCheckBox();
       app.getUser().submitForm();
       Assert.assertTrue(app.getUser().isRegistrationUnSuccessWrongPassword());


    }
@AfterMethod
    public void postCondition(){
        app.getUser().clickOkButton();
}

}
