package project_3;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main_Activity {
    public static double pathLength=0;

    public static void main(String[] args){

        ArrayList<City> cities = (ArrayList) ReadFile();
        ArrayList<City> tsp = new ArrayList<City>();

        Methods.Travel(cities.get(0), cities, tsp);
        for (City c:tsp) {
            System.out.println(c);
        }
        System.out.println("\n" + pathLength);
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

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            while((line = bufferedReader.readLine()) != null) {
                String[] parts = SplitFile(line);
                //String [] parts = line.split(" ");
                id = Integer.parseInt(parts[0]);
                x = Double.parseDouble(parts[1]);
                y = Double.parseDouble(parts[2]);
                City city = new City(id,x,y);
                cities.add(city);
            }
            bufferedReader.close();
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

    /*public static String[] SplitFile(String input){
        String [] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int [] numberss = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String [] values = new String[3];
        String [] out = input.split("");
        int a;
        String b;
        int j=0;
        b="";

        for (int i=0; i<input.length(); i++){
            System.out.println("1");
            if (out[i].equals(numbers)){
                System.out.println("2");
                b += out[i];

            }

            else if(!b.equals("")){
                System.out.println("3");
                a= Integer.parseInt(b);
                values[j] = b;
                j++;
                b="";
            }
            else
                System.out.println("dak");

        }


        return values;
    }
*/

}
