public class PhysicsEngine {
    public int fps = 60;

    public Ball ball;
    public Ball target;

    GameFrame context;

    public PhysicsEngine(GameFrame context){
        this.context = context;
    }
    public void run(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        updatePhysics();
                        Thread.sleep(1000/fps);
                    }
                    catch (Exception e){

                    }

                }
            }
        };
        runnable.run();

    }

    private void updatePhysics(){
        if(ball.y > -1000){
            ball.y += ball.speedY * (1f/fps);
            ball.x += ball.speedX * (1f/fps);
            ball.speedY -= 98* (1f/fps);
        }
        if(Math.sqrt(Math.pow(ball.x - target.x, 2)+Math.pow(ball.y - target.y, 2)) < 20){
            context.recreateTarget();
        }
        context.mainPanel.repaint();
    }
}
