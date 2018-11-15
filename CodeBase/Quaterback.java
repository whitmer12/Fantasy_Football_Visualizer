
public class Quaterback extends FantasyPlayer {
	
	public Quaterback() {
		
	}

	private int passingYards;
	private int passingTouchdowns;
	private int passingAttempts;
	
	public int getPassingYards() {return passingYards;}
	
	public int getPassingTouchdowns() {return passingTouchdowns;}
	
	public int getPassingAttempts() {return passingAttempts;}
	
	public  void setPassingYards(int passingYards) {this.passingYards = passingYards;}
	
	public void setPassingTouchdowns(int passingTouchdowns) {this.passingTouchdowns = passingTouchdowns;}
	
	public void setPassingAttempts(int passingAttempts) {this.passingAttempts = passingAttempts;}
}
