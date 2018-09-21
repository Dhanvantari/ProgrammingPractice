package CTCI;

import java.io.IOException;
//Write a method to replace all spaces in a string with ‘%20’.
public class ArrayString1_3 {

	public static void main(String[] args) throws IOException{
		char[] strArr = {'a', 'b', ' ','c' ,' ', ' '};
		System.out.println("Before URLify "+ new String(strArr));
		urlify(strArr, 4);
		System.out.println("After URLify 1: "+ new String(strArr));
	}

	private static void urlify(char[] strArr, int originalLen) {
		int spaceCount=0;
		for(int i=0; i<originalLen;i++) {
			if(strArr[i]==' ')
				spaceCount++;
		}
		
		int newIndex = originalLen + (2*spaceCount)-1;
		for(int i= originalLen-1; i>=0;i--) {
			if(strArr[i] == ' ') {
				strArr[newIndex--] = '0';
				strArr[newIndex--] = '2';
				strArr[newIndex--] = '%';
			}
			else {
				strArr[newIndex--] = strArr[i];
			}
		}
		
		System.out.println("After URLify 2: "+ new String(strArr));
	}
	

}
