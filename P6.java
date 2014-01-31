import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @see java.awt.Color
 * @see java.awt.event.ItemListener ...
 **/
 public class P6 extends JApplet implements ItemListener, ActionListener
 {
   private int x1 = 20, y1 = 100;          // upper left coord
   private int x2 = 500, y2 = 500;         // lower end coord
   static int shape; //
   private String [] shapeNames = {"Arc", "Line", "Oval", "Polygon"};
   private JRadioButton jrbRed, jrbBlue, jrbGreen, jrbYellow;
   private JComboBox<String> shapeComboBox;      // shape combo box reference
   private Color color = Color.blue;                  // color reference

   public void init()
   {

    shapeComboBox = new JComboBox<String>(shapeNames);//populate list
		shapeComboBox.setSelectedIndex(-1);
    shapeComboBox.addItemListener(this);
    

    ButtonGroup bGroup = new ButtonGroup();//Radio button manager
    jrbBlue = new JRadioButton("Blue");//instantiate Blue radio button
    jrbBlue.setForeground(Color.blue); // blue colored text label
    jrbBlue.setBackground(Color.black); // black button
    bGroup.add(jrbBlue); // group for Radio Button

    jrbRed = new JRadioButton("Red"); //instantiate Red Radio Button
    jrbRed.setForeground(Color.red); //red colored text label
    jrbRed.setBackground(Color.black); //black button
		bGroup.add(jrbRed);

    jrbYellow = new JRadioButton("Yellow"); //instantiate yellow Radio Button
    jrbYellow.setForeground(Color.yellow); // yellow colored text label
    jrbYellow.setBackground(Color.black); // black button
    bGroup.add(jrbYellow);

    jrbGreen = new JRadioButton("Green"); //instantiate Green Radio Button
    jrbGreen.setForeground(Color.green); // green colored text label
    jrbGreen.setBackground(Color.black); // black button
		bGroup.add(jrbGreen);
    
    setLayout( new FlowLayout()); //set FlowLayout manager
    add(jrbBlue); // add buttons to applet
    add(jrbRed);
    add(jrbYellow);
    add(jrbGreen);

    setBackground(Color.white);//applet background white

    jrbBlue.setSelected(true);//default color for shape
    jrbBlue.addActionListener(this); // register listener
    jrbRed.addActionListener(this);
    jrbYellow.addActionListener(this);
    jrbGreen.addActionListener(this);
    add(shapeComboBox);
   }
   public void paint(Graphics g)
   {
     super.paint(g);
     g.drawRect (x1, y1, x2-x1, y2-y1); // bounding rectangle
     g.setColor(color);              // radio button choice
     final int ARC = 1;
		 final int LINE = 2;
		 final int OVAL = 3;
		 final int POLYGON = 4;
	   Polygon polly = new Polygon();
		 switch(shape)
		 {
		  case ARC: 
        g.fillArc(x1, y1, x2-x1, y2-y1, 0, 45); //start at 0 for 45
        g.fillArc(x1, y1, x2-x1, y2-y1, 90, 45); // start at 90 for 45
        g.fillArc(x1, y1, x2-x1, y2-y1, 180, 45); //start at 180 for 45
        g.fillArc(x1, y1, x2-x1, y2-y1, 270, 45); //start at 270 for 45
		    break;
		 case LINE:
        g.drawLine( x1, y1, x2, y2);
				break;
     case POLYGON:
				polly.addPoint(x1, y1);
				polly.addPoint(x2, y1);
				polly.addPoint((x2+x1)/2, (y1+y2)/2);
				polly.addPoint(x1, y2);
				polly.addPoint(x2, y2);
				g.fillPolygon(polly);
				break;
		 case OVAL:
				g.drawOval(x1, y1, x2-x1, y2-y1);//oval based on its bounding rect
				g.fillOval(x1, y1, x2-x1, y2-y1);
				break;
		 }
   }
   public void itemStateChanged(ItemEvent e)
   {
     shape = shapeComboBox.getSelectedIndex() + 1;
     repaint();
   }
   public void actionPerformed(ActionEvent e)
   {
     if(e.getSource() == jrbBlue)
				 color = Color.blue;
     else if(e.getSource() == jrbRed)
				 color = Color.red;
     else if(e.getSource() == jrbYellow)
       color = Color.yellow;
     else if(e.getSource() == jrbGreen)
       color = Color.green;
		 repaint();
   }
 }
