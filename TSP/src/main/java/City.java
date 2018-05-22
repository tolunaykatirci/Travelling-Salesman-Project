import java.util.ArrayList;
import java.util.List;

public class City {

    private int id;
    private double x;
    private double y;
    private boolean isVisited;
    private City nearestNeighbour;
    public List<City> neighbours = new ArrayList<City>();

    public Integer indexX = null;
    public Integer indexY = null;

    public City(double x, double y) {
        this.x = x;
        this.y = y;
        this.isVisited = false;
    }

    public City(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.isVisited = false;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", isVisited=" + isVisited +
                '}';
    }

    public City getNearestNeighbour() {
        nearestNeighbour = null;
        double nearestCityPath = Double.MAX_VALUE;
        for (City c: Database.cities) {
            if(!(c.getId()==getId()) && !c.isVisited()){
                double path = Util.getWeight(this,c);
                if(path<nearestCityPath){
                    nearestCityPath=path;
                    nearestNeighbour = c;
                }
            }
        }
        return nearestNeighbour;
    }

    public void setNearestNeighbour(City nearestNeighbour) {
        this.nearestNeighbour = nearestNeighbour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
