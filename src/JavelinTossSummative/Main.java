/* This program is designed to pop up a full screen window and run a game. The
 * game is called "Javelin Toss" and the goal of the game is to set an angle
 * and power for throwing the javelin as close as possible to the target 
 * center. The target will be in a random location after each shot, and also
 * the height at which the javelin is being thrown will be at a random height.
 * There is also a competitive goal where the player can face a computer that 
 * can be set to four difficulty levels: Easy, Medium, Hard, and Impossible.
 * Furthermore, there is a two player function that lets two players compete
 * against each other.
 */
package JavelinTossSummative;

/* William Ma
 * 433144
 * ICS 3U0
 * Mr. North
 * Date Started: May 30 2012
 * Date Finished: June 7, 2012
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main 
{
    public static void main(String[] args) 
    {
        GameScreen screen = new GameScreen();
        screen.addWindowListener
                (new WindowAdapter()
                   {
                       public void windowClosing(WindowEvent e)
                       {
                           System.exit(0);
                       } //gnisolCwodniw
                   } //retpadAwodniW
                ); //renetsiLwodniWdda
    } //niam
} //niam

class GameScreen extends JFrame implements ActionListener
{
    //Window
        private JPanel pane;
    //Background
 //       private JPanel background;
    //Welcome sentence
        static Welcome welcome = new Welcome();
    //Instructions sentences and guides
        static Instructions instruction = new Instructions();
    //Preference sentence
        static Preferences preference = new Preferences();
    //Mini javelin tosser player
        static JavelinTosser miniTosser = new JavelinTosser();
    //Javelin held by the javelin tosser
        static Javelin javelin = new Javelin();
    //Target
        static Target target = new Target();
    //Javelin Tosser picture
        static final ImageIcon JAVELIN_GUY = new ImageIcon("Resources/Javelin+Toss+Guy.png");
        static final JLabel JAVELIN_TOSSER = new JLabel(JAVELIN_GUY);
   
    //Background for default     
        static final ImageIcon BACKGROUND1 = new ImageIcon("Resources/background.png");
    //Background for hard computer     
        static final ImageIcon BACKGROUND2 = new ImageIcon("Resources/background1.png");
    //Background for medium computer
        static final ImageIcon BACKGROUND3 = new ImageIcon("Resources/background2.png");
    //Background for impossible computer    
        static final ImageIcon BACKGROUND4 = new ImageIcon("Resources/background3.png");
    //The background label that goes onto the pane    
        static JLabel background = new JLabel(BACKGROUND1);
        
    //List of all buttons    
        //Start game button
            static JButton startGame = new JButton("Start Game");
        //Instructions button
            static JButton instructions = new JButton("Instructions");
        //Done button to go back from instructions
            static JButton done = new JButton("Done"); 
        //No Computers button
            static JButton noComp = new JButton("No Computers");
        //Easy Computer button
            static JButton easyComp = new JButton("Easy Computer");
        //Medium Computer button
            static JButton mediumComp = new JButton("Medium Computer");
        //Hard Computer button
            static JButton hardComp = new JButton("Hard Computer");
        //Impossible Computer button
           static JButton impComp = new JButton("Impossible Computer");
        //Two Players button
            static JButton twoPlayer = new JButton("Two Players");
        //Up 1 degree button
            static JButton up1 = new JButton("+1º");
        //Up 5 degree button
            static JButton up5 = new JButton("+5º");
        //Down 1 degrees button
            static JButton down1 = new JButton("-1º");
        //Down 5 degrees button
            static JButton down5 = new JButton("-5º");
        //Lower power 1 level button
            static JButton lower1 = new JButton("-1P");
        //Lower power 5 levels button
            static JButton lower5 = new JButton("-5P");
        //Raise power 1 level button
            static JButton raise1 = new JButton("+1P");
        //Raise power 5 levels button
            static JButton raise5 = new JButton("+5P");
        //Fire button to fire javelin
            static JButton fire = new JButton("Fire!");
        //Quit button for quit game
            static JButton quit = new JButton("Quit");
        //Finish button to finish the game
            static JButton finish = new JButton("Finish");
        //Next button for next turn
            static JButton next = new JButton("Next");
        //Back button from start game
            static JButton back = new JButton("Back");
        //Yes button to make sure you want to quit the game
            static JButton yes = new JButton("Yes");
        //No button to stay in the current game
            static JButton no = new JButton("No"); 
        //See computer shot button to show what the computer hits
            static JButton computerShot = new JButton("See Computer Shot");
        //Credits button
            static JButton credits = new JButton("Credits");
        /*Secret cheat button at credits screen to make height of javelin
         * thrower stationary*/
            static JButton secretButton = new JButton(".");
            
    //If secret button pressed turn this on
        static boolean secretStabilize = false;    
            
    //JLabel to display credits
        static JLabel creditMe = new JLabel("Game Created By: WILLIAM MA");    
    
    //Fonts for lettering
        static Font ariel16 = new Font("Ariel",Font.BOLD,16);
        static Font ariel40 = new Font("Ariel",Font.BOLD,40);
        static Font ariel14 = new Font("Ariel",Font.BOLD,14);
        static Font ariel25 = new Font("Ariel",Font.BOLD,25);
        
    //JLabels for the up/down and raise/lower buttons
        static JLabel degree1 = new JLabel("± 1 Degree");
        static JLabel degree5 = new JLabel("± 5 Degrees");
        static JLabel power1 = new JLabel("± 1 Power Level");
        static JLabel power5 = new JLabel("± 5 Power Levels");
        
    //JLabel for quit
        static JLabel confirmQuit = new JLabel("Are you sure you want to quit?");
         
    //Distance of the target and the javelin thrower    
        static int targetDistance;
        static int javelinHeight;     
    //Angle of the javelin
        static int degree;
    //Power of the javelin
        static int power; 

    //Counter to keep track of fors
        static int counter;
        static int counter1;
        
    //Computer's turn or player 2's turn and player 1's turn
        static int turn = -1;
        static int compTurn = -1;
        
    //Tells if its player1's turn or player2's turn
        static int playerTurn;
   
    //JLabels for the angle and power
        static JLabel currentAngle = new JLabel();
        static JLabel currentPower = new JLabel();
    //Box to put in the JLabel
        static anglePowerBox box = new anglePowerBox();
        
        
    //Array for the two scoreboards
        static int[][] scores = new int[2][10];
        
    //Total scores for player 1 and 2
        static int total1;
        static int total2;
   
    //Shows who's turn it is and the turn number
        static JLabel turnInfo = new JLabel();
        
    //JLabel to display current score
        static JLabel currentScore = new JLabel();
    //JLabel to display a congratulations score   
        static JLabel congratulations = new JLabel();       
        
    //Scoreboard sections
        static ScoreBoard1 scoreBoard1 = new ScoreBoard1();
        static ScoreBoard2 scoreBoard2 = new ScoreBoard2();        

    //Second player (either comp level or player2) 
        static int compLevel;
        
    //Secret easter egg
        static int secret = 0;                 
        
    public GameScreen ()
    {
        //Names window "Javelin Toss"
            super("Javelin Toss");
            
        //Adds action listeners for when the buttons are pressed     
            startGame.addActionListener(this);
            instructions.addActionListener(this);
            done.addActionListener(this); 
            noComp.addActionListener(this);
            easyComp.addActionListener(this);
            mediumComp.addActionListener(this);
            hardComp.addActionListener(this);
            impComp.addActionListener(this);
            twoPlayer.addActionListener(this);
            up1.addActionListener(this);
            up5.addActionListener(this);
            down1.addActionListener(this);
            down5.addActionListener(this);
            raise1.addActionListener(this);
            raise5.addActionListener(this);
            lower1.addActionListener(this);
            lower5.addActionListener(this);
            finish.addActionListener(this);
            fire.addActionListener(this);
            quit.addActionListener(this);
            next.addActionListener(this);
            back.addActionListener(this);
            yes.addActionListener(this);
            no.addActionListener(this); 
            computerShot.addActionListener(this);
            credits.addActionListener(this);
            secretButton.addActionListener(this);
        
        //Sets no layout
            pane = (JPanel) getContentPane();
            pane.setLayout(null);                   
        
        //Add welcome sentence that slowly reveals itself
            background.add(welcome); 
            welcome.setBounds(380,64,500,40);
             
        //Add main picture
            background.add(JAVELIN_TOSSER);
            Dimension manSize = JAVELIN_TOSSER.getPreferredSize();
            JAVELIN_TOSSER.setBounds(423,232,manSize.width,manSize.height);
            
       //Adds the buttons and places them in the correct spot. Some are not visible yet because the start screen is not meant to show them
            
            //Buttons at start screen  
                //Adds start game button at bottom left
                    background.add(startGame);
                    startGame.setBounds(0,684,640,40);
                //Adds instructions button at bottom right    
                    background.add(instructions);
                    instructions.setBounds(640,684,640,40);
                //Adds credits button at start screen
                    background.add(credits);
                    credits.setBounds(0,14,200,40);
                    //Adds JLabel to the credits page
                        background.add(creditMe);
                        creditMe.setBounds(300,364,600,60);
                        creditMe.setFont(ariel40);
                        creditMe.setVisible(false);
                                
            //Buttons af preference screen    
                //Adds no computer button at top middle
                    background.add(noComp);
                    noComp.setBounds(540,114,200,40);
                //Adds easy computer button under no computer
                    background.add(easyComp);
                    easyComp.setBounds(540,204,200,40);
                //Adds medium computer under easy computer   
                    background.add(mediumComp);
                    mediumComp.setBounds(540,294,200,40);
                //Adds hard computer button under medium computer 
                    background.add(hardComp);
                    hardComp.setBounds(540,384,200,40);
                //Adds impossible computer button under hard computer 
                    background.add(impComp);
                    impComp.setBounds(540,474,200,40);
                //Adds two player button under impossible computer   
                    background.add(twoPlayer);
                    twoPlayer.setBounds(540,564,200,40);              
                //Adds the back button under two player    
                    background.add(back);
                    back.setBounds(540,654,200,40);
                //Hides all preference buttons for now
                    Methods.preferenceButtons(false);
            
            //Button used at instruction screen        
                //Adds done button under main instructions text   
                    background.add(done);
                    done.setBounds(5,74,600,40);
           
            //Buttons at play screen    
                //Adds the increase 1 degree button at bottom left   
                    background.add(up1);
                    up1.setBounds(0,664,160,30);
                //Adds the up 5 degree buttton to the right of the up 1 button  
                    background.add(up5);
                    up5.setBounds(160,664,160,30);             
                //Adds down 1 degree button under up 1 degree     
                    background.add(down1);
                    down1.setBounds(0,694,160,30);
                //Adds down 5 degree button under up 5 degree    
                    background.add(down5);
                    down5.setBounds(160,694,160,30);
                //Adds lower power by 1 buttun to the right of up 5 degree    
                    background.add(lower1);
                    lower1.setBounds(320,664,80,60);
                //Adds lower power by 5 button to the right of raise 1 power    
                    background.add(lower5);
                    lower5.setBounds(480,664,80,60);
                //Adds raise 1 power button to the right of lower 1 power   
                    background.add(raise1);
                    raise1.setBounds(400,664,80,60);
                //Adds raise 5 power button to the right of lower 5 power    
                    background.add(raise5);
                    raise5.setBounds(560,664,80,60);
                //Adds fire button to the right of raise 5 power     
                    background.add(fire);
                    fire.setBounds(640,664,400,60);
                //Adds quit button to the right of fire    
                    background.add(quit);
                    quit.setBounds(1040,664,240,60);             
                
            //Adds JLabels for the gameplay buttons
                background.add(degree1);
                degree1.setFont(ariel16);
                degree1.setBounds(40,639,160,20);
                background.add(degree5);
                degree5.setFont(ariel16);
                degree5.setBounds(200,639,160,20);
                background.add(power1);
                power1.setFont(ariel16);
                power1.setBounds(340,639,160,20);
                background.add(power5);
                power5.setFont(ariel16);
                power5.setBounds(495,639,160,20);
           
           //Adds JLabel for the current angle and power and the box surrounding it
                background.add(currentAngle);
                currentAngle.setFont(ariel16);
                currentAngle.setBounds(70,574,100,30);
                background.add(currentPower);
                currentPower.setFont(ariel16);
                currentPower.setBounds(70,594,100,30);
                background.add(box);
                box.setBounds(50,576,130,50);
                    
                    
            //Button after game is over
                //Adds the finish button at the whole bottom side    
                    background.add(finish);
                    finish.setBounds(0,684,1280,40);
                    finish.setVisible(false);
                    
            //Button after fire is hit
                //Adds the next button at the whole bottom side    
                    background.add(next);
                    next.setBounds(0,684,1280,40);
                    next.setVisible(false);
                    
            //Button for seeing the computer shoot
                    background.add(computerShot);
                    computerShot.setBounds(0,684,1280,40);
                    computerShot.setVisible(false);
                    
            //Buttons and label after quit is hit
                //Add JLabel for the confirming quit
                    background.add(confirmQuit);
                    confirmQuit.setFont(ariel40);
                    confirmQuit.setBounds(350,214,880,60);
                //Adds the yes button under the warning
                    background.add(yes);
                    yes.setBounds(390,314,150,40);
                //Adds the no button beside the yes button
                    background.add(no);
                    no.setBounds(690,314,150,40);
                //Sets these buttons and quit label as hidden for now
                    Methods.yesNo(false);
      
       //Adds the instructions page
            background.add(instruction);
            instruction.setBounds(0,14,1280,740);
            
       //Adds the "Please Choose Your Preference" sentence at top after start game is clicked
            background.add(preference);
            preference.setBounds(315,64,620,40);
            
       //Adds Javelin Tosser on the left side and his javelin
            background.add(miniTosser);
            miniTosser.setBounds(10,14,100,615);
            background.add(javelin);
            javelin.setBounds(10,14,1270,740);
           
       //Adds Target on the bottom
            background.add(target);
            target.setBounds(200,614,1080,20);
            
       //Adds first and second scoreboard at top right
            background.add(scoreBoard1);
            scoreBoard1.setBounds(610,19,660,52);
            background.add(scoreBoard2);
            scoreBoard2.setBounds(610,59,660,42); 
            
       //Add congratulations score for the end result
            background.add(congratulations);
            congratulations.setBounds(250,354,900,60);
            congratulations.setFont(ariel40);            
            
       //Sets instructions buttons and pictures to hidden for now
            Methods.instructionButtons(false);
            
       //Hides all play buttons for now    
            Methods.gameScreen(false,false);
            
       //Add current score in the middle of the screen
            background.add(currentScore);
            currentScore.setBounds(490,354,300,60);
            currentScore.setFont(ariel40);
       
       //Add the turn information at the top left of the screen
            background.add(turnInfo);
            turnInfo.setBounds(5,19,200,20);
            turnInfo.setFont(ariel16);
            
       //Add the secret button 
            background.add(secretButton);
            secretButton.setBounds(1200,700,3,3);
            secretButton.setVisible(false);
            
       //Adds the background and all its components to the pane      
            pane.add(background);
            background.setBounds(0,-13,1280,740);
            
       //Sets the screen size to 1280 pixels by 740
            setSize(1280,740);
            setVisible(true);
            setResizable(false);
    } //neercSemaG
    
    public void actionPerformed (ActionEvent e)
    {
        switch (e.getActionCommand()) 
        {
            case "Start Game":
                //Hide all start screen buttons and pictures
                    Methods.startButtons(false);
                //Display all the preference difficulties
                    Methods.preferenceButtons(true);
               //Resets all variables
                    Methods.reset();
                    break;
            case "Back":
                //Goes back to start screen from credits or preference screen
                    Methods.startButtons(true);
                    Methods.preferenceButtons(false);
                    creditMe.setVisible(false);
                    secretButton.setVisible(false);
                    break;
            case "Instructions":
                //Displays the instructions page
                    Methods.startButtons(false);
                    Methods.instructionButtons(true);
                    Methods.targetDistance = 800;
                    Methods.javelinHeight = 200;
                    compLevel = 1;
                    Methods.degree = 45;
                    Methods.power = 73;                    
                    currentAngle.setText("Angle: " + Methods.degree);
                    currentPower.setText("Power: " + Methods.power);
                    Methods.gameScreen(true,false);
                //Secret button order
                    if (secret == 3)
                        secret++;
                    break;
            case "Done":
                //Go back to start screen
                    Methods.startButtons(true);
                    Methods.gameScreen(false,false);
                    Methods.instructionButtons(false);
                    break;
            case "+1º":
                //Raise angle by 1 degree
                    Methods.degree++;
                //Make sure angle is not greater than 90 
                    Methods.degree = Methods.confirmAngle(Methods.degree);
                //Update the current angle shown    
                    Methods.currentAngle();
                    break;
                //The rest of the +/- power and angles follow same concept
            case "+5º":
                    Methods.degree += 5;
                    Methods.degree = Methods.confirmAngle(Methods.degree);
                    Methods.currentAngle();
                    break;
            case "-1º":
                    Methods.degree--;
                    Methods.degree = Methods.confirmAngle(Methods.degree);
                    Methods.currentAngle();
                    break;
            case "-5º":
                    Methods.degree -= 5;
                    Methods.degree = Methods.confirmAngle(Methods.degree);
                    Methods.currentAngle();
                    break;
            case "+1P":
                    Methods.power++;
                    Methods.power = Methods.confirmPower(Methods.power);
                    Methods.currentPower();
                    break;
            case "+5P":
                    Methods.power += 5;
                    Methods.power = Methods.confirmPower(Methods.power);
                    Methods.currentPower();
                    break;
            case "-1P":
                    Methods.power--;
                    Methods.power = Methods.confirmPower(Methods.power);
                    Methods.currentPower();
                    break;
            case "-5P":
                    Methods.power -= 5;
                    Methods.power = Methods.confirmPower(Methods.power);
                    Methods.currentPower();    
                    break;   
            case "No Computers":
                //Hide all preference buttons
                    Methods.preferenceButtons(false);
                //Turn on no computer
                    compLevel = 0;
                //Player turn
                    playerTurn = 0;
                //Secret button order
                    if (secret == 1)
                        secret++;
                //Turns the game function on
                    Methods.newTurn();
                    //If secret stabilizer is true then set a static distance
                    //of 150
                    if (secretStabilize == true)
                        Methods.javelinHeight = 150;
                    turn++;
                //Display turn information
                    Methods.turnInformation();
                    turnInfo.setVisible(true);
                //Show game screen buttons
                    Methods.gameScreen(true,true);
                //Show angle and power
                    Methods.currentAngle();
                    Methods.currentPower();
                    break;
            case "Two Players":
                //Hide all preference buttons
                    Methods.preferenceButtons(false);
                //Turn on two players
                    compLevel = 1;
                //Player 1's turn
                    playerTurn = 0;   
                //Secret button order
                    if (secret == 2)
                        secret++;
                //Turns the game function on
                    Methods.newTurn();
                    //If secret stabilizer is true then set a static distance
                    //of 150
                    if (secretStabilize == true)
                        Methods.javelinHeight = 150;
                    turn++;
                    compTurn++;
                //Display turn information
                    Methods.turnInformation();
                    turnInfo.setVisible(true);
                //Show game screen buttons
                    Methods.gameScreen(true,true);
                    scoreBoard2.setVisible(true);
                //Show angle and power
                    Methods.currentAngle();
                    Methods.currentPower();
                    break;
            case "Impossible Computer":
                //Skill level is 5
                    compLevel = 5;
                //Secret button order 
                    if (secret == 0)
                        secret++;
                //Change background to fiery place
                    background.setIcon(BACKGROUND4);
            case "Hard Computer":
                //Skill level is 4
                    if (compLevel == -1)                      
                        compLevel = 4;
                //Change background to starry night
                    if (compLevel == 4)
                        background.setIcon(BACKGROUND2);
                //Secret button order
                    if (secret == 4 && compLevel == 4)
                        secret++;
            case "Medium Computer":
                //Skill level is 3
                    if (compLevel == -1)
                        compLevel = 3;
                //Change background to sunset
                    if (compLevel == 3)
                        background.setIcon(BACKGROUND3);
            case "Easy Computer": 
                //Skill level is 2
                    if (compLevel == -1)
                        compLevel = 2;
                //Initializes for all computers
                //Hide all preference buttons 
                    Methods.preferenceButtons(false);
                    playerTurn = 0;
                //Turns the game function on    
                    Methods.newTurn();
                    //If secret stabilizer is true then set a static distance
                    //of 150
                    if (secretStabilize == true)
                        Methods.javelinHeight = 150;
                    turn++;
                    compTurn++;
                //Display turn information    
                    Methods.turnInformation();
                    turnInfo.setVisible(true);
                //Show game screen buttons and scoreboard 2    
                    Methods.gameScreen(true,true);
                    scoreBoard2.setVisible(true);
                //Show angle and power    
                    Methods.currentAngle();
                    Methods.currentPower();
                    break;                                              
            case "Fire!":
                //Get the distance the javelin travelled
                    Methods.javelinTossed();
                //Get the score of the javelin
                    if (playerTurn == 0)
                    {
                        scores[playerTurn][turn] = Methods.score();
                        currentScore.setText("You scored " + scores[playerTurn][turn]);
                    } //fi
                    else
                    {
                        scores[playerTurn][compTurn] = Methods.score();
                        currentScore.setText("You scored " + scores[playerTurn][compTurn]);
                    } //esle
                //Make the javelin move to target
                    javelin.setVisible(false);
                    miniTosser.repaint(); 
                    javelin.setVisible(true);
                //Replace game buttons with next button       
                    Methods.gameButtons(false);                    
                    next.setVisible(true);                        
                    currentScore.setVisible(true);
                    scoreBoard1.repaint();
                    scoreBoard2.repaint();
                    break;
            case "Quit":
                //Open up the are you sure you want to quit
                    Methods.yesNo(true);
                    Methods.gameScreen(true,false);
                    break;
            case "No":
                //Go back to game
                    Methods.yesNo(false);
                    Methods.gameScreen(true,true);
                    break;
            case "Yes":
                //Reset game and go to main
                    Methods.yesNo(false);
                    Methods.gameScreen(false,false);
                    Methods.startButtons(true);
                    Methods.reset();
                    scoreBoard2.setVisible(false);
                    turnInfo.setVisible(false);
                    background.setIcon(BACKGROUND1);
                    break;
            case "Next":
                 //Next turn which is either computer, p2 or still p1
                
                 //If player 1's turn just past then initiate player 2
                    if (playerTurn == 0)
                    {
                        turn++;  
                        if (compLevel != 0)
                            playerTurn++;
                    } //fi
                    
                    else
                    {
                        compTurn++;
                        playerTurn--;
                    } //esle
                    
                    Methods.newTurn();
                    
                    //If secret button is pressed then keep a constant distance
                    //of 150
                        if (secretStabilize == true)
                            Methods.javelinHeight = 150;
                    
                    //This is for single player only results
                        if (turn == 10 && compLevel == 0)
                        {
                            finish.setVisible(true);
                            currentScore.setVisible(false);
                            total1 = Methods.totalScore(0);
                            congratulations.setText("Congratulations! You scored a total of " + total1 + "!");
                            congratulations.setVisible(true);
                            next.setVisible(false);
                        } //fi

                    //This is for two player only results    
                        else if (compTurn == 10 && compLevel == 1)
                        {
                            finish.setVisible(true);
                            currentScore.setVisible(false);
                            total1 = Methods.totalScore(0);
                            total2 = Methods.totalScore(1);
                            
                            //If player 1 wins
                                if (total1 > total2)
                                {
                                    congratulations.setText("<html>Congratulations Player 1!"
                                                          + "<br>You win with a score of " + total1 + "!!!<html>");
                                } //fi
                                
                            //If its a tie
                                else if (total1 == total2)
                                {
                                    congratulations.setText("<html>Congratulations to both of you!"
                                                          + "<br>You have tied in score!!!<html>");
                                } //fi esle
                                
                            //If player 2 wins
                                else
                                {
                                    congratulations.setText("<html>Congratulations Player 2!"
                                                          + "<br> You win with a score of " + total2 + "!!!<html>");
                                } //esle
                                
                            congratulations.setBounds(380,274,800,120);
                            congratulations.setVisible(true); 
                            next.setVisible(false);
                        } //fi esle
                        
                    //This is for player 1 vs computer only results
                        else if (compTurn == 10 && compLevel > 1)
                        {
                            finish.setVisible(true);
                            currentScore.setVisible(false);
                            total1 = Methods.totalScore(0);
                            total2 = Methods.totalScore(1);
                            
                            //Sorry text if player 1 loses to computer
                                if (total2 > total1)
                                {
                                    congratulations.setText("Sorry, Computer wins! Better luck next time!");
                                    congratulations.setBounds(220,354,900,60);
                                } //fi
                            
                            //Congratulations for a tie
                                else if (total2 == total1)
                                {
                                    congratulations.setText("Congratulations on a tie! Try to beat it now!");
                                } //fi esle
                           
                            //Congratulations for beating easy computer    
                               else if (compLevel == 2)
                                {
                                    congratulations.setFont(ariel25);
                                    congratulations.setText("<html>Congratulations you have beaten the easy computer!"
                                                        + "<br>Now try to beat the medium computer!<html>");
                                    congratulations.setBounds(320,274,1000,120);
                                } //fi esle
                            
                            //Congratulations for beating medium computer    
                                else if (compLevel == 3)
                                {
                                    congratulations.setFont(ariel25);
                                    congratulations.setText("<html>Wow! You just beat the medium computer!"
                                                           + "<br>Now on to the hard computer...<html>");
                                    congratulations.setBounds(370,274,1000,120);
                                } //fi esle
                                
                            //Congratulations for beating hard computer
                                else if (compLevel == 4)
                                {
                                    congratulations.setFont(ariel25);
                                    congratulations.setText("<html>No words can describe your accomplishment."
                                                          + "<br>You have beaten the hard computer making you almost better than"
                                                          + "<br>the progamer - er - programmer himself! Do not even think "
                                                          + "<br> of facing the impossible computer.<html>");
                                    congratulations.setBounds(290,214,1000,200);
                                } //fi esle
                                
                           //Congratulations for beating impossible computer
                                else if (compLevel == 5)
                                {
                                    congratulations.setFont(ariel25);
                                    congratulations.setText("<html>I, the progamer - er - programmer salute"
                                                          + "<br>you for your accomplishment. CONGRATULATIONS!!!"
                                                          + "<br>You beat the game!@@$%!1!@@!<html>");
                                    congratulations.setBounds(300,234,1000,180);
                                } //fi esle
                                
                                congratulations.setVisible(true);
                                computerShot.setVisible(false);
                                next.setVisible(false);
                        } //fi esle
                        
                        else if (compLevel > 1 && playerTurn == 1)
                        {
                            next.setVisible(false);
                            miniTosser.repaint();
                            currentScore.setVisible(false);
                            javelin.repaint();
                            Methods.turnInformation();
                            computerShot.setVisible(true);
                        } //fi esle
                        
                        else
                        {
                            Methods.gameButtons(true);
                            miniTosser.repaint();
                            javelin.repaint();
                            currentScore.setBounds(490,354,300,60);
                            currentScore.setVisible(false);
                            next.setVisible(false);
                            Methods.turnInformation();
                        } //esle
                    break;
            case "Finish":
                //Restarts game
                    Methods.gameScreen(false,false);
                    scoreBoard2.setVisible(false);
                    Methods.startButtons(true);
                    Methods.reset();
                    finish.setVisible(false);
                    congratulations.setVisible(false);
                    turnInfo.setVisible(false);
                    compLevel = -1;
                    congratulations.setFont(ariel40);
                    background.setIcon(BACKGROUND1);
                    break;
            case "See Computer Shot":
                //Runs the master AI
                    Methods.masterAI();
                //Gets the score for the computer                   
                    scores[playerTurn][compTurn] = Methods.score();
                    currentScore.setText("Computer scored " + scores[playerTurn][compTurn]); 
                    currentScore.setBounds(420,354,600,60);
                //Make the javelin move to target
                    javelin.setVisible(false);
                    miniTosser.repaint(); 
                    javelin.setVisible(true);
                //Replace game buttons with next button       
                    Methods.gameButtons(false);                    
                    next.setVisible(true);                        
                    currentScore.setVisible(true);
                    scoreBoard1.repaint();
                    scoreBoard2.repaint();
                    computerShot.setVisible(false);
                    break;  
            case "Credits":
                //Show credits screen
                    Methods.startButtons(false);
                    creditMe.setVisible(true);
                    back.setVisible(true);  
                //Secret button order
                    if (secret == 5)
                        secret++;
                //Show secret button
                    secretButton.setVisible(true);
                break;
            case ".":
                //Stabilize the javelin thrower's height if clicked first
                    if (secretStabilize == false)
                        secretStabilize = true;
                //If clicked again, turns it off
                    else 
                        secretStabilize = false;
        }//hctiws 
    } //demrofrePnoitca 
} //neercSemaG







