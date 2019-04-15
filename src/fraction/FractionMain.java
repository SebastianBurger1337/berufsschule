package fraction;

public class FractionMain
{
    public static void main(String[] args)
    {
        Fraction b1 = new Fraction(3, 4);
        Fraction b2 = new Fraction(-2, -1);
        Fraction res = b1.mul(b2);
        System.out.println(res.toString());
    }
}
