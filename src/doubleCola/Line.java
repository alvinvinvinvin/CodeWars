/**
 * For example, Penny drinks the third can of cola and the queue will look like this:

Rajesh, Howard, Sheldon, Sheldon, Leonard, Leonard, Penny, Penny
Write a program that will return the name of a man who will drink the n-th cola.

Note that in the very beginning the queue looks like that:

Sheldon, Leonard, Penny, Rajesh, Howard
##Input

The input data consist of an array which contains five names, and single integer n.

(1 ≤ n ≤ 1000000000).
##Output / Examples Return the single line — the name of the person who 
drinks the n-th can of cola. The cans are numbered starting from 1. 
Please note that you should spell the names like this: 
"Sheldon", "Leonard", "Penny", "Rajesh", "Howard" (without the quotes). 
In that order precisely the friends are in the queue initially.

 string[] names = new string[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
 int n = 1;
 Line.WhoIsNext(names, n) --> "Sheldon"

 int n = 6;
 Line.WhoIsNext(names, n) --> "Sheldon"

 int n = 52;
 Line.WhoIsNext(names, n) --> "Penny"

 int n = 7230702951;
 Line.WhoIsNext(names, n) --> "Leonard"
 */
package doubleCola;

/**
 * @author e007777
 *
 */
public class Line {
	   public static String WhoIsNext(String[] names, int n)
	   {
	        // Your code is here...
		   if(n<=5) return names[n-1];
		   int len = names.length;
		   //start from 6 - 15 -> 0;
		   int layer = find_layer(len, n);
		   int start = find_start(len, layer);
		   int n_ppl = pow2(layer);
		   int index = (n-start)/n_ppl;
		   System.out.println("layer: "+layer);
		   System.out.println("start: "+start);
		   System.out.println("n_ppl: "+n_ppl);
		   System.out.println("index: "+index);
		   return names[index];
		   
		   
	   }
	   
	   public static int find_layer (int len, int n){
		   int i = 0;
		   while(true){
			   int start = find_start(len, i);
			   int dynamic_len = find_dynamic_len(len,i);
			   int end = start + dynamic_len - 1;
			   if( (n > start && n < end) || n == start || n == end){
				   System.out.println("i: "+i);
				   System.out.println("inner_start: "+start);
				   System.out.println("inner_dynamic_len: "+dynamic_len);
				   return i;
			   }
			   i++;
		   }
	   }
	   
	   public static int find_start(int len, int layer){
		   int pow2 = pow2(layer);
		   return 1 + len * (pow2 -1) ;
	   }
	   
	   public static int find_dynamic_len(int len, int layer){
		   int pow2 = pow2(layer);
		   return len*pow2;
	   }
	   
	   public static int pow2(int layer){
		   return (int) Math.pow(2, layer+1);
	   }
	   
	   
	   /**
	    * Let's unfold the queue:
	    * 

1 2 3 4 5   1 1 2 2 3 3 4 4 5 5   1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 5 5 5 5   ...
We notice that if we do this transformation, we can reduce r while preserving the shape of the queue:

1 2 3 4 5   1 1 2 2 3 3 4 4 5 5   1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 5 5 5 5   ...

r -= 5 ->
1 1 2 2 3 3 4 4 5 5   1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 5 5 5 5   ...

r /= 2 -> //Note: this is integer division, so it's   r = floor(r/2)
1 2 3 4 5    1 1 2 2 3 3 4 4 5 5   ...
Which gives us a way to reduce r until it's between 1 to 5, which we can directly use as an index.
	    * @param names
	    * @param n
	    * @return
	    */
	   public static String WhoIsNext2(String[] names, int n)
	   {
	       while(n>names.length){
	    	   n = (n-names.length+1)/2;
	       }
	       return names[n-1];
	   }
}
