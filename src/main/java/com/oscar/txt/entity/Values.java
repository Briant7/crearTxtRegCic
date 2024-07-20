package com.oscar.txt.entity;

import java.io.Serializable;

public class Values implements Serializable {

	private String regiones;
	private String ciclos;

	public Values() {

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
