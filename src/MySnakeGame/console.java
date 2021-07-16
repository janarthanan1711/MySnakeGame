package MySnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class console extends JPanel implements KeyListener, ActionListener {

     private ImageIcon righthead;
     private ImageIcon lefthead;
     private ImageIcon uphead;
     private ImageIcon downhead;
     private ImageIcon snakebody;

     private Timer timer;
     private int delay = 100;

     private boolean right = false;
     private boolean left = false;
     private boolean up = false;
     private boolean down = false;



     private int snakelength = 3;

    private int xposition[] = new int[1000];
    private int yposition[] = new int[1000];


    private ImageIcon snakeHeaderImage;

    private int [] getXposition = {25,50,75,100,125,150,175,200,225,250,275,300,325,
            350,375,400,425,450,475,500,525,550,575,600,625,650,675,
            700,725,750,775,800};
    private int [] getYposition = {75,100,125,150,175,200,225,250,275,300,325,350,
             375,400,425,450,475,500,525,550,575,600,675};

    private ImageIcon appleimage;
    private Random random = new Random();

    private int xpos = random.nextInt(34);
    private int ypos = random.nextInt(23);

    private int score = 0;
    private int moves;

    private int numberofmoves = 0;

    public console()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }


     public void paint(Graphics graphics){

        snakeHeaderImage = new ImageIcon("snaketitle.jpg");
        snakeHeaderImage.paintIcon(this,graphics,25,10);

        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(25,75,850,575);

        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font("arial",Font.BOLD, 16 ));
        graphics.drawString("Scores: "+score, 800, 30);

         graphics.setColor(Color.BLUE);
         graphics.setFont(new Font("arial",Font.BOLD, 16 ));
         graphics.drawString("Length: "+snakelength, 800, 50);



        if(numberofmoves==0){
            snakelength = 3;

            righthead = new ImageIcon("righthead.png");

            xposition[2] = 50;
            xposition[1] = 75;
            xposition[0] = 100;
            yposition[2] = 100;
            yposition[1] = 100;
            yposition[0] = 100;

            righthead.paintIcon(this,graphics,xposition[0],yposition[0]);


        }

        for(int i=0;i<snakelength;i++)
        {
            if(i==0 && right){
                righthead = new ImageIcon("righthead.png");
                righthead.paintIcon(this,graphics,xposition[i],yposition[i]);

            }
            if(i==0 && left){
                lefthead = new ImageIcon("lefthead.png");
               lefthead.paintIcon(this,graphics,xposition[i],yposition[i]);

            }
            if(i==0 && up){
               uphead = new ImageIcon("uphead.png");
             uphead.paintIcon(this,graphics,xposition[i],yposition[i]);

            }
            if(i==0 && down){
             downhead = new ImageIcon("downhead.png");
               downhead.paintIcon(this,graphics,xposition[i],yposition[i]);

            }
            if(i!=0){
                snakebody = new ImageIcon("snakebody.png");
                snakebody.paintIcon(this,graphics,xposition[i],yposition[i]);


            }

        }

        appleimage = new ImageIcon("apple.png");

        if((getXposition[xpos] == xposition[0] && getYposition[ypos] == yposition[0]))
        {
            score++;
            snakelength++;
            xpos = random.nextInt(34);
            ypos = random.nextInt(23);
        }
        appleimage.paintIcon(this, graphics, getXposition[xpos], getYposition[ypos]);


        for(int b = 1; b<snakelength; b++){
            if(xposition[b]==xposition[0] && yposition[b]==yposition[0]){

                right = false;
                left = false;
                up = false;
                down = false;

                graphics.setColor(Color.YELLOW);
                graphics.setFont(new Font("arial", Font.BOLD, 60));
                graphics.drawString("GAME OVER",300,300);

                graphics.setFont(new Font("arial", Font.BOLD, 30));
                graphics.drawString("Press SPACE to RESTART",350,340);


            }
        }

            graphics.dispose();




    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        timer.start();
        if(right)
        {
            for(int r = snakelength-1; r>=0; r--)
            {
                yposition[r+1] = yposition[r];

            }
            for(int r = snakelength; r>=0; r--)
            {
                if(r==0)
                {
                    xposition[r] = xposition[r] + 25;

                }
                else
                {
                    xposition[r] = xposition[r-1];
                }
                if(xposition[r] > 850)
                {
                    xposition[r] = 25;

                }
            }
            repaint();
        }
        if(left)
        {
            for(int r = snakelength-1; r>=0; r--)
            {
                yposition[r+1] = yposition[r];

            }
            for(int r = snakelength; r>=0; r--)
            {
                if(r==0)
                {
                    xposition[r] = xposition[r] - 25;

                }
                else
                {
                    xposition[r] = xposition[r-1];
                }
                if(xposition[r] < 25)
                {
                    xposition[r] = 850;

                }
            }
            repaint();

        }
        if(up)
        {
            for(int r = snakelength-1; r>=0; r--)
            {
                xposition[r+1] = xposition[r];

            }
            for(int r = snakelength; r>=0; r--)
            {
                if(r==0)
                {
                    yposition[r] = yposition[r] - 25;

                }
                else
                {
                    yposition[r] = yposition[r-1];
                }
                if(yposition[r] < 75)
                {
                    yposition[r] = 625;

                }
            }
            repaint();

        }
        if(down)
        {

            for(int r = snakelength-1; r>=0; r--)
            {
                xposition[r+1] = xposition[r];

            }
            for(int r = snakelength; r>=0; r--)
            {
                if(r==0)
                {
                    yposition[r] = yposition[r] + 25;

                }
                else
                {
                    yposition[r] = yposition[r-1];
                }
                if(yposition[r] > 625)
                {
                    yposition[r] = 75;

                }
            }
            repaint();


        }

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        if(keyEvent.getKeyCode() == KeyEvent.VK_SPACE)
        {
            moves = 0;
            score = 0;
            snakelength = 3;
            repaint();
        }

        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            numberofmoves++;
            right = true;
            if(!left)
            {
                right = true;
            }
            else
            {
                right = false;
                left = true;
            }

            up = false;
            down = false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
        {
            numberofmoves++;
            left = true;
            if(!right)
            {
                left = true;
            }
            else
            {
                left = false;
                right = true;
            }

            up = false;
            down = false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP)
        {
            numberofmoves++;
            up = true;
            if(!down)
            {
                up = true;
            }
            else
            {
                up = false;
                down = true;
            }

            left = false;
            right = false;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
        {
            numberofmoves++;
            down = true;
            if(!up)
            {
                down = true;
            }
            else
            {
                down = false;
                up = true;
            }

            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
