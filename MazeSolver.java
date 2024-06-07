package gameProject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeSolver implements GameObject {
	protected void printPath(int[] end) {

		for (int[] at = end; at != null; at = parent[at[0] * END + at[1]]) {
			path.addFirst(at);
			// at[0]=1;

		}
		// System.out.println(end[0] * END + end[1]);
		for (int[] loc : path) {
			System.out.println("[" + loc[0] + ", " + loc[1] + "]");
		}
	}

	public void bfs(int[] start, int[] end) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		visited[start[0]][start[1]] = true;
		parent[start[0] * END + start[1]] = null;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];

			if (x == END - 1 && y == END - 1) {
				printPath(end);
				return;
			}

			for (int[] dir : direction) {
				int newX = x + dir[0];
				int newY = y + dir[1];

				if (newX >= 0 && newY >= 0 && newX < END && newY < END && !visited[newX][newY]
						&& maze[newX][newY] == 0) {
					visited[newX][newY] = true;
					queue.add(new int[] { newX, newY });
					parent[newX * END + newY] = current;
					// System.out.print("t:"+newX+","+newY);
				}
			}
			System.out.println();
		}
	}

}
