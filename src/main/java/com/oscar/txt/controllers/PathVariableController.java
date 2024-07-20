package com.oscar.txt.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oscar.txt.entity.Values;


@RestController
@RequestMapping("/api/var")
public class PathVariableController{

	@Value("${regiones}")
	private String regiones;

	@Value("${ciclos}")
	private String ciclos;

	@Value("${ruta.archivo}")
	private String ruta;

	@GetMapping("/archivo")
	public void archivo() {

		Values values = new Values();
		values.setRegiones(regiones);
		values.setCiclos(ciclos);

		String fileName = ruta + "file.txt";

		try {
			String separador = ",";
			String[] arregloRegiones = regiones.split(separador);
			String[] arregloCiclos = ciclos.split(separador);
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < arregloRegiones.length; i++) {
				list.add(arregloRegiones[i] + "-" + arregloCiclos[i]);
			}
			
		    System.out.println(" ");
			list.add(" ");	
			ArrayList<String> listHor = list;
			String listHori = listHor.toString().replaceAll("]", "");
			list.add(0, listHori.replaceAll("\\[", ""));

			list.add("");
			int contador = 8;
			for (int i = 0; i < arregloRegiones.length; i++) {
				list.add(arregloRegiones[contador] + "-" + arregloCiclos[contador]);
				--contador;
			}

			Path file = Paths.get(fileName);
			Files.write(file, list, StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Algo salio mal!");
			e.printStackTrace();
		}
	}
}
