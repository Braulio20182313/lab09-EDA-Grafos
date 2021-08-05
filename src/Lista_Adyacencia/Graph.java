package Lista_Adyacencia;
import java.util.*;
public class Graph {
	class Edge {
		int v, w;
		public Edge (int v, int w) {
			this.v=v;
			this.w=w;
		}
		public String toString() {
			return "("+v+","+w+")";
		}	
	}
	
	List<Edge>G[];
	public Graph(int n) {
		G=new LinkedList[n];
		for(int i=0; i<G.length;i++)
			G[i]=new LinkedList<Edge>();
	}
	
	//Metodo complemetario para saber si el nodo x esta 
	//conectado con el nodo y
	
	boolean isConnected(int u, int v) {
		for(Edge i: G[u])
			if (i.v==v) return true;
		return false;
	}
	
	void addEdge(int u,int v,int w) {
		G[u].add(0,new Edge(v,w));
	}
	
	public String toString() {
		String result="";
		for (int i = 0; i < G.length; i++) 
			result+=i+"=>"+G[i]+"\n";
		return result;
	}
}
