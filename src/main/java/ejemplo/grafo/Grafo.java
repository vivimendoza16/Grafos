package ejemplo.grafo;

import properties.PropertyManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Grafo {

	List<Nodo> nodos = new ArrayList<>();
	
	public Grafo() { }
	
	public void addNodo(String nombre)
	{
		Nodo nodo = new Nodo();
		nodo.setNombre(nombre);
		nodos.add(nodo);
	}
	
	
}
