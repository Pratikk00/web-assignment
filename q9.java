import java.applet.Applet;
import java.awt.Graphics;

public class ScrollingApplet extends Applet implements Runnable {
    private String textToScroll;
    private int xCoordinate = 300; // Initial x-coordinate for text

    public void init() {
        // Retrieve the value of the "text" parameter from the HTML page
        textToScroll = getParameter("text");

        // If the parameter is not provided, set a default text
        if (textToScroll == null || textToScroll.isEmpty()) {
            textToScroll = "Default Scrolling Text!";
        }

        // Start a thread to handle the scrolling animation
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            // Scroll the text by decrementing x-coordinate
            xCoordinate--;

            // If the text has moved off the applet, reset x-coordinate
            if (xCoordinate < -500) {
                xCoordinate = getWidth();
            }

            // Repaint the applet
            repaint();

            try {
                // Add a delay to control the scrolling speed
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        // Display the scrolling text on the applet
        g.drawString(textToScroll, xCoordinate, 20);
    }
}
