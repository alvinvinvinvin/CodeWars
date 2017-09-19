/**
 * The goal of this exercise is to convert a string to a new string where each character 
 * in the new string is '(' if that character appears only once in the original string, 
 * or ')' if that character appears more than once in the original string. 
 * Ignore capitalization when determining if a character is a duplicate.

Examples:

"din" => "((("

"recede" => "()()()"

"Success" => ")())())"

"(( @" => "))(("


Notes:

There is a flaw in the JS version, that may occur in the random tests. 
Do not hesitate to do several attempts before modifying your code if you fail there. 

Assertion messages may be unclear about what they display in some languages. 
If you read "...It Should encode XXX", the "XXX" is actually the expected result, 
not the input! (these languages are locked so that's not possible to correct it).
 */
package duplicateEncoder;

/**
 * @author e007777
 *
 */
public class DuplicateEncoder {
	static String encode(String word){
		word = word.toUpperCase();
	    //ASCII 32 - 126
		int[] map = new int[127];
		for(int i = 0; i<word.length();i++){
			map[word.charAt(i)]++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<word.length();i++){
			if(map[word.charAt(i)] > 1){
				sb.append(")");
			}else{
				sb.append("(");
			}
		}
		return sb.toString();
	}
}