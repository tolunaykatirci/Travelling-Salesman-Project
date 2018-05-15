import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String path = "example-input-3.txt";
        Database.cities =  (ArrayList) FileReader.readCities(path);
        //System.out.println(cities.get(75));
        //System.out.println(Util.getWeightFromOrigin(cities.get(0)));
        Database.citiesSortedByX = Util.sortByX(Database.cities);
        Database.citiesSortedByY = Util.sortByY(Database.cities);
        //System.out.println(sortedList.toString());
        Database.size = Database.cities.size();

        //System.out.println(Database.citiesSortedByX);
        //System.out.println(Database.citiesSortedByY);

        for (City c: Database.citiesSortedByX) {
            if(c.indexX == null)
                System.out.println(c);
        }
        Util.TSP(Database.citiesSortedByX.get(23));
        for (City c:Database.tsp) {

            System.out.println(c);
        }
        System.out.println("furkans");
        System.out.println(Database.pathLength);
        System.out.println("input length: " + Database.cities.size() + " output length: " + Database.tsp.size());

    }
}
