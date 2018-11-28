import java.util.*;

public class Quaterback extends FantasyPlayer implements Player {
	
	
	public Quaterback() {
		
	}
	
	public Quaterback(String name, String position, String team, String yards, String TDs, String touches) {
		this.setPassingAttempts(touches);
		this.setPassingTouchdowns(TDs);
		this.setPassingYards(yards);
		this.name = name;
		this.position = position;
		this.position = "QB";
		this.calculateReliability();
	}

	private static int[] passingYards = new int[5];
	private static int[] passingTouchdowns = new int[5];
	private static int[] passingAttempts = new int[5];
	
	
	@Override
	public void calculateReliability() {

		for (int i = 0; i < 5; i++) {
			
			this.reliabilityScore[i] = (int) ((this.passingYards[i]/this.passingAttempts[i]) + (this.passingTouchdowns[i] * 3));
		}

	}
	
	public int[] getPassingYards() {return passingYards;}
	
	public int[] getPassingTouchdowns() {return passingTouchdowns;}
	
	public int[] getPassingAttempts() {return passingAttempts;}
	
	public  void setPassingYards(String passingYards) {
		
		Scanner s = new Scanner(passingYards);
		this.passingYards = new int[5];
		int total = 0;
		for (int i = 0; i < 4; i++) {
			this.passingYards[i] = (int)(s.nextInt());
			total += this.passingYards[i];
		}
		s.close();
		
		this.passingYards[4] = (int) (total/4);
		
	}
	
	public void setPassingTouchdowns(String passingTouchdowns) {
		
		Scanner s = new Scanner(passingTouchdowns);
		this.passingTouchdowns = new int[5];
		int total = 0;
		for (int i = 0; i < 4; i++) {
			this.passingTouchdowns[i] = (int)(s.nextInt());
			total += this.passingTouchdowns[i];
		}
		s.close();
		
		this.passingTouchdowns[4] = (int) (total/4);
	}
	
	public void setPassingAttempts(String passingAttempts) {

		Scanner s = new Scanner(passingAttempts);
		this.passingAttempts = new int[5];
		int total = 0;
		for (int i = 0; i < 4; i++) {
			this.passingAttempts[i] = (int)(s.nextInt());
			total += this.passingAttempts[i];
		}
		s.close();
		this.passingAttempts[4] = (int) (total/4);
	
	}

}
