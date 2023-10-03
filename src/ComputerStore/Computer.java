package ComputerStore;

import java.util.Scanner;

class Computer {
    private String brand;
    private String model;
    private long sn;
    private double price;
    private static int numberOfCreatedComputers = 0;

    // Constructor
    public Computer(String brand, String model, long sn, double price) {
        this.brand = brand;
        this.model = model;
        this.sn = sn;
        this.price = price;
        numberOfCreatedComputers++;
    }

    // Accessors and Mutators
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getSn() {
        return sn;
    }

    public void setSn(long sn) {
        this.sn = sn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method to display computer information
    @Override
    public String toString() {
        return "Brand: " + brand + "\nModel: " + model + "\nSN: " + sn + "\nPrice: $" + price;
    }

    // Static method to find the number of created Computer objects
    public static int findNumberOfCreatedComputers() {
        return numberOfCreatedComputers;
    }

    // Equals method to compare two Computer objects
    public boolean equals(Computer other) {
        return this.brand.equals(other.brand) && this.model.equals(other.model) && this.price == other.price;
    }
}

