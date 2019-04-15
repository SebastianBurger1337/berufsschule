package bruchRechnung;

public class BruchMain
{
    public static void main(String[] args)
    {
        Bruch b1 = new Bruch(3, 4);
        Bruch b2 = new Bruch(-2, -1);
        Bruch res = b1.mul(b2);
        System.out.println(res.toString());
    }
}
