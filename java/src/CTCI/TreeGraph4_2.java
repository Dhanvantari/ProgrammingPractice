package CTCI;

import java.io.IOException;
import java.util.LinkedList;
import CTCI.util.Node;
import CTCI.util.BTreePrinter;
//Given a sorted array with unique integer elements. write an algorithm to create a binary searck tree with minimum height

public class TreeGraph4_2 {
	public static void main(String[] args) throws IOException{
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		Node root=createTree(arr, 0, arr.length-1);
		BTreePrinter.printNode(root);
	}

	private static Node<Integer> createTree(int[] arr, int start, int end) {
		if(end<start) {
			return null;
		}
		
		int mid = (start+end)/2;
		Node<Integer> n = new Node<Integer>(arr[mid]);
		n.left=createTree(arr, start, mid-1);
		n.right=createTree(arr, mid+1, end);
		return n;
	}
}
/* Output:
            
       5               
      / \       
     /   \      
    /     \     
   /       \    
   2       8       
  / \     / \   
 /   \   /   \  
 1   3   6   9   
      \   \   \ 
      4   7   10 
                                

*/