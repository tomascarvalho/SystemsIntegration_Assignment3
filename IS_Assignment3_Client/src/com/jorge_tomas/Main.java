package com.jorge_tomas;

import artifact.ManagementWeb;
import artifact.ManagementWebService;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    private static String inputEmail() {
        String email;
        Scanner sc = new Scanner(System.in);

        System.out.print("Email: ");
        email = sc.nextLine();
        System.out.println(); //aesthetic new line

        while (!validate(email)){ // While email not valid
            System.out.println("Please enter a valid email!");
            System.out.print("Email: ");
            email = sc.nextLine();
            System.out.println(); //aesthetic new line
        }
        email = email.toLowerCase();
        return email;
    }

    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1 - Add follower");
        System.out.println("2 - List followers");
        System.out.println("3 - Remove follower");
        System.out.println("\n0 - Exit");
        System.out.print("Choice: ");
    }

    public static void main(String[] args) {
	    // write your code here
        ManagementWebService managementWebService = new ManagementWebService();
        ManagementWeb managementWeb = managementWebService.getManagementWebPort();
        String email, brand;
        int priceMin, priceMax;

        String choice = new String();
        Scanner sc = new Scanner(System.in);

        displayMenu();
        choice = sc.nextLine();
        System.out.println(); //aesthetic new line


        while (!choice.equals("0")){
            switch(choice) {
                case "1":

                    email = inputEmail();
                    System.out.print("Brand: ");
                    brand = sc.nextLine();
                    System.out.println(); //aesthetic new line
                    brand = brand.toLowerCase();

                    System.out.println("Price Range");
                    do {
                        System.out.print("Please enter the lower bound. It should be an integer, greater than 0: ");
                        System.out.println(); //aesthetic new line
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a number!");
                            sc.next(); // this is important!
                        }
                        priceMin = sc.nextInt();
                    } while (priceMin < 0);

                    do {
                        System.out.print("Please enter the upper bound. It should be an integer, greater or equal to lower bound: ");
                        System.out.println(); //aesthetic new line
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a number!");
                            sc.next(); // this is important!
                        }
                        priceMax = sc.nextInt();
                    } while (priceMax < priceMin);

                    System.out.println(managementWeb.addFollower(email, brand, priceMin, priceMax));
                    break;

                case "2":
                    System.out.println(managementWeb.listFollowers());
                    break;
                case "3":
                    System.out.println("To remove a follower, enter his email");
                    email = inputEmail();
                    System.out.println(managementWeb.removeFollower(email));
                    break;
                default:
                    System.out.println("Invalid input!");
            }
            displayMenu();
            choice = sc.nextLine();
            System.out.println(); //aesthetic new line

        }
    }
}
