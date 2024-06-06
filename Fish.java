package inheritance;

import java.awt.Image;

import javax.swing.ImageIcon;
// 물고기 객체(짝수번째에 자리 옮김)
public class Fish extends GameObject {
	private int idx=0;
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	@Override
	protected void move(String key) {
		if(idx%2==1) {
			//x+=distance;
		}
		else {
			y+=distance;
		}
		idx+=1;
	}
	@Override
	protected Image getShape() {
		ImageIcon fish = new ImageIcon("images/fish.png");
		Image img=fish.getImage();
		return img;
	}
	@Override
	protected void limit() {
		if(x>=end_x) 
			x=x-end_x;
		else if(x<0)
			x=end_x-1;
		if(y>=end_y)
			y=y-end_y;
		else if(y<0)
			y=end_y-1;
	}
}
