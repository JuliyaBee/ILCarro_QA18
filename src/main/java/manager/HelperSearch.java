package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperSearch extends HelperBase{


    public HelperSearch(WebDriver wd) {
        super(wd);
    }
    public void openSearchForm(){
        click(By.xpath("//a[@href='"));
    }
}
