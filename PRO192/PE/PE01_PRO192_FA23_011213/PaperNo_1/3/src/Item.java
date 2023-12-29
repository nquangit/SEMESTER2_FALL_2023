/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Item {

    String name;
    int quantity;

    public Item() {
    }

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        String output;
        output = String.format("%s, %d", this.getName(), this.quantity);
        return output;
    }
}
