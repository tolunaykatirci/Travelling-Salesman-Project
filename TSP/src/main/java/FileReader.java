import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<City> readCities(String path){
        List<City> cities = new ArrayList<City>();
        BufferedReader br = null;
        java.io.FileReader fr = null;
        int id;
        double x, y;

        try {
            fr = new java.io.FileReader(path);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] parts = sCurrentLine.split(" ");
                id = Integer.parseInt(parts[0]);
                x = Double.parseDouble(parts[1]);
                y = Double.parseDouble(parts[2]);
                City city = new City(id,x,y);
                cities.add(city);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

        return cities;
    }
}
