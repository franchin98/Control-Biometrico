package com.ar.unlam.objects;

public class Usuario {

    private Integer numeroDeUsuario;
    private String apellido;
    private TipoDeEmpleado categoriaDelUsuario;
    private Double sueldoDelEmpleado;

    public Usuario(Integer numeroDeUsuario, String apellido, TipoDeEmpleado categoriaDelUsuario,
	    Double sueldoDelEmpleado) {
	
	this.numeroDeUsuario = numeroDeUsuario;
	this.apellido = apellido;
	this.categoriaDelUsuario = categoriaDelUsuario;
	this.sueldoDelEmpleado = sueldoDelEmpleado;
    }

    public Usuario() {
	
    }

    public Integer getNumeroDeUsuario() {
        return numeroDeUsuario;
    }

    public void setNumeroDeUsuario(Integer numeroDeUsuario) {
        this.numeroDeUsuario = numeroDeUsuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDeEmpleado getCategoriaDelUsuario() {
        return categoriaDelUsuario;
    }

    public void setCategoriaDelUsuario(TipoDeEmpleado categoriaDelUsuario) {
        this.categoriaDelUsuario = categoriaDelUsuario;
    }

    public Double getSueldoDelEmpleado() {
        return sueldoDelEmpleado;
    }

    public void setSueldoDelEmpleado(Double sueldoDelEmpleado) {
        this.sueldoDelEmpleado = sueldoDelEmpleado;
    }
    
    

}
