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
        Fraction fraction = new Fraction(0, 1);
        assertEquals("0", fraction.toString());
        fraction = new Fraction(1, 1);
        assertEquals("1", fraction.toString());
        fraction = new Fraction(3, 2);
        assertEquals("1 1/2", fraction.toString());
        fraction = new Fraction(13, 4);
        assertEquals("3 1/4", fraction.toString());
        fraction = new Fraction(-4, 4);
        assertEquals("-1", fraction.toString());
        fraction = new Fraction(5, -4);
        assertEquals("-1 1/4", fraction.toString());
    }

    @Test
    public void testExpand()
    {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(new Fraction(2, 4), fraction.expand(2));
        //assertTrue(new Fraction(2,4).equals(fraction.expand(2)));
    }

    // Removed due to potential wrong results.

    /**
     * @Test public void testReduce()
     * {
     * Fraction fraction = new Fraction(2, 4);
     * assertEquals("1/2", fraction.reduce(2).toString());
     * fraction = new Fraction(3, 9);
     * assertEquals("1/3", fraction.reduce(3).toString());
     * }
     */

    @Test
    public void testSimplify()
    {
        Fraction fraction = new Fraction(2, 4);
        assertEquals("1/2", fraction.simplify().toString());
        fraction = new Fraction(-2, 4);
        assertEquals("-1/2", fraction.simplify().toString());
    }

    @Test
    public void testAdd()
    {
        Fraction fraction = new Fraction(1, 2);
        assertEquals("1", fraction.add(fraction).toString());
        Fraction secondFraction = new Fraction(1, 3);
        assertEquals("5/6", fraction.add(secondFraction).toString());
        fraction = new Fraction(-2, 4);
        secondFraction = new Fraction(1, 3);
        assertEquals("-1/6", fraction.add(secondFraction).toString());
    }

    @Test
    public void testSub()
    {
        Fraction fraction = new Fraction(1, 2);
        assertEquals("0", fraction.sub(fraction).toString());
        Fraction secondFraction = new Fraction(1, 3);
        assertEquals("1/6", fraction.sub(secondFraction).toString());
        fraction = new Fraction(-2, 4);
        secondFraction = new Fraction(-1, 3);
        assertEquals("-1/6", fraction.sub(secondFraction).toString());
    }
}
