package gameProject;

public class Controller implements GameObject {

	public static void main(String[] args) {
		Maze_Initialize m = new Maze_Initialize();
		MazeSolver mazeSolver = new MazeSolver();
		m.MakeMaze();
		// Controller.class.getResource("images/Hawaii_5.0.wav");
		int[] start = { 0, 0 };
		int[] end = { END - 1, END - 1 };
		mazeSolver.bfs(start, end);
		m.ArrangeItem();
		new InitialGamePanel();

	}

}
