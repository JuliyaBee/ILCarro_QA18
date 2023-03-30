package manager;

import models.User;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd){
        super(wd);
    }
    public void openLoginForm(){
        click(By.xpath("//a[.=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"),email );
        type(By.id("password"), password);
    }
    public void fillLoginForm(User user){// overloading возможность работы метода с разным набором данных
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());

    }
    public void submitForm(){
       // click(By.xpath("//button[@type='submit']"));
    // wd.findElement(By.xpath("//button[@type='submit']")).submit();
        WebElement element =  wd.findElement(By.xpath("//button[@type='submit']"));
        if(element.isEnabled()==true){
            element.submit();
        }
    }

    public void openRegistrationForm(){
      click(By.xpath("//a[.=' Sign up ']"));
    }
    public void fillRegistrationForm(String name, String lastName, String email, String password) {
        type(By.id("name"), name);
        type(By.id("lastName"), lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillRegistrationForm( User user) {
        type(By.id("name"), user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }
    public void clickCheckBox() {
//  *****************variant 1       boolean isSelected;
//        WebElement checkBox=wd.findElement(By.xpath("//label[@for='terms-of-use']"));
//        checkBox.click();
        //  isSelected= checkBox.isSelected();
        //  if(isSelected==false){
        // checkBox.click();}
 //  ******************  variant 2
//        JavascriptExecutor script = (JavascriptExecutor) wd;
//        script.executeScript("document.querySelector('#terms-of-use').click();");
//   **************** variant 3
        Rectangle rect = wd.findElement(By.xpath("//*[@class='checkbox-container']")).getRect();//получение координат родителя/
        int x = rect.getX()+5;
        int y = rect.getY()+rect.getHeight()*1/2;
        Actions actions = new Actions(wd);
        actions.moveByOffset(x, y).click().perform();



    }

    public boolean isRegistratedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='You are logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='You are logged in success']")).getText().contains("logged");
    }
    public boolean isRegistrationUnSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h1[.='Registration failed']"))));
        return wd.findElement(By.xpath("//h1[.='Registration failed']")).getText().contains("failed");
    }
    public boolean isRegistrationUnSuccessWrongPassword() {
        WebDriverWait wait=new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[contains(text(),\"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]\")]"))));
        return wd.findElement(By.xpath("//div[contains(text(),\"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]\")]")).getText().contains("contain");
    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
            }

    public void logOut(){
        click(By.xpath ("//a[.=' Logout ']"));
    }

    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h2[.='Logged in success']"))));
        return wd.findElement(By.xpath("//h2[.='Logged in success']")).getText().contains("success");
    }

    public boolean isLoggedFailWrongEmail1() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]"))));
        return wd.findElement(By.xpath("//div[.=\"It'snot look like email\"]")).getText().contains("like email");
    }
    public boolean isLoggedFailWrongEmail2() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h1[.='Login failed']"))));
        return wd.findElement(By.xpath("//h1[.='Login failed']")).getText().contains("failed");
    }
    public boolean isLoggedFailEmptyEmail() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[.=' Email is required ']"))));

        return wd.findElement(By.xpath("//div[.=' Email is required ']")).getText().contains("required");
    }
    public boolean isLoggedFailWrongPassword() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//h1[.='Login failed']"))));
        return wd.findElement(By.xpath("//h1[.='Login failed']")).getText().contains("failed");
    }


    public void clickOkButton(){
        if(isElementPresent(By.xpath("//button[.='Ok']"))){
           click(By.xpath("//button[.='Ok']")); ;
        }
    }



}
