package src.main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import static java.lang.System.exit;

public class AldousBroder {

    public static ArrayList<Edge> aldousBroder(Graph graph) {
        ArrayList<Edge> listToReturn = new ArrayList<>();
        ArrayList<Integer> sommetsToReturn = new ArrayList<>();
        LinkedList<Edge> sommets = new LinkedList<>();
        LinkedList<Edge> voisins = new LinkedList<>();

        for (Edge edge : graph){
            sommets.add(edge);
        }

        Collections.shuffle(sommets);
        Edge sommetActuel = sommets.removeFirst();
        listToReturn.add(sommetActuel);
        sommetsToReturn.add(sommetActuel.getDest());

        while(sommetsToReturn.size() < graph.order-1){

            voisins.addAll(graph.neighbours(sommetActuel.getDest()));
            voisins.addAll(graph.neighbours(sommetActuel.getSource()));

            Collections.shuffle(voisins);
            sommetActuel = voisins.removeFirst();

            if(! sommetsToReturn.contains(sommetActuel.getDest())){
                sommetsToReturn.add(sommetActuel.getDest());
                listToReturn.add(sommetActuel);
            }

            voisins = new LinkedList<>();
        }

        return listToReturn;


        /*ArrayList<Edge> listToReturn = new ArrayList<>();
        LinkedList<Integer> sommetsToReturn = new LinkedList<>();
        LinkedList<Integer> sommets = new LinkedList<>();
        LinkedList<Integer> voisins = new LinkedList<>();

        System.out.println("IN : " + graph.order);

        for (int i = 0 ; i < graph.order ; ++i){
            sommets.add(i);
        }

        Collections.shuffle(sommets);
        int sommetActuel = sommets.removeFirst();
        sommetsToReturn.add(sommetActuel);

        while(sommets.size() > 0){

            for(Edge edge : graph.neighbours(sommetActuel)){
                if((! sommetsToReturn.contains(edge.getDest())) && (! voisins.contains(edge.getDest())))
                    voisins.add(edge.getDest());
                if((! sommetsToReturn.contains(edge.getSource())) && (! voisins.contains(edge.getSource())))
                    voisins.add(edge.getSource());
            }


            Collections.shuffle(voisins);
            sommetActuel = voisins.removeFirst();
            sommets.remove((Integer) sommetActuel);
            sommetsToReturn.add(sommetActuel);
        }

        System.out.println("OUT : " + sommetsToReturn.size());
        System.out.println("OUT : " + listToReturn.size());
        exit(0);*/

        //return listToReturn;
    }

}
