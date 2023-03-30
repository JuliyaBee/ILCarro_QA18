package manager;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
   // WebDriver wd;
    HelperUser user;
    public void init(){
       // wd=new ChromeDriver();
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new MyListener());
        user=new HelperUser(wd);
     //   wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.web.app/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    public void stop(){
        wd.quit();

    }

    public HelperUser getUser() {
        return user;
    }


}
