package com.company;

import java.util.*;

public final class Car extends Vehicle {


    NumDoors numOfDoors;
    protected String itemName;

    protected int itemQuantity;


    public static int Quantity=0;

    public Car() {

    }

    public Car(String vin_) {
        super.setVin(vin_);
    }


    /**
     * addCar method adds a new car to the inventory
     * <p>
     *   The addCar method prompts user to enter
     *   a car VIN, model, maker, year, color, and price,
     *   to be stored in the inventory.
     * </p>
     * @return a Car object
     */

    public Car addCar() {
        Car car = new Car();
        Scanner scnr = new Scanner(System.in);

        // try and catch ??

        // ask for dealership id

        System.out.println("Enter Dealership ID: ");
        car.setDealershipID(scnr.nextInt());

        System.out.println("Please enter VIN number: ");
        car.setVin(scnr.next());

        System.out.println("Please enter car model: ");
        model = testAlpha(getInput());
        car.setModel(model);

        System.out.println("Please enter car maker: ");
        maker = testAlpha(getInput());
        car.setMaker(maker);

        System.out.println("Please enter car year: ");
        String _year = testInt(getInput());
        year = Integer.parseInt(_year);
        car.setYear(year);

        car.setNumOfDoors();

        //scnr.nextLine(); //IMPORTANT: do not remove, needed so that setColor works properly

        System.out.println("Please enter car color: ");
        color = testAlpha(getInput());
        car.setColor(color);

        System.out.println("Please enter car price: ");
        String _price = testDouble(getInput());
        price = Double.parseDouble(_price);
        car.setPrice(price);

        return car;
    }


    public void setQuantity(int newQty) {
        itemQuantity = newQty;
    }

    public void printCars() {
        System.out.println(itemName + " " + itemQuantity);
    }

    @Override
    protected void setDoors() {

    }


    /**
     * printCars method prints car inventory list
     * @param carList car list Array List
     */
    public static void printCars(ArrayList<Car> carList) {
        for (Car car : carList) {
            System.out.printf("%-10s | %-10s | %-12s | %-10s | %-10s | %-12s | %-10s \n", car.getName(), car.getVin(), car.getModel(), car.getMaker(), car.getColor(), car.getYear(), car.getPrice());

        }
    }

    // methods to print specific car types by color, year, maker


    /**
     * printCarsByColor method prints cars that are of a certain color
     * @param carList car Array List
     * @param _color a specific car color
     */
    public static void printCarByColor(ArrayList<Car> carList, String _color) {
        for (Car car : carList) {

            // cannot use super.color from a non static context, so added String color to Car class

            if (car.color.equals(_color)) {
               // System.out.printf("%-10s | %-10s | %-12s | %-10s | %-10s\n", car.getVin(), car.getYear(), car.getMaker(), car.getModel(), car.getName());
                System.out.println(" Car VIN number: " + car.getVin() + " Car color: " + car.getColor() + " Car Maker: " + car.getMaker() + " Car Model: " + car.getModel());
            }
        }
    }

    /**
     * printCarsByNumDoors method prints cars by number of doors
     * @param carList car Array List
     * @param _doors number of doors
     */

    public static void printCarByNumDoors(ArrayList<Car> carList, NumDoors _doors) {
        for (Car car : carList) {

            if (car.numOfDoors.equals(_doors)) {
                // System.out.printf("%-10s | %-10s | %-12s | %-10s | %-10s\n", car.getVin(), car.getYear(), car.getMaker(), car.getModel(), car.getName());
                System.out.println("Car VIN number:" + car.getVin() + " Car color:" + car.getColor());
            }
        }
    }

    /**
     * printCarsByMaker method prints cars by their maker
     * @param carList car Array List
     * @param _maker car maker
     */

    public static void printCarByMaker(ArrayList<Car> carList, String _maker) {
        for (Car car : carList) {

            if (car.maker.equals(_maker)) {
                // System.out.printf("%-10s | %-10s | %-12s | %-10s | %-10s\n", car.getVin(), car.getYear(), car.getMaker(), car.getModel(), car.getName());
                System.out.println("Car VIN number:" + car.getVin() + " Car color:" + car.getColor());
            }
        }
    }

    /**
     *
     * printCarsByModel method prints cars by model
     * @param carList car Array List
     * @param _model car model type
     *
     */

    public static void printCarByModel(ArrayList<Car> carList, String _model) {
            for (Car car : carList) {

                if (car.maker.equals(_model)) {
                    // System.out.printf("%-10s | %-10s | %-12s | %-10s | %-10s\n", car.getVin(), car.getYear(), car.getMaker(), car.getModel(), car.getName());
                    System.out.println("Car VIN number:" + car.getVin() + " Car color:" + car.getColor());
                }
            }
    }

    /**
     *
     * sellCar method removes a car item from the car array list
     * @param carList car Array List
     * @param _VIN Vehicle Identification Number
     * @throws ConcurrentModificationException if VIN does not correspond
     *                                         to any car in the inventory
     *
     */

    public static void sellCar(ArrayList<Car> carList, String _VIN) {

        try {
            for (Car car : carList) {

                if (car.getVin().equals(_VIN)) {

                    carList.remove(car);
                }
            }
        }
        catch (ConcurrentModificationException e) {
            System.out.println("Invalid input. Make sure you entered the correct VIN.");
            sellCar(carList, _VIN);
            }
        }


    public static String getInput() {
        Scanner scnr = new Scanner(System.in);
        String input = scnr.nextLine();
        return input;

    }
    /**
     * testAlpha method tests if input contains alpha characters
     *
     * <p>
     *  This method consists of a try and catch block
     *  to assure user input contains only alpha characters.
     * </p>
     *
     * @param alphaCharacter user input
     * @return a String of alpha characters
     * @throws InputMismatchException if string tested does not contain
     *                                alpha characters
     *
     */

    public static String testAlpha(String alphaCharacter) {
        try {

            if (alphaCharacter.matches("^[a-zA-Z]*$")) {
                return alphaCharacter;
            }
            else  {
                throw new InputMismatchException("not alpha");
            }

        } catch (InputMismatchException notAnAlpha) {
            System.out.println("Invalid input. Please try again.");
            return getInput();

        }

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






