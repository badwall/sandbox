package vm.trello.apps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class AppBuilder {
    private WebDriver driver;
    private ListHelper listHelper;
    private NavigationHelper navigationHelper;
    private HelperBase helperBase;
    private String browser;

    public AppBuilder(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.SAFARI)) {
            driver = new SafariDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.listHelper = new ListHelper(driver);
        this.navigationHelper = new NavigationHelper(driver);
        this.helperBase = new HelperBase(driver);
    }

    public void finish() {
        driver.quit();
    }

    public ListHelper list() {
        return this.listHelper;
    }

    public NavigationHelper navigateTo() {
        return this.navigationHelper;
    }

    public HelperBase helper() {
        return this.helperBase;
    }
}
