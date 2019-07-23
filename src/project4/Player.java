/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, April 5th, 2018
 *  Description: The Player class includes the name, choice, and score
 * of Player. The Player class have setName() to get the name of Player
 * before the game is started. This class also show the sign of the chess
 * (cross: X, circle: O) and shows the name and score of Player
 */

package project4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Programmed by: Quang Bui
 * Due Date: Tuesday, April 3rd, 2018
 * Description: The Player class includes the name, choice, and score
 * of Player. The Player class have setName() to get the name of Player
 * before the game is started. This class also show the sign of the chess
 * (cross: X, circle: O) and shows the name and score of Player
 */
public class Player {
    private String name;
    private Mark choice;
    private int score; // if Player win, they will get 10 points
    // in their score
    // if two Players are draw, they get 15 points in their score

    /**
     * D E F A U L T  C O N S T R U C T O R
     * Pre-condition: the name, choice, and score variables must be
     * declared.
     * Post-condition: Construct an object of Player class with no
     * parameters. 
     */
    public Player(){
        name = "Quang Bui";
        choice = Mark.circle;
        score = 0;
    }
    
    /**
     * C O N V E R S I O N    C O N S T R U C T O R
     * @param inChoice
     * @param inScore 
     * Pre-condition: the name, choice, and score variables must be
     * declared.
     * Post-condition: Construct an object of Player class with no
     * parameters. 
     */
    public Player(Mark inChoice, int inScore){
        name = "Quang Bui";
        choice = inChoice;
        if(0 <= inScore){
            score = inScore;
        }
    }
    
    /**
     * Mutator: setName(String inName) 
     * @param inName 
     * Pre-condition: none
     * Post-condition: assigned name to inName
     */
    public void setName(String inName) {
        name = inName;
    }

    /**
     * Mutator: setChoice(Mark inChoice) 
     * @param inChoice 
     * Pre-condition: none
     * Post-condition: assigned choice to inChoice
     */
    public void setChoice(Mark inChoice) {
        choice = inChoice;
    }

    /**
     * Accessor: getName()
     * @return a copy of the Player's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Accessor: getChoice()
     * @return a copy of the Player's choice
     */
    public Mark getChoice(){
        return choice;
    }
    
    /**
     * Accessor: getScore()
     * @return a copy of the Player's score
     */
    public int getScore() {
        return score;
    }

    /**
     * Mutator: setScore(int inScore) 
     * @param inScore 
     * Pre-condition: inScore must be > 0
     * Post-condition: assigned score to inScore if inScore > 0;
     * otherwise, score = 0
     */
    public void setScore(int inScore) {
        if(0 < inScore){
            score = inScore;
        }else{
            score = 0;
        }
    }
    
    /**
     * Accessor: checkName()
     * @return flag
     * Pre-condition: none
     * Post-condition: the checkName() will return true if all
     * characters in this.name are alphabetic and space symbol;
     * otherwise, this method return false.
     */
    private boolean checkName(){
        boolean flag = false;
        String regex = "^[\\p{L} .'-]+$";
        Pattern model = Pattern.compile(regex);
        Matcher fit = model.matcher(this.name);
        if(fit.matches()){
            flag = true; // is a name
        }else{
            flag = false; // is not a name
        }
        return flag;
    }
    
    /**
     * Mutator: setName()
     * Pre-condition: the checkName() method must be defined
     * Post-condition: this method will carry out to input the name
     * of Player (The programmer must input with valid name: the name
     * is valid if all characters of name are alphabetic and exist the
     * space between two words; otherwise; the programmers must input
     * again.)
     */
    public void setName(){
        Scanner cin = new Scanner(System.in);
        
        do{
            System.out.print("Please enter your name: ");
            name = cin.nextLine();
            
            if(checkName() == false){
                System.err.println("The name is invalid. "
                        + "Can you check and enter again, please?");
            }
            
        }while(checkName() == false);
    }
    
    /**
     * Accessor: choiceName()
     * Pre-condition: the choice must be defined with enumerated type
     * (Mark)
     * Post-condition: output the sign of choice depend on the Mark
     * Mark.circle: " O ";
     * Mark.cross: " X ";
     * Mark.empty: "   "
     */
    private String choiceName(){
        String result = "";
        
        if(choice == Mark.circle){
            result += " O ";
        }else if(choice == Mark.cross){
            result += " X ";
        }else{
            result += "   ";
        }
        
        return result;
    }
    
    /**
     * Accessor: toString()
     * Pre-condition: the name, choice, and score are assigned the value
     * Post-condition: output all the information of Player class,
     * include: name, score, and choice of Player
     */
    public String toString(){
        String result = "";
        result = "Player \"" + name + "\" choose \"" 
                + this.choiceName() + "\" chess.\n";
        result += name + "'s score is: " + this.score;
        return result;
    }
}
