/**************************************************************/
/* Author: Elijah Rosal
/* Student ID: 07103992
/* CS 3310, Spring 2025
/* Programming Assignment 1
/* Graph class: Represents an undirected graph using an adjacency list
/**************************************************************/

import java.util.*;

public class Graph {
    private final int vertices; // Number of vertices in the graph
    private final List<List<Integer>> adjList; // Adjacency list representation of the graph

    /**************************************************************/
    /* Constructor: Graph
    /* Purpose: Initializes a graph with a given number of vertices
    /* Parameters:
    /* int vertices - The number of vertices in the graph */
    /* Returns: None
    /**************************************************************/
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    /**************************************************************/
    /* Method: addEdge 
    /* Purpose: Adds an undirected edge between two vertices 
    /* Parameters:
    /* int u - The first vertex of the edge 
    /* int v - The second vertex of the edge 
    /* Returns: None
    /**************************************************************/
    public void addEdge(int u, int v) {
        adjList.get(u - 1).add(v - 1);
        adjList.get(v - 1).add(u - 1);
    }

    /**************************************************************/
    /* Method: getConnectedComponents
    /* Purpose: Finds all connected components in the graph using DFS
    /* Parameters: None
    /* Returns: List<Set<Integer>> - A list of connected components
    /**************************************************************/
    public List<Set<Integer>> getConnectedComponents() {
        boolean[] visited = new boolean[vertices];
        List<Set<Integer>> components = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                Set<Integer> component = new HashSet<>();
                dfs(i, visited, component);
                components.add(component);
            }
        }
        return components;
    }

    /**************************************************************/
    /* Method: dfs
    /* Purpose: Recursively explores the graph to find connected components
    /* Parameters:
    /* int node - The current node being explored
    /* boolean[] visited - An array tracking visited nodes
    /* Set<Integer> component - The current connected component being built
    /* Returns: None
    /**************************************************************/
    private void dfs(int node, boolean[] visited, Set<Integer> component) {
        visited[node] = true;
        component.add(node + 1); // Convert back to 1-based index for output
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, component);
            }
        }
    }
}
