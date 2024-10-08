package shreyanayak;
import java.util.*;
public class warshall {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		int vertices = sc.nextInt();
		int[][] graph= new int[vertices][vertices];
		System.out.println("Enter the values:");
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				graph[i][j]=sc.nextInt();
			}
		}
		for(int k=0;k<vertices;k++)
		{
			for(int i=0;i<vertices;i++)
			{
				for(int j=0;j<vertices;j++)
				{
					graph[i][j]=graph[i][j]|(graph[i][k]&graph[k][j]);
				}
			}
		}
		System.out.println("Printing");
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
}
