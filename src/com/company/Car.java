package com.company;

import java.util.*;

public final class Car extends Vehicle {


    //quantity
    public static int Quantity=0;

    //


    public Car() {

    }

    public Car(String vin_) {
        super.setVin(vin_);
    }

    public Car addCar() {
        Car car = new Car();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter VIN number: ");
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

    protected String itemName;

    protected int itemQuantity;









}



