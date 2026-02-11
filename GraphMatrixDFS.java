//DFS USING THE ADJACENCY LIST
import java.util.*;
class GraphMatrixDFS{
	int v;
	int [][]adj;
	
	//Constructor
	GraphMatrixDFS(int v){
		this.v = v;
		adj = new int[v][v];
	}
	//adding edged
	void addEdge(int u,int w){
		adj[u][w] = 1;	
		adj[w][u] = 1;
	}
	
	//DFS logic
	
	void DFSUtil(int node , int []visited){
		visited[node]=1;
		System.out.print(node +"");
		for(int i=0;i<v;i++){
			if(adj[node][i] ==1 && visited[i]==0){
				DFSUtil(i,visited);
			}
		}
	}
	
	void DFS(int start){
		int []visited= new int[v];
		DFSUtil(start,visited);
		System.out.println();
	}
	public static void main(String []args){
		GraphMatrixDFS g = new GraphMatrixDFS(9);
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
		System.out.print("DFS starting from vertex 0:");
		g.DFS(0);
	}
}
