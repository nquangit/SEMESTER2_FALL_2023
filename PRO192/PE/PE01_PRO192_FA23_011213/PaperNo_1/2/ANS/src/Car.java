/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Car {

    String name;
    double price;

    public Car() {
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s, %.2f", this.name, this.price);
    }
}
