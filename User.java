package gameProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

class User extends JPanel implements GameObject{
	int x,y,score;
	int count=0;
	
	
	public User(int x, int y) {
		this.x=x;
		this.y=y;
		this.score=0;
		
	}
	
	public int move(int direction,JLabel scorelabel) {
		
		if(direction==KeyEvent.VK_LEFT) {
			x-=1;
			if(x<0 || maze[x][y]==1 ) {
				x+=1;
				
			}
			
		}
		else if(direction==KeyEvent.VK_RIGHT) {
			x+=1;
			if(x>=END|| maze[x][y]==1) {
				x-=1;
				
			}
			
		}
		else if(direction==KeyEvent.VK_DOWN) {
			y+=1;
			if(y>=END|| maze[x][y]==1) 
				y-=1;
				
			
		}
		else if(direction==KeyEvent.VK_UP) {
			y-=1;
			if(y<0 || maze[x][y]==1) {
				y+=1;
				
			}
			
		}
		if(ItemPosition[x][y]==1) {
			count+=1;
			score+=1;
			ItemPosition[x][y]=0;
			scorelabel.setText("score:"+score);
			scorelabel.setForeground(Color.red);
			return count;
		}
		else if(ItemPosition[x][y]==2) {
			score-=1;
			ItemPosition[x][y]=0;
		}
		if(x==END-1 && y==END-1)
			return -1000;
		scorelabel.setText("score:"+score);
		scorelabel.setForeground(Color.red);
		return 0;
		
		
		
	}
	
	
	

	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
