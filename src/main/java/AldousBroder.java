package src.main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class AldousBroder {

    public static ArrayList<Edge> aldousBroder(Graph graph) {
        ArrayList<Edge> listToReturn = new ArrayList<>();
        ArrayList<Integer> sommetsToReturn = new ArrayList<>();
        LinkedList<Edge> aretes = new LinkedList<>();
        LinkedList<Edge> voisins = new LinkedList<>();

        for (Edge edge : graph){
            aretes.add(edge);
        }

        Collections.shuffle(aretes);
        Edge aretesActuel = aretes.removeFirst();
        listToReturn.add(aretesActuel);
        sommetsToReturn.add(aretesActuel.getDest());

        while(sommetsToReturn.size() < graph.order-1){

            voisins.addAll(graph.neighbours(aretesActuel.getDest()));
            voisins.addAll(graph.neighbours(aretesActuel.getSource()));

            Collections.shuffle(voisins);
            aretesActuel = voisins.removeFirst();

            if(! sommetsToReturn.contains(aretesActuel.getDest())){
                sommetsToReturn.add(aretesActuel.getDest());
                listToReturn.add(aretesActuel);
            }

            voisins = new LinkedList<>();
        }

        return listToReturn;
    }

}
