/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Square extends Rectangle {

    String unit;

    public Square(int side) {
        super(side, side);
        this.unit = "cm";
    }

    public void setSquare(int side) {
        if (side > 0) {
            super.setLength(side);
            super.setWidth(side);
        }
    }

    public int getPerimeter() {
        return (this.getLength() + this.getWidth()) * 2;
    }

    public void output() {
        System.out.println("the side of the square=" + this.getLength() + "(" + this.unit + ")\n");
        System.out.println("the perimeter of the square=" + this.getPerimeter() + "(" + this.unit + ")");
    }
}
