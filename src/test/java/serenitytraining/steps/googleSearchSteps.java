package serenitytraining.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import serenitytraining.pages.GoogleHomePage;
import serenitytraining.pages.GoogleResultPage;


@Narrative(
        title = "Google Search",
        text = {
                "As a web user ,",
                "I need the ability to search google for results\n,",
                "So that I can find out more information about the things I search\n"
        })
public class googleSearchSteps {

    @Steps
    private GoogleHomePage googleHomePage = new GoogleHomePage();

    @Steps
    private GoogleResultPage googleResultPage = new GoogleResultPage();

    @Steps
    private String actorName = "";


    @Given("^the web user has an actors name (.*)$")
    public void theWebUserHasAnActorsNameActorName(String actor) {
        googleHomePage.open();
        actorName = actor;
    }

    @When("^the web user performs a google search$")
    public void the_web_user_performs_a_google_search() {
        googleHomePage.searchFor(actorName);
    }

    @Then("^the web user receives search results related to the actor name that was searched$")
    public void the_web_user_receives_search_results_related_to_the_actor_name_that_was_searched() {
        googleResultPage.actorNameIsVisible(actorName);
    }


}
