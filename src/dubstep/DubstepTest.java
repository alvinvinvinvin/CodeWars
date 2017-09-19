package dubstep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class DubstepTest {
    @Test
    public void Test1() {
      new Dubstep();
	assertEquals("ABC", Dubstep.SongDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
       new Dubstep();
	assertEquals("R L", Dubstep.SongDecoder("RWUBWUBWUBLWUB"));
    }
}