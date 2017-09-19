package doubleCola;

import static org.junit.Assert.*;

import org.junit.Test;

public class LineTest {
	
    @Test
    public void test1() {
      String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
      int n = 1;  
      new Line();
	assertEquals("Sheldon", Line.WhoIsNext(names, n));
    }
   @Test
    public void test2() {
      String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
      int n = 6;  
      new Line();
	assertEquals("Sheldon", Line.WhoIsNext(names, n));
    }
   @Test
   public void test3() {
     String[] names = new String[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
     int n = 52;  
     new Line();
	assertEquals("Penny", Line.WhoIsNext(names, n));
   }
}
