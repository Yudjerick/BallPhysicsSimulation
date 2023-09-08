import javax.swing.*;

public class GameFrame extends JFrame {
    public JPanel mainPanel;
    private JSlider powerSlider;
    private JSlider angleSlider;
    private JButton shootButton;
    private JLabel scoreLabel;
    private Ball ball;

    private Ball target;

    PhysicsEngine physicsEngine;

    private int score = 0;

    public GameFrame(){
        setContentPane(mainPanel);
        setBounds(0,0,800,800);
        super.setTitle("Ball Shooting Game");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        physicsEngine = new PhysicsEngine(this);
        ball.x = 0;
        ball.y = 0;
        physicsEngine.ball = ball;
        physicsEngine.target = target;

        shootButton.addActionListener(e->{
            ball = new Ball();
            ((RenderPanel)mainPanel).setBall(ball);
            physicsEngine.ball = ball;
            ball.x = 0;
            ball.y = 0;
            ball.speedX = (float) Math.cos(Math.toRadians(angleSlider.getValue())) * powerSlider.getValue()*10;
            ball.speedY = (float) Math.sin(Math.toRadians(angleSlider.getValue())) * powerSlider.getValue()*10;
        });

        setVisible(true);
        scoreLabel.setText("score: "+ String.valueOf(score));
        physicsEngine.run();
    }

    public void recreateTarget(){
        score++;
        scoreLabel.setText("score: "+ String.valueOf(score));
        target.x = (float) (50 + Math.random() * 700);
        target.y = (float) (50 + Math.random() * 700);
    }

    private void createUIComponents() {
        ball = new Ball();
        mainPanel = new RenderPanel(ball);
        target = new Ball();
        target.x = (float) (Math.random() * 800);
        target.y = (float) (Math.random() * 800);

        ((RenderPanel) mainPanel).setTarget(target);

    }
}
