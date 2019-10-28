package brickbreaker;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;

/**
 * This is template to create drawings in FX.
 *
 * @author Danijel Stefanovic 000789046
 */
public class BrickBreakerGame extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        int windowWidth = 650; // variable for width of the window 
        int windowHeight = 600; // variable fot the height of the window 
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(windowWidth, windowHeight); // set canvas Size in Pixels
        stage.setTitle("BrickBreaker"); // set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // declare variables
        Scanner input = new Scanner(System.in);
        int rows = 0;
        int columns = 0;
        int position_paddle = 0;
        int i,j;
        int x = windowWidth - 590, y = windowHeight - 500;
        int num_balls, color_balls;
        double x1 = 0, y1= 0;
        String score,lives;
        boolean validRows, validColumns, validPosition;
        
        // input statements 
        
        // set boolean flag 
        validRows = false;
        
        // start while loop 
        while (validRows == false) {
            
            // set limitation for rows between 1-10
            if (rows < 1 || rows > 10) {
            
            System.out.println("Please enter the number of rows (within range 1-10): ");
            rows = input.nextInt();
            
            }
            else {
                validRows = true;
            }
        }   
        
        // set boolean flag
        validColumns = false;
        
        // start while loop 
        while (validColumns == false) {
            
            // set limitation for columns between 1-10
            if (columns < 1 || columns > 10) {
            
            System.out.println("Please enter the number of columns (within range 1-10): ");
            columns = input.nextInt();
            
            }
        
            else {
                validColumns = true;
            }
        }  
        
        System.out.println("Please enter a current score: ");
        score = input.next();
        
        System.out.println("Please enter the number of lives remaining: ");
        lives = input.next();
        
        // set boolean flag
        validPosition = false;
        
        // start while loop
        while (validPosition == false) {
            
            // set limitation for paddle position   
            if (position_paddle < windowWidth - 610 || position_paddle > windowWidth - 90) {
            
            System.out.println("Please enter the x-position of the player's paddle using number (between 40 and 560): ");
            position_paddle = input.nextInt();
            
            }   
            
            else {
                validPosition = true;
            }
        }
        
        System.out.println("Please enter the number of balls in the game: ");
        num_balls = input.nextInt();
        
        System.out.println("Please enter the color of the ball (with 1 being BLUE, "
                + "2 being YELLOW, 3 being ORANGE and any other number will output default color which is GREY): ");
        color_balls = input.nextInt();
        
        // background 
        gc.fillRect(0,0,windowWidth,windowHeight);
        
        // framework - position and color
        gc.setFill(Color.GREY);
        gc.fillRect(0,0,windowWidth,windowHeight - 575);
        gc.fillRect(0,0,windowWidth - 625,windowHeight);
        gc.fillRect(windowWidth - 25,0,windowWidth - 625,windowHeight);
        gc.fillRect(0,windowHeight - 25,windowWidth,windowHeight - 575);
        
        // score section - position and color
        gc.setFill(Color.PURPLE);
        gc.fillRect(windowWidth - 625,0,80,25);
        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + score,windowWidth - 600,20);
        
        // lives section - position and color 
        gc.setFill(Color.PURPLE);
        gc.fillRect(windowWidth - 105,0,80,25);
        gc.setFill(Color.WHITE);
        gc.fillText("Lives: " + lives,windowWidth - 80,20);
        
        // player paddle - position and color
        
        // rectangle part
        gc.setFill(Color.GREY);
        gc.fillRect(position_paddle,windowHeight - 100,50,10);
        // oval part
        gc.setFill(Color.BROWN);
        gc.fillOval(position_paddle - 15,windowHeight - 100,15,10);
        gc.fillOval(position_paddle + 50,windowHeight - 100,15,10);

        /**
         * grid
         * start for loop to create rows
         * initialize value, set condition, increment by 1
         */
        for (i = 1; i <= rows; i++)  {
            
            /**
             * start for loop to create columns 
             * initialize value, set condition, increment by 1
             */
            for(j = 1; j <= columns; j++)   {
                
                // if statements to color rows from 1 to 10 
                if(i == 1)  {
                    
                    gc.setFill(Color.AQUA);
                }
                
                if(i == 2)  {
                    
                    gc.setFill(Color.CORAL);
                }
                    
                if(i == 3)  {
                    
                    gc.setFill(Color.RED);
                }
                
                if(i == 4)  {
                    
                    gc.setFill(Color.PLUM);
                }
                
                if(i == 5)  {
                    
                    gc.setFill(Color.FORESTGREEN);
                }
                
                if(i == 6)  {
                    
                    gc.setFill(Color.OLIVE);
                }
                
                if(i == 7)  {
                    
                    gc.setFill(Color.PEACHPUFF);
                }
                
                if(i == 8)  {
                    
                    gc.setFill(Color.SIENNA);
                }
                    
                if(i == 9)  {
                    
                    gc.setFill(Color.TOMATO);
                }
                
                if(i == 10)  {
                    
                    gc.setFill(Color.YELLOW);
                }
                    // set coordinates and size of the columns
                    gc.fillRect(x,y,50,20);
                    
                    // set gap between columns
                    x=x+53;
            }
                // set starting coordinate 
                x=60; 
                
                // set gap between rows 
                y=y+23;
        }
        
        // set color of balls
        switch(color_balls) {
            
            case 1:
                gc.setFill(Color.BLUE);
                break;
            case 2:
                gc.setFill(Color.YELLOW);
                break;
            case 3:
                gc.setFill(Color.ORANGE);
                break; 
            default:
                gc.setFill(Color.GREY);
                break;
        }
        
        /** 
         * set number of balls and position
         * initialize value, set condition, increment by 1
         */
        for(i=1; i<=num_balls; i++)   {
        
            // set limitation for the ball position 
            while((x1 < windowWidth - 620)||(x1 > windowWidth - 30))    {
                
                // random x-coordinate 
                x1=Math.random()*800;
                
            }
         
            // set limitation for the ball position 
            while((y1 < y)||(y1 > windowHeight - 105))   {
                
                // random y-coordinate 
                y1=Math.random()*600;
            }
            
            // set coordinates and size for the ball 
            gc.fillOval(x1,y1,5,5);
            
            // reset coordinates for new ball
            x1=0;y1=0;
        }
        
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}

