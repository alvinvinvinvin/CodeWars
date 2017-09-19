/**
 * You are given an array strarr of strings and an integer k. 
 * Your task is to return the first longest string consisting of k consecutive strings taken in the array.

#Example: longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"

n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 */
package consecutiveStrings;
import java.util.*;
/**
 * @author e007777
 *
 */
public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
    	int n = strarr.length;
    	if(n == 0 || k > n || k<=0) return "";
    	int len = 0;
    	Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i<k;i++){
        	len += strarr[i].length();
        	q.add(i);
        }
        int start = 0;
        for(int i = k; i<n; i++){
        	int new_len = len - strarr[start].length() + strarr[i].length();
        	if(new_len> len){
        		q.remove();
        		q.add(i);
        		start = q.peek();
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int i:q){
        	sb.append(strarr[i]);
        }
        return sb.toString();
        
    }
}
