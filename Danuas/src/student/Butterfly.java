/** TIME SPENT: 30 hours and # minutes. */

package student;
import java.util.List;
import danaus.*;

/**Butterfly is flying in boustrophedonic style. */
public class Butterfly extends AbstractButterfly {
	/**butterfly traverses the map in boustrophedonic fashion and contruct
	 * a two-dimensional array of TileStates to represent the portion of map
	 * that the butterfly explored */
	 public @Override TileState[][] learn() {
		//dir specifies the initial direction
		 Direction dir = danaus.Direction.E;
		//TileState represent the map that the butterfly explored 
        TileState[][] M = new TileState[getMapHeight()][getMapWidth()];
		while (true){
			refreshState();
			//update state to array(map)
			M[state.location.row][state.location.col]=state;
			try {
				//special case for east or west edge
				if ((state.location.col == getMapWidth()-1 && dir==Direction.E)
						|| (state.location.col == 0 && dir== Direction.W)){
					//stop if at the bottom row
					if (state.location.row == getMapHeight()-1){
						break;
					}
					fly(danaus.Direction.S, danaus.Speed.NORMAL);
					dir= Direction.opposite(dir);
				}
				//default case
				else{
					fly(dir, danaus.Speed.NORMAL);
				}				
			}
			catch(danaus.CliffCollisionException e) {
			    //if the butterfly is at the bottom row and collides
				if(state.location.row == getMapHeight()-1){
					break;
				}
				//fly south for one tile
		        fly(danaus.Direction.S, danaus.Speed.NORMAL);
				dir= Direction.opposite(dir);		
			}			
		}		
		return M;
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