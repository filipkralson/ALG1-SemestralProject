package pckgMain;

import java.util.Scanner;

/**
 * 6. vypocet souctu a soucinu polynomu
 * 
 * @author filkra
 * @version 11/01/22
 * 
 */

public class UI {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean end = false;

        do {
            displayMenu();

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    calculations.start();
                    break;
                case 2:
                    christmasArt.Fish();
                    break;
                case 0:
                    end = true;
                    break;
                default:
                    System.out.println("Neplatná volba!");
            }

        } while (!end);

    }

    private static void displayMenu() {

        System.out.println("--------------------");
        System.out.println("1. Vypocet polynomu");
        System.out.println("2. Vanocni uloha");
        System.out.println("0: Konec");
        System.out.println("--------------------");

    }

}
