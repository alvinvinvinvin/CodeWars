/**
 * 
 */
package decodeTheMorseCode;

import java.util.*;

/**
 * @author e007777
 *
 */
public class MorseCodeDecoder {
	public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
        morseCode.trim();
        StringBuilder sb_c = new StringBuilder();
        StringBuilder sb_w = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i =0; i<morseCode.length();i++){
        	char c = morseCode.charAt(i);
            if(c != ' '){
                sb_c.append(c);
                if(i==morseCode.length()-1){
        		    String charactor = MorseCode.get(sb_c.toString());
        		    sb_w.append(charactor);
        		    res.append(sb_w.toString());
                }
            }
            else{
    		    String charactor = MorseCode.get(sb_c.toString());
    		    sb_w.append(charactor);
    		    sb_c.setLength(0);
        	    if(morseCode.charAt(i+1) == ' '){
        			  res.append(sb_w.toString());
        			  res.append(i==morseCode.length()-1?"":" ");
        		}
        	}
        }
        return res.toString().toUpperCase();
    }
}
	
class MorseCode{
	static String[] english = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", 
            "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?" , " " };

  static String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
          ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
          "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
          "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
          "-----", "--..--", ".-.-.-", "..--.." , "|"};
  static Map<String, String> morse_map = new HashMap<String, String>(){
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		  for(int i = 0; i<english.length;i++){
			  put(morse[i], english[i]);
		  }
	}
  };
  
  public static String get(String code){
	  return morse_map.get(code);
  }
  
  
}
