package MySnakeGame;

import javax.swing.JFrame;
import java.awt.*;


public class Frame {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        console game = new console();

        frame.setBounds(10,10,915,700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.add(game);


    }
}
