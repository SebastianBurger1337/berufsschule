import bruchRechnung.Bruch;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BruchTestMarco {

    Bruch b1;
    Bruch b2;
    Bruch b3;
    Bruch b4;
    Bruch b5;

    @Before
    public void init() {
        b1 = new Bruch(2, 3);
        b2 = new Bruch(3, 4);
        b3 = new Bruch(-1, 2);
        b4 = new Bruch(-2, -1);
        b5 = new Bruch(1, -3);
    }

    @Test(expected = AssertionError.class)
    public void leererBruchTest() {
        Bruch leer = new Bruch(1,0);
    }

    @Test(expected = AssertionError.class)
    public void setNennerTest() {
        b1.setNenner(0);
    }

    @Test
    public void toStringTest() {
        assertEquals("2/3", b1.toString());
        assertEquals("3/4", b2.toString());
        assertEquals("-1/2", b3.toString());
        assertEquals("2", b4.toString());
        assertEquals("-1/3", b5.toString());

        assertEquals("2 1/3", new Bruch(7, 3).toString());
        assertEquals("-2 1/3", new Bruch(-7, 3).toString());
        assertEquals("-2", new Bruch(-18, 9).toString());
    }

    @Test
    public void mulTest() {
        assertEquals("1/2", b1.mul(b2).toString());
        assertEquals("-3/8", b2.mul(b3).toString());
        assertEquals("-1", b4.mul(b3).toString());
        assertEquals("1 1/2", b2.mul(b4).toString());
    }

    @Test
    public void divTest() {
        assertEquals("-2", b1.div(b5).toString());
        assertEquals("-4", b4.div(b3).toString());
        assertEquals("-2/3", b3.div(b2).toString());
        assertEquals("1 1/8", b2.div(b1).toString());
    }

    @Test
    public void addTest() {
        assertEquals("1/3", b1.add(b5).toString());
        assertEquals("1 5/12", b1.add(b2).toString());
        assertEquals("1/4", b2.add(b3).toString());
        assertEquals("-5/6", b3.add(b5).toString());
    }

    @Test
    public void subTest() {
        assertEquals("1/12", b2.sub(b1).toString());
        assertEquals("-2 1/2", b3.sub(b4).toString());
        assertEquals("2 1/2", b4.sub(b3).toString());
        assertEquals("1", b1.sub(b5).toString());
    }
}
