/** TIME SPENT: 20 hours and # minutes. */ 

package student;
import java.util.List;
import danaus.*;

public class Butterfly extends AbstractButterfly 
{
	private Direction direction = danaus.Direction.E;
	private int x_position;
	private int y_position;
	public   TileState[][] M;
	
	 public @Override TileState[][] learn() 
	 {
        M = new TileState[getMapWidth()][getMapHeight()];
		fly_continuous(danaus.Speed.NORMAL);
		
		return null;

	}
	 
	 /* ----------- Helper Methods ------------------------ */

	 /** Algorithm for the butterfly flying conditions according to the handout */
	 private void fly_continuous (Speed s)
	 // private TileState [][] fly_continuous (Speed s)
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
			 	
			 	/* When the butterfly hits the east edge it flies south one tile,
			 	 * then it flies to the west */
			 	if (getx_position() == (getMapWidth()-1)) 
			 	{
			 		setDirection(danaus.Direction.S);
			 		fly(getDirection(), danaus.Speed.NORMAL);
			 		setDirection(danaus.Direction.W);
			 		fly_continuous(danaus.Speed.NORMAL);
			 	}

			 	/* When the butterfly hits the west edge it flies south one tile,
			 	 * then it flies to the east */
			 	if (getx_position() == 0)
			 	{
			 		setDirection(danaus.Direction.S);
			 		fly(getDirection(), danaus.Speed.NORMAL);
			 		setDirection(danaus.Direction.E);
			 		fly_continuous(danaus.Speed.NORMAL);
			 	}
		 	
			 /* When the butterfly hits the south end of the map, the program 
			  * terminates */
			 	if (ending_cases()==true){
			 		return;
			 	}

			 	
			 }
			 /* For handling different cases when encountering a cliff */
			 catch (danaus.CliffCollisionException e) 
			 {
				 /* the case when the butterfly is on the west edge of the map
				  * going south and hits a cliff, it will fly east */
				 if ((getx_position() == 0) 
					&& (getDirection() == danaus.Direction.S))
				 {
					 setDirection(danaus.Direction.E);
					 fly_continuous(danaus.Speed.NORMAL);
				 }
				 
				 /* the case when the butterfly is on the west edge of the map
				  * going east and hits a cliff, it will fly south one tile,
				  * then try to fly east again */
				 if ((getx_position() == 0) 
					&& (getDirection() == danaus.Direction.E))
				 {
					 setDirection(danaus.Direction.S);
					 fly(getDirection(), danaus.Speed.NORMAL);
					 setDirection(danaus.Direction.E);
					 fly_continuous(danaus.Speed.NORMAL);
				 }
				 
				/* when the butterfly hits a cliff and its at the south edge of
				 * the map it terminates the program */
				 
				 /*TODO: return new TileState[][], when the butterfly hits a cliff
				  * and when its at the south edge of the map. This is a terminating
				  * condition see pg3 of handout. terminating condition 3. 
				  * so here the program should return a TitleState[][] with all the 
				  * data that the butterfly traveled on. */
				if (gety_position() == (getMapHeight()-1))
					break;

					//return new TileState[][];
				
				/* Handling collision with a cliff:
				 * Case 1: butterfly flies EAST hits a cliff, it would turn SOUTH
				 * 		   one tile then flies to the WEST
				 * Case 2: butterfly flies SOUTH hits a cliff, it would turn WEST
				 * Case 3: butterfly flies WEST hits a cliff, it would turn SOUTH 
				 * 		   one tile then flies to the EAST */
				switch (getDirection())
				{
					case E:
						setDirection(danaus.Direction.S);
						fly(getDirection(), danaus.Speed.NORMAL);
						setDirection(danaus.Direction.W);
						fly_continuous(danaus.Speed.NORMAL);
					
						
					case S:
						setDirection(danaus.Direction.W);
						fly_continuous(danaus.Speed.NORMAL);
					case W:
						setDirection(danaus.Direction.S);
						fly(getDirection(), danaus.Speed.NORMAL);
						setDirection(danaus.Direction.W);
						fly_continuous(danaus.Speed.NORMAL);
						
					default:
						setDirection(danaus.Direction.E);
						fly_continuous(danaus.Speed.NORMAL); 
						
				
				}
			 }
		 }
	 }
	 
	 private void set_explored_location() {
		 M[getx_position()][gety_position()].location 
		  = new Location(getx_position(), gety_position());
	 }
	 
	 /** check to see if the butterfly is near the end of the map and its flying */
	 private boolean ending_cases()
	 {
		 
		 if (gety_position() == getMapHeight()) {
			 return true;
		  }
		 else{
			 return false;
		 }
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