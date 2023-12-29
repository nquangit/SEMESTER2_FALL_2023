/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sheep
 */
public class MyString implements IString{

    @Override
    public int f1(String string) {
        int count = 0;
        String[] Test = string.split("\\s+");
        for (String string1 : Test) {
            //kiem tra so chan thi la (?=.*[2468].*).+
            //kiem tra phai so khong thi la (?=.*\\d+.*).+
            //Kiem tra xem phai letter khong thi la (?=.*[a-zA-z].*).+
            if(string1.matches("(?=.*[13579].*).+"))
                count++;
        }
        return count;
    }

    @Override
    public String f2(String string) {
        String[] array = string.split("\\s+");
        boolean isHas = false;
        String found = null;
        for (int i = 0; i < array.length; i++) {
        if (isPalindrome(array[i])) {
            found = array[i];
            isHas = true;
            array[i] = "YY";
            break;
        }
        }
        if (isHas) {
           string = string.replaceFirst(found, "YY");
        }
        return string;
    }
    public static boolean isPalindrome (String str) {
        int i = 0, j = str.length() -1;
        while (i<j) {
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        i++;
        j--;
        }
        return true;
    }
}
