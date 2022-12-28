  // check for collisions
  Rectangle birdRect = new Rectangle(birdX, birdY, BIRD_WIDTH, BIRD_HEIGHT);
  for (Pipe pipe : pipes) {
    Rectangle topPipeRect = new Rectangle(pipe.getX(), 0, PIPE_WIDTH, pipe.getTopHeight());
    Rectangle bottomPipeRect = new Rectangle(pipe.getX(), pipe.getBottomY(), PIPE_WIDTH, pipe.getBottomHeight());
    if (birdRect.intersects(topPipeRect) || birdRect.intersects(bottomPipeRect)) {
      gameOver = true;
      break;
    }
  }
  if (birdRect.intersects(new Rectangle(0, groundY, WIDTH, GROUND_HEIGHT))) {
    gameOver = true;
  }
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
  private static final int BIRD_HE
