 /* This is a class full of methods that are used in the main and drawing 
  * class. Methods include many functions such as the master AI, calculating
  * javeling distance, calculating scores, etc. There are 19 methods in this
  * class.
 */
package JavelinTossSummative;

/* William Ma
 * 433144
 * ICS 3U0
 * Mr. North
 * Date Started: May 30, 2012
 * Date Finished: June 7, 2012
 */

public class Methods
{
    
    static int javelinHeight,           //New height of javelintosser
               targetDistance,          //New distance of target
               power = 0,               //Power of throw
               degree = 0,              //Angle of throw
               score,                   //Score of throw
               distance = -1,           //Distance travelled by javelin
               realDistance;            //Real distance between javelin and target
    static double time,                 //Time it takes for javelin to land
                  x,                    //Horizontal power
                  y;                    //Vertical power
          
    //Method that gives the target a new random location in between 200 pixels and 1280
        public static void targetLocation ()
        {
            targetDistance = (int) ((881*Math.random())+45);
            realDistance = targetDistance + 160;
        } //noitocaLtegrat
        
    //Method that gives the javelin tosser a new random location of height between 20 pixels and 350
        public static void javelinLocation ()
        {
            javelinHeight = (int) (261*Math.random());
        } //noitocoLnilevaj
   
    //Method that either hides or shows the play screen buttons & pics 
    //Also sets the buttons enabled or not according to second parameter    
        public static void gameScreen (boolean b, boolean e)
        {
            GameScreen.up1.setVisible(b);
            GameScreen.up5.setVisible(b);
            GameScreen.down1.setVisible(b);
            GameScreen.down5.setVisible(b);
            GameScreen.fire.setVisible(b);
            GameScreen.quit.setVisible(b);
            GameScreen.raise1.setVisible(b);
            GameScreen.raise5.setVisible(b);
            GameScreen.lower1.setVisible(b);
            GameScreen.lower5.setVisible(b);
            GameScreen.scoreBoard1.setVisible(b);
            GameScreen.target.setVisible(b);
            GameScreen.miniTosser.setVisible(b);
            GameScreen.javelin.setVisible(b);
            GameScreen.up1.setEnabled(e);
            GameScreen.up5.setEnabled(e);
            GameScreen.down1.setEnabled(e);
            GameScreen.down5.setEnabled(e);
            GameScreen.fire.setEnabled(e);
            GameScreen.quit.setEnabled(e);
            GameScreen.raise1.setEnabled(e);
            GameScreen.raise5.setEnabled(e);
            GameScreen.lower1.setEnabled(e);
            GameScreen.lower5.setEnabled(e);
            GameScreen.power1.setVisible(b);
            GameScreen.power5.setVisible(b);
            GameScreen.degree1.setVisible(b);
            GameScreen.degree5.setVisible(b);
            GameScreen.currentAngle.setVisible(b);
            GameScreen.currentPower.setVisible(b);
            GameScreen.box.setVisible(b);
        } //neercSemag
        
     //Method either shows or hides the game screen buttons only
        public static void gameButtons (boolean b)
        {
            GameScreen.up1.setVisible(b);
            GameScreen.up5.setVisible(b);
            GameScreen.down1.setVisible(b);
            GameScreen.down5.setVisible(b);
            GameScreen.fire.setVisible(b);
            GameScreen.quit.setVisible(b);
            GameScreen.raise1.setVisible(b);
            GameScreen.raise5.setVisible(b);
            GameScreen.lower1.setVisible(b);
            GameScreen.lower5.setVisible(b);
            GameScreen.power1.setVisible(b);
            GameScreen.power5.setVisible(b);
            GameScreen.degree1.setVisible(b);
            GameScreen.degree5.setVisible(b);
        } //snottuBemag
        
     //Method that either hides or shows the preference screen buttons & pics
        public static void preferenceButtons (boolean b)
        {
            GameScreen.noComp.setVisible(b);
            GameScreen.easyComp.setVisible(b);
            GameScreen.mediumComp.setVisible(b);
            GameScreen.hardComp.setVisible(b);
            GameScreen.impComp.setVisible(b);
            GameScreen.twoPlayer.setVisible(b);
            GameScreen.back.setVisible(b);
            GameScreen.preference.setVisible(b);
        } //snottuBecnereferp
        
     //Method that either hides or shows the start screen buttons & pics 
        public static void startButtons (boolean b)
        {
            GameScreen.welcome.setVisible(b);
            GameScreen.JAVELIN_TOSSER.setVisible(b);
            GameScreen.instructions.setVisible(b);
            GameScreen.startGame.setVisible(b);
            GameScreen.credits.setVisible(b);
        } //snottuBtrats
        
     //Method that either hides or shows the instructions buttons & pics
        public static void instructionButtons (boolean b)
        {
            GameScreen.scoreBoard2.setVisible(b);
            GameScreen.done.setVisible(b);
            GameScreen.instruction.setVisible(b);
        } //snottuBnoitcurtsni
        
     //Method that either hides or shows the yes or no buttons for quit
        public static void yesNo (boolean b)
        {
            GameScreen.yes.setVisible(b);
            GameScreen.no.setVisible(b);
            GameScreen.confirmQuit.setVisible(b);
        } //oNsey
        
     //Method that updates the current angle
        public static void currentAngle ()
        {
            GameScreen.currentAngle.setText("Angle: " + degree);
        } //elgnAtnerruc
        
     //Method that updates the current power
        public static void currentPower ()
        {
            GameScreen.currentPower.setText("Power: " + power);
        } //rewoPtnerruc
        
     //Makes sure angle is not lower than 0 or greater than 90   
        public static int confirmAngle (int a)
        {
            if (a > 90)
                return 90;
            else if (a < 0)
                return 0;
            else
                return a;
        } //elgnAmrifnoc
        
     //Makes sure power is not lower than 0 or greater than 100
        public static int confirmPower (int p)
        {
            if (p > 100)
                return 100;
            else if (p < 0)
                return 0;
            else
                return p;
        } //rewoPmrifnoc
        
     //Calculates the distance travelled by the javelin
        public static void javelinTossed ()
        {
            //Getting the actual height between the javelin and ground
            double height = 587 - javelinHeight;
            //Convert degree to radians
                double radians = degree*(Math.PI/180);
            //To find y power, we can use cosX = adj/hyp and sinX = opp/hyp
                y = Math.sin(radians)*power;
                x = Math.cos(radians)*power;
            //Use kinematics formula d = v1*t + 0.5a*t^2 to find the time
                time = (y + Math.sqrt(Math.pow(y,2) + 19.6*height))/9.8;
            //Solve the distance by multiplying x by the time
                distance = (int) Math.round(x*time);
        } //dessoTnilevaj
        
     //Calculates the score
        public static int score ()
        {
                
            //Scoring
                if (distance >= (realDistance - 5) && distance <= (realDistance + 5))
                    score = 10;
                else if (distance >= (realDistance - 15) && distance <= (realDistance + 15))
                    score = 8;
                else if (distance >= (realDistance - 25) && distance <= (realDistance + 25))
                    score = 6;
                else if (distance >= (realDistance - 35) && distance <= (realDistance + 35))
                    score = 4;
                else if (distance >= (realDistance - 45) && distance <= (realDistance + 45))
                    score = 2;
                else
                    score = 0;
                
                return score;                               
        } //erocs
        
     //Makes new location for height and target
        public static void newTurn ()
        {
            targetLocation();
            javelinLocation();
            GameScreen.target.setVisible(false);
            GameScreen.javelin.setVisible(false);
            GameScreen.target.setVisible(true);
            GameScreen.javelin.setVisible(true);
            GameScreen.miniTosser.setVisible(false);
            GameScreen.miniTosser.setVisible(true);
            distance = -1;
        } //nruTwen
        
     //Resets all memory
        public static void reset ()
        {
            //Resets scores
                for (int row = 0; row < GameScreen.scores.length; row ++)
                    for (int col = 0; col < GameScreen.scores[0].length; col++)
                        GameScreen.scores[row][col] = 0;
            //Resets distance
                distance = -1;
            //Resets turn
                GameScreen.turn = -1;
                GameScreen.compTurn = -1;
            //Resets power and degree
                power = 0;
                degree = 0;
            //Resets computer level
                GameScreen.compLevel = -1;
        } //teser  
        
    //Returns total score with a parameter that tells which player to keep score
        public static int totalScore (int i)
        {
            int total = 0;
            
            //Adds all scores of player 1 if i == 0 and player 2 if i == 1
                for (int counter = 0; counter < 10; counter++)
                    total += GameScreen.scores[i][counter];
                
            return total;                           
        } //erocSlatot
        
    //THE MASTER AI!!! The 4 computer difficulties
        public static void masterAI ()
        {
            /* The AI levels use the compLevel variable. A compLevel of 1
             * will initiate the easy computer, 3 will give medium computer, 
             * 4 will give hard, and 5 will give  an impossible computer.*/
            
            //Easy Mode (javelin can shoot anywhere in a quarter screen range of target
                if (GameScreen.compLevel == 2)
                    //around 320 is a quarter of the screen so 160 on both sides of target
                        distance = realDistance - 160 + (int)(321*Math.random());
           
           //Medium mode (javelin can hit the target 50% of the time
                else if (GameScreen.compLevel == 3)
                    //180 is twice the target length so now we have 90 on both sides
                        distance = realDistance - 90 + (int)(181*Math.random());
                
           //Hard mode (javelin can shoot anywhere on the target)
                else if (GameScreen.compLevel == 4)
                    //90 is the target size so 45 on both sides of the target
                        distance = realDistance - 45 + (int)(91*Math.random());
                
           //Impossible mode (javelin can shoot anywhere on the inner 3 target points)
                else if (GameScreen.compLevel == 5)
                    //30 is the size for the inner 3 spaces of the target so 15 on both sides of the target
                        distance = realDistance - 15 + (int)(31*Math.random());
        } //IAretsam
        
   //Updates the turn information
        public static void turnInformation ()
        {
            int player = GameScreen.playerTurn + 1;
            int turn1 = GameScreen.turn + 1;
            int turn2 = GameScreen.compTurn + 1;
            
            //Player 1's turn
            if ((turn1 != turn2) && GameScreen.compLevel > 1)
                GameScreen.turnInfo.setText("Computer's turn " + turn2);              
            //Player 2's turn
            else if ((turn1 != turn2) && GameScreen.compLevel == 1)
                GameScreen.turnInfo.setText("Player " + player + "'s turn " + turn2);
            //Computer's turn
            else
                GameScreen.turnInfo.setText("Player " + player + "'s turn " + turn1);
        } //noitamrofnInrut
} //sdohteM
