package student;
import java.util.List;

import danaus.*;

public class Danaus extends AbstractButterfly {
	
	public TileState[][] learn () {
		for (int i=0; i<Integer.MAX_VALUE; i++) {
			try{
				fly(danaus.Direction.S, danaus.Speed.NORMAL);
		}
			catch (danaus.CliffCollisionException e) {}
			}
		return null;
	}
	
	@Override
	public void run(List<Long> flowerIds) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Flower> flowerList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Location flowerLocation(Flower f) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Location flowerLocation(long flowerId) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
