package bruchRechnung;

public class BruchMain
{
    public static void main(String[] args)
    {
        Bruch bruch1 = new Bruch(0, 2);
        Bruch bruch2 = new Bruch(1, 2);
        bruch1.simplify();
    }
}
