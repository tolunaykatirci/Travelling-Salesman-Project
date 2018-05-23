package project_3;

import java.util.ArrayList;

public class Methods {

    public static void Travel(City city, ArrayList<City> cities, ArrayList<City> tsp){
        City city2;
        if(city == null){
            return;
        }
        visited(city,cities,tsp);

        for (int i=0; i<cities.size()-1; i++){
            city2=findNearestNeighbour(city);
            visited(city2,cities,tsp);
            city=city2;
        }
    }

    public static void visited(City city, ArrayList<City> cities, ArrayList<City> tsp){
        if(city == null){
            return;
        }
        city.visited=true;
        addNeighbours(city, cities);
        tsp.add(city);
    }

    public static void addNeighbours(City city, ArrayList<City> cities){
        for (City c: cities) {
            if(c.visited==false){
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
        Main_Activity.pathLength+=minDistance;

        return nearest_city;
    }

    public static double getDistance(City city1, City city2){

        return  Math.sqrt(Math.pow((Math.abs(city1.x - city2.x)),2) +
                          Math.pow((Math.abs(city1.y - city2.y)), 2));
    }

}
