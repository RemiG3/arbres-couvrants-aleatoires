package src.main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import static java.lang.System.exit;

public class AldousBroder {

    public static ArrayList<Edge> aldousBroder(Graph graph) {
        ArrayList<Edge> listToReturn = new ArrayList<>();
        LinkedList<Edge> sommetsToReturn = new LinkedList<>();
        LinkedList<Edge> sommets = new LinkedList<>();
        LinkedList<Edge> voisins = new LinkedList<>();

        System.out.println("IN : " + graph.order);

        for (Edge edge : graph){
            sommets.add(edge);
        }

        Collections.shuffle(sommets);
        Edge sommetActuel = sommets.removeFirst();
        sommetsToReturn.add(sommetActuel);

        while(sommets.size() > 0){

            for(Edge edge : graph.neighbours(sommetActuel.getDest())){
                if((! sommetsToReturn.contains(edge)) && (! voisins.contains(edge)))
                    voisins.add(edge);
            }

            for(Edge edge : graph.neighbours(sommetActuel.getSource())){
                if((! sommetsToReturn.contains(edge)) && (! voisins.contains(edge)))
                    voisins.add(edge);
            }


            Collections.shuffle(voisins);
            sommetActuel = voisins.removeFirst();
            sommets.remove(sommetActuel);
            sommetsToReturn.add(sommetActuel);
            System.out.println(voisins.size());
        }

        System.out.println("OUT : " + sommetsToReturn.size());
        System.out.println("OUT : " + listToReturn.size());
        System.out.println(sommetActuel.toString());
        exit(0);


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

        return listToReturn;
    }

}
