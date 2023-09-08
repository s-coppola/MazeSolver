package hw2;

import hw1.JaggedGridReader;
import hw2.MazeSolver;
import java.util.*;

public class MainSolver {
    public static void main(String[] args) {
    
      JaggedGridReader input = new JaggedGridReader("maze.txt");
          
      char[][] maze = input.getCopy();

      MazeSolver_C solver = new MazeSolver_C(maze);
      solver.solve();
    }
}
