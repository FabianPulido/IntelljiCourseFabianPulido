package co.com.choucair.certificacion.proyectobase.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ChoucairLoginPage extends PageObject {

    public static final Target BOTON_LOGIN = Target.the("button that shows us the form to login").
            located(By.xpath("//div[@class='d-block d-lg-none']//strong[contains(text(),'Ingresar')]"));

    public static final Target INPUT_USER = Target.
            the("where do write the user").
            located(By.id("username"));

    public static final Target INPUT_PASSWORD = Target.
            the("where do write the password").
            located(By.id("password"));

    public static final Target ENTER_BUTTON = Target.
            the("button to confirm login").
            located(By.xpath("//button[contains(@class,'btn btn-primary')]"));

}
