package serenitytraining.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://www.google.com")
public class GoogleHomePage extends PageObject {

    /**
     * searchInputField
     *
     * <p>the main search bar for the front page of Google
     */
    @FindBy(name = "q")
    WebElement searchInputField;


    public GoogleHomePage() {
    }

    /**
     * searchFor
     *
     * <p>inputs a string of text into the main Google search bar and hits Enter
     *
     * @param input String information to be entered into the search input field
     */
    public void searchFor(String input) {
        searchInputField.sendKeys(input, Keys.ENTER);
        waitForTitleToAppear(input + " - Google Search");
    }


}