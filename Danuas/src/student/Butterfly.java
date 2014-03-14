/** TIME SPENT: # hours and # minutes. */ 

package student;
import java.util.List;
import danaus.*;

public class Butterfly extends AbstractButterfly {
	
	 public @Override TileState[][] learn() {
		for (int i=0; i<100; i++) {
			try{
				 fly(danaus.Direction.E, danaus.Speed.NORMAL);
			}
			catch (danaus.CliffCollisionException e) {}
			}
		return null;
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