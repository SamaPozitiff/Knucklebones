package knucklebonesGame.View;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class GameFrame extends  JLabel{

    JFrame frame;
    PaintGame paintGame;

    @Autowired
    public GameFrame(PaintGame paintGame){

        this.paintGame = paintGame;
        frame = new JFrame("KnuckleBones");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.setSize(1920,1080);
        paintGame.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
        frame.getContentPane().add(paintGame);
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.red);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
