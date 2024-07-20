package com.oscar.txt.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oscar.txt.component.ValuesComponent;
import com.oscar.txt.entity.Values;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

	@Value("${regiones}")
	private String regiones;

	@Value("${ciclos}")
	private String ciclos;

	@Value("${ruta.archivo}")
	private String ruta;

	@Autowired
	private ValuesComponent valuesComponent;

	/**
	 * Metodo que recibe una peticion para generar un archivo txt.
	 * 
	 * @return
	 */
	@GetMapping("/archivo")
	public ResponseEntity<?> generarArchivoTxt() {

		Values values = new Values();
		values.setRegiones(regiones);
		values.setCiclos(ciclos);

		values.setRuta(ruta);

		String fileName = values.getRuta() + "file.txt";

		ArrayList<String> list = (ArrayList<String>) valuesComponent.obtenerLista(values);

		Path file = Paths.get(fileName);
		try {
			Files.write(file, list, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El archivo TXT se ha creado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
}
