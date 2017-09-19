/**
 * Write a function, persistence, that takes in a positive parameter 
 * num and returns its multiplicative persistence, which is the number 
 * of times you must multiply the digits in num until you reach a single digit.

For example:

 persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
                      // and 4 has only one digit

 persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
                       // 1*2*6 = 12, and finally 1*2 = 2

 persistence(4) == 0 // because 4 is already a one-digit number
 */
package persistentBugger;

/**
 * @author e007777
 *
 */
public class Persist {
	
	public static int persistence(long n) {
		// your code
		int count = 0;
		if(n < 10) return count;
		return helper(n, count);
	}
	
	public static int helper(long n, int count){
		if(n < 10) return count;
		count++;
		long res = n%10;
		n /= 10;
		while(n>0){
			long d = n%10;
			res *= d;
			n /= 10;
		}
		
		return helper(res, count);
	}
}
