import javax.swing.JFrame;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainTurkeyViewer {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        final int FRAME_WIDTH = 300;
        final int FRAME_HEIGHT = 300;
        
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setTitle("Happy Thanksgiving");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btn = new JButton("Click to wink");
        btn.setBounds(10, FRAME_HEIGHT-60, 150, 20);
        frame.add(btn);
        
        // Second stage
        TurkeyComponent turkey1 = new TurkeyComponent(  FRAME_WIDTH/4, 
                                                        FRAME_HEIGHT/4,
                                                        FRAME_WIDTH/4);

        frame.add(turkey1);
        
        class ListenWink implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                turkey1.wink();
                frame.repaint();
            }
        }
        
        ActionListener listener = new ListenWink();
        btn.addActionListener(listener);
        
        //       
        frame.setVisible(true);   
    }
}
