package com.ar.unlam.objects;

import java.util.ArrayList;
import java.util.Iterator;

public class ControlBiometrico {

    private String nombreDelControlBiometrico;
    private ArrayList<Usuario> listaDeUsuarios;

    public ControlBiometrico(String nombreDelControlBiometrico) {
	this.setNombreDelControlBiometrico(nombreDelControlBiometrico);
	setListaDeUsuarios(new ArrayList<Usuario>());
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
	if (elUsuarioTieneDatos(nuevoUsuario))
	    listaDeUsuarios.add(nuevoUsuario);

    }

    public Usuario buscarUsuario(Integer numeroDeUsuario) {
	return buscarEnLaListaDeUsuariosPor(numeroDeUsuario);
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
