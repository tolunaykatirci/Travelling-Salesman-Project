import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

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
                String[] parts = getValues(sCurrentLine);
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


    public static String[] getValues(String input){
        String [] values = new String[3];
        String [] out = input.split(" ");
        int j=0;

        for (int i=0; i<out.length; i++){
            /*if(j==3)
                break;*/
            if(!out[i].equals("")){
                values[j] = out[i];
                j++;
            }
        }

        return values;
    }

    public static void writeToFile(List<City> cities, String path, Integer length){

        BufferedWriter bw = null;
        FileWriter fw = null;

        try{
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            bw.write(length.toString() + "\n");
            for (City c:cities) {
                bw.write(c.getId() + "\n");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

    }
}
