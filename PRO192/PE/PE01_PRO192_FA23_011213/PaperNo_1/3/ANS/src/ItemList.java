/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ItemList extends ArrayList<Item> {

    public void addItem(Item item) {
        super.add(item);
    }

    public void printItemByQuantity(int value) {
        Iterator iter = super.iterator();
        while (iter.hasNext()) {
            Item item = (Item) iter.next();
            if (item.getQuantity() == value) {
                System.out.println(item);
            }
        }
    }

    public int getTotalQuantity() {
        Iterator iter = super.iterator();
        int result = 0;
        while (iter.hasNext()) {
            Item item = (Item) iter.next();
            result += item.getQuantity();
        }
        return result;
    }
}
