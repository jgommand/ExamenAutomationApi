package nttdata.steps;

import nttdata.model.Order;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import org.openqa.selenium.remote.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class StoreSteps {

    private final String URL_BASE = "https://petstore.swagger.io/v2/";
    private Response response;
    private int statusCode;
    private int responseBodyOrderId;

    public void crearOrden(int orderId, int petId, int quantity, String fecha) {

        String requestBody = "{"
                + "\"id\": " + orderId + ","
                + "\"petId\": " + petId + ","
                + "\"quantity\": " + quantity + ","
                + "\"shipDate\": \"" + fecha + "\","
                + "\"status\": \"placed\","
                + "\"complete\": true"
                + "}";

        SerenityRest.given()
                .contentType("application/json")
                .baseUri(URL_BASE)
                .body(requestBody)
                .post("store/order")
                .as(Order.class);
        statusCode = SerenityRest.then().extract().statusCode();
        responseBodyOrderId = SerenityRest.then().extract().path("id");
    }


    public void consultarOrden(int orderId) {
        Order order = given().baseUri(URL_BASE).log().all().when()
                .get("store/order/"+orderId).as(Order.class);
        System.out.println("Orden encontrada"+order.getId());
    }
    public void validadCodigoRespuesta(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().statusCode());
    }

    public void validarCuerpoRespuestaConsulta(int orderId) {
        int idResponse=SerenityRest.lastResponse().body().path("id");
        Assert.assertEquals(orderId,idResponse);
    }

    public void validarCuerpoRespuestaCreacion(int orderId) {
        int idResponse=SerenityRest.lastResponse().body().path("id");
        Assert.assertEquals(orderId,idResponse);
    }
}
