/**************************************************************/
/* Author: Elijah Rosal
/* Student ID: 07103992
/* CS 3310, Spring 2025
/* Programming Assignment 1
/* GraphTraversal class: Provides utility methods for parsing
/* and analyzing graphs from an input file.
/**************************************************************/

import java.util.*;

public class GraphTraversal {

    /**************************************************************/
    /* Method: parseGraph
    /* Purpose: Parses a line from the input file and creates a graph
    /* Parameters:
    /* String line - A line from the input file describing a graph 
    /* Returns: Graph - The constructed graph object
    /**************************************************************/
    public static Graph parseGraph(String line) {
        String[] parts = line.split(" ");
        int vertices = Integer.parseInt(parts[0]);
        Graph graph = new Graph(vertices);

        for (int i = 1; i < parts.length; i++) {
            String edge = parts[i].substring(1, parts[i].length() - 1); // Remove parentheses
            String[] verticesEdge = edge.split(",");
            int u = Integer.parseInt(verticesEdge[0]);
            int v = Integer.parseInt(verticesEdge[1]);
            graph.addEdge(u, v);
        }

        return graph;
    }

    /**************************************************************/
    /* Method: printConnectedComponents
    /* Purpose: Prints the connected components of a given graph
    /* Parameters:
    /* Graph graph - The graph whose components need to be printed 
    /* int graphNumber - The graph index (for labeling output)
    /* Returns: None
    /**************************************************************/
    public static void printConnectedComponents(Graph graph, int graphNumber) {
        List<Set<Integer>> components = graph.getConnectedComponents();
        int numComponents = components.size();

        System.out.println("Graph" + graphNumber + ":");
        System.out.print(numComponents + (numComponents > 1 ? " connected components: " : " connected component: "));

        for (Set<Integer> component : components) {
            System.out.print(component + " ");
        }

        System.out.println("\n");
    }
}
