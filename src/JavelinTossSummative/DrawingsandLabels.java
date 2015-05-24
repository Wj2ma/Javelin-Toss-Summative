/* This class contains most of the drawings from the game. Drawings include
 * the javelin throwers, scoreboards, labels, instruction screens, etc.
 */
package JavelinTossSummative;

/* William Ma
 * 433144
 * ICS 3U0
 * Mr. North
 * Date Started: May 30, 2012
 * Date Finished: June 7, 2012
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Title screen welcome sentence
    class Welcome extends JComponent
    {
        public Welcome ()
        {
            repaint();
        } //emocleW
        
        public void paint (Graphics g)
        {
            //Sets font to ariel 40
                g.setFont(GameScreen.ariel40);
                g.drawString("Welcome to Javelin Toss!",20,30);
        } //tniap     
    } //emocleW

//Draws the target at a random location at the bottom
    class Target extends JComponent
    {
        public Target ()
        {
            repaint();
        } //tegraT
        
        public void paint (Graphics g)
        {
            g.setColor(Color.red);
            g.fillRect(Methods.targetDistance-45,0,90,20);
            g.setColor(Color.white);
            g.fillRect(Methods.targetDistance-15,0,10,20);
            g.fillRect(Methods.targetDistance+5,0,10,20);
            g.fillRect(Methods.targetDistance-35,0,10,20);
            g.fillRect(Methods.targetDistance+25,0,10,20);        
        } //tniap
    } //tegraT

//Draws the javelin tosser at a random location to the left standing on a platform
class JavelinTosser extends JComponent
{
    public JavelinTosser ()
    {
        repaint();
    } //ressoTnilevaJ
    
    public void paint (Graphics g)
    {
        int distance = Methods.javelinHeight;
        //Head outline
            g.drawOval(20,distance,20,20);
        //Body
            g.drawLine(30,distance+20,30,distance+55);
            
        //Draw either throwing it or holding it
            if (Methods.distance == -1)
            {
                //Left arm (from our view)
                    g.drawLine(30,distance+30,15,distance+32);
                //Left hand
                    g.drawLine(15,distance+32,12,distance+31);
            } //fi
            
            else
            {
                //Left arm throwing
                    g.drawLine(30,distance+30,50,distance+25);
            } //esle
        //Right arm
            g.drawLine(30,distance+30,40,distance+45);
        //Left leg
            g.drawLine(30,distance+55,20,distance+75);
        //Right leg
            g.drawLine(30,distance+55,40,distance+75);
        //Tail if its impossible computer
            if (GameScreen.playerTurn == 1 && GameScreen.compLevel == 5)
            {
                g.drawLine(30,distance+50,10,distance+65);
                g.setColor(Color.red);
                int[] xTri = {2,8,12};
                int[] yTri = {distance+71,distance+62,distance+68};   
                g.fillPolygon(xTri,yTri,3);
                g.setColor(Color.black);
            } //fi

        /*Color the face white for player 1, yellow for player 2, cyan for
         * easy computer, green for medium computer, magenta for hard, and
         * red for impossible
         */
            if (GameScreen.playerTurn == 1)
            {
                if (GameScreen.compLevel == 1)
                    g.setColor(Color.yellow);
                else if (GameScreen.compLevel == 2)
                    g.setColor(Color.cyan);
                else if (GameScreen.compLevel == 3)
                    g.setColor(Color.magenta);
                else if (GameScreen.compLevel == 4)
                {
                    //grey hat for hard computer
                        g.setColor(Color.lightGray);
                        int[] xTri = {15,30,45};
                        int[] yTri = {distance+3,distance-7,distance+3};
                        g.fillPolygon(xTri,yTri,3);
                    
                   g.setColor(Color.green);
                } //fi esle
                else
                {
                    //Flaming head for impossible computer
                        g.setColor(Color.orange);
                        g.drawLine(20,distance+10,20,distance-2);
                        g.drawLine(22,distance+8,22,distance-4);
                        g.drawLine(24,distance+6,24,distance-6);
                        g.drawLine(26,distance+4,26,distance-8);
                        g.drawLine(28,distance+2,28,distance-10);
                        g.drawLine(30,distance,30,distance-10);
                        g.drawLine(32,distance,30,distance-10);
                        g.drawLine(34,distance+2,34,distance-8);
                        g.drawLine(36,distance+4,36,distance-6);
                        g.drawLine(38,distance+6,38,distance-4);
                        g.drawLine(40,distance+8,40,distance-2);
                    g.setColor(Color.red);
                } //esle
                
            } //fi
            
            else if (GameScreen.secret >= 6)
            {
                //Secret easter egg achieved makes javelin tosser have a crown
                //and a pink face
                    g.setColor(Color.yellow);
                    int[] xCrown = {18,42,42,36,30,24,18};
                    int[] yCrown = {distance+3,distance+3,distance-7,distance-2,distance-7,distance-2,distance-7};
                    g.fillPolygon(xCrown,yCrown,7);                
                    g.setColor(Color.pink);                                                                   
            } //fi esle
            
            else
                g.setColor(Color.white);
            
            g.fillOval(21,distance+1,18,18);
        
        //Draw the platform he is on
            g.setColor(Color.gray);
            g.fillRect(0,distance+75,60,10);
            g.fillRect(20,distance+75,20,537-distance);
        
        //Outline of platform
            g.setColor(Color.black);
            g.drawRect(0,distance+75,60,10);
            g.drawRect(20,distance+75,20,537-distance);
        //Eyebrow    
            g.drawLine(30,distance+3,42,distance+5);
        //Eye
            g.fillOval(34,distance+4,3,3);
        //Mouth
            g.drawLine(30,distance+15,40,distance+14);
    } //tniap
} //ressoTnilevaJ

//Draws the javelin in the javelin tossers hand
    class Javelin extends JComponent
    {
        public Javelin ()
        {
            repaint();
        } //nilevaJ

        public void paint(Graphics g)
        {
            int yDistance = Methods.javelinHeight;
            
            //If javelin doesn't need to move  
            
            //Easter egg javelin makes the javelin tip red and a yellow circle
            //at the end with an orange aura around it
                if (Methods.distance == -1 && GameScreen.playerTurn == 0 && GameScreen.secret >= 6) 
                {
                    g.drawLine(0,yDistance+32,60,yDistance+15);
                    int[] xTri = {55,55,60};
                    int[] yTri = {yDistance+14,yDistance+20,yDistance+15};
                    g.setColor(Color.red);
                    g.fillPolygon(xTri,yTri,3);
                    g.setColor(Color.yellow);
                    g.fillOval(58,yDistance+13,4,4);
                    g.setColor(Color.orange);
                    g.drawLine(58,yDistance+14,55,yDistance+13);
                    g.drawLine(59,yDistance+13,57,yDistance+11);
                    g.drawLine(60,yDistance+12,60,yDistance+9);
                    g.drawLine(61,yDistance+13,63,yDistance+11);
                    g.drawLine(62,yDistance+14,65,yDistance+13);
                    g.drawLine(62,yDistance+15,65,yDistance+15);
                    g.drawLine(61,yDistance+16,63,yDistance+18);
                    g.drawLine(61,yDistance+17,62,yDistance+20);
                    g.drawLine(60,yDistance+18,60,yDistance+21);
                    g.drawLine(59,yDistance+17,57,yDistance+19);
                    g.drawLine(58,yDistance+17,56,yDistance+18);
                    g.setColor(Color.black);
                } //fi
                
            //Impossible computer javelin is a pitchfork
                else if (Methods.distance == -1 && GameScreen.playerTurn == 1 && GameScreen.compLevel == 5)
                {
                    g.drawLine(0,yDistance+32,60,yDistance+15);
                    g.setColor(Color.red);
                    g.drawLine(60,yDistance+15,70,yDistance+13);
                    g.drawLine(60,yDistance+15,62,yDistance+10);
                    g.drawLine(60,yDistance+15,63,yDistance+20);
                    g.drawLine(62,yDistance+10,69,yDistance+8);
                    g.drawLine(63,yDistance+20,70,yDistance+18);
                } //fi esle
                
                else if (Methods.distance == -1)
                {
                    g.drawLine(0,yDistance+32,60,yDistance+15);
                    g.drawLine(60,yDistance+15,55,yDistance+14);
                    g.drawLine(60,yDistance+15,55,yDistance+20);
                } //fi esle
            
            //Draws the end result after the javelin has been thrown
                else
                    g.drawLine(Methods.distance+30,610,Methods.distance-30,560);
        } //tniap
    } //nilevaJ

//Preference sentence after start game is clicked
    class Preferences extends JComponent
    {
        public Preferences ()
        {
            repaint();
        } //secnereferP
        
        public void paint (Graphics g)
        {
            //Sets font to ariel 40
                g.setFont(GameScreen.ariel40);
                g.drawString("Please Choose Your Preference",20,30);
        } //tniap    
    } //secnereferP

//Scoreboard1
    class ScoreBoard1 extends JComponent
    {
        public ScoreBoard1 ()
        {
            repaint();
        } //1draoBerocS
        
        public void paint (Graphics g)
        {
            //Draws the whole scoreboard for player 1
                int counter;
            //Score in a string form
                String number;
            //Fills the first to boxes which are larger and contains the category    
                g.fillRect(0,0,100,20);
                g.fillRect(0,20,100,30);

            //Draws all 11 boxes that are equal in size that contains the turn number and total
                for (counter = 100; counter < 650; counter += 50)
                    {
                        g.setColor(Color.black);
                        g.fillRect(counter,0,50,20);
                        g.setColor(Color.white);
                        g.drawRect(counter,0,50,20);
                    } //rof

            //Draws all 11 boxes that are equal in size that contains player 1's scores
                for (counter = 100; counter < 650; counter += 50)
                {
                    g.setColor(Color.black);
                    g.fillRect(counter,20,50,30);
                    g.setColor(Color.white);
                    g.drawRect(counter,20,50,30);
                } //rof
                    
            //Draws the outline of the first 2 boxes in white
                g.drawRect(0,0,100,20);
                g.drawRect(0,20,100,30);
            
            //Sets font to 16 ariel and makes color magenta
                g.setColor(Color.MAGENTA);
                g.setFont(GameScreen.ariel16);
            
            //Draws player 1 category
                g.drawString("Player 1",24,42);
            
            //Sets font to 14 ariel
                g.setFont(GameScreen.ariel14);
            
            //Draws the turn category
                g.drawString("Turn:",30,15);
            
            //Draws the turn numbers
                int counter2 = 120;
                for (counter = 1; counter <= 10; counter++)
                {               
                    number = Integer.toString(counter);
                    g.drawString(number,counter2,15);
                    counter2 += 50;
                } //rof
            
            //Sets font to 16 ariel
                g.setFont(GameScreen.ariel16);
                
            //Draws the scores of player 1  
                counter2 = 120;
                for (counter = 0; counter < 10; counter++)
                {
                    number = Integer.toString(GameScreen.scores[0][counter]);
                    g.drawString(number,counter2,40);
                    counter2 += 50;                
                } //rof
                
            //Draws the total score of player 1
                if (GameScreen.turn == 10)
                {
                    int total = 0;
                    for (counter = 0; counter < 10; counter++)
                        total += GameScreen.scores[0][counter];
                    number = Integer.toString(total);
                    g.drawString(number,620,40);
                } //fi
                
             
            //Draws the total category
                g.drawString("Total",607,15);
        } //tniap
    } //1draoBerocS

//Scoreboard2
    class ScoreBoard2 extends JComponent
    {
        public ScoreBoard2 ()
        {
            repaint();
        } //2draoBerocS
        
        public void paint(Graphics g)
        {
            int counter;
            String number;
            
            //Fill first box which has the player name
                g.fillRect(0,0,100,40);
            
            //Draws 11 more boxes that contain the score and the total
                for (counter = 100; counter < 650; counter += 50)
                {
                    g.setColor(Color.black);
                    g.fillRect(counter,0,50,40);
                    g.setColor(Color.white);
                    g.drawRect(counter,0,50,40);
                } //rof
            
            //Draw first box in white
                g.drawRect(0,0,100,40);
            
            //Set the font and color to magenta
                g.setFont(GameScreen.ariel16);
                g.setColor(Color.MAGENTA);
            
            //Either name second box comp or player2 according to who is playing
                if (GameScreen.compLevel == 1)
                    g.drawString("Player 2",24,32);                 
                else
                    g.drawString("Comp",30,32);
                
            //Draws the scores of player 2
                int counter2 = 120;
                for (counter = 0; counter < 10; counter++)
                {
                    number = Integer.toString(GameScreen.scores[1][counter]);
                    g.drawString(number,counter2,30);
                    counter2 += 50;                
                } //rof
                
            //Draws the total score for player 2     
                if (GameScreen.compTurn == 10)
                {
                    int total = 0;
                    for (counter = 0; counter < 10; counter++)
                        total += GameScreen.scores[1][counter];
                    number = Integer.toString(total);
                    g.drawString(number,620,30);
                } //fi
        } //tniap
    } //2draoBerocS

//Instructions
    class Instructions extends JComponent
    {
        public Instructions ()
        {
            repaint();
        } //snoitcurtsnI
        
        public void paint (Graphics g)
        {
            Font ariel20 = new Font("Ariel",Font.BOLD,20);
            g.setFont(ariel20);
            //Main goal
                g.drawString("The goal of this game is to try to throw the javelin as close",5,20);
                g.drawString("to the center of the target as possible.",5,45);
                
            
            Font ariel14 = new Font("Ariel",Font.BOLD,14);
            g.setFont(ariel14);
            //Arrow pointing at javelin tosser and informs its importance
                g.drawLine(80,240,170,210);
                g.drawLine(80,240,95,227);
                g.drawLine(80,240,100,240);
                g.drawString("This is you. Note the height of where you are throwing the javelin.",150,200);
            
            //Arrow pointing at the target and informs its importance
                g.drawLine(1000,570,1000,520);
                g.drawLine(1000,570,990,560);
                g.drawLine(1000,570,1010,560);
                g.drawString("This is what you want to hit.",900,400);
                g.drawString("The scoring starts at 2 for the",900,420);
                g.drawString("outermost section and every",900,440);
                g.drawString("section after that is worth 2",900,460);
                g.drawString("more points, making the center",900,480);
                g.drawString("10 points.",900,500);
                
            //Draw arrows pointing at the raies/lower and up/down buttons and informs its importance
                g.drawLine(80,620,320,570);
                g.drawLine(240,620,320,570);
                g.drawLine(400,620,320,570);
                g.drawLine(560,620,320,570);
                g.drawString(("Use these buttons to adjust your angle and"),200,520);
                g.drawString("your power. The maximum angle you can have is",200,540);
                g.drawString("90º, and the maximum power you can have is 100.",200,560);
                
            //Draw arrow pointing at the fire button and informs its importance
                g.drawLine(840,640,840,590);
                g.drawLine(840,640,830,630);
                g.drawLine(840,640,850,630);
                g.drawString("Click this to fire the javelin!!!",760,580);
                
            //Draw arrow pointing at the box with angle and poewr and informs its importance
                g.drawLine(110,550,180,460);
                g.drawLine(110,550,110,535);
                g.drawLine(110,550,124,550);
                g.drawString("This box shows your current angle and power level",150,450);
                
            //Draw arrow pointing at the quit button and informs its importance
                g.drawLine(1160,640,1160,590);
                g.drawLine(1160,640,1150,630);
                g.drawLine(1160,640,1170,630);
                g.drawString("Click this button if you want to",1050,560);
                g.drawString("quit the current game",1050,580);
                
            //Draw arrow pointing at the scoreboard and informs its importance
                g.drawLine(935,95,935,145);
                g.drawLine(935,95,925,105);
                g.drawLine(935,95,945,105);
                g.drawString("This is the scoreboard. It will keep track of your scores",735,155);
                g.drawString("and either player 2's scores or the computer's",735,175);
        } //tniap
    } //snoitcurtsnI

//Little white box for where the current angle and current power are located
    class anglePowerBox extends JComponent
    {
        public anglePowerBox ()
        {
            repaint();
        } //xoBrewoPelgna

        public void paint(Graphics g)
        {
            g.drawRect(0,0,109,50);
            g.setColor(Color.red);
            g.fillRect(1,1,108,49);
        } //tniap
    } //xoBrewoPelgna


      

