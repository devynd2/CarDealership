package com.company;


import java.util.Scanner;

import java.util.ArrayList;

public class Parts {


    private int partID;
    private String name;
    private PartsCategory partCategory;


    // constructors

    public Parts() {

    }

    public Parts(int _partID, PartsCategory _partCategory, String _name) {
        this.name = _name;
        this.partCategory = _partCategory;
        this.partID = _partID;

    }

    /**
     * addParts method adds parts to inventory               (1)
     * <p>
     * Longer description. If there were any, it would be    (2)
     * here.
     * </p>
     *
     * @return parts object of the Parts class
     */

    public Parts addParts() {
        Parts parts = new Parts();
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter part name: ");
        parts.setPartName(scnr.nextLine());
        parts.setCategory();
        return parts;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int randomID) {
        this.partID = randomID;
    }

    public PartsCategory getPartCategory() {
        return partCategory;
    }

    /*
        public void setPartCategory(String anyPartCategory) {
            this.partCategory = anyPartCategory;
        }
    */
    public String getPartName() {
        return name;
    }

    public void setPartName(String anyName) {
        this.name = anyName;
    }

    public PartsCategory setCategory() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Parts Type: ");
        partCategory = PartsCategory.valueOf(input.next().toLowerCase());
        // add if statement for cash payment to calculate change
        return partCategory;
    }

    public static void printParts(ArrayList<Parts> PartsArrayList) {
        for (Parts parts : PartsArrayList) {
            System.out.printf("%-10s | %-10s | %-12s | %-10s | %-10s | %-12s\n", parts.getPartName());

        }
    }
}











