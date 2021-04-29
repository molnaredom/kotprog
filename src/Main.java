import mukodes.Jatek;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Jatek jatek = new Jatek();


        jatek.start();

        /*Scanner scanner = null;
        try {
            scanner = new Scanner(new File("p.txt"));
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }*/


    }
}
