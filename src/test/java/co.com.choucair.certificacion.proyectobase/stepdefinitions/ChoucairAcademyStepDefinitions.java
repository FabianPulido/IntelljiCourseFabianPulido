package co.com.choucair.certificacion.proyectobase.stepdefinitions;

import co.com.choucair.certificacion.proyectobase.model.AcademyChoucairData;
import co.com.choucair.certificacion.proyectobase.questions.Answer;
import co.com.choucair.certificacion.proyectobase.tasks.Login;
import co.com.choucair.certificacion.proyectobase.tasks.OpenUp;
import co.com.choucair.certificacion.proyectobase.tasks.Search;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class ChoucairAcademyStepDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("Rose wants to learn automation at the academy Choucair")
    public void researchingThings(List<AcademyChoucairData> academyChoucairData) throws Exception {
      OnStage.theActorCalled("Rose").wasAbleTo(OpenUp.thePage(),(Performable) Login.onThePage(AcademyChoucairData.get(0).getStrUser(),AcademyChoucairData.get(0).getStrPassword()));
    }

    @When("Rose search for the course on the choucair academy platform")
    public void searchesFor(List<AcademyChoucairData> academyChoucairData) throws Exception {
        OnStage.theActorCalled("Rose").attemptsTo( Search.the(AcademyChoucairData.get(0).getStrcourse()) );
    }

    @Then("Rose finds the course called")
    public void should_see_information_about(List<AcademyChoucairData> academyChoucairData) throws Exception {
    OnStage.theActorCalled("Rose").should(GivenWhenThen.seeThat(Answer.toThe(AcademyChoucairData.get(0).getStrcourse())));
    }
}
