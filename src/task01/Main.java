package task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        //File file = new File("C:\\Users\\mahes\\Ibfwork\\Task1\\cat_in_the_hat.txt");

       //File name will be typed in after the 
       String file = "";
       if(args.length>0){
           file = args[0];
       }
       System.out.println("The file name entered is: " + file);
       BufferedReader br = new BufferedReader(new FileReader(file));
       HashMap<String, Integer> map = new HashMap<>();
       String line;

       while ((line = br.readLine()) != null) {
           // System.out.println(line);

           // to replace all the punctuation that you dont want with white space
           line = line.replaceAll("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]", "").trim();

           // to replace all the white spaces
           String[] words = line.split(" ");

           // to put the words as a key and then assosciate with the value
           for (String word : words) {
               word = word.toLowerCase();
               if (map.containsKey(word)) {
                   map.put(word, map.get(word) + 1);
               } else {
                   map.put(word, 1);
               }
           }
           
       }

       // to print out all the frequencies

       // //for (String word : map.keySet()) {
       //     System.out.println(word + "- " + map.get(word));
       // }

       //Frequencies in descending order
       //Sorry teacher i dont know how to give top 10 I hope this is enough
       LinkedHashMap<String, Integer> descend = new LinkedHashMap<>();
       map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
               .forEachOrdered(x -> descend.put(x.getKey(), x.getValue()));

               System.out.println("Most frequent to least frequent: " + descend);
               br.close();
   }
    
}
