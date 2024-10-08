package shreyanayak;
import java.util.*;

public class QuickSort {
	public static void quicksort(int arr[],int low, int high) {
		if(low<high) {
			int partitionIndex = partition(arr,low,high);
			quicksort(arr,low,partitionIndex-1);
			quicksort(arr,partitionIndex+1,high);
		}
	}
	public static int partition(int arr[], int low, int high) {
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}			
			}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array");
		int n=sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		quicksort(arr,0,arr.length-1);
		System.out.println("Array after sorting");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+ " ");
	}
		}



