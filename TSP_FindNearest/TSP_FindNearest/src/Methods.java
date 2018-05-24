package project_3;

import java.util.ArrayList;

public class Methods {

    public static void Travel(City city, ArrayList<City> cities_sortedX, ArrayList<City> tsp){
        City city2;
        if(city == null){
            return;
        }
        visited(city,cities_sortedX,tsp);

        for (int i=0; i<cities_sortedX.size()-1; i++){
            city2=findNearestNeighbour(city);
            visited(city2,cities_sortedX,tsp);
            city=city2;
        }
    }

    public static void visited(City city, ArrayList<City> cities_sortedX, ArrayList<City> tsp){
        if(city == null){
            return;
        }
        city.visited=true;
        addNeighbours(city, cities_sortedX);
        tsp.add(city);
    }

    public static void addNeighbours(City city, ArrayList<City> cities_sortedX){
        for (City c: cities_sortedX) {
            if(c.visited==false && city.neighbours.size()<=200){
                city.neighbours.add(c);
            }
        }
    }

    public static City findNearestNeighbour(City city){
        City nearest_city=null;
        double minDistance = Double.MAX_VALUE;
        for (City c: city.neighbours) {
            double distance = getDistance(city, c);
            if(distance < minDistance){
                minDistance = distance;
                nearest_city = c;

            }
        }
        //System.out.println("---" + minDistance);
        Main_Activity.pathLength+=minDistance;
        //System.out.println("***" + Main_Activity.pathLength);

        return nearest_city;
    }

    public static double getDistance(City city1, City city2){

        return  Math.sqrt(Math.pow((Math.abs(city1.x - city2.x)),2) +
                          Math.pow((Math.abs(city1.y - city2.y)), 2));
    }

    public static ArrayList<City> Sort_X(ArrayList<City> cities){

        ArrayList<City> Orj_city = (ArrayList<City>) cities.clone();
        ArrayList<City> city = new ArrayList<City>();

        for (City c: cities) {
            c=findMinX(Orj_city);
            city.add(c);
            Orj_city.remove(c);
        }


        return city;
    }

    public static City findMinX(ArrayList<City> city){
        City min_city=null;
        double minX = Double.MAX_VALUE;
        for (City c: city) {
            double min=c.x;
            if(min < minX){
                minX = min;
                min_city = c;
            }
        }

        return min_city;
    }

}
