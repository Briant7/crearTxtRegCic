package com.oscar.txt.entity;

import java.io.Serializable;

public class Values implements Serializable {

	private static final long serialVersionUID = 1L;

	private String regiones;
	private String ciclos;

	private String ruta;

	public Values() {

	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getRegiones() {
		return regiones;
	}

	public void setRegiones(String regiones) {
		this.regiones = regiones;
	}

	public String getCiclos() {
		return ciclos;
	}

	public void setCiclos(String ciclos) {
		this.ciclos = ciclos;
	}

}
