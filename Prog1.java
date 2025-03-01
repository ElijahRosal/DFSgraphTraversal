/**************************************************************/
/* Author: Elijah Rosal
/* Student ID: 07103992
/* CS 3310, Spring 2025
/* Programming Assignment 1
/* Prog1 class: Entry point of the program. Reads graphs from
/* a file and prints their connected components.
/**************************************************************/

import java.io.*;

public class Prog1 {

    /**************************************************************/
    /* Method: main
    /* Purpose: Reads graph data from a file and prints connected components
    /* Parameters:
    /* String[] args - Command-line arguments, expecting a file name
    /* Returns: None
    /**************************************************************/
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Prog1 <input-file>");
            return;
        }

        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                String line;
                int graphCount = 1;
                
                while ((line = reader.readLine()) != null) {
                    Graph graph = GraphTraversal.parseGraph(line);
                    GraphTraversal.printConnectedComponents(graph, graphCount);
                    graphCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
