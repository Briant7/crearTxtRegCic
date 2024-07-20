package com.oscar.txt.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.oscar.txt.entity.Values;

@Component
public class ValuesComponent {

	/**
	 * Metodo que se ocupa para obtener una lista con las regiones y ciclos
	 * ordenadas ascendente y descendente.
	 * @param values
	 * @return
	 */
	public List<String> obtenerLista(Values values) {
		ArrayList<String> list = new ArrayList<String>();

		try {
			String separador = ",";
			String[] arregloRegiones = values.getRegiones().split(separador);
			String[] arregloCiclos = values.getCiclos().split(separador);
			for (int i = 0; i < arregloRegiones.length; i++) {
				list.add(arregloRegiones[i] + "-" + arregloCiclos[i]);
			}

			ArrayList<String> listHor = list;
			String listHori = listHor.toString().replaceAll("]", "");
			list.add(0, listHori.replaceAll("\\[", ""));

			list.add(1, "");
			list.add("");
			int contador = 8;
			for (int i = 0; i < arregloRegiones.length; i++) {
				list.add(arregloRegiones[contador] + "-" + arregloCiclos[contador]);
				--contador;

			}
		} catch (Exception e) {
			System.out.println("Algo salio mal!");
			e.printStackTrace();
		}
		return list;
	}
}
