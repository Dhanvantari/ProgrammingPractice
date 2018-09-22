package CTCI;

import java.io.IOException;

//Rotate nxn matrix clockwise
public class ArrayString1_7 {

	public static void main(String[] args) throws IOException {

		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print2D(mat);
		rotateClockwise(mat);
		print2D(mat);

	}

	private static boolean rotateClockwise(int[][] mat) {
		//Top: [layer][i]
		//Left: [n-1-i][layer]
		//Bottom: [n-1-layer][n-1-i]
		//right: [i][n-1-layer]
		
		if(mat.length == 0 && mat.length != mat[0].length) { //making sure its a square matrix
			return false;
		}
		int n= mat.length;
		for(int layer =0; layer<n/2; layer ++) { //go through all layers from outer most layer to inner layer 
			int start = layer;
			int end = n-1-layer;
			for(int i= start; i<end;i++) {
				int temp= mat[layer][i]; //temp <- top[i]
				mat[layer][i] = mat[n-1-i][layer]; //top[i] <- left[i]
				mat[n-1-i][layer]= mat[n-1-layer][n-1-i]; // left[i] <- bottom[i]
				mat[n-1-layer][n-1-i] = mat[i][n-1-layer]; //bottom[i] <- right[i]
				mat[i][n-1-layer] = temp;
			}
		}
		return true;
	}

	public static void print2D(int mat[][]) {
		System.out.println("\n****************************************\n");

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}
	
	
}
