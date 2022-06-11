import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {


    public GameFrame() {

        setBounds(400, 100, Data.getBackground().getWidth(), Data.getBackground().getHeight());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Java飞机大战");
        setBackground(Color.BLACK);
    }


}
