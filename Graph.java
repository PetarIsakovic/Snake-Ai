import java.util.HashMap;
import java.util.ArrayList;

public class Graph {

    HashMap<String, ArrayList<String>> graph = new HashMap<>();

    public Graph(){
    }

    public void addVertex(String key){

        if(!graph.containsKey(key)){
            graph.put(key, new ArrayList<String>());
        }

    }

    public void addEdge(String key1, String key2){

        addVertex(key1);
        addVertex(key2);

        graph.get(key1).add(key2);

    }

}
