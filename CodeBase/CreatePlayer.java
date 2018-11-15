
public class CreatePlayer {
	
	public FantasyPlayer player1;
	
	private int week;
	
	public int getWeek() {return week;}
	
	public void setWeek(int week) {this.week = week;}
	
	public void CreatePlayer() {
		FantasyPlayer player1 = new FantasyPlayer();
		player1.setName("");
		player1.setPosition("");
		player1.setReliabilityScore(-100);
		player1.setTeam("");
	}
	
	public CreatePlayer(String name, String position, String team, String yards, String TDs, String touches, String week) {
		
		
		//for demo:
		this.week = Integer.parseInt(week);
		
		if(position.equalsIgnoreCase("RB") || position.equalsIgnoreCase("TE") || position.equalsIgnoreCase("WR")) {
			player1 = new SkillPosition();
			
			/*TODO:
			 * 
			 * create constructors for skillpositions and quarterbacks that take in yardage data
			 * create the new skill position players with populated fields
			 * 
			 */
			
			player1.setName(name);
			player1.setPosition(position);
			player1.setTeam(team);
			
			//for demo:
			System.out.println(player1.getName() + "   " + player1.getPosition());
			
		}else if(position.equals("QB")){
			player1 = new Quaterback();
		}
		
	}
	
	public CreatePlayer() {
	}

	public FantasyPlayer returnNewPlayer;
	public SkillPosition returnSkillPlayer;
	public Quaterback returnQuaterback;
	
}
