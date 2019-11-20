package src.main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph implements Iterable<Edge>{
    // classe de graphe non orientés permettant de manipuler
    // en même temps des arcs (orientés)
    // pour pouvoir stocker un arbre couvrant, en plus du graphe
    
	int order;
	int edgeCardinality;
	
	ArrayList<LinkedList<Edge>> adjacency;
	ArrayList<LinkedList<Arc>> inAdjacency;
	ArrayList<LinkedList<Arc>> outAdjacency;
	
	public boolean isVertex(int index) {
	    return !(adjacency.get(index) == null) || !(inAdjacency.get(index) == null) || !(outAdjacency.get(index) == null);
	}
	
	public <T> ArrayList<LinkedList<T>> makeList(int size) {
		ArrayList<LinkedList<T>> res = new ArrayList<>(size);
		for(int i = 0; i <= size; i++) {
			res.add(null);			
		}
		return res;
	}
	
	public Graph(int upperBound) {
	    adjacency = makeList(upperBound);
	    inAdjacency = makeList(upperBound);
	    outAdjacency = makeList(upperBound);
	}
	
	public void addVertex(int indexVertex) {
		if (!isVertex(indexVertex))
	    	adjacency.set(indexVertex, null);
	}
	
	public void ensureVertex(int indexVertex) {
	    // à remplir
	}	
	
	public void addArc(Arc arc) {
	    inAdjacency.get(arc.getDest()).add(arc);
	    outAdjacency.get(arc.getSource()).add(arc);
	}
	
	public void addEdge(Edge e) {
	    adjacency.get(e.getSource()).add(e);
	    adjacency.get(e.getDest()).add(e);
	}

	@Override
	public Iterator<Edge> iterator() {
		return null;
	}

	private class EdgeIterator implements Iterator{
		int position = 0;

		@Override
		public boolean hasNext() {
			return position < adjacency.size();
		}

		@Override
		public Object next() {
			if(hasNext())
				return null;
			else
				return null;
		}
	}
}
