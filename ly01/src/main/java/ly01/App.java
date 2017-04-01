package ly01;

/**
 * Mower application 
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Start Mower app ...\n" );
        Grid grid = new Grid(5,5);
        
        Mower m1 = new Mower("M1", grid, "1 2 N");
        m1.move("GAGAGAGAA");
        System.out.println("M1 "+ m1.getPosition());
        
        Mower m2 = new Mower("M2", grid, "3 3 E");
        m2.move("AADAADADDA");
        System.out.println("M2 "+ m2.getPosition());
        
    }
}
