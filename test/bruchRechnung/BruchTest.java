package bruchRechnung;

import org.junit.Test;

import static org.junit.Assert.*;

public class BruchTest
{

    @Test
    public void testMul()
    {
        Bruch bruch = new Bruch(1, 4);
        Bruch bruchRes = new Bruch(1, 4).mul(bruch);
        Bruch comparison = new Bruch(1, 16);
        assertEquals(comparison.toString(), bruchRes.toString());
    }

    @Test
    public void testDiv()
    {
        Bruch bruch = new Bruch(1, 4);
        Bruch bruchRes = new Bruch(1, 4).div(bruch);
        Bruch comparison = new Bruch(1, 1);
        assertEquals(comparison.toString(), bruchRes.toString());
    }

    @Test
    public void testToString()
    {
        Bruch bruch = new Bruch(0,1);
        assertEquals("0", bruch.toString());
        bruch = new Bruch(1,1);
        assertEquals("1", bruch.toString());
        bruch = new Bruch(3,2);
        assertEquals("1 1/2", bruch.toString());
        bruch = new Bruch(13, 4);
        assertEquals("3 1/4", bruch.toString());
        bruch = new Bruch(-4, 4);
        assertEquals("-1", bruch.toString());
        bruch = new Bruch(5, -4);
        assertEquals("-1 -1/4", bruch.toString());
    }

    @Test
    public void testExpand()
    {
        Bruch bruch = new Bruch(1, 2);
        assertEquals(new Bruch(2, 4), bruch.expand(2));
        //assertTrue(new Bruch(2,4).equals(bruch.expand(2)));
    }

    @Test
    public void testReduce()
    {
    }

    @Test
    public void testSimplify()
    {
    }

    @Test
    public void testAdd()
    {

    }

    @Test
    public void testSub()
    {

    }
}
