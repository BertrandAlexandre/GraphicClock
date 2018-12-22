package fr.alexandrebertrand.graphicclock;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Board of the application
 * 
 * @author Alexandre Bertrand
 */
public final class Board extends JPanel implements ActionListener {

    /*
     * Attributes
     */
	
    /** Main timer of the app */
    private final Timer timer;
    
    /*
     * Constructors
     */
    
    /**
     * Default constructor of the game
     * Initialise the board and the game
     */
    public Board() {
    	int ms = (int) Math.round(1000d / 60);
    	timer = new Timer(ms, this);
    	timer.start();
        setBackground(new Color(30, 30, 30));
        setOpaque(true);
    }
    
    /*
     * Methods
     */

    /**
     * Performed action
     * 
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    /**
     * Paint components
     * 
     * @param g Graphic context
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        FontMetrics fm;
        LocalDateTime d = LocalDateTime.now();
        int r = 90;
        g2.setColor(Color.WHITE);
        g2.drawOval(69, 69, 262, 262);
        g2.drawOval(45, 45, 310, 310);
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));
        g2.drawLine(200, 200, 200, 200);
        
        g2.setColor(Color.WHITE);
        for (int i = 0; i < 12; i++) {
            if ((12 - i) % 3 == 0) {
                g2.setFont(g2.getFont().deriveFont(25f));
            } else {
                g2.setFont(g2.getFont().deriveFont(17f));
            }
            fm = g2.getFontMetrics();
            int hs = 110;
            double ht = Math.toRadians((i * 30 + 180) % 360);
            int hx = (int) (Math.sin(ht) * hs + 200);
            int hy = (int) (Math.cos(ht) * hs + 200);
            int hv = 12 - i;
            g2.drawString(String.valueOf(hv),
                    hx - fm.stringWidth(String.valueOf(hv)) / 2, hy + 10);
        }
        
        drawSeconds(g2, d, r);
        drawMinutes(g2, d, r);
        drawHours(g2, d, r);
    }
    
    /**
     * Draw seconds of the clock
     * 
     * @param g2 2D graphic context
     * @param d  Current local date time
     * @param r  Rotation of the clock
     */
    private void drawSeconds(Graphics2D g2, LocalDateTime d, int r) {
        g2.setColor(Color.GREEN);
        int secondsAngle = - (d.getSecond() * 360 / 60);
        g2.drawArc(64, 64, 272, 272, r, secondsAngle);
        
        int hs = -90;
        double ht = Math.toRadians(secondsAngle);
        int hx = (int) (Math.sin(ht) * hs + 200);
        int hy = (int) (Math.cos(ht) * hs + 200);
        g2.drawLine(200, 200, hx, hy);
    }
    
    /**
     * Draw minutes of the clock
     * 
     * @param g2 2D graphic context
     * @param d  Current local date time
     * @param r  Rotation of the clock
     */
    private void drawMinutes(Graphics2D g2, LocalDateTime d, int r) {
        g2.setColor(Color.PINK);
        int minutesAngle = - (d.getMinute() * 360 / 60);
        g2.drawArc(57, 57, 286, 286, r, minutesAngle);
        
        int ms = -70;
        double mt = Math.toRadians(minutesAngle);
        int mx = (int) (Math.sin(mt) * ms + 200);
        int my = (int) (Math.cos(mt) * ms + 200);
        g2.drawLine(200, 200, mx, my);
    }
    
    /**
     * Draw hours of the clock
     * 
     * @param g2 2D graphic context
     * @param d  Current local date time
     * @param r  Rotation of the clock
     */
    private void drawHours(Graphics2D g2, LocalDateTime d, int r) {
        g2.setColor(Color.CYAN);
        int hoursAngle = - ((d.getHour() % 12) * 360 / 12);
        g2.drawArc(50, 50, 300, 300, r, hoursAngle);
        
        int ss = -50;
        double st = Math.toRadians(hoursAngle);
        int sx = (int) (Math.sin(st) * ss + 200);
        int sy = (int) (Math.cos(st) * ss + 200);
        g2.drawLine(200, 200, sx, sy);
    }
    
}
