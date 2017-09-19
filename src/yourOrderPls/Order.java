/**
 * 
 */
package yourOrderPls;
import java.util.*;
import java.util.stream.Collectors;
/**
 * @author e007777
 *
 */
public class Order {
	public static String order(String words) {
	    // ...
		if(words.isEmpty()) return words;
	    String[] temp = words.split(" ");
	    int len = temp.length;
	    String[] res = new String[len];
	    for(int i = 0; i<len; i++){
	      String s1 = temp[i];
	      int s2 = Integer.parseInt(s1.replaceAll("\\D+", ""));
	      int n = s2 - 1;
	      res[n] = temp[i];
	    }
	    String joined = String.join(" ", res);
	    return joined;
	 }
	
	public static String order2(String words){
		return Arrays.stream(words.split(" ")).sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D+","")))).collect(Collectors.joining(" "));
	}
}
