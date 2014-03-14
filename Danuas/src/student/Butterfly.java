/** TIME SPENT: # hours and # minutes. */ 

package student;
import java.util.List;
import danaus.*;

public class Butterfly extends AbstractButterfly 
{
	private Direction direction = danaus.Direction.E;
	
	 public @Override TileState[][] learn() 
	 {
		 refreshState();
		try
		{
			fly_continuous(danaus.Speed.NORMAL);
		}
		catch (danaus.CliffCollisionException e) 
		{
			switch (getDirection())
			{
				case E:
					setDirection(danaus.Direction.S);
					fly_continuous(danaus.Speed.NORMAL);
				case S:
					setDirection(danaus.Direction.W);
					fly_continuous(danaus.Speed.NORMAL);
					
				default:
					break; 
			
			}
			
		}
		return null;
	}
	 
	 /* ----------- Helper Methods ------------------------ */
	 private void fly_continuous (Speed s)
	 {
		 for (;;)
		 {
			 fly(getDirection(), s);
		 }
	 }
	 
	 public Direction getDirection() {
		 return direction;
	 }

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