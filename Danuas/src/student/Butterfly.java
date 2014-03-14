/** TIME SPENT: # hours and # minutes. */ 

package student;
import java.util.List;
import danaus.*;

public class Butterfly extends AbstractButterfly 
{
	private Direction direction = danaus.Direction.E;
	private int x_position;
	private int y_position;
	
	 public @Override TileState[][] learn() 
	 {

		fly_continuous(danaus.Speed.NORMAL);
		
		return null;

	}
	 
	 /* ----------- Helper Methods ------------------------ */
	 /** Algorithm for the butterfly flying conditions according to the handouts */
	 private TitleState[][] fly_continuous (Speed s)
	 {
		 for (;;)
		 {
			 try
			 {
				/* Fly the butterfly, at every new tile, it would refresh the 
				 * state and record the location of the butterfly in its private 
				 * variables x_position, y_position */
			 	fly(getDirection(), s);
			 	refreshState();
			 	set_location();
			 	
			 	/* When the butterfly hits the west edge or east edge of the map
			 	 * it flies south */
			 	if ((getx_position() == (getMapWidth()-1)) 
			 	 || (getx_position() == 0))
			 	{
			 		setDirection(danaus.Direction.S);
			 		fly_continuous(danaus.Speed.NORMAL);
			 	}
			 	
			 	
			 	
			 	
			 	
			 }
			 /* For handling different cases when encountering a cliff */
			 catch (danaus.CliffCollisionException e) 
			 {
				/* when the butterfly hits a cliff and its at the south edge of
				 * the map it terminates the program */
				 
				 /*TODO: return new TileState[][], when the butterfly hits a cliff
				  * and when its at the south edge of the map. This is a terminating
				  * condition see pg3 of handout. terminating condition 3. 
				  * so here the program should return a TitleState[][] with all the 
				  * data that the butterfly traveled on. */
				if (gety_position() == (getMapHeight()-1))
					return new TileState[][];
				
				/* Handling collision with a cliff:
				 * Case 1: butterfly flies EAST hits a cliff, it would turn SOUTH
				 * Case 2: butterfly flies SOUTH hits a cliff, it would turn WEST
				 * Case 3: butterfly flies WEST hits a cliff, it would turn SOUTH */
				switch (getDirection())
				{
					case E:
						setDirection(danaus.Direction.S);
						fly_continuous(danaus.Speed.NORMAL);
					case S:
						setDirection(danaus.Direction.W);
						fly_continuous(danaus.Speed.NORMAL);
					case W:
						setDirection(danaus.Direction.S);
						fly_continuous(danaus.Speed.NORMAL);
						
					default:
						setDirection(danaus.Direction.E);
						fly_continuous(danaus.Speed.NORMAL); 
				
				}
			 }
		 }
	 }
	 
	 /** check to see if the butterfly is near the end of the map and its flying */
	 private void ending_cases()
	 {
		 
	 }
	 
	 /** stores the location that the butterfly is currently on in its private
	  *  variables  */
	 private void set_location()
	 {
		 this.x_position = state.location.col;
		 this.y_position = state.location.row;
	 }
	 
	 /** @return the x position the butterfly is on */
	 public int getx_position()
	 {
		 return x_position;
	 }
	 
	 /** @return the y position the butterfly is on */
	 public int gety_position()
	 {
		 return y_position;
	 }
	 
	 /** @return the direction the butterfly is heading towards */
	 public Direction getDirection() 
	 {
		 return direction;
	 }

	 /** set the direction the butterfly is heading */
	 public void setDirection(Direction direction) 
	 {
		 this.direction = direction;
	 }
	 
	 /* ----------------------------------------------- */
	
	public @Override void run(List<Long> flowerIds) {
		// DO NOT IMPLEMENT FOR A3
	}
	
	public @Override List<Flower> flowerList() {
		// DO NOT IMPLEMENT FOR A3
		return null;
	}
	
	public @Override Location flowerLocation(Flower f) {
		// DO NOT IMPLEMENT FOR A3
		return null;
	}
	
	public @Override Location flowerLocation(long flowerId) {
		// DO NOT IMPLEMENT FOR A3
		return null;
	}

}