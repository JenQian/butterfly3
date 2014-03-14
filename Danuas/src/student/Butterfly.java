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
	 private TitleState[][] fly_continuous (Speed s)
	 {
		 for (;;)
		 {
			 try
			 {
			 	fly(getDirection(), s);
			 	refreshState();
			 	set_location();
			 	
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
				if (gety_position() == (getMapHeight()-1))
					return new TileState[][];
				
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
	 public Direction getDirection() {
		 return direction;
	 }

	 /** set the direction the butterfly is heading */
	 public void setDirection(Direction direction) {
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