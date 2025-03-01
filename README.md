## Author
Elijah Rosal  
CS 3310, Spring 2025  
Programming Assignment 1  

## Description
This Java program reads an undirected graph from a file, determines its connected components using Depth-First Search, and outputs the result. Each line in the input file represents a separate graph, where the first number indicates the number of vertices, followed by pairs of vertices representing edges.

## Files
- `Prog1.java` – Main class that reads input and runs the program.
- `Graph.java` – Represents an undirected graph and finds connected components.
- `GraphTraversal.java` – Utility class for parsing and processing graphs.

## How to Compile
Open a terminal and navigate to its directory. Then, run:
```bash
javac Graph.java GraphTraversal.java Prog1.java

## How to Run
```bash
java Prog1 <your_filename>.txt