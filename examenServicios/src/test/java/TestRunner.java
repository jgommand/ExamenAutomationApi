import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.everis.base",
        tags = "@crearOrden", // => Se puede especificar qué Ejecutar
        strict = true)

public class TestRunner {
}
