/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class MyClass implements IProcess {

    @Override
    public int countWords(String str1, String str2) {
        String[] str1Words = str1.split("\\s+");
        String[] str2Words = str2.split("\\s+");
        int count = 0;
        for (String str1word : str1Words) {
            for (String str2word : str2Words) {
                if (str1word.equalsIgnoreCase(str2word)) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public String getLastWord(String str) {
        String[] words = str.split("\\s+");
        String result = words[words.length - 1];
        return result.replaceFirst("^\\w", Character.toString(result.charAt(0)).toUpperCase());
    }
}
