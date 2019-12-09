package src.main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BreadthFirstSearch {
    public static ArrayList<Arc> generateTree(Graph graph, int s) {
        ArrayList<Arc> listToReturn = new ArrayList<>();
        LinkedList<Integer> parcoursSommets = new LinkedList<>();
        ArrayList<String> couleurs = new ArrayList<>();
        for (int i = 0 ; i < graph.order ; ++i){
            couleurs.add("BLANC");
        }
        parcoursSommets.addLast(s);
        couleurs.set(s,"GRIS");
        while (parcoursSommets.size() != 0){
            s = parcoursSommets.removeFirst();
            for (Arc voisin : graph.outNeighbours(s)) {
                //System.out.println(graph.outNeighbours(s));
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


    public static ArrayList<Edge> generateRandomTree(Graph graph) {
        ArrayList<Edge> listToReturn = new ArrayList<>();
        LinkedList<Integer> parcoursSommets = new LinkedList<>();
        ArrayList<String> couleurs = new ArrayList<>();

        for (int i = 0 ; i < graph.order ; ++i){
            couleurs.add("BLANC");
            parcoursSommets.addLast(i);
        }

        Collections.shuffle(parcoursSommets);
        int s = parcoursSommets.removeFirst();
        parcoursSommets = new LinkedList<>();

        parcoursSommets.addLast(s);
        couleurs.set(s,"GRIS");

        while (parcoursSommets.size() != 0){
            Collections.shuffle(parcoursSommets);
            s = parcoursSommets.removeFirst();

            for (Edge voisin : graph.neighbours(s)) {
                if (couleurs.get(voisin.getDest()).equals("BLANC")){
                    parcoursSommets.addLast(voisin.getDest());
                    couleurs.set(voisin.getDest(),"GRIS");
                    listToReturn.add(voisin);
                }

                if (couleurs.get(voisin.getSource()).equals("BLANC")){
                    parcoursSommets.addLast(voisin.getSource());
                    couleurs.set(voisin.getSource(),"GRIS");
                    listToReturn.add(voisin);
                }
            }
            couleurs.set(s,"NOIR");
        }

        return listToReturn;
    }
}
