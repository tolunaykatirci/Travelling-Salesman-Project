import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {

    public static ArrayList<City> cities;
    public static ArrayList<City> citiesSortedByX;
    public static ArrayList<City> citiesSortedByY;
    public static HashMap<Integer, City> hmByX;

    public static List<City> tsp = new ArrayList<City>();

    public static int size;
    public static double pathLength =0;
}
