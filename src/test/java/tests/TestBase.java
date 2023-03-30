package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import manager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ApplicationManager app=new ApplicationManager();
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
            public void setUp() {
        app.init();
    }
//
}
