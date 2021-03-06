package fraction;

/**
 * @author Sebastian Burger
 * A class representing a mathematical fraction.
 */
public class Fraction
{
    private int numerator;
    private int denominator;

    /**
     * Constructor for an empty Fraction.
     */
    public Fraction()
    {
        numerator = 0;
        denominator = 1;
    }

    /**
     * Constructor for the Fraction.
     *
     * @param numerator   Numerator
     * @param denominator Denominator
     * @throws ArithmeticException In the case that the denominator equals 0.
     */
    public Fraction(int numerator, int denominator) throws ArithmeticException
    {
        if (denominator == 0)
        {
            throw new ArithmeticException("Division by 0 not possible!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        invertNegativeNumbers();
    }

    public int getNumerator()
    {
        return numerator;
    }

    public void setNumerator(int numerator)
    {
        this.numerator = numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setDenominator(int denominator)
    {
        if (denominator == 0)
        {
            throw new ArithmeticException();
        }
        this.denominator = denominator;
    }

    public void output()
    {
        System.out.println(toString());
    }

    /**
     * Multiplies the current fraction with another.
     *
     * @param fraction
     */
    public Fraction mul(Fraction fraction)
    {
        return new Fraction(this.numerator * fraction.getNumerator(), this.denominator * fraction.getDenominator());
    }

    /**
     * Divides the current fraction with another.
     *
     * @param fraction The fraction to divide by.
     */
    public Fraction div(Fraction fraction)
    {
        return new Fraction(this.numerator * fraction.getDenominator(), this.denominator * fraction.getNumerator());
    }

    /**
     * Marco
     */
    private void invertNegativeNumbers()
    {
        if (numerator >= 0 && denominator < 0)
        {
            denominator = denominator * -1;
            numerator = numerator * -1;
        }
        else if (numerator < 0 && denominator < 0)
        {
            denominator = denominator * -1;
            numerator = numerator * -1;
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
        Fraction simplifiedFraction = this.simplify();
        int simplifiedZaehler = simplifiedFraction.getNumerator();
        int simplifiedNenner = simplifiedFraction.getDenominator();
        if (Math.abs(simplifiedZaehler) % simplifiedNenner == 0)
        {
            return String.valueOf(simplifiedZaehler / simplifiedNenner);
        }
        else if (Math.abs(simplifiedZaehler) > simplifiedNenner)
        {
            return String.format("%d %d/%d", simplifiedZaehler / simplifiedNenner,
                    Math.abs(simplifiedZaehler - ((simplifiedZaehler / simplifiedNenner) * simplifiedNenner)),
                    simplifiedNenner);
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
    public static int getLowestCommonDenominator(int a, int b)
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
            if (i % a == 0 && i % b == 0)
            {
                return i;
            }
        }
        return a * b;
    }

    /**
     * Gets the greatest common divisor of two numbers.
     *
     * @param a
     * @param b
     * @return The greatest common divisor.
     */
    public static int getGreatestCommonDivisor(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);

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

    /**
     * Expands a fraction by the provided expander.
     *
     * @param expander The expander.
     * @return The new expanded fraction.
     */
    public Fraction expand(int expander)
    {
        return new Fraction(numerator * expander, denominator * expander);
    }

    /**
     * @param reducer
     * @return TODO: check for division resulting in a double - experimental function.
     */
    private Fraction reduce(int reducer)
    {
        if (reducer == 0)
        {
            return new Fraction(0, 0);
        }
        else if (reducer < 0)
        {
            return expand(reducer * -1);
        }
        return new Fraction(numerator / reducer, denominator / reducer);
    }

    public Fraction simplify()
    {
        int greatestCommonDivisor = getGreatestCommonDivisor(numerator, denominator);
        return new Fraction(numerator / greatestCommonDivisor, denominator / greatestCommonDivisor);
    }

    /**
     * TODO refactor.
     * Adds a given fraction to the current fraction.
     *
     * @param fraction The fraction to be added.
     * @return A new fraction representing the product of the addition.
     */
    public Fraction add(Fraction fraction)
    {
        int lowestCommonDenominator = getLowestCommonDenominator(this.denominator, fraction.getDenominator());
        Fraction fraction1 = this.expand(lowestCommonDenominator / denominator);
        Fraction fraction2 = fraction.expand(lowestCommonDenominator / fraction.getDenominator());
        return new Fraction(fraction1.getNumerator() + fraction2.getNumerator(), lowestCommonDenominator);
    }

    /**
     * TODO refactor
     * Subtracts the given fraction from the current fraction.
     *
     * @param fraction The fraction to be subtracted.
     * @return
     */
    public Fraction sub(Fraction fraction)
    {
        int lowestCommonDenominator = getLowestCommonDenominator(this.denominator, fraction.getDenominator());
        Fraction fraction1 = this.expand(lowestCommonDenominator / denominator);
        Fraction fraction2 = fraction.expand(lowestCommonDenominator / fraction.getDenominator());
        return new Fraction(fraction1.getNumerator() - fraction2.getNumerator(), lowestCommonDenominator);
    }

    /**
     * Checks whether a given object is the same as the current fraction.
     *
     * @param obj The object to be checked.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Fraction)
        {
            Fraction fraction = ((Fraction) obj).simplify();
            Fraction simplifiedThis = this.simplify();
            return (simplifiedThis.getNumerator() == fraction.getNumerator()) && (simplifiedThis.getDenominator() == fraction.getDenominator());
        }
        else
        {
            return false;
        }
    }
}
