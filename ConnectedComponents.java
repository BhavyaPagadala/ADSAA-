//program to implement the biconnected components using dfs
import java.util.*;
class ConnectedComponents{
	int [] [] adj;
	int v;
	boolean [] visited;
	ConnectedComponents(int v){
		this.v=v;
		adj=new int[v][v];
		visited = new boolean[v];
	}
	void dfs(int i){
		visited[i]=true;
		System.out.print(i+" ");
		for(int j=0;j<v;j++){
			if((adj[i][j] ==1)&&!visited[j]){
				dfs(j);
			}
		}
	}
	void findConnectedComponents(){
		int count =0;
		for(int i=0;i<v;i++){
			if(!visited[i]){
				count++;
				System.out.print("components:"+count+":");
				dfs(i);
				System.out.println();
			}
		}
	}
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices:");
		int v= sc.nextInt();
		ConnectedComponents graph = new ConnectedComponents(v);
		System.out.println("Enter the adjacency matrix:");
		for(int i=0;i<v;i++){
			for(int j=0;j<v;j++){
				graph.adj[i][j]=sc.nextInt();
			}
		}
		graph.findConnectedComponents();
	}
}
