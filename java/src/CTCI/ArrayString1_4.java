package CTCI;

public class ArrayString1_4 {

	//Palindrome permutation
	public static void main(String[] args) {
		String s= "Tact coa";
		s= s.toLowerCase();
		System.out.println(isPalindromePermutation(s));
			
		
	}

	private static boolean isPalindromePermutation(String s) {
		
		int table[]=createHashtableWithCharCount(s);
		return isCountOfOddMaxOne(table);
	}

	private static boolean isCountOfOddMaxOne(int[] table) {
		boolean isOdd = false;
		for(int i:table) {
			if(i%2==1) {
				if(isOdd) 
					return false;
				isOdd =true;
			}
		}
		return true;
	}

	private static int[] createHashtableWithCharCount(String s) {
		int table[]= new int[26];
		int aNumeric = Character.getNumericValue('a');
		int zNumeric = Character.getNumericValue('z');
		
		for(char n: s.toCharArray()) {
			int nNumeric= Character.getNumericValue(n);
			if(nNumeric>=aNumeric && nNumeric<=zNumeric )
				table[nNumeric-aNumeric]++;
		}
		return table;
	}

}
