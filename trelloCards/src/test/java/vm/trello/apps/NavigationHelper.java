package vm.trello.apps;

import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void board(String boardId, String boardName) {
        driver.get(String.format("https://trello.com/b/%s/%s", boardId, boardName));
    }

}
