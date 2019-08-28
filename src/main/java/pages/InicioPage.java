package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicioPage {
	
	WebDriver driver;
	
	public void setPlaca(String placa) {
		driver.findElement(By.id("placaVehiculo")).sendKeys(placa);
	}
	
	public void setTipoVehiculo(String tipoVehiculo) {
		driver.findElement(By.id("tipoVehiculo")).sendKeys(tipoVehiculo);
	}
	
	public void setCilindraje(String cilindraje) {
		driver.findElement(By.id("cilindrajeVehiculo")).sendKeys(cilindraje);
	}
	
	public void clicCrear() {
		driver.findElement(By.id("crearVehiculo")).click();
	}
	
	public void clicSalir() {
		driver.findElement(By.id("sacarVehiculo")).click();
	}
	
	public void buscarVehiculoPorPlaca(String placa) {
		driver.findElement(By.id("busquedaVehiculo")).sendKeys(placa);
	}
	public InicioPage(WebDriver driver) {
		this.driver = driver;
	}
}
