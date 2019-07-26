package vm.trello.apps;

import org.openqa.selenium.*;

public class HelperBase {

    protected WebDriver driver;

    private final String startPage = "https://trello.com/login";
    private final String userName = "";
    private final String password = "";
    private final By userNameField = By.id("user");
    private final By userPasswordField = By.id("password");
    private final By userLoginButton = By.id("login");


    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.get(startPage);
        click(userNameField);
        type(userNameField, userName);
        click(userPasswordField);
        type(userPasswordField, password);
        click(userLoginButton);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Personal Boards'])[2]/following::div[1]"));
    }

    // PageObject: Manipulation Group

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void type(By by, String s) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(s);
    }

    public void clear(By by) {
        driver.findElement(by).clear();
    }

    public void editFieldAndPressKey(By by, Keys keys, String listEditedTitle) {
        type(by, listEditedTitle);
        driver.findElement(by).sendKeys(keys);
    }

    public void submit(By by) {
        driver.findElement(by).submit();
    }

    // PageObject: Information Group

    public String pageTitle() {
        return driver.getTitle();
    }

    public String pageUrl() {
        return driver.getCurrentUrl();
    }

    public boolean elementIsPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public String elementText(By by) {
        return driver.findElement(by).getText();
    }
}
