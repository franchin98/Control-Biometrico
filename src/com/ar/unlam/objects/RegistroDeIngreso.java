package com.ar.unlam.objects;

public class RegistroDeIngreso {
    private Integer numeroDeUsuario;
    private Integer diaDeIngreso;
    private Integer mesDeIngreso;
    
    
    public RegistroDeIngreso(Integer numeroDeUsuario, Integer mesDeIngreso, Integer diaDeIngreso) {
	this.numeroDeUsuario = numeroDeUsuario;
	this.diaDeIngreso = diaDeIngreso;
	this.mesDeIngreso = mesDeIngreso;
    }

    public Integer getNumeroDeUsuario() {
        return numeroDeUsuario;
    }

    public void setNumeroDeUsuario(Integer numeroDeUsuario) {
        this.numeroDeUsuario = numeroDeUsuario;
    }

    public Integer getDiaDeIngreso() {
        return diaDeIngreso;
    }

    public void setDiaDeIngreso(Integer diaDeIngreso) {
        this.diaDeIngreso = diaDeIngreso;
    }

    public Integer getMesDeIngreso() {
        return mesDeIngreso;
    }

    public void setMesDeIngreso(Integer mesDeIngreso) {
        this.mesDeIngreso = mesDeIngreso;
    }
    
    
    
    
}
