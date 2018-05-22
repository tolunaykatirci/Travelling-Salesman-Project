import javafx.scene.chart.PieChart;
import org.omg.CORBA.DATA_CONVERSION;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {

    public static void sagüstsolalt(){

        double xDifference = Database.citiesSortedByX.get(Database.citiesSortedByX.size()-1).getX() - Database.citiesSortedByX.get(0).getX();

        double yMin = Database.citiesSortedByY.get(0).getY();
        double yMax = Database.citiesSortedByY.get(Database.citiesSortedByY.size()-1).getY();
        double yDifference = yMax - yMin;
        int ybol = (int) (yDifference/98) + 1;
        City c=null;

        for (int i=0; i<Database.size; i++){
            c=Database.citiesSortedByX.get(i);
            if(c.getY()<yMin+ybol)
                break;
        }
        double maxy =  yMin+ybol, miny = yMin;
        while(miny<yMax){
            while(c!=null){
                c.setVisited(true);
                Database.tsp.add(c);
                c = getNearestRight(c,miny,maxy);
            }
            miny=maxy;
            maxy=maxy+ybol;
            c = getMostRight(miny,maxy);
            while(c!=null){
                c.setVisited(true);
                Database.tsp.add(c);
                c = getNearestLeft(c,miny,maxy);
            }
            miny=maxy;
            maxy=maxy+ybol;
            c = getMostLeft(miny,maxy);
        }




    }



    public static City getMostRight(double ymin, double ymax){
        City c=null;

        for (int i=0; i<Database.size; i++){
            c = Database.citiesSortedByX.get(Database.size-1-i);
            if(c.getY()>=ymin && c.getY()<=ymax && !c.isVisited())
                return c;
        }
        return c;
    }

    public static City getMostLeft(double ymin, double ymax){
        City c=null;

        for (int i=0; i<Database.size; i++){
            c = Database.citiesSortedByX.get(i);
            if(c.getY()>=ymin && c.getY()<=ymax && !c.isVisited())
                return c;
        }
        return c;
    }

    public static City getNearestRight(City city, double yMin, double yMax){
        City nearest = null;
        Double shortestPath = Double.MAX_VALUE;
        Double nextPath;

        int index = Database.citiesSortedByX.indexOf(city);

        index++;
        while(index<Database.size){
            nearest = Database.citiesSortedByX.get(index);
            if(nearest.isVisited() || nearest.getY()>yMax || nearest.getY()<yMin){
                index++;
                continue;
            }
            return nearest;
        }
        return null;

        /*for (City c:Database.citiesSortedByX) {
            if(c.getX()<city.getX() && c.getY()>yLimit)
                continue;
            nextPath = Util.getWeight(city,c);
            if(nextPath < shortestPath){
                shortestPath = nextPath;
                nearest = c;
            }
        }
        return nearest;*/
    }

    public static City getNearestLeft(City city, double yMin, double yMax){
        City nearest = null;

        int index = Database.citiesSortedByX.indexOf(city);
        index--;
        while(index>=0){
            nearest = Database.citiesSortedByX.get(index);
            if(nearest.isVisited() || nearest.getY()>yMax || nearest.getY()<yMin){
                index--;
                continue;
            }
            return nearest;
        }

        return null;

    }


}
