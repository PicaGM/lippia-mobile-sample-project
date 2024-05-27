@Clockify @Regression
  Feature: Como cliente de la applicacion quiero probar el correcto funcionamiento de la misma

    @Login @Smoke
      Scenario: Iniciar sesion en la app de Clockify
      Given el usuario abre la app
      When el usuario inicia sesion con mail y contraseña
      Then se inicia sesion con la cuenta

    @TimeEntry @Smoke
      Scenario Outline: Crear una entrada en la app de Clockify
      Given el usuario abre la app
      When el usuario inicia sesion con mail y contraseña
      And selecciona crear nuevo proyecto
      And rellena las casillas de <horario> y <descripcion>
      Then el proyecto se crea correctamente y se encuentra en el inicio

      Examples:
        | horario | descripcion |
        | 12      | TP8         |
        | 08      | tp8         |