package cn.linadan.programming_language.exam1.exam1_2.recursion_and_iteration;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
	static node[] st = new node[10000];
	public static void main(String[] args) {
		Random random = new Random();
		System.out.print("输入数组长度:");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int array[] = new int[n];
		int array2[] = new int[n];
		for(int i = 0;i < n;i++){
			array[i] = random.nextInt(n*3);
			array2[i] = array[i];
		}
		for(int i = 0;i < 10000; i++)
			st[i] = new node();
		display(array);
		long start=System.nanoTime();   
		QuickSortRecursion (array, 0, n-1 ) ;
	    long end=System.nanoTime();   
		System.out.println("快排递归运行时间： "+(end-start)/1000000.0+"ms");
		display(array);
		display(array2);
		start=System.nanoTime();   
		QuickSortIteration (array2, 0, n-1 ) ;
	    end=System.nanoTime();   
		System.out.println("快排迭代运行时间： "+(end-start)/1000000.0+"ms");
		display(array2);
		
	}
	static int split(int data[],int low,int high)  
	{  
	    int i=low;  
	    int x=data[low];  
	    int tmp;  
	    for(int j=low+1;j<=high;j++)  
	    {  
	        if(data[j]<x)  
	        {   i++;  
	            if(i!=j)   
	            {  
	                tmp=data[j];  
	                data[j]=data[i];  
	                data[i]=tmp;  
	            }  
	        }  
	    }  
	    tmp=data[low];  
	    data[low]=data[i];  
	    data[i]=tmp;  
	    return i;  
	}  
	static void QuickSortRecursion(int data[],int low,int high){
	   
		 if(low<high)  
		 {  
		        int w=split(data,low,high);  
		        QuickSortRecursion(data,low,w-1);  
		        QuickSortRecursion(data,w+1,high);  
		 }  
	       
	}
	static void QuickSortIteration(int data[],int s,int t)  
	{  
	    int top=-1,low,high;  
	    top++;  
	    st[top].low=s;
	    st[top].high=t;  
	    while(top>-1)  
	    {  
	        low=st[top].low;
	        high=st[top].high;  
	        top--;  
	        int w;  
	        if(low<high)  
	        {  
	            w=split(data,low,high);
	            st[++top].low=low;
	            st[top].high=w-1;  
	            st[++top].low=w+1;
	            st[top].high=high;  
	        }  
	    }  
	}  
	static void display(int data[])
	{
		for(int i = 0;i < data.length;i++)
			System.out.print(data[i]+" ");
		System.out.println();
	}
	
}
class node  
{ 
	int low,high;  
} 
