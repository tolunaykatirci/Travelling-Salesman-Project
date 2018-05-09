import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Util {


    public static double getWeight(City a, City b){
        double xDifference = a.getX() - b.getX();
        double yDifference = a.getY() - b.getY();
        return  Math.sqrt(Math.pow(xDifference,2) + Math.pow(yDifference, 2));
    }


    public static double getWeightFromOrigin(City a){
        City b = new City(0,0);
        return getWeight(a,b);
    }

    public static ArrayList<City> sortByX(ArrayList<City> cities){
        ArrayList<City> sortedCities = (ArrayList) cities.clone();
        for(int i=1; i<sortedCities.size(); i++){
            City key = sortedCities.get(i);

            int j=i-1;
            sortedCities.get(j).indexX = j;
            while(j>=0 && sortedCities.get(j).getX() > key.getX()){
                sortedCities.set(j+1,sortedCities.get(j));
                sortedCities.get(j+1).indexX = i;
                j = j-1;
            }
            sortedCities.set(j+1,key);
            sortedCities.get(j+1).indexX = i;
        }
        return sortedCities;
    }

    public static ArrayList<City> sortByY(ArrayList<City> cities){
        ArrayList<City> sortedCities = (ArrayList) cities.clone();
        for(int i=1; i<sortedCities.size(); i++){
            City key = sortedCities.get(i);

            int j=i-1;
            sortedCities.get(j).indexY = j;
            while(j>=0 && sortedCities.get(j).getY() > key.getY()){
                sortedCities.set(j+1,sortedCities.get(j));
                sortedCities.get(j+1).indexY = i;
                j = j-1;
            }
            sortedCities.set(j+1,key);
            sortedCities.get(j+1).indexY = i;
        }
        return sortedCities;
    }

    public static void addNeighbours(City city){
        //c.neighbours.add();
        int i=1;
        int count = 0;
        int indexX = city.indexX;
        int indexY = city.indexY;
        while(count<50 && Database.size > i){

            City nb, yb;
            if(indexX-i >0){
                nb = Database.citiesSortedByX.get(indexX-i);
                if(nb.isVisited()==false){
                    city.neighbours.add(nb);
                    count++;
                }
            }
            if(indexY-i >0){
                yb = Database.citiesSortedByY.get(indexY-i);
                if(yb.isVisited()==false){
                    city.neighbours.add(yb);
                    count++;
                }
            }

            if( (indexX+i) < Database.size){
                nb = Database.citiesSortedByX.get(indexX+i);
                if(nb.isVisited()==false){
                    city.neighbours.add(nb);
                    count++;
                }
            }
            if(indexY+i < Database.size){
                yb = Database.citiesSortedByY.get(indexY+i);
                if(yb.isVisited()==false){
                    city.neighbours.add(yb);
                    count++;
                }
            }

            i++;
        }
    }

    public static City findNearestNeighbour(City city){
        City nearest = null ;
        double weight = Double.MAX_VALUE;
        for (City c: city.neighbours) {
            double cw = getWeight(city, c);
            if(cw < weight){
                weight = cw;
                nearest = c;
            }
        }
        if(weight!=Double.MAX_VALUE)
            Database.pathLength+=weight;

        return nearest;
    }

    public static void TSP(City city){
        if(city == null){
            return;
        }
        city.setVisited(true);

        addNeighbours(city);
        Database.tsp.add(city);
        TSP(findNearestNeighbour(city));
    }


}
