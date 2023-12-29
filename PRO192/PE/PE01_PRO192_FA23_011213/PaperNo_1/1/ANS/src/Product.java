/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Product {

    int id;
    String name;
    double price;
    int quantity;
    int discount;

    public Product() {
    }

    public Product(int id, String name, double price, int quantity, int discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public void setDiscount(int discount) {
        this.discount = (discount > 0) ? discount : 0;
    }

    @Override
    public String toString() {
        double subTotal;
        subTotal = this.quantity * this.price * (100.0f - this.discount) / 100;
        return String.format("%d,%s,%.2f,%d,%.2f", this.id, this.name, this.price, this.quantity, subTotal);
    }
}
