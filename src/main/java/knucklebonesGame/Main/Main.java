package knucklebonesGame.Main;

import knucklebonesGame.Model.Field;
import knucklebonesGame.View.GameFrame;
import knucklebonesGame.View.PaintGame;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
public class Main {

    public static void main (String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("knucklebonesGame");

        Field allyField = context.getBean("allyField", Field.class);
        Field enemyField = context.getBean("enemyField", Field.class);
        GameFrame gameFrame = context.getBean(GameFrame.class);

        allyField.addValueToRow(1, 6);
        allyField.addValueToRow(1,6);
        allyField.addValueToRow(1,4);
        allyField.removeValueFromRow(1,6);
        System.out.println(Arrays.toString(allyField.getField()[1]));
        System.out.println(Arrays.toString(enemyField.getField()[1]));
    }
}
