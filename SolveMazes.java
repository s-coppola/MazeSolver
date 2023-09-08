//This is the program. SolveMazes should repeatedly ask for a file name or the word stop. 
//Each time the file name is not stop, it should use the JaggedGridReader from homework 1 to read the file, 
//use the MazeSolver to solve the maze, then print the solution to the maze along with the number of cells visited, or "No Solution" 
//if the maze was not solved. Once it finishes processing the mazes, it should print the performance of the maze solver as a percentage with no 
//decimal places and then the program should end. 

package hw2;

import hw1.JaggedGridReader;
import hw2.MazeSolver;
import java.util.*;

public class SolveMazes {
   public static void main(String[] args) {
   
      //Scanner kb = new Scanner(System.in);
      //System.out.print("Enter filename: ");
      //String fileName = kb.nextLine();
      String fileName = "maze.txt";
      
      if (fileName.equals("stop")){
         System.exit(0);
      }
      if (!fileName.equals("stop")) {
      
          JaggedGridReader input = new JaggedGridReader(fileName);
          
          char[][] maze = input.getCopy();
          
          MazeSolver solve = new MazeSolver();
          
      System.out.println(solve.getMoves());
      //System.out.println(solve.solveMaze(maze));
      System.out.println(solve.getNumCellsVisited());
      double perfD = solve.getPerformance();
      int perf = (int) perfD;
      System.out.println(perf);
      } else
         System.out.println("No Solution");
   }
}