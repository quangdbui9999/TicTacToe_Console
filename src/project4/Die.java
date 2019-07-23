/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, April 5th, 2018
 *  Description: The Die class will carry to create a dice with purpose for
 * Player to roll the dice. This class have function: create a dice, 
 * show the value of a dice, initialize, get the value and 
 * set the value of a dice.
 */

package project4;

import java.util.Random;

/**
 *
 * Programmed by: Quang Bui
 * Due Date: Thursday, April 5th, 2018
 * Description: The Die class will carry to create a dice with purpose for
 * Player to roll the dice. This class have function: create a dice, 
 * show the value of a dice, initialize, get the value and 
 * set the value of a dice.
 */
public class Die {
    private int faceUp;
    
    /**
     * D E F A U L T  C O N S T R U C T O R
     * Pre-condition: the faceUpmust be declared.
     * Post-condition: Construct an object of Die class with no
     * parameters. 
     */
    public Die(){
        faceUp = 1;
    }
    
    /**
     * Accessor: getFaceUp()
     * @return a copy of Die's faceUp
     */
    public int getFaceUp(){
        return faceUp;
    }
    
    /**
 * setFaceUp()
 * @param inFace 
 * change the value of faceUp to the input provided
 * preconditions: inFace is between 1 - 6
 * postconditions: if inFace is valid (1-6); change faceUp to inFace
 *                 otherwise faceUp is not changed
 */

    public void setFaceUp(int inFace){
        if(1 <= inFace && inFace <= 6){
            faceUp = inFace;
        }
    }
    
    /**
 * Roll()
 * randomly roll the Die and change faceUp to the result 1 - 6
 * preconditions: none
 * postconditions:  faceUp's value is changed to the result randomly
 *                  generated (1 - 6)
 */

    public void roll(){
        Random rand = new Random();
        faceUp = 1 + rand.nextInt(6);
    }
    
    /**
     * Accessor: toString
     * @return result
     * Pre-condition: the faceUp values must be have initialized
     * Post-condition: output the faceUp values in the form of the dice.
     */
    public String toString(){
        String result = "";
        switch(faceUp)
        {
            case 1:
                result += " ----- \n";
                result += "|     |\n";
                result += "|  o  |\n";
                result += "|     |\n";
                result += " ----- \n";
            break;
            case 2:
                result += " ----- \n";
                result += "| o   |\n";
                result += "|     |\n";
                result += "|   o |\n";
                result += " ----- \n";
            break;
            case 3:
                result += " ----- \n";
                result += "| o   |\n";
                result += "|  o  |\n";
                result += "|   o |\n";
                result += " ----- \n";
            break;
            case 4:
                result += " ----- \n";
                result += "| o o |\n";
                result += "|     |\n";
                result += "| o o |\n";
                result += " ----- \n";
            break;
            case 5:
                result += " ----- \n";
                result += "| o o |\n";
                result += "|  o  |\n";
                result += "| o o |\n";
                result += " ----- \n";
            break;
            case 6:
                result += " ----- \n";
                result += "| o o |\n";
                result += "| o o |\n";
                result += "| o o |\n";
                result += " ----- \n";
            break;
        }
        
        return result;
    }
}