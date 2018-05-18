import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;

public class project_3 {
    public static double pathLength;

    public static void main(String[] args){

        ArrayList<City> cities = (ArrayList) ReadFile();
        ArrayList<City> tsp = new ArrayList<City>();
        //ArrayList<City> cities2 = (ArrayList) cities.clone();
        //double pathLength =0;

        Util.TSP(cities.get(0), cities, tsp);
        for (City c:tsp) {
            System.out.println(c);
        }
        System.out.println(pathLength);
        System.out.println("input: " + cities.size());
        System.out.println("output: " + tsp.size());
    }

    static List<City> ReadFile(){

        List<City> cities = new ArrayList<City>();
        int id;
        double x,y;
        String fileName = "example-input-2.txt";
        String line;

        try {

            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                String[] parts = SplitFile(line);
                id = Integer.parseInt(parts[0]);
                x = Double.parseDouble(parts[1]);
                y = Double.parseDouble(parts[2]);
                City city = new City(id,x,y);
                cities.add(city);
            }

            bufferedReader.close();
            fileReader.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    return cities;
    }

    // That's for File Reading. Splitting parts in the file.
    public static String[] SplitFile(String input){
        String [] values = new String[3];
        String [] out = input.split(" ");
        int j=0;

        for (int i=0; i<out.length; i++){
            if(!out[i].equals("")){
                values[j] = out[i];
                j++;
            }
        }

        return values;
    }


}
