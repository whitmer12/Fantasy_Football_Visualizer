import java.util.Scanner;

public class SkillPosition extends FantasyPlayer implements Player{
	
	public void SkillPosition(){
		
	}
	
	public SkillPosition(String name, String position, String team, String yards, String TDs, String touches) {
		this.setTouches(touches);
		this.setTouchdowns(TDs);
		this.setScrimmageYards(yards);
		this.name = name;
		this.position = position;
		this.position = "QB";
		this.calculateReliability();
	}
	
	@Override
	public void calculateReliability() {

		for (int i = 0; i < 5; i++) {
			
			this.reliabilityScore[i] = (int) ((this.scrimmageYards[i]/this.touches[i]) + (this.touchdowns[i] + 6));
		}

	}
	
	private int[] scrimmageYards;
	private int[] touchdowns;
	private int[] touches;
	
	public int[] getScrimmageYards() {return scrimmageYards;}
	
	public int[] getTouchdowns() {return touchdowns;}
	
	public int[] touches() {return touches;}
	
	public void setScrimmageYards(String scrimmageYards) {
		
		Scanner s = new Scanner(scrimmageYards);
		this.scrimmageYards = new int[5];
		int total = 0;
		for (int i = 0; i < 4; i++) {
			this.scrimmageYards[i] = (int)(s.nextInt());
			total += this.scrimmageYards[i];
		}
		s.close();
		
		this.scrimmageYards[4] = (int) (total/4);
		
	}
	
	public void setTouchdowns(String touchdowns) {

		Scanner s = new Scanner(touchdowns);
		this.touchdowns = new int[5];
		int total = 0;
		for (int i = 0; i < 4; i++) {
			this.touchdowns[i] = (int)(s.nextInt());
			total += this.touchdowns[i];
		}
		s.close();
		
		this.touchdowns[4] = (int) (total/4);
	
	}
	
	public void setTouches(String touches) {

		Scanner s = new Scanner(touches);
		this.touches = new int[5];
		int total = 0;
		for (int i = 0; i < 4; i++) {
			this.touches[i] = (int)(s.nextInt());
			total += this.touches[i];
		}
		s.close();
		
		this.touches[4] = (int) (total/4);
	
	}
}
