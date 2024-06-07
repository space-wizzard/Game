package gameProject;

import java.util.Random;

import javax.swing.ImageIcon;

public class Maze_Initialize implements GameObject {

	public void MakeMaze() {

		for (int i = 0; i < END; i++) {
			for (int j = 0; j < END; j++) {
				Random rand = new Random();
				maze[i][j] = rand.nextInt(2);
			}
		}

		for (int i = 0; i < END - 1; i++) {
			for (int j = 0; j < END - 1; j++) {
				if (maze[i + 1][j] == 1 && maze[i][j + 1] == 1) {
					Random rand = new Random();

					if (rand.nextInt(2) == 0)
						maze[i + 1][j] = 0;
					else
						maze[i][j + 1] = 0;
				}
			}
		}

		maze[0][0] = 0;
		maze[END - 1][END - 1] = 0; // Ensure the end is a path
		for (int i = 0; i < END; i++) {
			for (int j = 0; j < END; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();

		}
	}

	public void ArrangeItem() {
		Random rand = new Random();
		int count = 0;
		for (int i = 0; i < END; i++) {
			for (int j = 0; j < END; j++) {
				ItemPosition[i][j] = 0;

			}
		}

		for (int i = 0; i < END; i++) {
			for (int j = 0; j < END; j++) {
				for (int[] loc : path) {
					if (loc[0] == i && loc[1] == j) {
						if (count < 16 && rand.nextBoolean()) {
							ItemPosition[i][j] = 1;
							count += 1;
						} else {
							continue;
						}
						// count 변수를 조건문에 추가하면 path에 있는 좌표도 2가 된다.(count가 초과될때)

					}
					if (rand.nextInt(200) == 0 && loc[0] != i && loc[1] != j) {
						ItemPosition[i][j] = 2;
					}
				}
			}
		}
		System.out.println("count:" + count);
		ItemPosition[0][0] = 0;
		ItemPosition[END - 1][END - 1] = 0;
	}
}
