// javax : used to be java-extension. Now part of the standard library.
// Swing started as extension, now officialy part of the library.
import javax.swing.JComponent;

// AWT: Abstract Windowing Toolkit
import java.awt.Graphics;
// Graphics 2D: A more powerful graphic capabilities
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;
import java.awt.Stroke;
import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class TurkeyComponent extends JComponent {

    double myX, myY;
    double myW, myH;
    
    boolean winking=false;
    
    public TurkeyComponent()
    {
    }
    
    public TurkeyComponent(double x, double y, double w)
    {
        myX = x;
        myY = y;
        myW = w;
        myH = myW * 1.5;
    }

    public void wink()
    {
        winking = !winking ;
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g; // Casting!!
        
        // First draw the body thing below, in two stages.
        Ellipse2D.Double tail = new Ellipse2D.Double(myX-0.1*myW,myY-20,myW*1.2,myH);
        Color tailColor = Color.YELLOW;
        g2.setColor(tailColor);
        g2.fill(tail);  

        Ellipse2D.Double body = new Ellipse2D.Double(myX,myY,myW,myH);
        g2.draw(body);
        
        Color bodyColor = Color.ORANGE;
        g2.setColor(bodyColor);
        g2.fill(body);  // replaces! g2.draw(body);
        
        
        Ellipse2D.Double head = new Ellipse2D.Double(myX+0.5*myX-12,myY,24,30);
        Color headColor = Color.WHITE;
        g2.setColor(headColor);
        g2.fill(head);  
        
        Rectangle2D.Double leftLeg = new Rectangle2D.Double(myX+0.5*myX-20,myY+myH-12,5,20);
        Color legColor = Color.PINK;
        g2.setColor(legColor);
        g2.fill(leftLeg);  

        Rectangle2D.Double rightLeg = new Rectangle2D.Double(myX+0.5*myX+20,myY+myH-12,5,20);
        g2.setColor(legColor);
        g2.fill(rightLeg);  
        
        Ellipse2D.Double leftEye = new Ellipse2D.Double(myX+0.5*myX-8,myY+6,6,6);
        Color eyeColor = Color.BLACK;
        g2.setColor(eyeColor);
        g2.fill(leftEye);  
        
        if (!winking)
        {
            Ellipse2D.Double rightEye = new Ellipse2D.Double(myX+0.5*myX+3,myY+6,6,6);
            g2.setColor(eyeColor);
            g2.fill(rightEye);  
        }
        else
        {
            double x0=myX+0.5*myX+3 ;
            double y0=myY+9;
            Line2D.Double rightEye = new Line2D.Double(x0,y0,x0+8,y0);
            g2.setColor(eyeColor);    
            Stroke stroke = new BasicStroke(2f);
            Stroke oldStroke = g2.getStroke();
            g2.setStroke(stroke);
            g2.draw(rightEye);
            g2.setStroke(oldStroke);
        }
        Ellipse2D.Double wattle = new Ellipse2D.Double(myX+0.5*myX-4,myY+20,8,15);
        g2.setColor(Color.RED);
        g2.fill(wattle);     
    }
}
