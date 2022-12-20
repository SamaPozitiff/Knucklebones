package knucklebonesGame.view;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class PaintGame extends JLabel {

    Image bg = new ImageIcon("src/main/resources/background_boards.png").getImage();

    @Bean
    public PaintGame getPaintGame(){
    return new PaintGame();
    }


    public PaintGame(){
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0,0, this.getWidth(), this.getHeight(), this);
    }





}
