package BSF_DFS;
import java.util.*;

public class Graph {
	private LinkedList<Integer>adj[];
	
	public Graph(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
	
	public int bfs (int source, int destination) {
		
		boolean vis[] = new boolean[adj.length];
		int parent[] = new int [adj.length];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(source);
		parent[source]=-1;	
		vis[source]=true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur == destination) break;
			
			for(int neighbor: adj[cur]) {
				if(!vis[neighbor]) {
					vis[neighbor] = true;
					q.add(neighbor);
					parent[neighbor] = cur;
				}
			}
		}
		int cur = destination;
		int distance = 0;
		
		while ( parent[cur] != -1) {
			System.out.print(cur + "->");
			cur = parent[cur];
			distance++;
		}
		
		return distance;
	}
	
	private boolean dfsUtil(int source, int destination, boolean vis[]) {
		if (source == destination) return true;
		
		for(int neighbor: adj[source]) {
			if(!vis[neighbor]) {
				vis[neighbor] = true;
				boolean isConnected = dfsUtil(neighbor, destination, vis);
				if(isConnected) return true;	
			}
		}
		return false;
	}
	
	public boolean dfsStack(int source, int destination) {
		boolean vis[] = new boolean[adj.length];
		vis[source] = true;
		Stack<Integer> stack = new Stack<>();
		
		stack.push(source);
		
		while(!stack.isEmpty()) {
			int cur = stack.pop();
			
			if(cur == destination) return true;
			
			for(int neighbor: adj[cur]) {
				if(!vis[neighbor]) {
					vis[neighbor] = true;
					stack.push(neighbor);
				}
			}
		}
		
		return false;
	}
	
	public boolean dfs(int source, int destination) {
		boolean vis[] = new boolean [adj.length];
		vis[source] = true;
		
		return dfsUtil(source, destination, vis);
	}
}
