package src.main.java;

import java.util.*;

import static java.lang.System.exit;

public class Kruskal {

    public static ArrayList<Edge> kruskal(Graph graph){
        LinkedList<Edge> edgeList = new LinkedList<>();
        ArrayList<Integer> sommetsAjoutes = new ArrayList<>();
        ArrayList<Edge> arbreCouvrant = new ArrayList<>();

        for (LinkedList<Edge> listEdgesByVertex : graph.adjacency) {
            edgeList.addAll(listEdgesByVertex);
        }

        Collections.sort(edgeList);

        while(!edgeList.isEmpty()){
            Edge currentEdge = edgeList.removeFirst();
            if (!sommetsAjoutes.contains(currentEdge.dest) && !sommetsAjoutes.contains(currentEdge.source)){
                sommetsAjoutes.add(currentEdge.dest);
                sommetsAjoutes.add(currentEdge.source);
                arbreCouvrant.add(currentEdge);
            }
            else if(!sommetsAjoutes.contains(currentEdge.dest)) {
                sommetsAjoutes.add(currentEdge.dest);
                arbreCouvrant.add(currentEdge);
            }
            else if(!sommetsAjoutes.contains(currentEdge.source)) {
                sommetsAjoutes.add(currentEdge.source);
                arbreCouvrant.add(currentEdge);
            }

            else if (sommetsAjoutes.contains(currentEdge.dest) && sommetsAjoutes.contains(currentEdge.source)){
                ArrayList<Edge> temporaryArbreCouvrant = new ArrayList<>(arbreCouvrant);
                if (!containsCycle(temporaryArbreCouvrant,currentEdge,graph))
                    arbreCouvrant.add(currentEdge);
            }
        }

        return arbreCouvrant;
    }

    private static int findSubset(int[] parent, int i){
        if (parent[i] == -1){
            return i;
        }
        return findSubset(parent,parent[i]);
    }

    private static void uniteSubsets(int[] parent, int x, int y){
        int xset = findSubset(parent,x);
        int yset = findSubset(parent,y);
        parent[xset] = yset;
    }

    public static boolean containsCycle(ArrayList<Edge> temporaryArbreCouvrant, Edge currentEdge, Graph graph) {
        temporaryArbreCouvrant.add(currentEdge);

        int[] parent = new int[graph.order];

        for (int i=0; i<graph.order; ++i)
            parent[i]=-1;

        for (Edge edge : temporaryArbreCouvrant)
        {
            int x = findSubset(parent, edge.source);
            int y = findSubset(parent, edge.dest);

            if (x == y)
                return true;
            uniteSubsets(parent, x, y);
        }
        return false;
    }

}
