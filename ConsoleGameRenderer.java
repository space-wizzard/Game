package inheritance;

import javax.swing.JPanel;

public class ConsoleGameRenderer extends JPanel implements GameRenderer {
	@Override
	public void UpdateGamePane(Bear bear,Fish fish) {
		
		for (int i = 0; i < end_x; i++) {
            for (int j = 0; j < end_y; j++) {
                gamePane[i][j] = null;
            }
        }
		//사용자가 지정한 위치에 bear,fish를 넣는다.
		// 여기서 gamePane은 GameObject형의 객체 배열이다.
		gamePane[bear.getX()][bear.getY()]=bear;
		gamePane[fish.getX()][fish.getY()]=fish;
		
	}
	@Override
	public void Starter(Bear bear,Fish fish) {
		
			if(bear.collide(fish)) {
				System.out.println("Bear Wins!");
				System.exit(0);
			}
			else {
				System.out.println(bear.getX()+","+bear.getY());
			}
	}
	
	

}
