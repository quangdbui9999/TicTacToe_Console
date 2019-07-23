/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, April 5th, 2018
 *  Description: The Cell class will carry out to create a chess, this
 * class use the enumerated type of Mark (sign). This class have
 * function: create a chess (Mark.empty), get, set and output the 
 * value of chess.
 */

package project4;

import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, April 5th, 2018
 * Description: The Cell class will carry out to create a chess, this
 * class use the enumerated type of Mark (sign). This class have
 * function: create a chess (Mark.empty), get, set and output the 
 * value of chess.
 */
public class Cell {
    private Mark sign;
    
    /**
     * D E F A U L T  C O N S T R U C T O R
     * Pre-condition: none
     * Post-condition: Construct an object of Cell class with no
     * parameters. Default, the sign will be assigned to Mark.empty
     * (the beginning of the game, the grid always empty)
     */
    public Cell(){
        sign = Mark.empty;
    }
    
    /**
     * Accessor: toString
     * @return result
     * Pre-condition: none
     * Post-condition: outpur the information of each chess
     * Mark.circle: " O ";
     * Mark.cross: " X ";
     * Mark.empty: "   "
     */
    public String toString(){
        String result = "";
        switch(sign){
            case circle:{
                result += " O ";
                break;
            }
            case cross:{
                result += " X ";
                break;
            }
            case empty:{
                result += "   ";
                break;
            }
        }
        return result;
    }

    /**
     * Accessor: getSign()
     * @return a copy of Cell's sign value.
     */
    public Mark getSign() {
        return sign;
    }

    /**
     * Mutator: setSign(Mark sign)
     * @param sign 
     * Pre-condition: 
     * Post-condition: this method will assign the value of this.sign
     * to sign
     */
    public void setSign(Mark sign) {
        this.sign = sign;
    }
}
