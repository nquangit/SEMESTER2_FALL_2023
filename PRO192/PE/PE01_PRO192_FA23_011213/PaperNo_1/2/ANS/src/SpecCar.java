/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class SpecCar extends Car {

    int warranty;

    public SpecCar() {
    }

    public SpecCar(String name, double price, int warranty) {
        super(name, price);
        this.warranty = warranty;
    }

    public int getWarranty() {
        if (this.getName().equalsIgnoreCase("Audi")) {
            return this.warranty + 5;
        }
        return this.warranty + 2;
    }

    @Override
    public String toString() {
        return String.format("%s, %.2f, %d", this.getName().toUpperCase(), this.getPrice(), this.warranty);

    }
}
