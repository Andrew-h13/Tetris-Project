import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class AbstractPiece implements Piece{
	
	
	  
	   protected boolean ableToMove;
	   protected Square[] square; 
	   protected Grid grid;        
	   protected static final int PIECE_COUNT = 4;
	public void draw(Graphics g) {
		for (int i = 0; i < PIECE_COUNT; i++) {
			square[i].draw(g);
		}
	}


	public void move(Direction direction) {
		if (canMove(direction)) {
			for (int i = 0; i < PIECE_COUNT; i++)
				square[i].move(direction);
		}
		else if (direction == Direction.DOWN) {
			ableToMove = false;
		}
	}

	public Point[] getLocations() {
		Point[] points = new Point[PIECE_COUNT];
		for (int i = 0; i < PIECE_COUNT; i++) {
			points[i] = new Point(square[i].getRow(), square[i].getCol());
		}
		return points;
	}

	public Color getColor() {
		return square[0].getColor();
	}


	public boolean canMove(Direction direction) {
		if (!ableToMove)
			return false;

		boolean answer = true;
		for (int i = 0; i < PIECE_COUNT; i++) {
			answer = answer && square[i].canMove(direction);
		}

		return answer;
	}

	public void rotate()
	{
		boolean ck = true; //check if its true
		for(int i=0;i<PIECE_COUNT;i++) {
			if(i==1) {;} // if it equal to 1 do nothing
			else {
				
				int oldx = square[1].getCol();
				int oldy = square[1].getRow();
				
				int x = square[i].getCol();
				int y = square[i].getRow();
				
				int newX = y + oldx - oldy;
				int newY = x + oldy - oldx;
				if(ck=true) {
					square[i].setCol(newX);
					square[i].setRow(newY);
				}
				
				if((0<=newX)&&(newX<=Grid.WIDTH)) 
				{continue;}
				else if((0<newY)&&(newY<=Grid.HEIGHT))
				{continue;}
				else {ck = false;}
				}
			
		}
	}
	
}
			
		


