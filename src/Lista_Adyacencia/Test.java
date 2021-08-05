package Lista_Adyacencia;

public class Test {
	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(1, 3, 5);
		g.addEdge(1, 2, 14);
		g.addEdge(0, 2, 10);
		g.addEdge(0, 5, 15);
		g.addEdge(2, 2, 10);
		g.addEdge(9, 3, 16);
		
		System.out.println(g);
		
		//vemos si el nodo/vertice 1 esta conectado al dos
		//resultado true
		
		System.out.println(g.isConnected(1, 2));
	}
}
