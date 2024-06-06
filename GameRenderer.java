package inheritance;

import javax.swing.JCheckBox;
// Panel 업데이트하는 ConsoleGameRenderer 파일에서 필요한 메서드와 변수 지정
public interface GameRenderer {
	int end_x=10;
	int end_y=20;
	 JCheckBox[] direction= new JCheckBox[4];
	 String[] names= {"up","right","left","down"};
	GameObject[][] gamePane=new GameObject[end_x][end_y];
	void UpdateGamePane(Bear bear,Fish fish);
	void Starter(Bear bear,Fish fish);

}
