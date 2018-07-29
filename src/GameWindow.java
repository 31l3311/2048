import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame
{
  private GameWindow.PlayField playfield;
  private int squaresize = 60;
  private int mposx = 0,mposy = 0;
  private final int mouseBuffer = 200;
  private int score = 0;
  private Logic logic;
  
  public GameWindow(int numbrows, int numbcols)
  {
    super("GameWindow");
    setDefaultCloseOperation(2);
    setResizable(false);

    numbcols++;
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //this.squaresize = (screenSize.width / (5 * numbcols));
    int left = (screenSize.width - numbcols * this.squaresize) / 2;
    int top = (screenSize.height - numbrows * this.squaresize) / 2;
    setLocation(left, top);
    
    this.playfield = new PlayField();
    //Keydown
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

      @Override
      public boolean dispatchKeyEvent(KeyEvent ke) {
              switch (ke.getID()) {
              case KeyEvent.KEY_PRESSED:
                  if (ke.getKeyCode() == KeyEvent.VK_W || ke.getKeyCode() == KeyEvent.VK_UP) {
                    System.out.println("Up (KEY)");
                    playfield.board = logic.move(playfield.board,'u');
                  } else if (ke.getKeyCode() == KeyEvent.VK_A || ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    System.out.println("Left (KEY)");
                    playfield.board = logic.move(playfield.board,'l');
                  } else if (ke.getKeyCode() == KeyEvent.VK_S || ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    System.out.println("Down (KEY)");
                    playfield.board = logic.move(playfield.board,'d');
                  } else if (ke.getKeyCode() == KeyEvent.VK_D || ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    System.out.println("Right (KEY)");
                    playfield.board = logic.move(playfield.board,'r');
                  }
                  break;
              }
              //printBoard(playfield.board);
              return false;  
      }
  });

    //Mouse
    this.playfield.addMouseListener(new MouseListener() {
      public void mouseReleased(MouseEvent e) {
        if(mposx+mouseBuffer < e.getX()){ //right
          System.out.println("Right (MOUSE)");
        } else if(mposx-mouseBuffer > e.getX()){ //left
          System.out.println("Left (MOUSE)");
        } else if(mposy+mouseBuffer < e.getY()){ //down
          System.out.println("Down (MOUSE)");
        } else if(mposy-mouseBuffer > e.getY()){ //up
          System.out.println("Up (MOUSE)");
        }
      }
      
      public void mousePressed(MouseEvent e) {
        mposx = e.getX();
        mposy = e.getY();
      }
      
      public void mouseExited(MouseEvent e) {}
      
      public void mouseEntered(MouseEvent e) {}
      
      public void mouseClicked(MouseEvent e) {}
    });

    
    
    this.playfield.setPreferredSize(new Dimension(numbrows * this.squaresize, numbcols * this.squaresize));
    add(this.playfield, "Center");
    
    //this.moves = new ArrayList();
    
    pack();
  }
  
  private void addInput(int direction) {
    //this.moves.add(Integer.valueOf(i));
    //this.moves.add(Integer.valueOf(j));
  }
  
  public void printBoard(int[][] board) {
    this.playfield.setInfo(board);
    setVisible(true);
    this.playfield.repaint();
  }

  public void setLogic(Logic logic) {
    this.logic = logic;
  }


  private class PlayField extends JPanel {

    private int squaresize = 55;

    private int[][] board;
    private boolean[][] open;
    
    private PlayField() {}
    
    public void setInfo(int[][] board)
    {
      this.board = board;
    }

    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      Font currentFont = g.getFont();
      Font newFont = currentFont.deriveFont(GameWindow.this.squaresize / 1.5F);
      g.setFont(newFont);
      
      g2.setColor(Color.GRAY);
      g2.fill(getVisibleRect());

      System.out.println("-------CreatingField-------");
      System.out.println("Creating field (ROW/COLUMN)");

      for (int i = 0; i < this.board.length; i++) { //ROW
        for (int j = 0; j < this.board[0].length; j++) { //COLUMN
            System.out.println("(i:"+i+"/j:"+j+")["+this.board[j][i]+"]");
            int ii = i+1;
            int jj = j+1;

            switch(this.board[j][i]){
              case(0):g2.setColor(Color.LIGHT_GRAY);break;
              case(2):g2.setColor(Color.BLUE);break;
              case(4):g2.setColor(Color.BLACK);break;
              case(8):g2.setColor(Color.GREEN);break;
            }

            //g2.setColor(new Color(0x2dce98));

            g2.fill(new Rectangle2D.Double(i * GameWindow.this.squaresize + 1, j * GameWindow.this.squaresize + 1, GameWindow.this.squaresize - 1, GameWindow.this.squaresize - 1));

            if (this.board[j][i] != 0) {
              g2.setColor(Color.ORANGE);
              if(twodolar(this.board[j][i]) != 0){
                g2.drawString(""+twodolar(this.board[j][i]), i * GameWindow.this.squaresize + GameWindow.this.squaresize / 3, jj * GameWindow.this.squaresize - GameWindow.this.squaresize / 4);
              }


              /* DEPRECATED
              switch(this.board[j][i]){
                case(2):
                  g2.drawString("2", i * GameWindow.this.squaresize + GameWindow.this.squaresize / 3, jj * GameWindow.this.squaresize - GameWindow.this.squaresize / 4);
                  break;
                case(4):
                  g2.drawString("4", i * GameWindow.this.squaresize + GameWindow.this.squaresize / 3, jj * GameWindow.this.squaresize - GameWindow.this.squaresize / 4);
                  break;
                case(8):break;
              }
              */
            }
          }
      }
      g2.setColor(Color.BLUE);
      g2.drawString("Score:"+score, 2, (this.board[0].length+1) * GameWindow.this.squaresize - GameWindow.this.squaresize / 4);
    }

    public int twodolar(int i){
      if(i%2 == 0) {
        return i;
      }
      return 0;
    }
  }
}