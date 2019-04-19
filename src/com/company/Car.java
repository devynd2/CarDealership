package com.company;

import java.util.*;

public final class Car extends Vehicle {


    NumDoors numOfDoors;
    String color;

    public static int Quantity=0;


    public Car() {

    }

    public Car(String vin_) {
        super.setVin(vin_);
    }


    /**
     * addCar method adds a new car to the inventory
     * @return a Car object
     */

    public Car addCar() {
        Car car = new Car();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter VIN number: ");

        // try and catch ??
        car.setVin(scnr.nextLine());
        System.out.println("Please enter car model: ");



        car.setModel(scnr.nextLine());
        System.out.println("Please enter car maker: ");
        car.setMaker(scnr.nextLine());
        System.out.println("Please enter car year: ");
        car.setYear(scnr.nextInt());
        car.setDoors();

        // not working ??
        System.out.println("Please enter car color: ");
        car.setColor(scnr.nextLine());


        return car;
    }


    public void setQuantity(int newQty) {
        itemQuantity = newQty;
    }

    public void printCars() {
        System.out.println(itemName + " " + itemQuantity);
    }


    public String getColor() {
        return color;
    }

    public void setColor(String _Color) {
        this.color = _Color;
    }

    public NumDoors getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(NumDoors _numOfDoors) {
        this.numOfDoors = _numOfDoors;
    }


    protected String itemName;

    protected int itemQuantity;


    /**
     * printCars method prints car inventory list
     * @param carList car list Array List
     */



    public static void printCars(ArrayList<Car> carList) {
        for (Car car : carList) {
            System.out.printf("%-10s | %-10s | %-12s | %-10s | %-10s | %-12s\n", car.getName(), car.getVin(), car.getModel(), car.getMaker(), car.getColor(), car.getYear() );

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
                System.out.println("Car VIN number:" + car.getVin() + " Car color:" + car.getColor());
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

    public static void sellCar(ArrayList<Car> carList, String _VIN) {
        for (Car car : carList) {

            if (car.getVin().equals(_VIN)) {

                carList.remove(car);
            }
        }
    }


}



