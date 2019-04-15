package fraction;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest
{

    @Test
    public void testMul()
    {
        Fraction fraction = new Fraction(1, 4);
        Fraction fractionRes = new Fraction(1, 4).mul(fraction);
        Fraction comparison = new Fraction(1, 16);
        assertEquals(comparison.toString(), fractionRes.toString());
    }

    @Test
    public void testDiv()
    {
        Fraction fraction = new Fraction(1, 4);
        Fraction fractionRes = new Fraction(1, 4).div(fraction);
        Fraction comparison = new Fraction(1, 1);
        assertEquals(comparison.toString(), fractionRes.toString());
    }

    @Test
    public void testToString()
    {
        Fraction fraction = new Fraction(0,1);
        assertEquals("0", fraction.toString());
        fraction = new Fraction(1,1);
        assertEquals("1", fraction.toString());
        fraction = new Fraction(3,2);
        assertEquals("1 1/2", fraction.toString());
        fraction = new Fraction(13, 4);
        assertEquals("3 1/4", fraction.toString());
        fraction = new Fraction(-4, 4);
        assertEquals("-1", fraction.toString());
        fraction = new Fraction(5, -4);
        assertEquals("-1 -1/4", fraction.toString());
    }

    @Test
    public void testExpand()
    {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(new Fraction(2, 4), fraction.expand(2));
        //assertTrue(new Fraction(2,4).equals(fraction.expand(2)));
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
