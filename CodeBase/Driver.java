import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers

public class Driver extends JFrame {
   // Define canvas size constants
   public static final int CANVAS_WIDTH  = 1500;
   public static final int CANVAS_HEIGHT = 750;
  
   FantasyPlayer player1 = new FantasyPlayer();
 
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
		   p1 = new CreatePlayer(playerName.getText(), playerPosition.getText(), playerTeam.getText(), playerYards.getText(), playerTouchdowns.getText(), playerAttempts.getText(), week.getText());
	   }
 	  	   
	   public void actionPerformed(ActionEvent e) {
		   createPlayer();
		   
		   this.removeAll();
		   
		   Container cp = getContentPane();
		   
		   DrawGraphs frame2 = new DrawGraphs(p1);
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
	   /*
	    * TODO: put up first page with certain amount of input boxes
	    * put a button click to submit for new player
	    * on button click make a player and then draw graphs 
	    */
	   
	   
	   public DrawGraphs(CreatePlayer player1) {
		   this.player1 = player1;
	   }

	/*
	    * TODO: Get current week from user input to draw out x-axis of graphs
	    */	  
	   
	   private int xRange = 500;
	   private int yRange = 300;
	   private int xTicSpace = yRange/10;
	   private int yTicSpace = xRange/4;
	   
	   private void drawGraph(int x1, int x2, int y1, int y2, Graphics g) {
		   
		  /*
		   * TODO: Draw filled red ovals (really circles) wherever there belongs a point
		   * TODO: Draw red lines between the players' point values
		   * How to set color and then draw an oval:
		   * g.setColor(Color.RED);
		   * g.fillOval(300, 310, 30, 50);
		   */
		   
		   g.drawLine(x1, y1, x1, y2);
		   g.drawLine(x1, y2, x2, y2);		   
		   
		   int xTicIterator = y1;
		   
		   for(int i = 0; i < 10; i++) {
			   g.drawLine(x1-5, xTicIterator, x1+5, xTicIterator);
			   if(i <= 5) {
				   g.drawString(String.valueOf(20 - (i*2)), x1-20, xTicIterator+5);
			   }
			   else{
				   g.drawString(String.valueOf(20 - (i*2)), x1-15, xTicIterator+5);
			   }
			   xTicIterator += xTicSpace;
		   }
		   
		   int yTicIterator = x2;
		   
		   //int currentWeek = 0;
		   
		   for(int i = 0; i < 4; i++) {
			   g.drawLine(yTicIterator, y2+5, yTicIterator, y2-5);
			   //g.drawString(String.valueOf(currentWeek - i), yTicIterator-3, y2+15);
			   yTicIterator -= yTicSpace;
			   if(i == 3) {
				   //g.drawString(String.valueOf(currentWeek - i - 1), yTicIterator-3, y2+15);
			   }
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
		 //just for demo
		 g.drawString(String.valueOf(player1.getWeek()), 500, 50);
		 drawGraph(xInnerBound, xOuterBound, yInnerBound, yOuterBound, g);
		 /*
		 g.drawLine(30, 30, 30, 300);
         g.drawLine(30, 300, 530, 300);
         */
	   }
	   
	   private void drawGraph2(Graphics g) {
		 int xInnerBound = 750;
		 int xOuterBound = xInnerBound + xRange;
		 int yInnerBound = 20;
		 int yOuterBound = yInnerBound + yRange;
		 
		 drawGraph(xInnerBound, xOuterBound, yInnerBound, yOuterBound, g);

	   }

	   
	   private void drawGraph3(Graphics g) {
		int xInnerBound = 100;
		int xOuterBound = xInnerBound + xRange;
		int yInnerBound = 380;
		int yOuterBound = yInnerBound + yRange;
		 
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