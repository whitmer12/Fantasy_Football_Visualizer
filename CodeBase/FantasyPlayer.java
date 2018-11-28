
public class FantasyPlayer {
	
	protected String name;
	protected String position;
	protected String team;
	protected static int[] reliabilityScore = new int[5];
	
	public String getName() {return name;}
	
	public String getPosition() {return position;}
	
	public String getTeam() {return team;}

	public int[] getReliabilityScore() {return reliabilityScore;}
	
	public void setName (String name) {this.name = name;}
	
	public void setPosition(String position) {this.position = position;}
	
	public void setTeam(String team) {this.team = team;}	
	
	public void setReliabilityScore(int[] reliabilityScore) {this.reliabilityScore = reliabilityScore;}

}
