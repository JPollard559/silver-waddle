import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener {

  private static final int WIDTH = 400;
  private static final int HEIGHT = 600;
  private static final int BIRD_WIDTH = 40;
  private static final int BIRD_HEIGHT = 30;
  private static final int PIPE_WIDTH = 50;
  private static final int PIPE_GAP = 150;
  private static final int PIPE_SPACING = 200;
  private static final int GROUND_HEIGHT = 50;

  private Timer timer;
  private int ticks;
  private int birdX;
  private int birdY;
  private int birdVelocity;
  private int birdAcceleration;
  private int groundY;
  private boolean gameOver;
  private List<Pipe> pipes;
  private Random random;

  public FlappyBird() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          if (gameOver) {
            reset();
          } else {
            birdVelocity = -10;
          }
        }
      }
    });

    timer = new Timer(20, this);
    reset();
  }

  private void reset() {
    ticks = 0;
    birdX = WIDTH / 2 - BIRD_WIDTH / 2;
    birdY = HEIGHT / 2 - BIRD_HEIGHT / 2;
    birdVelocity = 0;
    birdAcceleration = 1;
    groundY = HEIGHT - GROUND_HEIGHT;
    gameOver = false;
    pipes = new ArrayList<>();
    pipes.add(new Pipe());
    random = new Random();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ticks++;

    // update bird position
    birdVelocity += birdAcceleration;
    birdY += birdVelocity;

    // check for game over
    if (birdY < 0 || birdY + BIRD_HEIGHT > groundY) {
      gameOver = true;
    }

    // update pipes
    Pipe firstPipe = pipes.get(0);
    if (firstPipe.getX() + PIPE_WIDTH < 0) {
      pipes.remove(firstPipe);
    }
    if (ticks % PIPE_SPACING == 0) {
      pipes.add(new Pipe());
    }
    for (Pipe pipe : pipes) {
      pipe.setX(pipe.getX() - 2);
    }