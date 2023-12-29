
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sheep
 */
public class MyCala implements ICala {

    @Override
    public int f1(List<Cala> t) {
        int count = 0;
        for (Cala cala : t) {
          char A = cala.getOwner().charAt(1);
          if (A >= '0' && A <= '9') 
              count++; 
        }
        return count;
    }

    @Override
    public void f2(List<Cala> t) {
        Cala max = t.get(0);
        for (Cala cala : t) {
            if(max.getPrice() < cala.getPrice())
                max  = cala;
        }
        int count = 0;
        Cala secondMax = null;
        for (Cala cala : t) {
            if(cala.getPrice() == max.getPrice())
                count++;
            if(count == 2) {
                secondMax = cala;
                break;
            }
           
        }
         if(secondMax != null) {
                t.remove(secondMax);
            }
                    
    }

    @Override
    public void f3(List<Cala> list) {
        Collections.sort(list, new Comparator<Cala>() {
            @Override
            public int compare(Cala o1, Cala o2) {
                String firstofo1 = o1.getOwner().substring(1);
                String firstofo2 = o2.getOwner().substring(1);
                return firstofo1.compareTo(firstofo2);
            }
    });
}
}
