/** TIME SPENT: # hours and # minutes. */ 

package student;
import java.util.List;
import danaus.*;

public class Butterfly extends AbstractButterfly {
	
	 public @Override TileState[][] learn() 
	 {
		try
		{
			fly_continuous(danaus.Direction.E, danaus.Speed.NORMAL);
		}
		catch (danaus.CliffCollisionException e) 
		{
			for (;;)
			{
				fly_continuous(danaus.Direction.S, danaus.Speed.NORMAL);
			}
		}
		return null;
	}
	 
	 /* ----------- Helper Methods ------------------------ */
	 private void fly_continuous (Direction heading, Speed s)
	 {
		 for (;;)
		 {
			 fly(heading, s);
		 }
	 }
	 
	
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