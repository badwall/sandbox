package vm.trello.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import vm.trello.data.BoardData;

import static vm.trello.apps.ListHelper.LIST_TITLE_EDIT_MODE;

public class ListTests extends TestBase {

    private String listTitle = "Test List";
    private String listEditedTitle = "Test List EDITED";
    private BoardData boardData = new BoardData(
            "4gp4oavQ",
            "Vadim Test",
            "vadim-test");

    @Test
    @Tag(name = "LIST")
    public void listCreationTest() {
        app().navigateTo().board(boardData.getBoardId(), boardData.getBoardName());
        app().list().addList(listTitle);

        //Assert: PageURL.contains(boardNameURL)
        MatcherAssert.assertThat(
                "boardNameURL isn't present in the PageURL",
                app().helper().pageUrl(),
                CoreMatchers.containsString(boardData.getBoardNameURL())
        );

        //Assert: PageTitle.contains(boardNameURL)
        MatcherAssert.assertThat(
                "pageTitle doesn't contains correct boardName",
                app().helper().pageTitle(),
                CoreMatchers.containsStringIgnoringCase(boardData.getBoardName())
        );

        //Assert: created list is present on the board with correct listTitle
        MatcherAssert.assertThat(
                "List with correct title isn't present on the board: check, that it was actually created",
                app().helper().elementIsPresent(By.cssSelector(
                        String.format(".list-header-name[aria-label='%s']", listTitle))),
                CoreMatchers.is(true)
        );
    }

    @Test
    @Tag(name = "LIST")
    public void listTitleEditingTest() {
        app().navigateTo().board(boardData.getBoardId(), boardData.getBoardName());
        app().list().editListTitle(listEditedTitle);

        //Assert: listTitle.equals(listEditedTitle)
        app().navigateTo().board(boardData.getBoardId(), boardData.getBoardName()); //refreshing the page to update source code
        MatcherAssert.assertThat(
                "Edited list title can't be found in the source code: probably it hasn't been updated on the UI either",
                app().helper().elementText(By.cssSelector(LIST_TITLE_EDIT_MODE)),
                CoreMatchers.is(listEditedTitle)
        );
    }

    @Test(dependsOnMethods = {"listCreationTest"})
    @Tag(name = "LIST")
    public void archiveEmptyListAfterCreationTest() {
        app().list().archiveList(listEditedTitle);

        //Assert: created list is deleted from the page
        MatcherAssert.assertThat(
                "The List is present on the board after deletion: check, that it was actually deleted",
                app().helper().elementIsPresent(By.cssSelector(
                        String.format(".list-header-name[aria-label='%s']", listEditedTitle))),
                CoreMatchers.is(false)
        );
    }
}
