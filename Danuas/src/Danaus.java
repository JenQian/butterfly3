import danaus.Direction;
import danaus.Speed;
import danaus.TileState;

public class Danaus 
{
	
	public TileState[][] learn () {
		try{
			fly(danaus.Direction.E, danaus.Speed.NORMAL);
		}
		catch (danaus.CliffCollisionException e) {}
		return null;
		}

	private void fly(Direction e, Speed normal) {
		// TODO Auto-generated method stub
		
	}
}
