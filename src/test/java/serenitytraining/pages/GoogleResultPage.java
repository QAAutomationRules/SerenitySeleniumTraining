package serenitytraining.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;

public class GoogleResultPage extends PageObject {


    /**
     * searchInputField
     *
     * <p>the main search bar for the front page of Google
     */
    @FindBy(name = "q")
    WebElement searchInputField;


    public GoogleResultPage() {
    }


    public boolean actorNameIsVisible(String actorName) {
        return find(By.xpath("//span[Contains(text(),'" + actorName + "']")).isVisible();

    }

}
