/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, April 5th, 2018
 *  Description: The checkGrid enumerated type will check the status of
 * the grid in the process of the game when the game are playing. 
 * The "fullGrid" will be checked when the game draw.
 * "fullO" and "fullX" will be checked if the game is loading (beginning
 * of the game) with full Grid.
 * "none": the game is continued (take turn the Player)
 * "rowCross" and "rowCircle": 3 consecutive rows of grid
 * "columnCross" and "columnCircle: 3 consecutive columns of grid
 * "diagonalCross" and "diagonalCircle": 3 consecutive in the 
 * main diagonal of the Grid.
 * "oppositeDiagonalCross" and "oppositeDiagonalCircle": 3 consecutive
 * opposite diagonal of the Grid.
 */

package project4;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, April 5th, 2018
 * Description: The checkGrid enumerated type will check the status of
 * the grid in the process of the game when the game are playing. 
 * The "fullGrid" will be checked when the game draw.
 * "fullO" and "fullX" will be checked if the game is loading (beginning
 * of the game) with full Grid.
 * "none": the game is continued (take turn the Player)
 * "rowCross" and "rowCircle": 3 consecutive rows of grid
 * "columnCross" and "columnCircle: 3 consecutive columns of grid
 * "diagonalCross" and "diagonalCircle": 3 consecutive in the 
 * main diagonal of the Grid.
 * "oppositeDiagonalCross" and "oppositeDiagonalCircle": 3 consecutive
 * opposite diagonal of the Grid.
 */
public enum checkGrid {
    fullGrid, fullO, fullX, none, rowCross, rowCircle, columnCross,
    columnCircle, diagonalCross, diagonalCircle, 
    oppositeDiagonalCross, oppositeDiagonalCircle;
}
