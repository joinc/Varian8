/*
* Составить  программу для управления скоростью движения точки по апплету. Одна кнопка увеличивает скорость,
* другая – уменьшает. Каждый щелчок изменяет скорость на определенную величину.
 */
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class LaboratoryWork4 extends JComponent {

    public static int speed_dot = 10;
    private int x = 199;
    private int y = 89;
    private int dx = 1;
    private int dy = 1;

    public LaboratoryWork4() {
        Timer timer = new Timer(10, e -> repaint());
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.black);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(1f));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if ((x <= 5) || (x >= width - 5)) { dx = -1 * dx; }
        if ((y <= 5) || (y >= height - 5)) { dy = -1 * dy; }
        x = x + dx * speed_dot;
        y = y + dy * speed_dot;
        g2d.setColor(Color.RED);
        g2d.fill(circle(x, y, 5));
    }

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }

    public static class PlusActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (speed_dot < 20) {
                speed_dot++;
                System.out.println(speed_dot);
            }
        }
    }

    public static class MinusActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (speed_dot > 1) {
                speed_dot--;
                System.out.println(speed_dot);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Перемещение точки");
                JButton button_minus = new JButton("Скорость меньше");
                JButton button_plus = new JButton("Скорость больше");
                button_plus.addActionListener(new PlusActionListener());
                button_minus.addActionListener(new MinusActionListener());
                JPanel panel_button = new JPanel();
                panel_button.add(button_minus);
                panel_button.add(button_plus);
                panel_button.setBorder(new EtchedBorder());
                frame.add(panel_button, BorderLayout.NORTH);
                frame.add(new LaboratoryWork4());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setResizable(false);
                frame.setVisible(true);
            }
        });
    }
}
