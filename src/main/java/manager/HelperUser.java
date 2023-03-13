package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd){
        super(wd);
    }
    public void openLoginForm(){
        click(By.xpath("//a[@href='/login?url=%2Fsearch']"));
    }
    public void fillLoginForm(String email, String password){
        type(By.xpath("//input[@id='email']"),email );
        type(By.xpath("//input[@id='password']"), password);
    }
    public void submitLogin(){
        click(By.xpath("//button [@type='submit']"));
       click(By.xpath("//button[@class='positive-button ng-star-inserted']"));
    }

    public void openRegistrationForm(){
      click(By.xpath("//div[1]/a[5]"));
    }
    public void fillRegistrationForm(String name, String LastName, String email, String Password){
        type(By.xpath("//input[@id='name']"), name);
        type(By.xpath("//input[@id='lastName']"), LastName);
        type(By.xpath("//input[@id='email']"), email);
        type(By.xpath("//input[@id='password']"), Password);
    }
    public void submitRegistration() {
        click(By.xpath("//label[@class='checkbox-label terms-label']"));
        click(By.xpath ("//button[@type='submit']"));
        click(By.xpath("//button[@class='positive-button ng-star-inserted']"));
    }
    public boolean isLogged(){
        return isElementPresent(By.linkText("Logged in success"));
    }
}
