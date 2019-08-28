package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.InicioPage;

public class RegistroVehiculoStep {

	WebDriver driver;
	InicioPage inicioPage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		inicioPage = new InicioPage(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Given("el usuario esta la pagina de inicio")
	public void usuarioEstaEnInicioEnElFormulario() {
		driver.get("http://localhost:4200/parqueadero");

	}

	// registro de vehiculo valido
	@When("^el usuario ingresa la placa \"([^\"]*)\"$")
	public void el_usuario_ingresa_la_placa(String placa) {
		inicioPage.setPlaca(placa);

	}

	@And("^y el tipo de vehiculo \"([^\"]*)\"$")
	public void yElTipoDeVehiculo(String tipoVehiculo) {
		inicioPage.setTipoVehiculo(tipoVehiculo);
	}

	@And("^y el cilindraje \"(.*)\"$")
	public void usuarioIngresaCilindraje(String cilindraje) {
		inicioPage.setCilindraje(cilindraje);
	}

	@Then("^el usuario puede ver el vehiculo en la lista de vehiculos parqueados \"(.*)\"$")
	public void vehiculoEsCreadoCorrectamente(String mensaje) throws Throwable {
		inicioPage.clicCrear();
		Thread.sleep(2000);
		String resultado = driver.findElement(By.id("swal2-title")).getText();
		assertTrue(resultado.contains(mensaje));
	}

	// registro de salida vehiculo
	@When("^el usuario busca un vehiculo por placa \"([^\"]*)\"$")
	public void usuarioBuscaVehiculoPorPlaca(String placa) {
		inicioPage.buscarVehiculoPorPlaca(placa);

	}

	@And("^y da click en salir")
	public void usuarioDaClickEnSalir() {
		inicioPage.clicSalir();
	}

	@Then("^el vehiculo sale de la lista de vehiculos parqueados \"([^\"]*)\"$")
	public void vehiculoEsRetiradoCorrectamente(String mensaje) throws Throwable {
		Thread.sleep(2000);
		String resultado = driver.findElement(By.id("swal2-title")).getText();
		assertTrue(resultado.contains(mensaje));
	}

	// Registro con placa invalida
	@When("^el usuario ingresa la placa invalida \"([^\"]*)\"$")
	public void usuarioIngresaPlacaInvalida(String placa) {
		inicioPage.setPlaca(placa);

	}

	@Then("^el vehiculo con tipo de placa invalida no puede ser registrado \"([^\"]*)\"$")
	public void noPuedeRegistrarVehiculoConPlacaInvalida(String mensaje) throws Throwable {
		inicioPage.clicCrear();
		Thread.sleep(2000);
		String resultado = driver.findElement(By.id("swal2-title")).getText();
		assertTrue(resultado.contains(mensaje));
	}

	@When("^el usuario ingresa el tipo de vehiculo invalido \"([^\"]*)\"$")
	public void elUsuarioIngresaTipoVehiculoInvalido(String tipoVehiculo) {
		inicioPage.setTipoVehiculo(tipoVehiculo);
	}

	@Then("^el vehiculo con tipo de vehiculo invalido no puede ser registrado \"([^\"]*)\"$")
	public void noPuedeRegistrarVehiculoConTipoInvalido(String mensaje) throws Throwable {
		inicioPage.clicCrear();
		Thread.sleep(2000);
		String resultado = driver.findElement(By.id("swal2-title")).getText();
		assertTrue(resultado.contains(mensaje));
	}
}
