
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		System.out.println("How many integers are in the array?");
		Scanner console_input=new Scanner(System.in);
		int num_ints=console_input.nextInt();
		
		System.out.println(num_ints);
		Random random_ints = new Random();
		Set<Integer> numSet1 = new HashSet<Integer>();

		Set<Integer> numSet2 = new HashSet<Integer>();
		
		
		try {
			while (numSet1.size() < num_ints){
				numSet1.add(random_ints.nextInt(num_ints*2));
				
			}
			
		} catch (Exception e) {}
		Integer[] a1st = numSet1.toArray(new Integer[numSet1.size()]);
		
		try {
			while (numSet2.size() < num_ints){
				numSet2.add(random_ints.nextInt(num_ints*2));
				
			}
			
		} catch (Exception e) {}
		Integer[] amid = numSet1.toArray(new Integer[numSet2.size()]);
		Collections.shuffle(Arrays.asList(a1st));
		Collections.shuffle(Arrays.asList(amid));
		
		System.out.print(Arrays.toString(a1st));
		
		
		System.out.println();
		//System.out.println(pivotMid(a,0,a.length-1));
		//pivot1st(amid,0,amid.length-1);
		quickSort1st(a1st);
		System.out.print(a1st[0]);
		for (int i =1; i < a1st.length;i++) {
			System.out.print(", "+a1st[i]);
		}
		
		System.out.println();
		//System.out.println(pivotMid(a,0,a.length-1));
		//pivot1st(amid,0,amid.length-1);
		quickSort1st(a1st);
		System.out.print(a1st[0]);
		for (int i =1; i < a1st.length;i++) {
			System.out.print(", "+a1st[i]);
		}
		
 	}
	public static int pivot1st(Integer[] a, int l, int r) {
		System.out.println(l+" "+r);
		int i, j, p;
		p=a[l];
		i=l-1;
		j=r+1;
		System.out.println(p + " "+ i +" "+j);
		do {
			do {
				i++;
			} while(a[i]<p);
			//System.out.println(i);
			do {
				j--;
			} while(a[j]>p);
			
			swap(a, i, j);
		} while (i<j);
		swap(a,i,j); //undo last swap.
		swap(a,l,j); //pivot resides on index j.
		
		return j;
	}

	public static int pivotMid(Integer[] a, int l, int r) {
		int middle_element=a[((l+r)/2)];
		int i, j, p;
		p=middle_element;
		i=l-1;
		j=r+1;
		do {
			do {
				i++;
			} while(a[i]<p);
			
			do {
				j--;
			} while(a[j]>p);
			swap(a, i, j);
		} while (i<j);
		swap(a,i,j); //undo last swap.
		swap(a,l,j); //pivot resides on index j.
		
		return j;
		}
	
	public static void swap(Integer[] amid, int i, int j) {
		int temp = amid[i];
		amid[i]=amid[j];
		amid[j]=temp;
	}
	
	/*public static int partition(Integer[] arr, int low, int high)
	{
	    int pivot = arr[low];
	    int i = low - 1, j = high + 1;
	  
	    while (true)
	    {
	        // Find leftmost element greater than
	        // or equal to pivot
	        do
	        {
	            i++;
	        } while (arr[i] < pivot);
	  
	        // Find rightmost element smaller than
	        // or equal to pivot
	        do
	        {
	            j--;
	        } while (arr[j] > pivot);
	  
	        // If two pointers met.
	        if (i >= j)
	            return j;
	  
	        swap(arr, i, j);
	    }
	}*/
	public static void quickSort1st(Integer[] a, int l, int r) {
		if (l<r) {
			
			int p = pivot1st(a,l,r);
			quickSort1st(a,l,p-1);
			quickSort1st(a, p+1,r);
		}
	}
	public static void quickSort1st(Integer[] a) {
		quickSort1st(a, 0, a.length-1);
	}
	public static void quickSortMid(Integer[] a, int l, int r) {
		if(r>l) {
			int p = pivotMid(a,l,r);
			quickSortMid(a,l,p-1);
			quickSortMid(a,p+1,r);
		}
	}
	public static void quickSortMid(Integer[] a) {
		quickSortMid(a, 0, a.length-1);
	}
}
