package src.main.java;

import java.util.*;

public class Prim {

    public static ArrayList<Edge> newPrim(Graph graph, int s){
        LinkedList<Edge> priorityList = new LinkedList<>();
        ArrayList<Edge> arbreCouvrant = new ArrayList<>();
        List<Integer> sommetsAjoutes = new ArrayList<>();
        priorityList.addAll(graph.neighbours(s));
        sommetsAjoutes.add(s);

        //Edge edgeMin = null;
        while(sommetsAjoutes.size() != graph.order){
            Edge edgeMin = extractMin(priorityList,sommetsAjoutes);
            arbreCouvrant.add(edgeMin);
            sommetsAjoutes.add(edgeMin.dest);
            for (Edge edge : graph.neighbours(edgeMin.dest)) {
                if (!sommetsAjoutes.contains(edge.dest)) {
                    priorityList.add(edge);
                }
            }
        }
        //arbreCouvrant.add(edgeMin);
        return arbreCouvrant;
    }

    private static Edge extractMin(LinkedList<Edge> priorityList, List<Integer> sommetDejaPresents){
        Edge edgeMin = new Edge(0,0,Double.MAX_VALUE);
        for (Edge edge : priorityList) {
            if (edge.weight < edgeMin.weight && !sommetDejaPresents.contains(edge.dest)){
                edgeMin = edge;
            }
        }
        return edgeMin;
    }


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

            if(edgeCoutMin.dest != -1){
                //System.out.println(edgeCoutMin.dest);
                //System.out.println(sommetsAjoutables.toString());
                sommetsAjoutables.remove((Integer) edgeCoutMin.dest);
                sommetsAjoutes.add(edgeCoutMin.dest);
                arbreCouvrant.add(edgeCoutMin);
            } else {
                break;
            }
        }
        return arbreCouvrant;
    }
}
