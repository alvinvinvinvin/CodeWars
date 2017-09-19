/**
 * This time no story, no theory. 
 * The examples below show you how to write function accum:

Examples:

Accumul.accum("abcd");    // "A-Bb-Ccc-Dddd"
Accumul.accum("RqaEzty"); // "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
Accumul.accum("cwAt");    // "C-Ww-Aaa-Tttt"
The parameter of accum is a string which includes only letters from a..z and A..Z.
 */
package mumbling;

import java.util.Arrays;

/**
 * @author e007777
 *
 */
public class Accumul {
    public static String accum(String s) {
        // your code
    	char[] c_a = s.toCharArray();
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0 ; i< c_a.length;i++){
    		char[] c_t_a = new char[i+1];
    		char c = c_a[i];
    		c_t_a[0] = Character.toUpperCase(c);
    		if(i != 0){ 
    			Arrays.fill(c_t_a, 1,i+1,Character.toLowerCase(c));
    		}
    		sb.append(new String(c_t_a));
    		sb.append(i==c_a.length-1?"":"-");
    	}
    	return sb.toString();
    }
}
