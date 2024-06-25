import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String namaFile = "Src/cuboid.csv";
        List<Cuboid> c = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(namaFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Cuboid cuboid = new Cuboid();
                cuboid.panjang = Double.parseDouble(row[0]);
                cuboid.lebar = Double.parseDouble(row[1]);
                cuboid.tinggi = Double.parseDouble(row[2]);
                c.add(cuboid);
            }
            for (Cuboid cuboid : c) {
                System.out.print("Volume balok :");
                System.out.println(cuboid.volume());
                System.out.print("Luas permukaan balok :");
                System.out.println(cuboid.luasPermukaan());
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        c.sort(Comparator.comparingDouble(Cuboid::luasPermukaan));

        String fileOutput = "Src/Output.txt";
       try (FileWriter fw = new FileWriter(fileOutput)){
           for (Cuboid cuboid : c) {
               fw.write(cuboid.luasPermukaan() + "\n");
           }
       }catch (IOException e){
           System.err.println(e.getMessage());
       }
    }
}