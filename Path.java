import java.util.HashMap;
import java.util.ArrayList;;

public class Path {


    HashMap<String, ArrayList<String>> map = new HashMap<>();
    String source;
    String target;
    HashMap<String, Boolean> checked = new HashMap<>();
    HashMap<String, Integer> weight = new HashMap<>();
    HashMap<String, String> prev = new HashMap<>();

    public Path(HashMap<String, ArrayList<String>> map, String source, String target){

        try{
        this.map = map;
        this.source = source;
        this.target = target;

        for(String key: map.keySet()){
            checked.put(key, false);
            weight.put(key, Integer.MAX_VALUE);
            prev.put(key, null);
        }

        weight.put(source, 0);

        while(checked.get(target) == false){

            int smalestValue = Integer.MAX_VALUE;
            String smallestKey = "";

            for(String key: weight.keySet()){

                if(weight.get(key) < smalestValue && checked.get(key) == false){
                    smalestValue = weight.get(key);
                    smallestKey = key;
                }

            }

            for(int i = 0; i < map.get(smallestKey).size(); i++){

                if(checked.get(map.get(smallestKey).get(i)) == false && weight.get(map.get(smallestKey).get(i)) > smalestValue+1){
                    weight.put(map.get(smallestKey).get(i), smalestValue+1);
                    prev.put(map.get(smallestKey).get(i), smallestKey);
                }

            }

            checked.put(smallestKey, true);

        }
    }
    catch(Exception e){}

    }

}