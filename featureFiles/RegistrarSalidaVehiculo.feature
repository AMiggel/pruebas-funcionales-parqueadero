
Feature: Test Registrar Salida de vehiculo
  yo como usuario quiero que cuando registre una salida de un vehiculo en el parqueadero
  lo quite de la lista de vehiculos parqueados

  Scenario Outline: el usuario registra salida a un vehiculo 
    Given el usuario esta la pagina de inicio
    When el usuario busca un vehiculo por placa "<placa>" 
    And y da click en salir
    Then el vehiculo sale de la lista de vehiculos parqueados "<mensaje>"
 
    Examples: 
      | placa  | 		 mensaje				|
      | CAS322 |  Vehiculo retirado	|
