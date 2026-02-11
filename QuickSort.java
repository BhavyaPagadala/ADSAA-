//QUICK SORT USING JAVA
import java.util.*;
class QuickSort{
	static int[]a;
	static int partition(int low,int high){
		//taking the first element as the pivot
		int pivot = a[low];
		int i=low;
		int j=high;
		while(i <= j){
  			while(i<+high && a[i] <=pivot){
				i++;
			}
			while(a[j] > pivot){
				j--;
			}
			if(i<j){
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		//placing pivot in that position
		a[low] = a[j];
		a[j] = pivot;
		return j;
	}
	//QUICK SORT ALGORITHM
	static void quickSort(int low , int high){
		if(low < high){
			int j = partition(low,high);
			quickSort(low,j-1);
			quickSort(j+1,high);
		}
	}
	//MAIN METHOD
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of elements for sorting:");
		int n= sc.nextInt();
		a = new int[n];
		System.out.println("Enter the elements for sorting:");
		for(int i =0;i<n;i++){
			a[i]=sc.nextInt();
		}
		System.out.println("Elements Before sorting:");
		for(int i =0;i<n;i++){
			System.out.println(a[i]);
		}
		quickSort(0,a.length-1);
		System.out.println("Elements After sorting:");
		for(int i =0;i<n;i++){
			System.out.println(a[i]);
		}
	}
} 
