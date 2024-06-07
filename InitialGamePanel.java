package gameProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InitialGamePanel implements ActionListener {
	JFrame f;
	JMenuItem third;
	JMenuItem forth;

	public InitialGamePanel() {
		f = new JFrame();
		JMenuBar menubar = new JMenuBar();
		f.setJMenuBar(menubar);
		f.setTitle("Choose size");
		// 화면 분할 후 위는 조각 그림 아래는 미로
		third = new JMenuItem("3*3");
		forth = new JMenuItem("4*4");
		menubar.add(third);
		menubar.add(forth);

		third.addActionListener(this);
		forth.addActionListener(this);

		f.setSize(300, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("3*3")) {
			new GamePanel3();
		} else if (e.getActionCommand().equals("4*4")) {
			new GamePanel4();
		}
	}
}
