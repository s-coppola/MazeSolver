package hw2;
import hw1.JaggedGridReader;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.Point;
import java.awt.*;
import java.util.*;

public class MazeSolver {
   //an object for reading files into a 2-D array.
   
   //6 final char fields to define the characters representing the maze:
      private final char open = '.';
      private final char blocked = '#';
      private final char start = 'S'; 
      private final char goal = 'G';
      private final char marked = '+';
      private final char unmarked = 'x';
      
      //maze: the two dimensional char array that holds the current maze.
      private char[][] maze; 
      
      //mazePath: the solution to the maze after solving the maze or null if the maze is unsolved.
      private ArrayList<String> mazePath = new ArrayList<String>();
      
      //numCellsVisited: the number of cells visited for the current maze solved.
      private int numCellsVisited;
      private int mazesSolved; //mazesSolved: the number of mazesSolved
      private int mazesTried; //mazesTried: the number of mazesTried
      private int startX;
      private int startY;        
    
    public boolean solveMaze(char[][] maze) {
      this.maze = maze;
        mazesTried++;
        mazePath.clear();
        numCellsVisited = 0;
        startX = findStart()[0];
        startY = findStart()[1];
        return findPath(startX,startY);
    }
    

    private int[] findStart() {
        int[] result = new int[2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == start) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
    
    private boolean findPath(int x, int y) {  
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == blocked || maze[x][y] == marked) {
            return false;
        }
        if (maze[x][y] == goal) {
            mazesSolved++;
            return true;
        } else {
            maze[x][y] = marked;
            numCellsVisited++;
            if (findPath(x,y+1)) {
                mazePath.add("East");
                numCellsVisited++;
                return true;
            }
            if (findPath(x+1,y)) {
                mazePath.add("South");
                numCellsVisited++;
                return true;
            }
            if (findPath(x,y-1)) {
                mazePath.add("West");
                numCellsVisited++;
                return true;
            }
            if (findPath(x-1,y)) {
                mazePath.add("North");
                numCellsVisited++;
                return true;
            }
            maze[x][y] = unmarked;
            return false;
        }
    }
    
    public String[] getMoves() {
        if (mazePath.isEmpty()) {
            return null;
        } else {
            ArrayList<String> reversedPath = new ArrayList<>(mazePath);
            Collections.reverse(reversedPath);
            return reversedPath.toArray(new String[reversedPath.size()]);
            //had to reverse my path for some reason?
          }
    }
    
     public int getMazesTried() {
        return mazesTried;
    }

    public int getMazesSolved() {
        return mazesSolved;
    }
    
    public int getNumCellsVisited() {
        return numCellsVisited;
    }
    
    public double getPerformance() {
        if (mazesTried == 0) {
            return 0;
        } else {
            return (double) mazesSolved / mazesTried;
        }
    }
}