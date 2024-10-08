package shreyanayak;
import java.util.*;
public class topologicalsort {
	int V;
	List<Integer>[] adjlist;
	topologicalsort(int v){
		V=v;
		adjlist = new LinkedList[v];
		for(int i=0;i<v;i++)
			adjlist[i]=new LinkedList<>();
	}
	void addEdge(int v, int w)
	{
		adjlist[v].add(w);
	}
	void topoutil(int v, boolean visited[], Stack stack)
	{
		visited[v]=true;
		for(Integer neighbour: adjlist[v])
		{
			if(!visited[neighbour])
				topoutil(neighbour, visited, stack);
		}
		stack.push(v);
	}
	void toposort() {
		Stack stack = new Stack<>();
		boolean[] visited=new boolean[V];
		Arrays.fill(visited, false);
		for (int i = 0; i < V; ++i) { 
			if (!visited[i]) topoutil(i, visited, stack); 
			}
			System.out.println("Topological Sort:");
			while (!stack.isEmpty()) 
			System.out.print(stack.pop() + " "); 
			}
	public static void main(String args[]) { 
		Scanner scanner = new Scanner(System.in); 
		System.out.print("Enter the number of vertices: ");
		int V = scanner.nextInt();
		topologicalsort g = new topologicalsort(V);
		System.out.println("Enter the adjacency matrix:"); 
		for (int i = 0; i < V; i++) { for (int j = 0; j < V; j++) {
		if (scanner.nextInt() == 1) { 
		g.addEdge(i, j);
		}
		}
		}
		g.toposort(); 
		scanner.close();
		}
	}

