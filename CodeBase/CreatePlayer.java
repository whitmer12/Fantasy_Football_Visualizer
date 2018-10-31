
public class CreatePlayer {
	
	SkillPosition player1 = new SkillPosition();
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
	
	public void CreatePlayer(String name, String position, String team, int reliability, int yards, int TDs, int touches) {
	
	if(position == "Running Back" || position == "Tight End" || position == "Wide Reciever") {
		this.player1 = returnSkillPlayer(name, position, team, reliability, yards, TDs, touches);
	}
		
		
		
	}
	
	public FantasyPlayer returnNewPlayer;
	public SkillPosition returnSkillPlayer;
	public Quaterback returnQuaterback;
	
	public SkillPosition returnSkillPlayer(String name, String position, String team, int reliability, int yards, int TDs, int touches) {
		
		SkillPosition player1 = new SkillPosition();
		
		player1.setName(name);
		player1.setPosition(position);
		player1.setTeam(team);
		player1.setReliabilityScore(reliability);
		player1.setScrimmageYards(yards);
		player1.setTouchdowns(TDs);
		player1.setTouches(touches);
		
		return player1;
	}
}
