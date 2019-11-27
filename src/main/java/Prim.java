package src.main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Prim {

    public static ArrayList<Edge> prim(Graph graph, int s){
        List<Integer> sommetsAjoutables = new LinkedList<>();
        List<Integer> sommetsAjoutes = new LinkedList<>();
        ArrayList<Edge> arbreCouvrant = new ArrayList<>();
        for (int i = 0 ; i < graph.order ; ++i){
            sommetsAjoutables.add(i);
        }
        sommetsAjoutables.remove(s);
        sommetsAjoutes.add(s);
        while (sommetsAjoutables.size() != 0){
            Edge edgeCoutMin = new Edge(-1,-1,Double.POSITIVE_INFINITY);
            for (Integer sommet : sommetsAjoutes){
                for (Edge edge : graph.neighbours(sommet)) {
                    if (sommetsAjoutables.contains(edge.getDest())){
                        if(edge.weight < edgeCoutMin.weight){
                            edgeCoutMin = edge;
                        }
                    }
                }
            }
            System.out.println(edgeCoutMin.dest);
            System.out.println(sommetsAjoutables.toString());
            sommetsAjoutables.remove((Integer) edgeCoutMin.dest);
            sommetsAjoutes.add(edgeCoutMin.dest);
            arbreCouvrant.add(edgeCoutMin);
        }
        return arbreCouvrant;
    }
}
