package ejemplo.grafo;

import java.util.List;

import properties.PropertyManager;

public class Ejemplo {

	public static void main(String[] args) {
		
		try {
			
			Grafo g = new Grafo();
			EstrategiaBusqueda buscar;
			if(PropertyManager.getProperty("DFS")) {
				buscar = new EstrategiaBusquedaDFS();
			}else {
				buscar = new EstrategiaBusquedaBFS();
			}
			
			EstrategiaDireccionPeso CreaArco;
			
			if(PropertyManager.getProperty("Direccion") && PropertyManager.getProperty("SinPeso")) {
					CreaArco = new EstrategiaDireccionDirigido();
			}
			else {
			
			if(PropertyManager.getProperty("Direccion") && PropertyManager.getProperty("ConPeso")) {
					CreaArco = new EstrategiaDireccionDirigidoPeso();
			}
			else {
				
			if(PropertyManager.getProperty("NoDirigido") && PropertyManager.getProperty("SinPeso")) {
					CreaArco = new EstrategiaDireccionNoDirigido();
			}else {
					CreaArco = new EstrategiaDireccionNoDirigidoPeso();
				}
			}}
			
			g.addNodo("A");
			g.addNodo("B");
			g.addNodo("C");
			
			CreaArco.Arco(g.nodos,"A", "B",2);
			CreaArco.Arco(g.nodos,"B", "C",4);
			CreaArco.Arco(g.nodos,"A", "C",1);

			List<Nodo> camino = buscar.buscarRuta(g.nodos,"A", "C");

			if (camino == null) {
				System.out.println("Camino A -> C no encontrado");
			} else {
				System.out.println("Camino A -> C encontrado");
				for (Nodo nodo: camino) {
					System.out.println(nodo.getNombre());
				}				
			}
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			
			Grafo g = new Grafo();
			EstrategiaBusqueda buscar;
			
			if(PropertyManager.getProperty("DFS")) {
				buscar = new EstrategiaBusquedaDFS();
			}else {
				buscar = new EstrategiaBusquedaBFS();
			}
			
			EstrategiaDireccionPeso CreaArco;
			
			if(PropertyManager.getProperty("Direccion") && PropertyManager.getProperty("SinPeso")) {
					CreaArco = new EstrategiaDireccionDirigido();
			}
			else {
			
			if(PropertyManager.getProperty("Direccion") && PropertyManager.getProperty("ConPeso")) {
					CreaArco = new EstrategiaDireccionDirigidoPeso();
			}
			else {
				
			if(PropertyManager.getProperty("NoDirigido") && PropertyManager.getProperty("SinPeso")) {
					CreaArco = new EstrategiaDireccionNoDirigido();
			}else {
					CreaArco = new EstrategiaDireccionNoDirigidoPeso();
				}
			}}
			
			g.addNodo("A");
			g.addNodo("B");
			g.addNodo("C");
			g.addNodo("D");
			g.addNodo("E");
			
			CreaArco.Arco(g.nodos,"A", "B",2);
			CreaArco.Arco(g.nodos,"B", "C",3);
			CreaArco.Arco(g.nodos,"C", "D",4);
			CreaArco.Arco(g.nodos,"E", "D",5);
			CreaArco.Arco(g.nodos,"A", "C",6);
			
			List<Nodo> camino = buscar.buscarRuta(g.nodos,"A", "E");
			
			if (camino == null) {
				System.out.println("Camino A -> E no encontrado");
			} else {
				System.out.println("Camino A -> E encontrado");
				for (Nodo nodo: camino) {
					System.out.println(nodo.getNombre());
				}				
			}
			System.out.println();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
