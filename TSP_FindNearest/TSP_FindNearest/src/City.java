import java.util.ArrayList;
import java.util.List;

public class City {

    public int id;
    public double x;
    public double y;
    public boolean visited;
    public List<City> neighbours = new ArrayList<City>();

    public City(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.visited = false;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", isVisited=" + visited;
    }

}
