package gameProject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;





public class GamePanel4 extends JFrame implements GameObject {

	
    private MyMazePanel mazePanel = new MyMazePanel();
    private PuzzlePanel puzzlePanel = new PuzzlePanel();
    User user = new User(0,0);
    int score=0;
    JLabel scorelabel = new JLabel("Score:"+score);
    
    JFrame f = new JFrame();
    public GamePanel4() {
    	 
    	 
    	 setTitle("미로 탈출");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         setLayout(new BorderLayout());
         
        add(puzzlePanel,BorderLayout.EAST);
      //puzzlePanel.setPreferredSize(new Dimension(100, 100));
         add(mazePanel,BorderLayout.CENTER);
         add(scorelabel,BorderLayout.WEST);

         addKeyListener(new MyKeyListener());
         setSize(10000,10000); 
         setVisible(true);
         setFocusable(true);
         requestFocusInWindow();
        
         
    }
     
    class MyKeyListener extends KeyAdapter {
    	 
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            int a=user.move(keyCode,scorelabel);
            System.out.println(a);
            if(a==-1000) {
            	System.exit(0);
            }
            
            loadImagePieces(a);
            //조각 그림 생성
            
            puzzlePanel.repaint();	
            mazePanel.repaint();
        }
    }
	
		private void loadImagePieces(int count) {
    	
        ImageIcon image=new ImageIcon("images/4by4/piece" + count + ".gif");
        puzzlePanel.addImagePiece(image);
        //puzzlePanel.repaint();
        
    }
		class PuzzlePanel extends JPanel {
        

        public PuzzlePanel() {
            GridLayout grid=new GridLayout(4,4);
            grid.setVgap(3);
            setLayout(grid);
        }
        
        public void addImagePiece(ImageIcon image) {
            
            JLabel pieceLabel = new JLabel(image);
            //pieceLabel.setMinimumSize(new Dimension(50, 50));
            add(pieceLabel);
            //setSize(300,300);
           
            
        }
    }
	
	
	
    
    class MyMazePanel extends JPanel{
    	 
		@Override
    	protected void paintComponent(Graphics g) {
    		ImageIcon wall = new ImageIcon("images/wall.png");
            ImageIcon road = new ImageIcon("images/path.png");
    		ImageIcon bear = new ImageIcon("images/bird.png");
    		ImageIcon item = new ImageIcon("images/fish.png");
    		
    		super.paintComponent(g);
    		
    		
    		for(int i=0;i<END;i++) {
    			for(int j=0;j<END;j++) {
    				
    				int x = i * 50;
    				int y = j * 50;
    				
    				
    				if(i==user.getX() && j==user.getY()) {    					 
    					 g.drawImage(bear.getImage(),x,y,50,50, this);
    					 continue;
    				 }
    				 if(maze[i][j]==1) {
    					 g.drawImage(wall.getImage(), x,y,50,50, this);
    					 continue;
    				 }
    				 else if(maze[i][j]==0) {
    					 g.drawImage(road.getImage(), x,y,50,50, this);
    				 }
    					 
    				  if(ItemPosition[i][j]==1) {
    					 g.drawImage(item.getImage(),x,y,50,50, this);
    					 
    					 
    				 }
    				 else if(ItemPosition[i][j]==2) {
    					 g.drawImage(item.getImage(),x,y,50,50, this);
    				 }
    				
    			}
    		}
    		
    }
    
 
}
    
  
}
