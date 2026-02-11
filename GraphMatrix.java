//BFS USING ADJACENCY MATRIX REPRESENTATION 
import java.util.*;
class GraphMatrixBFS{
	int v;
	int [][]adj;
	GraphMatrixBFS(int v){
		this.v = v;
		adj = new int[v][v];
	}
	void addEdge(int u,int v){
		adj[u][v] = 1;	
		adj[v][u] = 1;
	}
	void BFS(int s){
		boolean []visited= new boolean[v];
		Queue<Integer>queue = new LinkedList<>();
		visited[s] = true;
		queue.add(s);
		while(!queue.isEmpty()){
			int node=queue.poll();
			System.out.print(node+"");
			for(int i =0;i<v;i++){
				if(adj[node][i] == 1 && !visited[i]){
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
	public static void main(String []args){
		GraphMatrixBFS g = new GraphMatrixBFS(9);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(2,4);
		g.addEdge(2,5);
		g.addEdge(3,6);
		g.addEdge(3,7);
		g.addEdge(4,8);
		g.addEdge(5,8);
		g.addEdge(6,8);
		g.addEdge(7,8);
		System.out.print("BFS starting from vertex 0:");
		g.BFS(0);
	}
}
