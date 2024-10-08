package shreyanayak;

import java.util.Scanner;

public class kruskal {
    int parent[] = new int[10];
    int adjacency_matrix[][] = new int[10][10]; 
    int sum = 0; 
    int k = 0; 
    int n; 

    
    int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); 
        return parent[node];
    }

    
    void union(int i, int j) {
        parent[i] = j; 
    }

    void kruskal_algorithm(int adjacency_matrix[][], int n) {
        int u = 0, v = 0, min = Integer.MAX_VALUE;

        
        while (k < n - 1) {
            min = Integer.MAX_VALUE;

            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (adjacency_matrix[i][j] < min && i != j) {
                        min = adjacency_matrix[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            
            int parent_u = find(u);
            int parent_v = find(v);

            
            if (parent_u != parent_v) {
                union(parent_u, parent_v);
                System.out.println("(" + u + "," + v + ") = " + adjacency_matrix[u][v]);
                sum += adjacency_matrix[u][v];
                k++;
            }

            
            adjacency_matrix[u][v] = adjacency_matrix[v][u] = Integer.MAX_VALUE;
        }

        System.out.println("The cost of the minimum spanning tree = " + sum);
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        kruskal k = new kruskal(); 

        System.out.println("Enter the number of vertices of the graph:");
        k.num_vertices = sc.nextInt(); 

        System.out.println("Enter the weighted adjacency matrix:");
        for (int i = 1; i <= k.num_vertices; i++) {
            for (int j = 1; j <= k.num_vertices; j++) {
                k.adjacency_matrix[i][j] = sc.nextInt(); 
            }
        }
        k.kruskal_algorithm(k.adjacency_matrix, k.num_vertices);

        sc.close(); 
    }
}