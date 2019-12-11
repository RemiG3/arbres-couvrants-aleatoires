package src.main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ByRemovingCycle {

    public static ArrayList<Edge> byRemovingCycle(Graph graph){
        ArrayList<Edge> arretesParcourus = new ArrayList<>();
        ArrayList<Edge> listToReturn = new ArrayList<>();
        LinkedList<Integer> parcoursSommets = new LinkedList<>();
        LinkedList<Edge> voisins = new LinkedList<>();

        for (int i = 0 ; i < graph.order ; ++i){
            parcoursSommets.addLast(i);
        }

        Collections.shuffle(parcoursSommets);
        int src = parcoursSommets.removeFirst();
        int dst = src;

        while(parcoursSommets.size() > 0){
            voisins.addAll(graph.neighbours(src));
            voisins.addAll(graph.neighbours(dst));
            Collections.shuffle(voisins);

            Edge voisin = voisins.getFirst();
            arretesParcourus.add(voisin);
            voisins = new LinkedList<>();
            src = voisin.getDest();
            dst = voisin.getSource();
            parcoursSommets.remove((Integer) src);
            parcoursSommets.remove((Integer) dst);
        }


        for(Edge edge : arretesParcourus){
            ArrayList<Edge> temporaryArbreCouvrant = new ArrayList<>(listToReturn);
            if ((! Kruskal.containsCycle(temporaryArbreCouvrant,edge,graph))){
                listToReturn.add(edge);
            }
        }

        return listToReturn;
    }

}
