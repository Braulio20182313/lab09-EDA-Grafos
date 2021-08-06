package Dijkstra;

import java.util.ArrayList;

public class Graph {
	private Node[] nodes;
	private int noOfNodes;
	private Edge[] edges;
	private int noOfEdges;
	
	public Graph(Node[] nodes) {
		this.nodes = nodes;
		
		//crear todos los nodos listos para ser actualizados con los bordes
		
		this.noOfNodes = calculateNoOfNodes(edges);
		this.nodes = new Node[this.noOfNodes];
		
		for (int n = 0; n < this.noOfNodes; n++) {
			this.nodes[n] = new Node();
		}
		
		//agrega todos los bordes a los nodos, cada borde agregado a dos nodos (hacia y desde)
		
		this.noOfEdges = edges.length;
		
		for(int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
			this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
			this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
		}
	}
	
	private int calculateNoOfNodes(Edge[]edges) {
		int noOfNodes=0;
		
		for(Edge e: edges) {
			if(e.getToNodeIndex() > noOfNodes)
				noOfNodes = e.getToNodeIndex();
			if(e.getFromNodeIndex() > noOfNodes)
				noOfNodes = e.getFromNodeIndex();
		}
		noOfNodes++;
		
		return noOfNodes;
	}

	public void calculateShortestDistance() {
		//Nodo en 0 como inicio
		this.nodes[0].setDistanceFromSource(0);
		int nextNode = 0;
		
		//visita cada nodo
		for (int i = 0; i < this.nodes.length; i++) {
			//bucle alrededor de los bordes del nodo actual
			ArrayList<Edge> currentNodesEdges = this.nodes[nextNode].getEdges();
			
			for (int joinedEdge = 0; joinedEdge < currentNodesEdges.size(); joinedEdge++) {
				int neighbourIndex = this.nodes[nextNode].getDistanceFromSource()+currentNodesEdges.get(joinedEdge).getLength();
				
				//Solo si no se visita
				if (!this.nodes[neighbourIndex].isVisited()) {
					int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodesEdges.get(joinedEdge).getLength();
					
					if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
						nodes[neighbourIndex].setDistanceFromSource(tentative);
					}
				}
			}
			//nodos visitados?
			nodes[nextNode].setVisited(true);
			
			//el siguiente nodo debe estar con la distancia más corta
			nextNode = getNodeShortesDistanced();
		}
	}
	
	private int getNodeShortesDistanced() {
		int storedNodeIndex = 0;
		int storedDist = Integer.MAX_VALUE;
		
		for (int i = 0; i < this.nodes.length; i++) {
			int currentDist = this.nodes[i].getDistanceFromSource();
			
			if(!this.nodes[i].isVisited() && currentDist < storedDist) {
				storedDist = currentDist;
				storedNodeIndex = i;
			}
		}
		
		return storedNodeIndex;
	}
	
	public void printResult() {
		String output = "Numero de nodos = " + this.noOfNodes;
		output += "\n Numero de aristas = " + this.noOfEdges;
		
		for (int i = 0; i < this.nodes.length; i++) {
			output += ("\nLa distancia mascorta del nodo 0 al nodo " + i + "es" + nodes[i].getDistanceFromSource());
		}
		
		System.out.println(output);
		
	}
	public Node[] getNodes() {
		return nodes;
	}

	public int getNoOfNodes() {
		return noOfNodes;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public int getNoOfEdges() {
		return noOfEdges;
	}


	
}
