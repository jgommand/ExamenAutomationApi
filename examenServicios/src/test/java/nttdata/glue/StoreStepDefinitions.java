package nttdata.glue;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import nttdata.steps.StoreSteps;

public class StoreStepDefinitions {

    @Steps
    StoreSteps store;

    @Given("consulto la orden con id {int}")
    public void consulto_la_orden_con_id(int orderId) {
        store.consultarOrden(orderId);
    }
    @When("el código de estado de la respuesta debería ser {int}")
    public void el_codigo_de_estado_de_la_respuesta_deberia_ser(int statusCode) {
        store.validadCodigoRespuesta(statusCode);
    }

    @Then("el cuerpo de la respuesta de la consulta debería contener el id de la orden {int}")
    public void el_cuerpo_de_la_respuesta_de_la_consulta_deberia_contener_el_id_de_la_orden(int orderId) {
        store.validarCuerpoRespuestaConsulta(orderId);
    }

    @Then("el cuerpo de la respuesta debería contener el id de la orden {int}")
    public void elCuerpoDeLaRespuestaDelPostDeberíaContenerElIdDeLaOrdenOrderId(int orderId) {
        store.validarCuerpoRespuestaCreacion(orderId);
    }

    @Given("creo una orden con id {int} para la mascota {int} cantidad {int} comprado en la fecha {string}")
    public void creoUnaOrdenConIdOrderIdParaLaMascotaPetIdCantidadQuantityCompradoEnLaFecha(int orderId, int petId, int quantity, String fecha) {
        store.crearOrden(orderId, petId, quantity, fecha);
    }
}
