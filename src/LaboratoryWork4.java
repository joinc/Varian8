/*
* Составить  программу для управления скоростью движения точки по апплету. Одна кнопка увеличивает скорость,
* другая – уменьшает. Каждый щелчок изменяет скорость на определенную величину.
 */
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaboratoryWork4 {

    public static class MainFrame extends JFrame {
        private int speed_dot = 10;
        private JButton button_minus = new JButton("Скорость меньше");
        private JButton button_plus = new JButton("Скорость больше");
        private JLabel label_status = new JLabel("Скорость = " + speed_dot);
        private JPanel panel_button = new JPanel();
        private JPanel panel_main = new JPanel();
        private JPanel panel_status = new JPanel();

        public void init() {
            setTitle("Перемещение точки");
            setSize(new Dimension(500, 500));
            setResizable(false);
            button_plus.addActionListener(new PlusActionListener());
            button_minus.addActionListener(new MinusActionListener());
            panel_button.add(button_minus);
            panel_button.add(button_plus);
            panel_status.add(label_status);
            panel_main.setBorder(new EtchedBorder());
            panel_status.setBorder(new EtchedBorder());
            add(panel_button, BorderLayout.NORTH);
            add(panel_main);
            add(panel_status, BorderLayout.SOUTH);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public class PlusActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (speed_dot < 20) {
                    speed_dot++;
                    label_status.setText("Скорость = " + speed_dot);
                }
            }
        }

        public class MinusActionListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (speed_dot > 1) {
                    speed_dot--;
                    label_status.setText("Скорость = " + speed_dot);
                }
            }
        }

    }
    /*
        public class CircleComponent extends JPanel {
            private int x;
            private int y;
            Ellipse2D.Double circle;

            public CircleComponent() {
                circle = new Ellipse2D.Double(x, y, 10, 10);
            }

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                setBackground(Color.WHITE);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.RED);
                g2.fill(circle);
            }
        }
    */
    public static void main(String[] args) {
        MainFrame mf = new MainFrame();
        mf.init();

    }
}
