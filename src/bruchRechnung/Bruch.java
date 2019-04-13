package bruchRechnung;

/**
 *
 */
public class Bruch
{
    private int zaehler;
    private int nenner;

    public Bruch()
    {
        zaehler = 0;
        nenner = 1;
    }

    /**
     * Constructor for the fraction.
     * @param zaehler Numerator
     * @param nenner  Denominator
     * @throws ArithmeticException In the case that the denominator equals 0.
     */
    public Bruch(int zaehler, int nenner) throws ArithmeticException
    {
        if (nenner == 0)
        {
            throw new ArithmeticException("Durch 0 teilen ist nicht möglich!");
        }
        this.zaehler = zaehler;
        this.nenner = nenner;
        invertNegativeNumbers();
    }

    public int getZaehler()
    {
        return zaehler;
    }

    public void setZaehler(int zaehler)
    {
        this.zaehler = zaehler;
    }

    public int getNenner()
    {
        return nenner;
    }

    public void setNenner(int nenner)
    {
        assert nenner != 0;
        this.nenner = nenner;
    }

    public void anzeigen()
    {
        System.out.println(toString());
    }

    /**
     * Multiplies the current fraction with another.
     *
     * @param bruch
     */
    public Bruch mul(Bruch bruch)
    {
        return new Bruch(this.zaehler *= bruch.getZaehler(), this.nenner *= bruch.getNenner());
    }

    /**
     * Divides the current fraction with another.
     *
     * @param bruch The fraction to divide by.
     */
    public Bruch div(Bruch bruch)
    {
        return new Bruch(this.zaehler *= bruch.getNenner(), this.nenner *= bruch.getZaehler());
    }

    /**
     * Destroys Marco
     */
    private void invertNegativeNumbers()
    {
        if (zaehler >= 0 && nenner< 0)
        {
            nenner = nenner  * -1;
            nenner = zaehler * -1;
        }
        else if (zaehler < 0 && nenner < 0)
        {
            nenner  = nenner  * -1;
            zaehler = zaehler * -1;
        }
    }

    /**
     * Converts the current fraction to a String
     *
     * @return The fraction formatted as d/d = d
     */
    @Override
    public String toString()
    {
        Bruch simplifiedBruch = this.simplify();
        int simplifiedZaehler = simplifiedBruch.getZaehler();
        int simplifiedNenner = simplifiedBruch.getNenner();
        if (Math.abs(simplifiedZaehler)%nenner == 0)
        {
            return String.valueOf(simplifiedZaehler/nenner);
        }
        else if (Math.abs(simplifiedZaehler) > nenner)
        {
            return String.format("%d %d/%d", simplifiedZaehler/simplifiedNenner, simplifiedZaehler-((simplifiedZaehler/simplifiedNenner)*simplifiedNenner), simplifiedNenner);
        }
        return String.format("%d/%d", simplifiedZaehler, simplifiedNenner);
    }

    /**
     * Gets the smallest common denominator of two values.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The smallest common denominator of a and b.
     * TODO: Investigate potential that smaller number is divisor of bigger number
     */
    public int getLowestCommonDenominator(int a, int b)
    {
        if (a == b)
        {
            return a;
        }
        // Get the bigger of the two numbers
        int smallerNumber = a < b ? a : b;

        // Iterate over all possibilities between the bigger number and
        for (int i = smallerNumber; i < a * b; i++)
        {
            if (i % a  == 0 && i % b == 0)
            {
                return i;
            }
        }
        return a * b;
    }

    public int getGreatestCommonDivisor(int a, int b)
    {
        // Get the bigger of the two numbers
        int smallerNumber = a < b ? a : b;

        // Iterate over all possibilities between the bigger number and
        for (int i = smallerNumber; i > 1; i--)
        {
            if (a % i == 0 && b % i == 0)
            {
                return i;
            }
        }
        return 1;
    }

    public Bruch expand(int expander)
    {
        return new Bruch(zaehler * expander, nenner * expander);
    }

    /**
     * @param reducer
     * @return TODO: check for division resulting in a double
     */
    public Bruch reduce(int reducer)
    {
        return new Bruch(zaehler / reducer, nenner / reducer);
    }

    public Bruch simplify()
    {
        int greatestCommonDivisor = getGreatestCommonDivisor(zaehler, nenner);
        return new Bruch(zaehler/greatestCommonDivisor, nenner/greatestCommonDivisor);
    }

    /**
     * @param bruch
     * @return
     * TODO refactor
     */
    public Bruch add(Bruch bruch)
    {
        int lowestCommonDenominator = getLowestCommonDenominator(this.nenner, bruch.getNenner());
        Bruch bruch1 = this.expand(lowestCommonDenominator/nenner);
        Bruch bruch2 = bruch.expand(lowestCommonDenominator/bruch.getNenner());
        return new Bruch(bruch1.getZaehler() + bruch2.getZaehler(), lowestCommonDenominator);
    }

    /**
     * TODO refactor
     * @param bruch
     * @return
     */
    public Bruch sub(Bruch bruch)
    {
        int lowestCommonDenominator = getLowestCommonDenominator(this.nenner, bruch.getNenner());
        Bruch bruch1 = this.expand(lowestCommonDenominator/nenner);
        Bruch bruch2 = bruch.expand(lowestCommonDenominator/bruch.getNenner());
        return new Bruch(bruch1.getZaehler() - bruch2.getZaehler(), lowestCommonDenominator);
    }

    /**
     * Checks whether
     * @param obj
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Bruch)
        {
            Bruch bruch = ((Bruch)obj).simplify();
            Bruch simplifiedThis = this.simplify();
            return (simplifiedThis.getZaehler() == bruch.getZaehler()) && (simplifiedThis.getNenner() == bruch.getNenner());
        }
        else
        {
            return false;
        }
    }
}
