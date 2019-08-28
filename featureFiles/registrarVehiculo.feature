
Feature: test registro de vehiculos
  yo como usuario quiero que cuando registre un vehiculo en el parqueadero
  lo muestre en la lista de vehiculos parqueados


  Scenario Outline: el usuario registra un vehiculo con tipo de vehiculo valido
    Given el usuario esta la pagina de inicio
    When el usuario ingresa la placa "<placa>"
    And y el tipo de vehiculo "<tipoVehiculo>"
    And y el cilindraje "<cilindraje>"
    Then el usuario puede ver el vehiculo en la lista de vehiculos parqueados "<mensaje>"
 
    Examples: 
      | placa  | tipoVehiculo | cilindraje | 				 mensaje				  |
      | QWRIER |     CARRO		|		500 		 | Nuevo vehiculo registrado|
     
     
 Scenario Outline: el usuario registra un vehiculo con placa invalida
    Given el usuario esta la pagina de inicio
    When el usuario ingresa la placa invalida "<placa>"
    And y el tipo de vehiculo "<tipoVehiculo>"
    Then el vehiculo con tipo de placa invalida no puede ser registrado "<mensaje>"
 
    Examples: 
      | placa  | tipoVehiculo | cilindraje | 							mensaje										   |
      | QWE3 |    moto				|		9	 			 | La longitud de la placa debe ser mayor    |
      
      
  Scenario Outline: el usuario registra un vehiculo con tipo de vehiculo invalido
    Given el usuario esta la pagina de inicio
    When el usuario ingresa el tipo de vehiculo invalido "<tipoVehiculo>"
    And el usuario ingresa la placa "<placa>"
    Then el vehiculo con tipo de vehiculo invalido no puede ser registrado "<mensaje>"
 
    Examples: 
      | placa  | tipoVehiculo			| cilindraje | 						    	mensaje									|
      | QWE3AS |   bicicleta			|		9	 			 | El tipo de vehiculo debe ser carro o moto|    