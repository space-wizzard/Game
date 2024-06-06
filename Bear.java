package inheritance;

import java.awt.Image;

import javax.swing.ImageIcon;
// 곰 객체 (술래)
public class Bear extends GameObject {
	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	
	
	@Override
	protected void move(String key) {
			if(key.equals(names[0])) {
				y-=distance;
			}
			else if(key.equals(names[1])) {
				x+=distance;
			}
			else if(key.equals(names[2])) {
				x-=distance;
			}
			else if(key.equals(names[3])) {
				y+=distance;
			}
			
	}
	@Override
	protected Image getShape() {
		ImageIcon bear = new ImageIcon("images/bear.png");
		return bear.getImage();
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
	
	
	
	public boolean collide(Fish p) {
		if(this.x==p.x&& this.y==p.y) 
			return true;
		else
			return false;
	}
	
}

