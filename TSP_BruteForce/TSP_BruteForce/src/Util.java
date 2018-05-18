import java.util.ArrayList;

public class Util {

    public static void TSP(City city, ArrayList<City> cities, ArrayList<City> tsp){
        if(city == null){
            return;
        }
        city.setVisited(true);
        addNeighbours(city, cities);
        tsp.add(city);
        TSP(findNearestNeighbour(city), cities, tsp);
    }

    public static void addNeighbours(City city, ArrayList<City> cities){
        for (City c: cities) {
            if(!c.isVisited()){
                city.neighbours.add(c);
            }
        }
    }

    public static City findNearestNeighbour(City city){
        City nearest = null ;
        double weight = Double.MAX_VALUE;
        for (City c: city.neighbours) {
            double cw = getDistance(city, c);
            if(cw < weight){
                weight = cw;
                nearest = c;
            }
        }
        if(weight!=Double.MAX_VALUE)
            project_3.pathLength+=weight;

        return nearest;
    }

    public static double getDistance(City a, City b){
        double xDifference = Math.abs(a.getX() - b.getX());
        double yDifference = Math.abs(a.getY() - b.getY());
        return  Math.sqrt(Math.pow(xDifference,2) + Math.pow(yDifference, 2));
    }


}
