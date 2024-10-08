package shreyanayak;
import java.util.*;
class MergeSort{
	public static void mergesort(int arr[], int left, int right) {
		if(left<right)
		{
			int mid=left+(right-left)/2;
			mergesort(arr,left,mid);
			mergesort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	public static void merge(int arr[], int left, int mid, int right) {
		int n1=mid-left+1;
		int n2=right-mid;
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		for(int i=0;i<n1;i++)
			leftArray[i]=arr[left+i];
		for(int i=0;i<n2;i++)
			rightArray[i]=arr[mid+1+i];
		int i=0,j=0,k=left;
		while(i<n1&&j<n2) {
			if(leftArray[i]<rightArray[j])
				arr[k++]=leftArray[i++];
			else
				arr[k++]=rightArray[j++];
		}
		while(i<n1)
			arr[k++]=leftArray[i++];
		while(j<n2)
			arr[k++]=rightArray[j++];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array");
		int n=sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		mergesort(arr,0,arr.length-1);
		System.out.println("The array elements after sorting are");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+ " ");
	}
}