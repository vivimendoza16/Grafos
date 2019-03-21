package ejemplo.grafo;

import java.util.ArrayList;
import java.util.List;

import properties.PropertyManager;

public class EstrategiaDireccionNoDirigido implements EstrategiaDireccionPeso {


	EstrategiaBusqueda buscar;	
	EstrategiaDireccionPeso dirigir;
	List<Arco> arcos = new ArrayList<>();
	
	public void Arco(List<Nodo> nodos, String origen, String destino) {
		
		if(PropertyManager.getProperty("Direccion") && PropertyManager.getProperty("SinPeso")) {
			dirigir = new EstrategiaDireccionDirigido();
			}
		else {
		if(PropertyManager.getProperty("Direccion") && PropertyManager.getProperty("ConPeso")){
			dirigir = new EstrategiaDireccionDirigidoPeso();
			}
		else {
		if(PropertyManager.getProperty("NoDirigido") && PropertyManager.getProperty("ConPeso")){
			dirigir = new EstrategiaDireccionNoDirigidoPeso();
			}
		else {
			dirigir = new EstrategiaDireccionNoDirigido();
			}		
		}}
		
		if(PropertyManager.getProperty("DFS")) {
			buscar = new EstrategiaBusquedaDFS();
		}else {
			buscar = new EstrategiaBusquedaBFS();
		}
		Nodo nodoOrigen = buscar.buscarNodo(nodos, origen);
		Nodo nodoDestino = buscar.buscarNodo(nodos, destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		dirigir.addArco(arcos, nodoOrigen, nodoDestino);
	}
	
      public void Arco(List<Nodo> nodos, String origen, String destino, int Peso) {
		
		if(PropertyManager.getProperty("Direccion")) {
			if(PropertyManager.getProperty("SinPeso")) {
			dirigir = new EstrategiaDireccionDirigido();}
			else {
			dirigir = new EstrategiaDireccionNoDirigido();
			}
		}else {
			if(PropertyManager.getProperty("ConPeso")){
			dirigir = new EstrategiaDireccionDirigidoPeso();}
			else {
			dirigir = new EstrategiaDireccionNoDirigidoPeso();
			}
		}
		if(PropertyManager.getProperty("DFS")) {
			buscar = new EstrategiaBusquedaDFS();
		}else {
			buscar = new EstrategiaBusquedaBFS();
		}
		Nodo nodoOrigen = buscar.buscarNodo(nodos, origen);
		Nodo nodoDestino = buscar.buscarNodo(nodos, destino);
		
		// Origen o destino no encontrado
		if (nodoOrigen == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		if (nodoDestino == null) {
			throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
		}
		
		dirigir.addArco(arcos, nodoOrigen, nodoDestino);
	}
	
	
	public void addArco(List<Arco> arcos, Nodo nodoOrigen, Nodo nodoDestino)
	{
		Arco arco = new Arco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
		
		arco = new Arco();
		arco.setOrigen(nodoDestino);
		arco.setDestino(nodoOrigen);
		arcos.add(arco);
		nodoDestino.agregarArco(arco);
	}
	public void addArco(List<Arco> arcos, Nodo nodoOrigen, Nodo nodoDestino, int Peso)
	{
	  Arco arco = new Arco();
		arco.setOrigen(nodoOrigen);
		arco.setDestino(nodoDestino);
		arcos.add(arco);
		nodoOrigen.agregarArco(arco);
		
		arco = new Arco();
		arco.setOrigen(nodoDestino);
		arco.setDestino(nodoOrigen);
		arcos.add(arco);
		nodoDestino.agregarArco(arco);
	}
}
