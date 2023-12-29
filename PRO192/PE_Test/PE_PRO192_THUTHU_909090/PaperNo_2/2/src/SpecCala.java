/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sheep
 */
public class SpecCala extends Cala {
    private int color;

    public SpecCala() {
    }

    public SpecCala(int color) {
        this.color = color;
    }

    public SpecCala(int color, String owner, int price) {
        super(owner, price);
        this.color = color;
    }
    public void setData() {
        String A = super.getOwner().replace(super.getOwner().substring(1, 2), "XX");
        super.setOwner(A);
    }
    public int getValue() {
        if(color % 2 == 0) 
            return super.getPrice()+3;
        else 
            return super.getPrice()+7;
    }

    @Override
    public String toString() {
        return super.getOwner()+ ", "+ super.getPrice()+ ", " + color;
    }
    
}
