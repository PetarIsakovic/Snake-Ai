import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import javax.swing.Timer;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
//import a dictonary then limit it to 6 letter words

public class Snake extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 400;
    static final int HEIGHT = 400;

    //Title of the window
    String title = "Snake";
    int[][] grid = new int[40][40];

    ArrayList<Integer> xPos = new ArrayList<>();
    ArrayList<Integer> yPos = new ArrayList<>();

    ArrayList<Integer> snakeEnemyXPos = new ArrayList<>();
    ArrayList<Integer> snakeEnemyYPos = new ArrayList<>();

    int appleX = (int)(Math.random() * 40);
    int appleY = (int)(Math.random() * 40);

    boolean right = true;
    boolean left = false;
    boolean up = false;
    boolean down = false;

    int tick = 0;
    int rainbow = 0;

    int points = 0;

    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 100;
    int desiredTime = Math.round((1000 / desiredFPS));
    
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;

   
    
    // GAME VARIABLES END HERE    

    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public Snake(){
        xPos.add(20);
        yPos.add(20);
        

        snakeEnemyXPos.add(30);
        snakeEnemyYPos.add(20);

        grid[yPos.get(0)][xPos.get(0)] = 1;
        grid[appleY][appleX] = 2;
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        frame.getContentPane().setBackground(Color.BLACK);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);
        
        // Set things up for the game at startup
        setup();

       // Start the game loop
        gameTimer = new Timer(desiredTime,this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        Font bigFont = new Font("Serif", Font.BOLD, 100);
        g.setFont(bigFont);
        if(points < 10){
        g.drawString("" + points, 175, 200);
        }
        else{
            g.drawString("" + points, 150, 200);
        }

        for(int i  =0; i < grid.length; i++){
            for(int j  =0; j < grid[0].length; j++){
                g.setColor(new Color(56,56,56));
                    g.drawRect(j*10, i*10, 10, 10);
            }
        }

    
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(rainbow > 0){
                    g.setColor(new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256)));
                    }
                    else{
                        g.setColor(new Color(61, 156, 26));
                        g.drawRect(j*10, i*10, 10, 10);
                        g.setColor(new Color(78, 199, 34));
                    }
                    g.fillRect(j*10, i*10, 10, 10);
                }
                else if(grid[i][j] == 2){
                    g.setColor(new Color(224, 22, 22));
                    g.drawRect(j*10, i*10, 10, 10);
                    g.setColor(new Color(171, 17, 17));
                    g.fillRect(j*10, i*10, 10, 10);

                }

                else if(grid[i][j] == 3){
                    g.setColor(Color.ORANGE);
                    g.drawRect(j*10, i*10, 10, 10);
                    g.setColor(Color.ORANGE);
                    g.fillRect(j*10, i*10, 10, 10);

                }
              
            }
        }
        
        
         }
    
    
    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void setup() {
        // Any of your pre setup before the loop starts should go here
        
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void loop() {

       
        for(int i = 0; i < xPos.size(); i++){
            for(int j = 0; j < snakeEnemyXPos.size(); j++){
            if(xPos.get(i) == snakeEnemyXPos.get(j) && yPos.get(i) == snakeEnemyYPos.get(j)){
                grid = new int[40][40];
             snakeEnemyXPos = new ArrayList<>();
                snakeEnemyYPos = new ArrayList<>();
                snakeEnemyXPos.add(30);
        snakeEnemyYPos.add(20);
                    xPos = new ArrayList<>();
                    yPos = new ArrayList<>();

                    appleX = (int)(Math.random() * 40);
                    appleY = (int)(Math.random() * 40);

                    tick = 0;
                    rainbow = 0;
                    xPos.add(20);
        yPos.add(20);

        grid[yPos.get(0)][xPos.get(0)] = 1;
        grid[appleY][appleX] = 2;
        points = 0;
            }
        }
        }
    

        tick++;
        boolean move = false;
        boolean aI = false;
        if(tick % 15 == 0){

            grid[yPos.get(yPos.size()-1)][xPos.get(xPos.size()-1)] = 0;


            for(int i = xPos.size()-1; i > 0; i--){
                xPos.set(i, xPos.get(i-1));
                yPos.set(i, yPos.get(i-1));
            }
            move = true;
            tick = 0;
            aI = true;
        }

    

        if(move){
            enemyUpdate();
        if(right){

            if(xPos.get(0) == 39){
                xPos.set(0, 0);
            }
            else{
            xPos.set(0, xPos.get(0)+1);
            }

        }
        else if(left){
            if(xPos.get(0) == 0){
                xPos.set(0, 39);
            }
            else{
            xPos.set(0, xPos.get(0)-1);
            }
        }
        else if(up){
            if(yPos.get(0) == 0){
                yPos.set(0, 39);
            }
            else{
            yPos.set(0, yPos.get(0)-1);
            }
        }
        else if(down){
            if(yPos.get(0) == 39){
                yPos.set(0, 0);
            }
            else{
            yPos.set(0, yPos.get(0)+1);
            }
        }

        for(int i  = 0; i < xPos.size(); i++){
            grid[yPos.get(i)][xPos.get(i)] = 1;
  
            
        }

        if(grid[appleY][appleX] != 2){
            if(appleY == yPos.get(0) && appleX == xPos.get(0)){
                xPos.add(xPos.get(xPos.size()-1));
                yPos.add(yPos.get(yPos.size()-1));
                rainbow = 200;
                points++;
                }
                else{
                    snakeEnemyXPos.add(snakeEnemyXPos.get(snakeEnemyXPos.size()-1));
                    snakeEnemyYPos.add(snakeEnemyYPos.get(snakeEnemyYPos.size()-1));
                }
            appleX = (int) (Math.random() * 40);
            appleY = (int) (Math.random() * 40);
            grid[appleY][appleX] = 2;
          
        }
        for(int i = 0; i < xPos.size(); i++){
            for(int j = i+2; j < xPos.size(); j++){
                if(i != j && xPos.get(i) == xPos.get(j) && yPos.get(i) == yPos.get(j)){
                    grid = new int[40][40];
                    snakeEnemyXPos = new ArrayList<>();
                    snakeEnemyYPos = new ArrayList<>();
                    snakeEnemyXPos.add(30);
        snakeEnemyYPos.add(20);

                    xPos = new ArrayList<>();
                    yPos = new ArrayList<>();

                    appleX = (int)(Math.random() * 40);
                    appleY = (int)(Math.random() * 40);

                    tick = 0;
                    rainbow = 0;
                    xPos.add(20);
        yPos.add(20);

        grid[yPos.get(0)][xPos.get(0)] = 1;
        grid[appleY][appleX] = 2;
        points = 0;
        break;
                }
            }
        }
    }
    if(rainbow > 0){
        rainbow--;
    }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {

        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {

        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_D && left == false){
                right = true;
                down = false;
                up = false;
                enemyUpdate();
                grid[yPos.get(yPos.size()-1)][xPos.get(xPos.size()-1)] = 0;

                grid[yPos.get(yPos.size()-1)][xPos.get(xPos.size()-1)] = 0;
                for(int i = xPos.size()-1; i > 0; i--){
                    xPos.set(i, xPos.get(i-1));
                    yPos.set(i, yPos.get(i-1));
                }

                if(xPos.get(0) == 39){
                    xPos.set(0, 0);
                }
                else{
                xPos.set(0, xPos.get(0)+1);
                }
                tick = 0;
                
                for(int i  = 0; i < xPos.size(); i++){
                    grid[yPos.get(i)][xPos.get(i)] = 1;
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_A && right == false){
                left = true;
                down = false;
                up = false;
                enemyUpdate();
                grid[yPos.get(yPos.size()-1)][xPos.get(xPos.size()-1)] = 0;

                for(int i = xPos.size()-1; i > 0; i--){
                    xPos.set(i, xPos.get(i-1));
                    yPos.set(i, yPos.get(i-1));
                }

                if(xPos.get(0) == 0){
                    xPos.set(0, 39);
                }
                else{
                xPos.set(0, xPos.get(0)-1);
                }
                tick = 0;
                for(int i  = 0; i < xPos.size(); i++){
                    grid[yPos.get(i)][xPos.get(i)] = 1;
                }

            }
            else if(e.getKeyCode() == KeyEvent.VK_W && down == false){
                left = false;
                right = false;
                up = true;
                enemyUpdate();
                grid[yPos.get(yPos.size()-1)][xPos.get(xPos.size()-1)] = 0;

                for(int i = xPos.size()-1; i > 0; i--){
                    xPos.set(i, xPos.get(i-1));
                    yPos.set(i, yPos.get(i-1));
                }

                if(yPos.get(0) == 0){
                    yPos.set(0, 39);
                }
                else{
                yPos.set(0, yPos.get(0)-1);
                }
                tick = 0;
                for(int i  = 0; i < xPos.size(); i++){
                    grid[yPos.get(i)][xPos.get(i)] = 1;
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_S && up == false){
                left = false;
                right = false;
                down = true;
                enemyUpdate();
                grid[yPos.get(yPos.size()-1)][xPos.get(xPos.size()-1)] = 0;

                for(int i = xPos.size()-1; i > 0; i--){
                    xPos.set(i, xPos.get(i-1));
                    yPos.set(i, yPos.get(i-1));
                }
                if(yPos.get(0) == 39){
                    yPos.set(0, 0);
                }
                else{
                yPos.set(0, yPos.get(0)+1);
                }
                tick = 0;
                for(int i  = 0; i < xPos.size(); i++){
                    grid[yPos.get(i)][xPos.get(i)] = 1;
                }
            }
            if(grid[appleY][appleX] != 2){
                if(appleY == yPos.get(0) && appleX == xPos.get(0)){
                    xPos.add(xPos.get(xPos.size()-1));
                    yPos.add(yPos.get(yPos.size()-1));
                    rainbow = 200;
                    points++;
                    }
                    else{
                        snakeEnemyXPos.add(snakeEnemyXPos.get(snakeEnemyXPos.size()-1));
                        snakeEnemyYPos.add(snakeEnemyYPos.get(snakeEnemyYPos.size()-1));
                    }
                appleX = (int) (Math.random() * 40);
                appleY = (int) (Math.random() * 40);
                grid[appleY][appleX] = 2;



              
            }
            for(int i = 0; i < xPos.size(); i++){
                for(int j = i+2; j < xPos.size(); j++){
                    if(i != j && xPos.get(i) == xPos.get(j) && yPos.get(i) == yPos.get(j)){
                        grid = new int[40][40];
                        snakeEnemyXPos = new ArrayList<>();
                        snakeEnemyYPos = new ArrayList<>();
                        snakeEnemyXPos.add(30);
        snakeEnemyYPos.add(20);
    
                        xPos = new ArrayList<>();
                        yPos = new ArrayList<>();
    
                        appleX = (int)(Math.random() * 40);
                        appleY = (int)(Math.random() * 40);
    
                       
    
                        tick = 0;
                        rainbow = 0;
                        xPos.add(20);
        yPos.add(20);

        grid[yPos.get(0)][xPos.get(0)] = 1;
        grid[appleY][appleX] = 2;
        points = 0;
        break;
                    }
                }
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        loop();
        repaint();
    }

    public static void main(String[] args) {
        // creates an instance of my game
        Snake game = new Snake();
    }

    public void enemyUpdate(){
        Graph map = new Graph();

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){

                    if(grid[i][j] != 1){

                        try{

                            if(grid[i][j+1] != 1 && grid[i][j+1] != 3){
                                map.addEdge(i + ","+ j, i + "," + (j+1));
                            }

                        }
                        catch(Exception e){
                            map.addEdge(i + ","+ j, i + "," + (0));
                        }

                        try{

                            if(grid[i][j-1] != 1 && grid[i][j-1] != 3){
                                map.addEdge(i + ","+ j, i + "," + (j-1));
                            }

                        }
                        catch(Exception e){
                            map.addEdge(i + ","+ j, i + "," + (grid[0].length-1));
                        }

                        try{

                            if(grid[i+1][j] != 1 && grid[i+1][j] != 3){
                                map.addEdge(i + ","+ j, (i+1) + "," + j);
                            }

                        }
                        catch(Exception e){
                            map.addEdge(i + ","+ j, 0 + "," + j);
                        }

                        try{

                            if(grid[i-1][j] != 1 && grid[i-1][j] != 3){
                                map.addEdge(i + ","+ j, (i-1) + "," + j);
                            }

                        }
                        catch(Exception e){
                            map.addEdge(i + ","+ j, (grid.length-1) + "," + j);
                        }

                    }

                }
            }

            Path tracker = new Path(map.graph, (snakeEnemyYPos.get(0) + "," + snakeEnemyXPos.get(0)), (appleY + "," + appleX));
            
            String target = (appleY + "," + appleX);

            String nextMove = "";
            ArrayList<String> moves = new ArrayList<>();
            while(target != null){
            moves.add(target);
            target = tracker.prev.get(target);
            }

            grid[snakeEnemyYPos.get(snakeEnemyYPos.size()-1)][snakeEnemyXPos.get(snakeEnemyXPos.size()-1)] = 0;

            for(int i = snakeEnemyXPos.size()-1; i > 0; i--){
                snakeEnemyXPos.set(i, snakeEnemyXPos.get(i-1));
                snakeEnemyYPos.set(i, snakeEnemyYPos.get(i-1));
            }

            try{
            String[] holder = moves.get(moves.size()-2).split(",");

            snakeEnemyYPos.set(0, Integer.parseInt(holder[0]));
            snakeEnemyXPos.set(0, Integer.parseInt(holder[1]));
            }
            catch(Exception e){}

            for(int i = 0; i < snakeEnemyXPos.size(); i++){
                grid[snakeEnemyYPos.get(i)][snakeEnemyXPos.get(i)] = 3;
            }
    }
}