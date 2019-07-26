package vm.trello.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import vm.trello.apps.AppBuilder;

public class TestBase {
    //Command Line usage example: -Pbrowser=chrome
    protected static final AppBuilder appBuilder = new AppBuilder(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app().init();
        app().helper().login();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app().finish();
    }

    public AppBuilder app() {
        return appBuilder;
    }



}
