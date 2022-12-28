  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.SKYBLUE);
    g.fillRect(0, 0, WIDTH, HEIGHT);
    g.setColor(Color.GREEN);
    g.fillRect(0, groundY, WIDTH, GROUND_HEIGHT);
    g.setColor(Color.RED);
    g.fillRect(birdX, birdY, BIRD_WIDTH, BIRD_HEIGHT);
    for (Pipe pipe : pipes) {
      g.setColor(Color.GREEN.darker());
      g.fillRect(pipe.getX(), 0, PIPE_WIDTH, pipe.getTopHeight());
      g.fillRect(pipe.getX(), pipe.getBottomY(), PIPE_WIDTH, pipe.getBottomHeight());
    }
    if (gameOver) {
      g.setColor(Color.BLACK);
      g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
      g.drawString("Game Over", WIDTH / 2 - 75, HEIGHT / 2);
    }
  }
