import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers


public class Driver extends JFrame {
   // Define canvas size constants
   public static final int CANVAS_WIDTH  = 1500;
   public static final int CANVAS_HEIGHT = 750;
 
   public Driver(){

	   Container cp = getContentPane();
	   cp.setPreferredSize(new Dimension(CANVAS_WIDTH/2, CANVAS_HEIGHT/2));
	   cp.setBackground(Color.WHITE);
	   pack();
	   
	   EnterFields canvas = new EnterFields();
	   cp.add(canvas);
	   
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setVisible(true);
   }
   
   private class EnterFields extends JPanel implements ActionListener{
	   
	   CreatePlayer p1;
	   
	   JButton submit = new JButton("Submit Info");
	   JTextField playerName = new JTextField(20);
	   JTextField playerTeam = new JTextField(20);
	   JTextField playerPosition = new JTextField(2);
	   JTextField playerYards = new JTextField(15);
	   JTextField playerTouchdowns = new JTextField(15);
	   JTextField playerAttempts = new JTextField(15);
	   JTextField week = new JTextField(1);
	   
	   
	   public EnterFields() {
		   
		   this.setLayout(new GridLayout(0,2));
		   
		   this.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		   this.setBackground(Color.white);
		   this.setBounds(20, 20, 20, 20);
		   
		   submit.addActionListener(this);
		   
		   this.add(new JLabel("Player Name:"));
		   this.add(playerName);
		   
		   this.add(new JLabel("Player Team:"));
		   this.add(playerTeam);
		   
		   this.add(new JLabel("Player Position:"));
		   this.add(playerPosition);
		   
		   this.add(new JLabel("Player Passing/Scrimmage Yards:"));
		   this.add(playerYards);
		   
		   this.add(new JLabel("Player Passing/Total TDs:"));
		   this.add(playerTouchdowns);
		   
		   this.add(new JLabel("Player Passes/touches:"));
		   this.add(playerAttempts);
		   
		   this.add(new JLabel("Current Week:"));
		   this.add(week);
		   
		   this.add(submit);
	   }
	   
	   private void createPlayer() {
		   p1 = new CreatePlayer(playerName.getText(), playerPosition.getText(), playerTeam.getText(), playerYards.getText(), playerTouchdowns.getText(), playerAttempts.getText());
	   }
 	  	   
	   public void actionPerformed(ActionEvent e) {
		   createPlayer();
		   
		   this.removeAll();
		   
		   Container cp = getContentPane();
		   
		   DrawGraphs frame2 = new DrawGraphs(p1,Integer.valueOf(week.getText()));
		   cp.add(frame2);
		   
		   cp.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		   pack();
		   validate();
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setVisible(true);
	   }
	   
   }
   
   
   
   
   public class DrawGraphs extends JPanel {
	   
	   CreatePlayer player1;
	   int week;
	   /*
	    * TODO: put up first page with certain amount of input boxes
	    * put a button click to submit for new player
	    * on button click make a player and then draw graphs 
	    */
	   
	   
	   public DrawGraphs(CreatePlayer player1, int week) {
		   this.player1 = player1;
		   this.week = week;
	   }

	/*
	    * TODO: Get current week from user input to draw out x-axis of graphs
	    */	  
	   
	   private int xRange = 500;
	   private int yRange = 300;
	   private int xTicSpace = yRange/10;
	   private int yTicSpace = xRange/4;
	   
	   private void drawGraph(int x1, int x2, int y1, int y2, Graphics g) {
		   
		  if(player1.position.equalsIgnoreCase("QB")) {
			  g.drawString(player1.hmQ.get(player1.position).getName(), 900, 500);
			  g.drawString("QuaterBack", 900, 525);
		  }else {
			  g.drawString(player1.hmSP.get(player1.position).getName(), 900, 500);
			  if(player1.position.equalsIgnoreCase("RB")) {
				  g.drawString("Running Back", 900, 525);
			  }else
			  if(player1.position.equalsIgnoreCase("WR")) {
				  g.drawString("Wide Reciever", 900, 525);
			  }else {
				  g.drawString("Tight End	", 900, 525);
			  }
		  }
		   
		   g.drawLine(x1, y1, x1, y2);
		   g.drawLine(x1, y2, x2, y2);		   
		   
		   int xTicIterator = y1;
		   
		   for(int i = 0; i < 10; i++) {
			   g.drawLine(x1-5, xTicIterator, x1+5, xTicIterator);
			   if(x1 == 100 && y1 == 20) {
				   if(i <= 5) {
					   g.drawString(String.valueOf(250 - (i*25)), x1-20, xTicIterator+5);
				   }
				   else{
					   g.drawString(String.valueOf(250 - (i*25)), x1-15, xTicIterator+5);
				   }
				   xTicIterator += xTicSpace;
			   }
			   else {
				   if(i <= 5) {
					   g.drawString(String.valueOf(20 - (i*2)), x1-20, xTicIterator+5);
				   }
				   else{
					   g.drawString(String.valueOf(20 - (i*2)), x1-15, xTicIterator+5);
				   }
				   xTicIterator += xTicSpace;
			   }
		   }
		   
		   int yTicIterator = x2;
		   
		   for(int i = 0; i < 4; i++) {
			   g.drawLine(yTicIterator, y2+5, yTicIterator, y2-5);
			   if(i == 0) {
				   g.drawString(String.valueOf(week - i), yTicIterator-3, y2+15);
			   }
			   yTicIterator -= yTicSpace;
			   g.drawString(String.valueOf(week - i - 1), yTicIterator-3, y2+15);
		   }
		   
	   }
	   
	   private void drawGraph1(Graphics g) {
		   
		 /*g.drawString(player1.getName(), 900, 500);
		 g.drawString(player1.getTeam(), 900, 525);
		 g.drawString(player1.getPosition(), 900, 550);*/
	     		 
		 int xInnerBound = 100;
		 int xOuterBound = xInnerBound + xRange;
		 int yInnerBound = 20;
		 int yOuterBound = yInnerBound + yRange;
		 
		 g.drawString("Yards", yInnerBound + 300, xInnerBound - 90);
		 g.drawString("Week", yInnerBound + 320, xInnerBound + 250);

		 
		 g.setColor(Color.RED);
		 
		 for(int i = 0; i < 5; i++) {
			 if(player1.position.equalsIgnoreCase("QB")) {
				 
				 //Fantasy Points by week
				 //starts at 4 weeks ago (ticSpace * 0)
				 //goes to next week (ticSpace * 4)
				 
				 g.fillOval(xInnerBound + (yTicSpace * i) - 3, (int) (yInnerBound + ((250 - player1.hmQ.get(player1.position).getPassingYards()[i]))*1.2) - 3, 6, 6);
				 
				 //Draws the 4 lines between the 5 points
				 //starts between 4 and 3 weeks ago
				 //Goes until predicted next week
				 if(i != 4) {
					 
					 g.drawLine(xInnerBound + (yTicSpace * i), (int) (yInnerBound + ((250 - player1.hmQ.get(player1.position).getPassingYards()[i]) * 1.2)), xInnerBound + (yTicSpace * (i+1)), (int) (yInnerBound + ((250 - player1.hmQ.get(player1.position).getPassingYards()[i+1]) * 1.2)));
				 
				 }
			 }
			 else {
				 g.fillOval(xInnerBound + (yTicSpace * i) - 3, (int) (yInnerBound + ((250 - player1.hmSP.get(player1.position).getScrimmageYards()[i]) * 1.2)) - 3, 6, 6);
				 
				 if(i != 4) {
					 g.drawLine(xInnerBound + (yTicSpace * i), (int) (yInnerBound + ((250 - player1.hmSP.get(player1.position).getScrimmageYards()[i]) * 1.2)),  xInnerBound + (yTicSpace * (i+1)), (int) (yInnerBound + ((250 - player1.hmSP.get(player1.position).getScrimmageYards()[i+1]) * 1.2)));
				 }
			 }
		 }
		 
		 
		 g.setColor(Color.BLACK);
		 
		 drawGraph(xInnerBound, xOuterBound, yInnerBound, yOuterBound, g);
	   }
	   
	   private void drawGraph2(Graphics g) {
		 int xInnerBound = 750;
		 int xOuterBound = xInnerBound + xRange;
		 int yInnerBound = 20;
		 int yOuterBound = yInnerBound + yRange;
		 
		 g.drawString("Reliability Score", yInnerBound + 300, xInnerBound - 360);
		 g.drawString("Week", yInnerBound + 320, xInnerBound - 35);
		 
		 g.setColor(Color.RED);
		 int fantasyPoints = 0;
		 int nextFantasyPoints = 0;
		 for(int i = 0; i < 5; i++) {
			 if(player1.position.equalsIgnoreCase("QB")) {
				 
				 //Fantasy Points by week
				 //starts at 4 weeks ago (ticSpace * 0)
				 //goes to next week (ticSpace * 4)
				 fantasyPoints = (int) ((player1.hmQ.get(player1.position).getPassingTouchdowns()[i]*4) + (player1.hmQ.get((player1).position).getPassingYards()[i] / 25));
				 g.fillOval(xInnerBound + (yTicSpace * i) - 3, (int) (yInnerBound + ((20 - fantasyPoints) * 15)) - 3, 6, 6);
				 
				 //Draws the 4 lines between the 5 points
				 //starts between 4 and 3 weeks ago
				 //Goes until predicted next week
				 if(i != 4) {
					 nextFantasyPoints = (int) ((player1.hmQ.get(player1.position).getPassingTouchdowns()[i+1]*4) + (player1.hmQ.get((player1).position).getPassingYards()[i+1] / 25));
					 g.drawLine(xInnerBound + (yTicSpace * i), (int) (yInnerBound + ((20 - fantasyPoints) * 15)), xInnerBound + (yTicSpace * (i+1)), (int) (yInnerBound + ((20 - nextFantasyPoints) * 15)));
				 }
			 }else {
				 fantasyPoints = (int) ((player1.hmSP.get(player1.position).getTouchdowns()[i]*6) + (player1.hmSP.get(player1.position).getScrimmageYards()[i] / 10));
				 g.fillOval(xInnerBound + (yTicSpace * i) - 3, (int) (yInnerBound + ((20 - fantasyPoints) * 15)) - 3, 6, 6);
				 
				 if(i != 4) {
					 nextFantasyPoints = (int) ((player1.hmSP.get(player1.position).getTouchdowns()[i+1]*6) + (player1.hmSP.get(player1.position).getScrimmageYards()[i+1]/10));
							 g.drawLine(xInnerBound + (yTicSpace * i), (int) (yInnerBound + ((20 - fantasyPoints) * 15)), xInnerBound + (yTicSpace * (i+1)), (int) (yInnerBound + ((20 - nextFantasyPoints) * 15)));
				 }
			 }
		 }
		 
		 g.setColor(Color.BLACK);
		 
		 drawGraph(xInnerBound, xOuterBound, yInnerBound, yOuterBound, g);

	   }

	   
	   private void drawGraph3(Graphics g) {
		int xInnerBound = 100;
		int xOuterBound = xInnerBound + xRange;
		int yInnerBound = 380;
		int yOuterBound = yInnerBound + yRange;
		 
		g.drawString("Fantasy Points", yInnerBound + 600, xInnerBound - 80);
		g.drawString("Week", yInnerBound + 610, xInnerBound + 250);
		
		g.setColor(Color.RED);
		 
		for(int i = 0; i < 5; i++) {
			 if(player1.position.equalsIgnoreCase("QB")) {
				 
				 //reliability by week
				 //starts at 4 weeks ago (ticSpace * 0)
				 //goes to next week (ticSpace * 4)
				 
				 g.fillOval(xInnerBound + (yTicSpace * i) - 3, (int) (yInnerBound + ((20 - player1.hmQ.get(player1.position).getReliabilityScore()[i]) * 15)) - 3, 6, 6);
				 
				 //Draws the 4 lines between the 5 points
				 //starts between 4 and 3 weeks ago
				 //Goes until predicted next week
				 if(i != 4) {
					 g.drawLine(xInnerBound + (yTicSpace * i), (int) (yInnerBound + ((20 - player1.hmQ.get(player1.position).getReliabilityScore()[i]) * 15)), xInnerBound + (yTicSpace * (i+1)), (int) (yInnerBound + ((20 - player1.hmQ.get(player1.position).getReliabilityScore()[i+1]) * 15)));
				 }
			 }
			 else {
				 
				 g.fillOval(xInnerBound + (yTicSpace * i) - 3, (int) (yInnerBound + ((20 - player1.hmSP.get(player1.position).getReliabilityScore()[i]) * 15)) - 3, 6, 6);
				 
				 if(i != 4) {
					 g.drawLine(xInnerBound + (yTicSpace * i), (int) (yInnerBound + ((20 - player1.hmSP.get(player1.position).getReliabilityScore()[i]) * 15)), xInnerBound + (yTicSpace * (i+1)), (int) (yInnerBound + ((20 - player1.hmSP.get(player1.position).getReliabilityScore()[i+1]) * 15)));
				 }
				 
			 }
		 }
		 g.setColor(Color.BLACK);
		
		drawGraph(xInnerBound, xOuterBound, yInnerBound, yOuterBound, g);

	   }
	   
      // Override paintComponent to perform my own painting
      @Override
      public void paintComponent(Graphics g) {
    	 super.paintComponent(g);
         setBackground(Color.WHITE);  // set background color for this JPanel
         g.setColor(Color.BLACK);
         g.setFont(new Font("Monospaced", Font.BOLD, 12));

         drawGraph1(g);
         drawGraph2(g);
         drawGraph3(g);

         
      }
	   
   }
 
   public static void main(String[] args) {
      // Needed to run GUI code
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Driver(); // Let the constructor do the job
         }
      });
   }
}