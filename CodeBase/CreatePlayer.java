import java.util.HashMap;

public class CreatePlayer {
	
	public String position;
	HashMap <String, Quaterback> hmQ = new HashMap<String, Quaterback>();
	HashMap <String, SkillPosition> hmSP = new HashMap<String, SkillPosition>();
		
	public void CreatePlayer() {

	}
	
	public CreatePlayer(String name, String position, String team, String yards, String TDs, String touches) {
		
		this.position = position;
		
		if(position.equalsIgnoreCase("QB")) {
			hmQ.put(position, new Quaterback(name, position, team, yards, TDs, touches));
		}else if(position.equalsIgnoreCase("RB") || position.equalsIgnoreCase("WR") || position.equalsIgnoreCase("TE")) {
			hmSP.put(position,new SkillPosition(name, position, team, yards, TDs, touches));	
		}else {
			System.out.println("wrong position");
		}	
	
	}
	
}
