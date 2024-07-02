# new feature
# Tags: optional

Feature: Automatización del servicio de Store de PetStore

    @crearOrden
    Scenario Outline: Crear  Orden
        Given creo una orden con id <orderId> para la mascota <petId> cantidad <quantity> comprado en la fecha <shipDate>
        When el código de estado de la respuesta debería ser 200
        Then el cuerpo de la respuesta debería contener el id de la orden <orderId>
        Examples:
            | orderId | petId |quantity|shipDate|
            | 1       | 10    |1       |"2024-03-02T00:12:30.075Z"|
            | 2       | 20    |3       |"2023-01-06T00:09:30.075Z"|

      @consultarOrden
     Scenario Outline:  Consultar Orden
        Given consulto la orden con id <orderId>
        When el código de estado de la respuesta debería ser 200
        Then el cuerpo de la respuesta de la consulta debería contener el id de la orden <orderId>

        Examples:
            | orderId |
            | 1       |
            | 2       |
