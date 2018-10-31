import java.awt.*;       // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT event classes and listener interfaces
import javax.swing.*;    // Using Swing's components and containers

public class Driver extends JFrame {
   // Define canvas size constants
   public static final int CANVAS_WIDTH  = 1500;
   public static final int CANVAS_HEIGHT = 750;
  int pageFlag = 1;
  
  SkillPosition player1 = new SkillPosition();

 
   public Driver() {

	   
	   
	   player1.setName("");
	   player1.setName("David Johnson");
	   player1.setPosition("Running Back");
	   player1.setTeam("Cardinals");
	   player1.setScrimmageYards(100);
	   player1.setTouchdowns(2);
	   player1.setTouches(20);
	   player1.setReliabilityScore(10);
	   
	   Container cp = getContentPane();

	      if(pageFlag == 0) {
	    	  
	    	 
	    	  EnterFields canvas = new EnterFields();
		      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		      
		      JButton b1 = new JButton("Submit Player Info");
		      b1.setBounds(950, 650, 200, 50);
		      b1.setMnemonic(KeyEvent.VK_D);
		      b1.setActionCommand("Submit");   
		      //b1.addActionListener(new Submit());
		      
		      cp.add(b1);
		      cp.add(canvas);
		      
		  }else {
			  DrawGraphs canvas = new DrawGraphs(player1);
		      canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		      
		      JButton b1 = new JButton("Enter New Player");
		      b1.setBounds(950, 650, 200, 50);
		      b1.setMnemonic(KeyEvent.VK_D);
		      b1.setActionCommand("Clear");
		      //b1.addActionListener(new Clear());
		      
		      cp.add(b1);
		      cp.add(canvas);	      
	      
		  }
	      
	      setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
	      pack();              // Sets the size of the canvas
	      setTitle("Fantasy Football Visualizer");
	      setVisible(true);
	  
	  
   }
   
   
   private class EnterFields extends JPanel{
	   
	   
	   private void EnterFields(Graphics g) {
		   
		   g.drawString("Works!", 50, 50);
		   
	   }

	   
	   public void paintComponent(Graphics g) {
		   super.paintComponent(g);
	       setBackground(Color.WHITE);  // set background color for this JPanel
	  
           g.setColor(Color.BLACK);
	       g.setFont(new Font("Monospaced", Font.BOLD, 12));
	       
	       EnterFields(g);
	          
	    }
	   
   }
   
   
   
   private class DrawGraphs extends JPanel {
	   
	   SkillPosition player1;
	   
	   /*
	    * TODO: put up first page with certain amount of input boxes
	    * put a button click to submit for new player
	    * on button click make a player and then draw graphs 
	    */
	   
	   
	   public DrawGraphs(SkillPosition player1) {
		   
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
		   
		 g.drawString(player1.getName(), 900, 500);
		 g.drawString(player1.getTeam(), 900, 525);
		 g.drawString(player1.getPosition(), 900, 550);
	     		 
		 int xInnerBound = 100;
		 int xOuterBound = xInnerBound + xRange;
		 int yInnerBound = 20;
		 int yOuterBound = yInnerBound + yRange;
		 
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