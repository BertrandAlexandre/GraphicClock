package fr.alexandrebertrand.graphicclock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javafx.embed.swing.JFXPanel;
import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public final class App extends JFrame {
    
    /*
     * Constructor
     */

    /**
     * Constructor to initialize the UI view
     */
    public App() {
        initUI();
    }

    /*
     * Methods
     */

    /**
     * Initialize the UI view
     */
    public void initUI() {
        final JFXPanel fxPanel = new JFXPanel();
        add(new Board());

        setPreferredSize(new Dimension(400, 420));
        setResizable(false);
        pack();
        
        setTitle("Graphic Clock");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Launcher of the game
     * 
     * @param args Main arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new App();
            ex.setVisible(true);
        });
    }

}
