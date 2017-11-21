package com.jorphrey;

import com.jorphrey.io.*;
import com.jorphrey.purchase.Purchase;
import com.jorphrey.purchase.Purchases;
import com.jorphrey.tools.DateChecker;

import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class Spending {
    private Purchases purchases;
    private Scanner scanner;
    private SerializeList serializeList;
    private File file;

    public Spending() {
        scanner = new Scanner(System.in);
        serializeList = new SerializeList();
        file = new File(serializeList.getFile());
        purchases = new Purchases();
    }

    public void Begin() {

        if (file.exists()) {
            purchases.setPurchases(serializeList.deserialize(serializeList.getFile()));
        }
        int entry = 0;

        System.out.println(purchases.getPurchases().size());

        System.out.println("Welcome to your spending tracker.");
        printMenu("main");

        while (true) {
            System.out.print("Please enter the number of your choice or 0 for menu: ");
            try {
                entry = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid entry");
            }
            switch (entry) {
                case 0:
                    printMenu("main");
                    break;
                case 1:
                    addPurchase();
                    break;
                case 2:
                    changePurchase();
                    break;
                case 3:
                    deletePurchase();
                    break;
                case 4:
                    sortPurchase();
                    break;
                case 5:
                    viewPurchases();
                    break;
                case 9:
                    System.exit(0);
            }
            if (entry > 5 || entry < 0) {
                System.out.println("Invalid entry");
            }

        }
    }

    public void printMenu(String menu) {
        if (menu.equals("main")) {
            System.out.println("--------Main Menu--------");
            System.out.println("\t1. Add purchase");
            System.out.println("\t2. Change purchase");
            System.out.println("\t3. Delete purchase");
            System.out.println("\t4. Sort purchases");
            System.out.println("\t5. View purchases");
            System.out.println("\t9. Quit");
            System.out.println("-------------------------");
        } else if (menu.equals("sort")) {
            System.out.println("--------Sort Menu--------");
            System.out.println("\t1. Purchase name");
            System.out.println("\t2. Purchase type");
            System.out.println("\t3. Date");
            System.out.println("\t4. Cancel");
            System.out.println("\t9. Quit");
            System.out.println("-------------------------");
        }
    }

    public void addPurchase() {
        double cost = 0.0;
        LocalDate date;
        int month = 1;
        int year = 1;
        int day = 1;
        System.out.println("Please enter the following information about your purchase:");
        System.out.print("What did you purchase?: ");
        String what = scanner.nextLine();
        System.out.print("What type (i.e. grocery, clothing) of purchase was it?: ");
        String type = scanner.nextLine();
        while (true) {
            System.out.print("How much was it?: ");
            try {
                cost = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                //System.out.println("Invalid entry");
            }
            if (cost > 0.0) {
                break;
            } else {
                System.out.println("Invalid entry");
            }
        }

        String today;

        while (true) {
            System.out.print("Was it purchased today? Y or N: ");
            today = scanner.nextLine();
            if (today.toLowerCase().equals("y") || today.toLowerCase().equals("yes") ||
                    today.toLowerCase().equals("n") || today.toLowerCase().equals("no")) {
                break;
            } else {
                System.out.println("Invalid response");
            }
        }

        if (today.equals("n") || today.equals("no")) {
            while (true) {
                System.out.println("When was it purchased? ");

                try {
                    System.out.print("\tMonth: ");
                    month = Integer.parseInt(scanner.nextLine());
                    System.out.print("\tDay: ");
                    day = Integer.parseInt(scanner.nextLine());
                    System.out.print("\tYear: ");
                    year = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    //System.out.print("Invalid entry. ");
                }
                if (!(new DateChecker(day, month, year).isDateAccurate())) {
                    System.out.println("invalid date. ");
                } else {
                    date = LocalDate.of(year, month, day);
                    break;
                }
            }
        } else {
            date = LocalDate.now();
        }

        purchases.addPurchase(new Purchase(what, type, cost, date, purchases.getPurchases().size() + 1));

    }


    public void changePurchase() {
        if (purchases.isEmpty()) {
            System.out.println("No Purchases found yet.");
            return;
        }

        System.out.println("change");
    }

    public void deletePurchase() {
        if (purchases.isEmpty()) {
            System.out.println("No Purchases found yet.");
            return;
        }

        System.out.println("delete");
    }

    public void sortPurchase() {
        if (purchases.isEmpty()) {
            System.out.println("No Purchases found yet.");
            return;
        }

        printMenu("sort");
        int sortMenu = 0;

        while (sortMenu <= 0 || sortMenu > 5) {
            try {
                sortMenu = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid entry");
            }
        }
        switch (sortMenu) {
            case 1:
                purchases.sortByName();
                break;
            case 2:
                purchases.sortByType();
                break;
            case 3:
                purchases.sortByDate();
                break;
            case 4:
                break;
            case 5:
                System.exit(0);

        }
    }

    public void viewPurchases() {
        if (purchases.isEmpty()) {
            System.out.println("No Purchases found yet.");
            return;
        }

        for (Purchase p : purchases.getPurchases()) {
            System.out.println(p);
        }
        System.out.println();

    }


}
