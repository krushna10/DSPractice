import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaysOfDecodingEncodedMessage {
	//Recursive method to calculate the decoding ways
	public static int calcCountDecodingWays(char[] data, int k, int[] cache){
		int result = 1;
		if(k == 0) 
			return 1;
		int s = data.length - k - 1;
		if(data[s] == '0') 
			return 0;
		if(cache[k] != -1){
			return cache[k];
		}
		//else{
		System.out.println("result1 --> "+result);
		result += calcCountDecodingWays(data, k-1, cache); //This call is for every sub string with first/single digit
		String doubleDigit = new String(data, s, 2);

		if(k >= 2 && (Integer.parseInt(doubleDigit) <= 26) && (k < data.length - 1)){//This call is for every substring with first two digits iff sub string val <= 26
			result += calcCountDecodingWays(data, k-2, cache);
		}
		
		cache[k - 1] = result;//saving calculated count for each sub string
		return result;
	}

	public static  int countDecodingWays(String encdMsg, int k){
		int count = 0;
		int cache[] = new int[encdMsg.length()+1]; // To store and reuse the already calculated count, required for inputs like 11111 to reduce time complexity in recursion
		for(int i = 0; i < cache.length - 1; i++)
			cache[i] = -1;
		count = calcCountDecodingWays(encdMsg.toCharArray(), encdMsg.length() - 1, cache);
		return count;
	}

	public static void main(String args[]) throws IOException{
		int waysOfDecode = 0;
		int k = 1;
		//"123", abc --> 123(abc), 1 & 23(a,w), 12 & 3(l,c), 
		//"2613";bfac --> 2613, 26 & 13(bfac, zm) 
		//"1111"; aaaa ---> 1111(aaaa), 11 & 11(kk), 1 & 1 & 11(aak), 11, 1 & 1(kaa), 1, 11 & 1(aka), 
		InputStreamReader r=new InputStreamReader(System.in);  
		BufferedReader br=new BufferedReader(r);  

		System.out.print("Enter your encoded message (allowed digits 1 to 9):"); 
		String encdMsg = br.readLine(); 

		waysOfDecode = countDecodingWays(encdMsg, k);
		System.out.println("No of ways to decode "+encdMsg +" is :: "+waysOfDecode);
	}
}
