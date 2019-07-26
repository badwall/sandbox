package vm.trello.apps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ListHelper extends HelperBase {

    //global variables
    public static final String INIT_LIST_CREATION_SELECTOR = ".placeholder";
    public static final String LIST_CREATION_NAME_INPUT = "name";
    public static final String LIST_TITLE = ".list-header";
    public static final String LIST_TITLE_EDIT_MODE = ".list-header-name";
    public static final String ADD_LIST_BUTTON = "//input[@value='Add List']";
    public static final String ARCHIVE_LIST_LINK = "Archive This List";


    public ListHelper(WebDriver driver) {
        super(driver);
    }

    public void addList(String s) {
        click(By.cssSelector(INIT_LIST_CREATION_SELECTOR));
        type(By.name(LIST_CREATION_NAME_INPUT), s);
        submit(By.xpath(ADD_LIST_BUTTON));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add another list'])[1]/following::a[1]"));
    }

    public void editListTitle(String listEditedTitle) {
        click(By.cssSelector(LIST_TITLE));
        click(By.cssSelector(LIST_TITLE_EDIT_MODE));
        clear(By.cssSelector(LIST_TITLE_EDIT_MODE));
        editFieldAndPressKey(By.cssSelector(LIST_TITLE_EDIT_MODE), Keys.ENTER, listEditedTitle);
    }

    public void archiveList(String listName) {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" +
                listName + "'])[2]/following::a[1]"));
        click(By.linkText(ARCHIVE_LIST_LINK));
    }
}
