package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ar.unlam.objects.ControlBiometrico;
import com.ar.unlam.objects.RegistroDeIngreso;
import com.ar.unlam.objects.TipoDeEmpleado;
import com.ar.unlam.objects.Usuario;

public class ControlBiometricoTest {
    
    /*
     * 	Test basado en metodología Given-When-Then.
     * 	En la presente clase se aplican los test necesarios para verificar
     * 	el correcto funcionamiento de la clase principal ControlBiometrico.
     * 
     * 	@Author: Skurnik, Franco Daniel.
     */

    @Test
    public void queSePuedaCrearElControlBiometrico() {
	ControlBiometrico nuevo = dadoQueExisteUnControlBiometrico();
	assertNotNull(nuevo);
    }

    @Test
    public void queSePuedaAgregarUnUsuarioAlControlBiometrico() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoAgregoUnUsuarioConDatosEn(controlBiometrico);
	entoncesHayUsuariosRegistradosEn(controlBiometrico);
    }

    @Test
    public void queNoSePuedaAgregarUnUsuarioSinDatosAlControlBiometrico() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoAgregoUnUsuarioSinDatosEn(controlBiometrico);
	entoncesNoHayUsuariosRegistradosEn(controlBiometrico);
    }

    @Test
    public void queSePuedaBuscarUnUsuarioPorSuNumeroDeUsuario() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoAgregoUnUsuarioConDatosEn(controlBiometrico);
	entoncesPuedoBuscarAlUsuarioPorSuNumeroDeUsuarioEn(controlBiometrico);
    }

    @Test
    public void queNoSePuedaBuscarUnUsuarioConUnNumeroDeUsuarioIncorrecto() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoAgregoUnUsuarioConDatosEn(controlBiometrico);
	entoncesNoSePuedeEncontrarUnUsuarioConUnNumeroDeUsuarioIncorrecto(controlBiometrico);
    }
    
    @Test
    public void queSePuedaEncontrarAlGerenteQueTieneElSueldoMayor() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoAgregoGerentesAlControlBiometrico(controlBiometrico);
	entoncesPuedoEncontrarAlGerenteQueGanaMas(controlBiometrico);
    }
    
    @Test
    public void queNoSePuedaEncontrarAlGerenteQueTieneElSueldoMayor() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoNoAgregoGerentesAl(controlBiometrico);
	entoncesNoPuedoEncontrarANingunGerenteEnEl(controlBiometrico);
    }
    
    @Test
    public void queSePuedaRegistrarUnNuevoRegistroDeIngreso() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoAgregoUnUsuarioConDatosEn(controlBiometrico);
	cuandoAgregoUnNuevoRegistroDeIngreso(controlBiometrico);
	entoncesExistenRegistrosDeIngresosEn(controlBiometrico);
    }
    
    @Test
    public void queNoSePuedaRegistrarUnNuevoRegistroDeIngresoConFechaInvalida() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoAgregoUnUsuarioConDatosEn(controlBiometrico);
	cuandoAgregoUnNuevoRegistroDeIngresoConFechaInvalidaEn(controlBiometrico);
	entoncesNoExistenRegistroDeIngresoEn(controlBiometrico);
    }
    
    @Test
    public void queNoSePuedaRegistrarUnNuevoRegistroDeIngresoConNumeroDeUsuarioInvalido() {
	ControlBiometrico controlBiometrico = dadoQueExisteUnControlBiometrico();
	cuandoAgregoUnUsuarioConDatosEn(controlBiometrico);
	cuandoAgregoUnRegistroDeIngresoConNumeroDeUsuarioIncorrectoEn(controlBiometrico);
	entoncesNoExistenRegistroDeIngresoEn(controlBiometrico);
    }

    private void cuandoAgregoUnRegistroDeIngresoConNumeroDeUsuarioIncorrectoEn(ControlBiometrico controlBiometrico) {
	controlBiometrico.registrarUnNuevoIngreso(new RegistroDeIngreso(2000, 03, 30));	
    }

    private void entoncesNoExistenRegistroDeIngresoEn(ControlBiometrico controlBiometrico) {
	assertEquals(false, controlBiometrico.hayRegistrosDeIngresos());
	
    }

    private void cuandoAgregoUnNuevoRegistroDeIngresoConFechaInvalidaEn(ControlBiometrico controlBiometrico) {
	controlBiometrico.registrarUnNuevoIngreso(new RegistroDeIngreso(1998, 2, 29));
	
    }

    private void entoncesExistenRegistrosDeIngresosEn(ControlBiometrico controlBiometrico) {
	assertEquals(true, controlBiometrico.hayRegistrosDeIngresos());
	
    }

    private void cuandoAgregoUnNuevoRegistroDeIngreso(ControlBiometrico controlBiometrico) {
	controlBiometrico.registrarUnNuevoIngreso(new RegistroDeIngreso(1998, 2, 28));	
    }

    private void entoncesNoPuedoEncontrarANingunGerenteEnEl(ControlBiometrico controlBiometrico) {
	assertNull(controlBiometrico.obtenerAlGerenteConMayorSueldo());
	
    }

    private void cuandoNoAgregoGerentesAl(ControlBiometrico controlBiometrico) {
	controlBiometrico.agregarUsuario(new Usuario(2000, "Bazan", TipoDeEmpleado.OPERARIO, 45000.00));
	controlBiometrico.agregarUsuario(new Usuario(1998, "Skurnik", TipoDeEmpleado.OPERARIO, 50000.00));
	
    }

    private void entoncesPuedoEncontrarAlGerenteQueGanaMas(ControlBiometrico controlBiometrico) {
	assertEquals((Double)50000.00, controlBiometrico.obtenerAlGerenteConMayorSueldo().getSueldoDelEmpleado());
	
    }

    private void cuandoAgregoGerentesAlControlBiometrico(ControlBiometrico controlBiometrico) {
	controlBiometrico.agregarUsuario(new Usuario(2000, "Bazan", TipoDeEmpleado.GERENTE, 45000.00));
	controlBiometrico.agregarUsuario(new Usuario(1998, "Skurnik", TipoDeEmpleado.GERENTE, 50000.00));
    }

    private void entoncesNoSePuedeEncontrarUnUsuarioConUnNumeroDeUsuarioIncorrecto(
	    ControlBiometrico controlBiometrico) {
	assertNull(controlBiometrico.buscarUsuario(2000));
    }

    private void entoncesNoHayUsuariosRegistradosEn(ControlBiometrico controlBiometrico) {
	assertFalse(controlBiometrico.hayUsuariosRegistrados());

    }

    private void entoncesPuedoBuscarAlUsuarioPorSuNumeroDeUsuarioEn(ControlBiometrico controlBiometrico) {
	assertNotNull(controlBiometrico.buscarUsuario(1998));

    }

    private void cuandoAgregoUnUsuarioSinDatosEn(ControlBiometrico controlBiometrico) {
	controlBiometrico.agregarUsuario(new Usuario());

    }

    private void cuandoAgregoUnUsuarioConDatosEn(ControlBiometrico actual) {
	actual.agregarUsuario(new Usuario(1998, "Skurnik", TipoDeEmpleado.ADMINISTRATIVO, 2000.00));
    }

    private ControlBiometrico dadoQueExisteUnControlBiometrico() {
	return new ControlBiometrico("Lector biométrico");
    }

    private void entoncesHayUsuariosRegistradosEn(ControlBiometrico actual) {
	assertTrue(actual.hayUsuariosRegistrados());
    }

}
