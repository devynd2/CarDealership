/*
Project: Car Dealership
Purpose Details: The Truck class is a child of the Vehicle class. It contains setters, getters, and methods that add, modify, remove, and search for trucks in the dealership inventory.
Course: IST 242 - 001
Team: 2
Date Developed: 2/15/2019
Last Date Changed: 4/28/2019
Rev: 1
*/

package edu.psu.ist.ab.ist242.team2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

import java.util.ArrayList;

/**
 * <h1>Trucks</h1>
 *<p>
 * The Truck class is a child of the Vehicle class.
 * It contains setters, getters, and methods that add, modify,
 * remove, and search for trucks in the dealership inventory.
 *</p>
 *
 */


public final class Truck extends Vehicle {

    /**
     * Truck tonage
     */
    private Ton tonage;



// Constructor

    /**
     * Truck constructor
     * @param _Vin VIN
     */
    public Truck(String _Vin) {
        setVin (_Vin);
    }

    /**
     * Truck constructor
     */
    public Truck() {

    }

    /**
     * addTruck method adds a new truck to the inventory
     * <p>
     *   The addTruck method prompts user to enter
     *   a truck VIN, model, maker, year, color, and price,
     *   to be stored in the inventory.
     * </p>
     * @return a truck object
     */
    public Truck addTruck() {
        Truck truck = new Truck ();
        Scanner scnr = new Scanner (System.in);
        System.out.println("Enter Dealership ID: ");
        truck.setDealershipID(scnr.nextInt());
        System.out.println ("Please enter VIN number: ");
        truck.setVin (scnr.nextLine ());
        System.out.println ("Please enter truck model: ");
        truck.setModel (scnr.nextLine ());
        System.out.println ("Please enter truck maker: ");
        truck.setMaker (scnr.nextLine ());
        System.out.println ("Please enter truck year: ");
        String _year = testInt(getInput());
        year = Integer.parseInt(_year);
        truck.setYear(year);
        truck.setTon();
        truck.setNumOfDoors();
        System.out.println ("Please enter truck color: ");
        truck.setColor (scnr.nextLine ());
        System.out.println("Please enter truck price: ");
        price = Double.parseDouble(getInput());
        String _price = testDouble(getInput());
        price = Double.parseDouble(_price);
        truck.setPrice(price);

        return truck;
    }

    /**
     * Truck tonage setter
     * @param _tonage
     */

    public void setTon (Ton _tonage){
        tonage = _tonage;
    }

    /**
     * Truck tonage getter
     * @return tonage
     */
    public Ton getTon () {
            return tonage;
        }

    /**
     * move method sets wheeldrive
     */
    public void move () {
        setWheeldrive (Wheeldrive.four);
    }

    /**
     * setTon prompts user for an input
     *
     * <p>
     * setTon method asks for user input to set truck tonage
     * and converts the input to lowercase to assure it matches
     * the Ton enum values.
     * <p>
     *
     * @return tonage object
     */
        public Ton setTon() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter tonage ('one' / 'two'): ");
        tonage = Ton.valueOf(input.next().toLowerCase());
        return tonage;
    }

    /**
     * <p>
     * printTrucks method have a for each method to
     * print out all trucks' name, vin number, module, maker, color
     * that are in the inventory on certain format
     * <p>
     *
     *@param truckArrayList
     */
    public static void printTrucks(ArrayList<Truck> truckArrayList) {
        for (Truck truck : truckArrayList) {
            System.out.printf("%-10s | %-10s | %-12s | %-10s | %-10s | %-12s\n", truck.getName(), truck.getVin(), truck.getModel(), truck.getMaker(), truck.getColor(), truck.getYear());

        }
    }

    /**
     *
     * sellTruck method removes a truck item from the truck array list
     * @param trucksList truck Array List
     * @param _VIN Vehicle Identification Number
     * @throws ConcurrentModificationException if VIN does not correspond
     *                                         to any truck in the inventory
     *
     */
    public static void sellTruck(ArrayList<Truck> trucksList, String _VIN) {
        try {
            for (Truck truck : trucksList) {

                if (truck.getVin().equals(_VIN)) {

                    trucksList.remove(truck);
                }
            }
        }
        catch (ConcurrentModificationException e){
            System.out.println("Invalid input. Make sure you entered the correct VIN.");
            sellTruck(trucksList, _VIN);
        }

    }

    /**
     * getInput method prompts user for an input
     *
     * <p>
     *  This method is used inside the addCar method to
     *  ask for truck information and then through setters
     *  add that information into the truck array list.
     * </p>
     *
     * @return input
     */
    public static String getInput() {
        Scanner scnr = new Scanner(System.in);
        String input = scnr.nextLine();
        return input;

    }

    /**
     * testDouble method tests if input is a double
     *
     * <p>
     *  This method consists of a try and catch block
     *  to assure user input for setting an auto part price
     *  is a double.
     * </p>
     *
     * @param price user input
     * @return a price
     * @throws InputMismatchException if input tested is not a double
     *
     */
    public static String testDouble(String price) {
        try {

            if (price.matches("\\d+\\.\\d*$")) {
                return price;
            }
            else  {
                throw new InputMismatchException("not price");
            }

        } catch (InputMismatchException notAnAlpha) {
            System.out.println("Invalid input. Please try again.");
            return getInput();

        }

    }

    /**
     * testInt method tests if input matches numeric characters
     *
     * <p>
     *  This method consists of a try and catch block
     *  to assure user input for setting year contains digits.
     * </p>
     *
     * @param input user input
     * @return year
     * @throws InputMismatchException if input tested is not an integer
     *
     */
    public static String testInt(String input) {
        try {
            if (input.matches("\\d*$")) {
                return input;
            }
            else  {
                throw new NumberFormatException("not an integer");
            }
        } catch (NumberFormatException notAnInt) {
            System.out.println("Invalid input. You did not enter an integer number. Please try again. \n");
            return getInput();
        }
    }
}





