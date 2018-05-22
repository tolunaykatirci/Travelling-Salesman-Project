
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        String path = "example-input-3.txt";
        Database.cities =  (ArrayList) FileUtil.readCities(path);
        //System.out.println(cities.get(75));
        //System.out.println(Util.getWeightFromOrigin(cities.get(0)));
        Database.citiesSortedByX = Util.sortByX(Database.cities);
        Database.citiesSortedByY = Util.sortByY(Database.cities);
        //System.out.println(sortedList.toString());
        System.out.println(Database.citiesSortedByY.indexOf(Database.cities.get(0)));
        Database.size = Database.cities.size();

        //System.out.println(Database.citiesSortedByX);
        //System.out.println(Database.citiesSortedByY);

        for (City c: Database.citiesSortedByX) {
            if(c.indexX == null)
                System.out.println("sdsdadsadasd");
        }
        //Util.tsp();
        Algorithms.sagüstsolalt();
        for (City c:Database.tsp) {

            System.out.println(c);
        }

        Database.pathLength=0;
        for (int i=0; i<Database.tsp.size()-1; i++){
            Database.pathLength+=Util.getWeight(Database.tsp.get(i),Database.tsp.get(i+1));
        }
        Database.pathLength+=Util.getWeight(Database.tsp.get(Database.tsp.size()-1),Database.tsp.get(0));

        System.out.println(Database.pathLength);
        System.out.println("input length: " + Database.cities.size() + " output length: " + Database.tsp.size());
        FileUtil.writeToFile(Database.tsp,"example-output-3.txt", Database.pathLength);

        /*String path = "example-input-1.txt";
        Database.cities =  (ArrayList) FileReader.readCities(path);
        Database.cityCount = Database.cities.size();

        System.out.println(Database.cityCount);
        if(Database.cityCount > 1000 ){

        }

        Double[][] matrix = Util.getMatrix(Database.cities);*/



    }
}
