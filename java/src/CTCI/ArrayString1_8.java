package CTCI;

import java.io.IOException;

//element in mxn matrix is zero then the row and column to zero
public class ArrayString1_8 {

	public static void main(String[] args) throws IOException {

		int mat[][] = { { 0, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print2D(mat);
		//zeroMatrix(mat);
		zeroMatrixWithoutSpaceComplexity(mat);
		print2D(mat);

	}

	private static boolean zeroMatrix(int[][] mat) {
		
		boolean row[]= new boolean[mat.length];
		boolean column[] = new boolean[mat[0].length];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if(mat[i][j]==0) {
					row[i]=true;
					column[j]=true;
				}
			}
		}	
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if(row[i] || column[j])
					mat[i][j] = 0;
 			}
		}
		
		return true;
	}
	
	private static boolean zeroMatrixWithoutSpaceComplexity(int[][] mat) {
		
		boolean firstRowHasZero = false;
		boolean firstColumnHasZero = false;
		
		for (int i = 0; i< mat.length; i++) {
			if(mat[i][0] == 0) {
				firstColumnHasZero =true;
				break;
			}
		}
		
		for (int i = 0; i< mat[0].length; i++) {
			if(mat[0][i] == 0) {
				firstRowHasZero =true;
				break;
			}
		}
		
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[i].length; j++) {
				if(mat[i][j]==0) {
					mat[i][0]=0;
					mat[0][j]=0;
				}
			}
		}	
		for (int i = 1; i< mat.length; i++) {
			if(mat[i][0]==0) {
				for(int j= 0; j< mat[0].length;j++) {
					mat[i][j]=0;
				}
			}
		}
		
		for (int i = 1; i< mat[0].length; i++) {
			if(mat[0][i]==0) {
				for(int j= 0; j< mat.length;j++) {
					mat[j][i]=0;
				}
			}
		}
		

		
		if(firstRowHasZero) {
			for(int j= 0; j< mat[0].length;j++) {
				mat[0][j]=0;
			}
		}
		
		if(firstColumnHasZero) {
			for(int j= 0; j< mat.length;j++) {
				mat[j][0]=0;
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
