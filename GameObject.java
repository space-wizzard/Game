package gameProject;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public interface GameObject {
	int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int END = 17;
    int[][] maze = new int[END][END];
   boolean[][] visited = new boolean[END][END];
   int[][] parent = new int[END * END][2];
   LinkedList<int[]> path = new LinkedList<>();
   Image[][] panel = new Image[END][END];
   GameObject[][] gamePane=new GameObject[END][END];
   int[][] ItemPosition= new int[END][END];
   
}
