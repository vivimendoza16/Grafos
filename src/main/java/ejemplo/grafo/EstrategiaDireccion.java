package ejemplo.grafo;

import java.util.List;

interface EstrategiaDireccionPeso {
	public void Arco(List<Nodo> nodos, String origen, String destino);
	public void addArco(List<Arco> arcos, Nodo nodoOrigen, Nodo nodoDestino);
	public void Arco(List<Nodo> nodos, String origen, String destino, int Peso);
	public void addArco(List<Arco> arcos, Nodo nodoOrigen, Nodo nodoDestino, int Peso);
}
