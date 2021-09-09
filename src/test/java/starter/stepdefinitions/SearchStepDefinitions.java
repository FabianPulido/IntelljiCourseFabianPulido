package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;
import starter.navigation.AcademyChoucairData;
import starter.navigation.Login;
import starter.navigation.OpenUp;
import starter.navigation.Search;
import starter.questions.Answer;

import java.util.List;

public class SearchStepDefinitions {

    @Given("Rose wants to learn automation at the academy Choucair")
    public void researchingThings(List<AcademyChoucairData> academyChoucairData) throws Exception {
        OnStage.theActorCalled("Rose").wasAbleTo(OpenUp.thePage(),(Performable) Login.onThePage(academyChoucairData.get(0).getStrUser(), academyChoucairData.get(0).getStrPassword()));
    }

    @When("Rose search for the course on the choucair academy platform")
    public void searchesFor( List<AcademyChoucairData> academyChoucairData) throws Exception {
        OnStage.theActorCalled("Rose").attemptsTo( Search.the(academyChoucairData.get(0).getStrcourse()) );
    }

    @Then("Rose finds the course called")
    public void should_see_information_about(List<AcademyChoucairData> academyChoucairData) throws Exception {
        OnStage.theActorCalled("Rose").should(GivenWhenThen.seeThat(Answer.toThe(academyChoucairData.get(0).getStrcourse())));
    }
}
