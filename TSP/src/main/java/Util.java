import javafx.scene.chart.PieChart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {


    public static int getWeight(City a, City b){
        double xDifference = a.getX() - b.getX();
        double yDifference = a.getY() - b.getY();
        return (int) Math.round(Math.sqrt(Math.pow(xDifference,2) + Math.pow(yDifference, 2)));
    }


    public static int getWeightFromOrigin(City a){
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

    public static City getNearestNeighbour(City city){
        City nearestCity = null;
        double nearestCityPath = Double.MAX_VALUE;
        for (City c: Database.cities) {
            if(!(c.getId()==city.getId()) && !c.isVisited()){
                double path = getWeight(city,c);
                if(path<nearestCityPath){
                    nearestCityPath=path;
                    nearestCity = c;
                }
            }
        }
        return nearestCity;
    }

    public static void addNeighbours(City city){
        //c.neighbours.add();
        int i=1;
        int count = 0;

        city.neighbours.clear();
        int indexX = city.indexX;
        int indexY = city.indexY;
        while(count<Database.size && count<15000 && Database.size > i){

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
        /*if(weight!=Double.MAX_VALUE)
            Database.pathLength+=weight;*/

        return nearest;
    }

    public static void TSP(City city){
        if(city == null){
            return;
        }
        city.setVisited(true);

        //addNeighbours(city);
        Database.tsp.add(city);
        city.setNearestNeighbour(getNearestNeighbour(city));

        if(city.getNearestNeighbour()!=null){
                Database.pathLength+=getWeight(city,city.getNearestNeighbour());
        }
        TSP(city.getNearestNeighbour());
    }

    public static void tsp(){
        City c1,c2;

        for (City city: Database.cities) {
            Database.pathLength=0;
            city.setVisited(true);
            //Database.tsp.add(city);
            addNeighbours(city);
            c1=findNearestNeighbour(city);
            c2=city;
            while(c1!=null){
                Database.pathLength+=getWeight(c1,c2);
                c2=c1;
                c2.setVisited(true);
                //Database.tsp.add(c2);
                addNeighbours(c2);
                c1 = findNearestNeighbour(c2);
                //c1=c1.getNearestNeighbour();
            }

            Database.pathLength+=getWeight(city,c2);
            System.out.println("For city " + city.getId() + ", shortest path: " + Database.pathLength);
            refreshDBList();

        }
    }

    public static void refreshDBList(){
        for (City c:Database.cities) {
            c.setVisited(false);
        }
    }






    /************************************************************/

    public static Double[][] getMatrix(List<City> cities){
        int cityCount = cities.size();
        Double[][] matrix = new Double[cityCount][cityCount];
        long start = System.currentTimeMillis();
        for (int i=0; i< cityCount; i++){
            for (int j=0; j< cityCount; j++){
                if(i==j){
                    matrix[i][j] = Double.MAX_VALUE;
                }
                else{
                    matrix[i][j] = (double) Util.getWeight(cities.get(i),cities.get(j));
                }

            }
        }
        long stop = System.currentTimeMillis();
        System.out.println("Matrix constructed in " + ((stop-start)) + "ms!");


        return matrix;
    }


    public static void findShortestPath(Double[][] matrix, City startingCity, City stoppingCity){
        double shortestPath = 0;
        int length = matrix.length;
        /*for(int i=0; i< length; i++){
            for (int j=0; j<length; j++){

            }
        }*/
        for (City c1 :Database.cities) {
            for (City c2 :Database.cities) {

            }
        }
    }




}
