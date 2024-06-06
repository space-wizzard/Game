package inheritance;


import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
// 화면에 객체를 생성하고, 생성한 객체를 출력하는 파일
public class PaintPanel extends JFrame implements GameRenderer {
	Bear b;
	Fish f;
	ConsoleGameRenderer renderer = new ConsoleGameRenderer();
	private MyPanel panel = new MyPanel();
	public PaintPanel(Bear b,Fish f) {
		this.b=b;
		this.f=f;
		setTitle("JPanel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLayout(new FlowLayout(FlowLayout.LEFT,3,4));
		MyItemListener listener = new MyItemListener();
        for (int i = 0; i < direction.length; i++) {
            direction[i] = new JCheckBox(names[i]);
            add(direction[i]);
            direction[i].addItemListener(listener);
        }
		setSize(500,500);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
                String select = ((JCheckBox) e.getItem()).getText();
                // 생성한 객체 모든 기능 활성화
                b.move(select);
                b.limit();
                f.move(null);
                f.limit();
                // 객체 일정하게 옮김
                renderer.Starter(b, f);
                renderer.UpdateGamePane(b, f);
                // 같은 파일에서 getGraphics를 호출해 paintComponent함수의 매개변수로 넘어가야 한다.
                panel.paintComponent(getGraphics());
                
            }
			
		}
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (int i=0;i<end_x;i++) {
	            for (int j=0;j<end_y;j++) {
	            	GameObject obj=gamePane[i][j];
	                if (obj != null) {
	                	 g.drawImage(obj.getShape(), obj.x * 20, obj.y * 20, 20, 20, this);
	                } else {
	                	g.drawString("-", i * 20, (j + 1) * 20);
	                }	             
	            }
	           
	        }
			repaint();
		}
	}

	@Override
	public void UpdateGamePane(Bear bear, Fish fish) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Starter(Bear bear, Fish fish) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		Bear b = new Bear(5,4,1);
		Fish f = new Fish(7,1,2);
		new PaintPanel(b,f);
	}
}
