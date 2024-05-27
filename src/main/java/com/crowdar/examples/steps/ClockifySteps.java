package com.crowdar.examples.steps;
import com.crowdar.examples.services.ClockifyService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Clock;

public class ClockifySteps {
    @Given("el usuario abre la app")
    public void elUsuarioAbreLaApp() {
    }

    @When("el usuario inicia sesion con mail y contraseña")
    public void elUsuarioIniciaSesionConY() throws Exception {
        ClockifyService.loginClockify();
    }

    @Then("se inicia sesion con la cuenta")
    public void seIniciaSesionConLaCuenta() {
        ClockifyService.verifyLogin();
    }

    @And("selecciona crear nuevo proyecto")
    public void seleccionaCrearNuevoProyecto() {
        ClockifyService.createProject();
    }

    @Then("el proyecto se crea correctamente y se encuentra en el inicio")
    public void elProyectoSeCreaCorrectamenteYSeEncuentraEnElInicio() {
        ClockifyService.verifyProject();
    }

    @And("rellena las casillas de (.*) y (.*)")
    public void rellenaLasCasillasDeY(String horario, String descripcion) {
        ClockifyService.setProjectValues(horario, descripcion);
    }
}
