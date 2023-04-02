import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MyPanel extends JPanel {
    public int width = 500;
    public int height = 500;
    MyPanel() {
        this.setPreferredSize(new Dimension(width, height));
    }

    Array array = new Array();
//          MAPPING FUNCTION
//    public static double map(double value, double oldMin, double oldMax, double newMin, double newMax) {
//        return (((value - oldMin) * (newMax - newMin)) / (oldMax - oldMin)) + newMin;
//    }

    public void paint(Graphics g) {
        int numBars = 100;
        Graphics2D g2d = (Graphics2D) g;
        ArrayList<Integer> barHeights = array.generate(numBars);

        int barWidth = width / numBars;
        int maxBarHeight = height - 10;
        double scaleFactor = (double) maxBarHeight / (double) Collections.max(barHeights);
        int x = 0;
        int y = height;

        for (int i = 0; i < numBars; i++) {
            int barHeight = (int) (barHeights.get(i) * scaleFactor);
            g2d.drawRect(x, y - barHeight, barWidth, barHeight);
            x += barWidth;
        }
    }
}
