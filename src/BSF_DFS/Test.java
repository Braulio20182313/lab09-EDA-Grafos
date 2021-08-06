package BSF_DFS;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ingresar numero de vertices y aristas");
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Graph graph = new Graph(v);
		System.out.println("ingresar "+e+" aristas");
		
		for (int i = 0; i<e; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			
			graph.addEdge(source, destination);
		}
		
		System.out.println("Ingresa origen y destino: ");
		int source = sc.nextInt();
		int destination = sc.nextInt();
		
//		int distance = graph.bfs(source, destination);
//		System.out.println("Distancia minima es: " + distance);
		
		System.out.println("Posible ->" + graph.dfs(source, destination));
		sc.close();
	}
}
	