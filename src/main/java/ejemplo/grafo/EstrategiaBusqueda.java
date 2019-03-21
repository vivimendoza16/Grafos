package ejemplo.grafo;

import java.util.List;

interface EstrategiaBusqueda {
	
public List<Nodo> buscarRuta(List <Nodo> nodos, String origen, String destino) throws Exception;
public Nodo buscarNodo(List <Nodo> nodos, String nombre);

}