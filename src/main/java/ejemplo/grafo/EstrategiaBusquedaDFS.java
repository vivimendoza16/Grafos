package ejemplo.grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import ejemplo.grafo.Nodo;

public class EstrategiaBusquedaDFS implements EstrategiaBusqueda{

@Override
public List<Nodo> buscarRuta(List<Nodo> nodos, String origen, String destino) throws Exception {
	Nodo nodoOrigen = buscarNodo(nodos, origen);
	Nodo nodoDestino = buscarNodo(nodos, destino);
	List<Nodo> nodosRuta = new ArrayList<>();
	
	// Origen o destino no encontrado
	if (nodoOrigen == null) {
		throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
	}
	if (nodoDestino == null) {
		throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
	}
	
	if (buscarRutaDFS(nodosRuta, nodoOrigen, nodoDestino)) {
		return nodosRuta;
	} else {
		return null;
	}
}

private boolean buscarRutaDFS(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {
	
	// agrega el origen
    nodosRuta.add(nodoOrigen);
	
	// origen y destino son el mismo ?
	if(nodoOrigen.getNombre().equals(nodoDestino.getNombre())){
        return true;
    }
	
	// si no son el mismo, revise las rutas usando una pila
    Stack<Nodo> pilaDeNodos = new Stack<>();
    ArrayList<Nodo> nodosVisitados = new ArrayList<>();

    pilaDeNodos.add(nodoOrigen);

    while(!pilaDeNodos.isEmpty()){
        Nodo actual = pilaDeNodos.pop();

        // ignore los nodos ya visitados
        if (nodosVisitados.contains(actual))
        	continue;
        
        // es el nodo que estamos buscando ?
        if (actual.equals(nodoDestino)) {
        	nodosRuta.addAll(pilaDeNodos);
        	nodosRuta.add(nodoDestino);
            return true;
        }
        else {
            // siga buscando en las rutas no visitadas
        	nodosVisitados.add(actual);
        	for(Nodo nodo: actual.getNodosAdyacentes()) {
        		if (!pilaDeNodos.contains(nodo))
        			pilaDeNodos.add(nodo);
        	}
        }
    }
    return false;
    
}

public Nodo buscarNodo(List <Nodo> nodos, String nombre) 
{
	for (Nodo nodo: nodos) {
		if (nodo.getNombre().equals(nombre)) {
			return nodo;
		}
	}
	return null;
}
	
	
}
