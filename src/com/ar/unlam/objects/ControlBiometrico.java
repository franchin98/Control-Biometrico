package com.ar.unlam.objects;

import java.util.ArrayList;
import java.util.Iterator;



public class ControlBiometrico {

    private String nombreDelControlBiometrico;
    private ArrayList<Usuario> listaDeUsuarios;
    private ArrayList<RegistroDeIngreso> fichajesDeEmpleados;

    public ControlBiometrico(String nombreDelControlBiometrico) {
	setNombreDelControlBiometrico(nombreDelControlBiometrico);
	setListaDeUsuarios(new ArrayList<Usuario>());
	setFichajesDeEmpleados(new ArrayList<RegistroDeIngreso>(50000));
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
	if (elUsuarioTieneDatos(nuevoUsuario))
	    listaDeUsuarios.add(nuevoUsuario);
    }

    public Usuario buscarUsuario(Integer numeroDeUsuario) {
	return buscarEnLaListaDeUsuariosPor(numeroDeUsuario);
    }
    
    public void registrarUnNuevoIngreso(RegistroDeIngreso registroDeIngreso) {
	if (losDatosDelRegistroSonValidos(registroDeIngreso))
	    fichajesDeEmpleados.add(registroDeIngreso);
    }
    
    public Usuario obtenerAlGerenteConMayorSueldo() {
	Iterator<Usuario> iteradorDeLaLista = listaDeUsuarios.iterator();
	Usuario gerenteActual = obtenerAlPrimerGerenteEncontrado();

	while (iteradorDeLaLista.hasNext() && gerenteActual != null) {
	    Usuario auxiliar = iteradorDeLaLista.next();
	    if (auxiliar.getCategoriaDelUsuario().equals(TipoDeEmpleado.GERENTE))
		gerenteActual = gerenteActual.getSueldoDelEmpleado() < auxiliar.getSueldoDelEmpleado() ? auxiliar
			: gerenteActual;
	}

	return gerenteActual;
    }

    public ArrayList<RegistroDeIngreso> getFichajesDeEmpleados() {
	return fichajesDeEmpleados;
    }

    public void setFichajesDeEmpleados(ArrayList<RegistroDeIngreso> fichajesDeEmpleados) {
	this.fichajesDeEmpleados = fichajesDeEmpleados;
    }

    public String getNombreDelControlBiometrico() {
	return nombreDelControlBiometrico;
    }

    public void setNombreDelControlBiometrico(String nombreDelControlBiometrico) {
	this.nombreDelControlBiometrico = nombreDelControlBiometrico;
    }

    public ArrayList<Usuario> getListaDeUsuarios() {
	return listaDeUsuarios;
    }

    public void setListaDeUsuarios(ArrayList<Usuario> listaDeUsuarios) {
	this.listaDeUsuarios = listaDeUsuarios;
    }

    public Boolean hayUsuariosRegistrados() {
	return listaDeUsuarios.size() > 0;
    }

    public Boolean hayRegistrosDeIngresos() {
	return fichajesDeEmpleados.size() > 0;
    }

    private Boolean losDatosDelRegistroSonValidos(RegistroDeIngreso registroDeIngreso) {
	return (buscarEnLaListaDeUsuariosPor(registroDeIngreso.getNumeroDeUsuario()) != null)
		&& laFechaDeIngresoEsValida(registroDeIngreso.getMesDeIngreso(), registroDeIngreso.getDiaDeIngreso());
    }

    private Usuario buscarEnLaListaDeUsuariosPor(Integer numeroDeUsuario) {
	Iterator<Usuario> iteradorDeLaLista = listaDeUsuarios.iterator();
	while (iteradorDeLaLista.hasNext()) {
	    Usuario auxiliar = iteradorDeLaLista.next();
	    if (auxiliar.getNumeroDeUsuario().equals(numeroDeUsuario))
		return auxiliar;
	}

	return null;
    }

    private Boolean elUsuarioTieneDatos(Usuario aIngresar) {
	return elUsuarioTieneSueldo(aIngresar) && elUsuarioTieneNumero(aIngresar) && elUsuarioTieneApellido(aIngresar)
		&& elUsuarioTieneCategoria(aIngresar);
    }

    private Boolean elUsuarioTieneSueldo(Usuario aIngresar) {
	return aIngresar.getSueldoDelEmpleado() != null;
    }

    private Boolean elUsuarioTieneNumero(Usuario aIngresar) {
	return aIngresar.getNumeroDeUsuario() != null;
    }

    private Boolean elUsuarioTieneApellido(Usuario aIngresar) {
	return aIngresar.getApellido() != "";
    }

    private Boolean elUsuarioTieneCategoria(Usuario aIngresar) {
	return aIngresar.getCategoriaDelUsuario() != null;
    }
    
    private Boolean laFechaDeIngresoEsValida(Integer mes, Integer dia) {
	if(mes < 1 || mes > 12) return false;
	if(dia < 1 || dia > 31) return false;
	
	switch(mes) {
	case 2:
	    if(dia > 28) return false;
	    break;
	case 4:
	case 6:
	case 9:
	case 11:
	    if(dia > 30) return false;
	}
	
	return true;
    }

    private Usuario obtenerAlPrimerGerenteEncontrado() {
	Iterator<Usuario> iteradorDeLaLista = listaDeUsuarios.iterator();
	while (iteradorDeLaLista.hasNext()) {
	    Usuario auxiliar = iteradorDeLaLista.next();
	    if (auxiliar.getCategoriaDelUsuario().equals(TipoDeEmpleado.GERENTE))
		return auxiliar;
	}
	return null;
    }

}
