import javax.swing.*;
import java.awt.*;

public class RenderPanel extends JPanel {
    private Ball ball;

    public void setTarget(Ball target) {
        this.target = target;
    }

    private Ball target;

    public RenderPanel(Ball ball){
        this.ball = ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval((int) (ball.x), 800-(int) (ball.y), 20, 20);
        g.setColor(Color.blue);
        g.fillOval((int) (target.x), 800-(int) (target.y), 20, 20);
    }
}
