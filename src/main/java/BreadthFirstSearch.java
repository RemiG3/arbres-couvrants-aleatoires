package src.main.java;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {
    public static ArrayList<Arc> generateTree(Graph graph, int s) {
        ArrayList<Arc> listToReturn = new ArrayList<>();
        LinkedList<Integer> parcoursSommets = new LinkedList<>();
        ArrayList<String> couleurs = new ArrayList<>();
        for (int i = 0 ; i < graph.order ; ++i){
            couleurs.set(i,"BLANC");
        }
        parcoursSommets.addLast(s);
        couleurs.set(s,"GRIS");
        while (parcoursSommets.size() != 0){
            s = parcoursSommets.removeFirst();
            for (Arc voisin : graph.outNeighbours(s)) {
                if (couleurs.get(voisin.getDest()).equals("BLANC")){
                    parcoursSommets.addLast(voisin.getDest());
                    couleurs.set(voisin.getDest(),"GRIS");
                    listToReturn.add(voisin);
                }
            }
            couleurs.set(s,"NOIR");
        }
        return listToReturn;
    }
}
