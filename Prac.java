import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Prac {
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> list = new HashMap<>();
        list.put(1,1343);
        list.put(2,2324);
        list.put(3,3445);
        list.put(4,400);
        list.put(5,list.getOrDefault(5, 0)+1);

        for(Map.Entry<Integer, Integer> entry : list.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue()); 
        }

        list.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
        

       




    }
}
