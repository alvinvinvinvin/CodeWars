/**
 * 
 */
package moneyMoneyMoney;

/**
 * @author e007777
 *
 */
public class Money {
	
	public static int calculateYears(double principal, double interest,  double tax, double desired) {
	  int year = 0;
    // your code
	  return calculate(principal, interest, tax, desired, year);
	}
	
	public static int calculate(double principal, double interest,  double tax, double desired, int year){
	  if(principal >= desired){
	    return year;
	  }
	  year++;
	  System.out.println(year);
	  double earned = principal * interest;
	  double current = earned * (1.0-tax) + principal;
	  return calculate(current, interest, tax, desired, year);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
