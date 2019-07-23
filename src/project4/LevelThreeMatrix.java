/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, April 5th, 2018
 *  Description: The LevelThreeMatrix class will carry out to create a
 * grid (the grid is created by an array of Cell type), check the status
 * of the grid
 * 1) Full grid
 * 2) 3 - consecutive of rows.
 * 3) 3 - consecutive of columns.
 * 4) 3 - consecutive of diagonal of grid.
 * 5) 3 - consecutive of opposite diagonal of the Grid.
 * In additional, this class also allow A Player to input in the grid
 * their chess by inputing the row and column position in the grid.
 */

package project4;

import java.util.Scanner;

/**
 *
 * Programmed by: Quang Bui
 * Due Date: Thursday, April 5th, 2018
 * Description: The LevelThreeMatrix class will carry out to create a
 * grid (the grid is created by an array of Cell type), check the status
 * of the grid
 * 1) Full grid
 * 2) 3 - consecutive of rows.
 * 3) 3 - consecutive of columns.
 * 4) 3 - consecutive of diagonal of grid.
 * 5) 3 - consecutive of opposite diagonal of the Grid.
 * In additional, this class also allow A Player to input in the grid
 * their chess by inputing the row and column position in the grid.
 */
public class LevelThreeMatrix {
    private int rowChose, columnChose;
    private Cell[][] grid;
    private checkGrid optionGrid;
    private static final int ROWS = 3;
    private static final int COLUMS = 3;
    
    /**
     * D E F A U L T  C O N S T R U C T O R
     * Pre-condition: the rowChose, columnChose, grid, and optionGrid
     * must be declared. The initializeCell() method must be called.
     * Post-condition: Construct an object of LevelThreeMatrix class 
     * with no parameters. 
     */
    public LevelThreeMatrix(){
        grid = new Cell[ROWS][COLUMS];
        rowChose = columnChose = 0;
        initializeCell();
    }
    
    /**
     * Mutator: initializeCell
     * Pre-condition: none
     * Post-condition: this method will be initialize the grid by
     * scanning all entries in the grid, each entry will be assign to
     * the Mark.empty is defined in the default constructor of
     * Cell class
     */
    public void initializeCell(){
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMS; j++){
                Cell entry = new Cell();
                grid[i][j] = entry;
            }
        }
    }

    /**
     * Accessor: getRowChose()
     * @return a copy of LevelThreeMatrix's rowChose value
     */
    public int getRowChose() {
        return rowChose;
    }

    /**
     * Mutator: setRowChose(int inRowChose) 
     * @param inRowChose 
     * Pre-condition: the inRowChose must be in the range of
     * [0 - (ROWS - 1)]
     * Post-condition: if the inRowChose in the range of 
     * [0 - (ROWS - 1)] the rowChose will be assigned to inRowChose;
     * otherwise, the rowChose = 0;
     */
    public void setRowChose(int inRowChose) {
        if(0 <= inRowChose && inRowChose < ROWS){
            rowChose = inRowChose;
        }
    }

    /**
     * Accessor: getColumnChose()
     * @return a copy of LevelThreeMatrix's columnChose value
     */
    public int getColumnChose() {
        return columnChose;
    }

    /**
     * Mutator: setColumnChose(int inColumnChose) 
     * @param inColumnChose 
     * Pre-condition: the inColumnChose must be in the range of
     * [0 - (COLUMS - 1)]
     * Post-condition: if the inColumnChose in the range of 
     * [0 - (COLUMS - 1)] the columnChose will be assigned to
     * inColumnChose; otherwise, the columnChose = 0;
     */
    public void setColumnChose(int inColumnChose) {
        if(0 <= inColumnChose && inColumnChose < COLUMS){
            columnChose = inColumnChose;
        }
    }

    /**
     * Accessor: getOptionGrid()
     * @return a copy of LevelThreeMatrix's optionGrid value
     */
    public checkGrid getOptionGrid() {
        return optionGrid;
    }

    /**
     * Mutator: setOptionGrid(checkGrid inOptionGrid) 
     * @param inOptionGrid 
     * Pre-condition: none
     * Post-condition: this method will assign the this.optionGrid to 
     * inOptionGrid;
     */
    public void setOptionGrid(checkGrid inOptionGrid) {
        this.optionGrid = inOptionGrid;
    }
    
    /**
     * Mutator: showGrid()
     * Pre-condition: all the entries of grid[][] must be initialized
     * Post-condition: this method (very important) will show the grid
     * at the beginning and the ending of the game and after one player
     * choose their position in row and columns to place their chess.
     */
    public void showGrid(){
        System.out.print("\n-------------");
        for(int i = 0; i < ROWS; i++){
            System.out.println();
            for(int j = 0; j < COLUMS; j++){
                if(j == 0){
                    System.out.print("|");
                }
                System.out.print(grid[i][j]);
                System.out.print("|");
            }
            System.out.print("\n");
            if(i == 0 || i == 1)
                System.out.print("-------------");
        }
        System.out.print("-------------\n\n");
    }
    
    /**
     * Mutator: inputRowColum()
     * Pre-condition: the rowChose and columnChose variable must be
     * declared.
     * Post-condition: this method will allow A Player to input the
     * row and column in the grid. This method will also check the
     * rowChose and columnChose must be in the range [1 - 3]
     * (Integer.parseInt(cin.nextLine()) - 1) before the position is
     * approved.
     * In addition, player can not input the alphabetic or symbol
     * character, if they player do it, they must be input again.
     */
    private void inputRowColum(){
        Scanner cin = new Scanner(System.in);
        boolean flag = true;
        // true: the number that users input are integer number;
        // false: the number that users input are not integer number
        
        do{
            try{
                do{
                    System.out.print("Please, enter a row[1 - 3]: ");
                    rowChose = Integer.parseInt(cin.nextLine()) - 1;

                    if(rowChose < 0 || rowChose > 2){
                        System.err.println("Your row entered is "
                                + "invalid, can you check and enter "
                                + "another row, please?");
                    }
                }while(rowChose < 0 || rowChose > 2);
                flag = true;
            }catch(NumberFormatException exception){
                System.err.println("Please enter an integer number.");
                flag = false;
            }
            
        }while(flag == false);
        
        do{
            try{
                do{
                    System.out.print("Please, enter a column[1 - 3]: ");
                    columnChose = Integer.parseInt(cin.nextLine()) - 1;

                    if(columnChose < 0 || columnChose > 2){
                        System.err.println("Your column entered is"
                                + " invalid, can you check and enter "
                                + "another column, please?");
                    }
                }while(columnChose < 0 || columnChose > 2);
                flag = true;
            }catch(NumberFormatException exception){
                System.err.println("Please enter an integer number.");
                flag = false;
            }
            
        }while(flag == false);
    }
    
    /**
     * Accessor: checkInputRowColum()
     * @return flag
     * Pre-condition: the rowChose must be in the range of [1 - ROWS]
     * columnChose must be in the range of [1 - COLUMS]
     * Post-condition: This method will check this position is taken or not
     * taken and make sure this position must be empty => this method
     * will return true; otherwise; this method return false;
     */
    private boolean checkInputRowColum(){
        boolean flag = false;
        // flag = true; the rowChose and columnChose are valid, and
        // the position is empty
        // flag = false; the position is taken 
        if(1 <= (rowChose + 1) && (rowChose + 1) <= ROWS
                && 1 <= (columnChose + 1) && (columnChose + 1) <= COLUMS
                && grid[rowChose][columnChose].getSign() == Mark.empty){
            flag = true;
        }else{
            flag = false;
        }
        
        return flag;
    }
    
    /**
     * Mutator: fillGrid(Player whoFill)
     * @param whoFill 
     * Pre-condition: the inputRowColum() and checkInputRowColum() must 
     * be defined because these method will be called in the 
     * fillGrid(Player whoFill) method
     * Post-condition: The fillGrid(Player whoFill) method will check
     * the position that Player entered is valid or invalid based on the 
     * inputRowColum() method. And then this method will check the 
     * position is taken or not taken based on the checkInputRowColum()
     * method. If checkInputRowColum() == true, the position will be 
     * assigned with the Mark of the Player (X, O) by the setSign()
     * method of Player class
     */
    public void fillGrid(Player whoFill){
        boolean flag = false;
        // flag = true; the rowChose and columnChose are valid, and
        // the position is empty
        // flag = false; the position is taken 
        do{
            inputRowColum();
            if(checkInputRowColum() == true){
                grid[rowChose][columnChose].setSign(whoFill.getChoice());
                flag = true;
            }else{
                System.err.println("This position is occupied. Can you "
                        + "choose another position, please?");
            }
        }while(flag == false);
    }
    
    /**
     * Accessor: checkFullTable
     * @return optionGrid
     * Pre-condition: Apply the enumerated type checkGrid to check the 
     * table is full or empty.
     * Post-condition: This method will check does the grid full or empty.
     * I use 3 counter variable to check: the table is full (count),
     * the table is full with X sign (xSign)
     * the table is full with O sign (oSign)
     * If count = 9 => optionGrid = checkGrid.fullGrid;
     * If oSign = 9 => optionGrid = checkGrid.fullO;
     * If xSign = 9 => optionGrid = checkGrid.fullX;
     * Otherwise => optionGrid = checkGrid.none => the game is continued
     */
    public checkGrid checkFullTable(){
        int count = 0, oSign = 0, xSign = 0;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMS; j++){
                if(grid[i][j].getSign() != Mark.empty){
                    count++;
                }
                if(grid[i][j].getSign() == Mark.cross){
                    xSign++;
                }
                if(grid[i][j].getSign() == Mark.circle){
                    oSign++;
                }
            }
        }
        if(xSign == 9){
            optionGrid = checkGrid.fullX;
        }else if(oSign == 9){
            optionGrid = checkGrid.fullO;
        }else if(count == 9){
            optionGrid = checkGrid.fullGrid;
        }else{
            optionGrid = checkGrid.none;
        }
        
        return optionGrid;
    }
    
    /**
     * Accessor: checkRow()
     * @return optionGrid
     * Pre-condition: Apply the enumerated type checkGrid to check the 
     * table is full with 3 consecutive in a row.
     * Post-condition: This method will check one of the three rows of
     * the grid is created 3 consecutive in a row or not.
     * If the grid is created 3 consecutive in a row (X)
     * => optionGrid = checkGrid.rowCross;
     * If the grid is created 3 consecutive in a row (O)
     * => optionGrid = checkGrid.rowCircle;
     * Otherwise => optionGrid = checkGrid.none => the game is continued
     */
    public checkGrid checkRow(){
        if(grid[rowChose][0].getSign() == grid[rowChose][1].getSign()
                && grid[rowChose][0].getSign() 
                == grid[rowChose][2].getSign()
                && grid[rowChose][0].getSign() != Mark.empty){
            if(grid[rowChose][0].getSign() == Mark.cross){
                optionGrid = checkGrid.rowCross;
            }else if(grid[rowChose][0].getSign() == Mark.circle){
                optionGrid = checkGrid.rowCircle;
            }
        }else{
            optionGrid = checkGrid.none;
        }
        
        return optionGrid;
    }
    
    /**
     * Accessor: checkColumn()
     * @return optionGrid
     * Pre-condition: Apply the enumerated type checkGrid to check the 
     * table is full with 3 consecutive in a column.
     * Post-condition: This method will check one of the three columns of
     * the grid is created 3 consecutive in a column or not.
     * If the grid is created 3 consecutive in a column (X)
     * => optionGrid = checkGrid.columnCross;
     * If the grid is created 3 consecutive in a column (O)
     * => optionGrid = checkGrid.columnCircle;
     * Otherwise => optionGrid = checkGrid.none => the game is continued
     */
    public checkGrid checkColumn(){
        if(grid[0][columnChose].getSign() == grid[1][columnChose].getSign()
                && grid[0][columnChose].getSign() 
                == grid[2][columnChose].getSign()
                && grid[0][columnChose].getSign() != Mark.empty){
            if(grid[0][columnChose].getSign() == Mark.cross){
                optionGrid = checkGrid.columnCross;
            }else if(grid[0][columnChose].getSign() == Mark.circle){
                optionGrid = checkGrid.columnCircle;
            }
        }else{
            optionGrid = checkGrid.none;
        }
        
        return optionGrid;
    }
    
    /**
     * Accessor: checkDiagonal()
     * @return optionGrid
     * Pre-condition: Apply the enumerated type checkGrid to check the 
     * table is full with 3 consecutive in a diagonal.
     * Post-condition: This method will check the diagonal of
     * the grid is created 3 consecutive in a diagonal or not.
     * If the grid is created 3 consecutive in a diagonal (X)
     * => optionGrid = checkGrid.diagonalCross;
     * If the grid is created 3 consecutive in a diagonal (O)
     * => optionGrid = checkGrid.diagonalCircle;
     * Otherwise => optionGrid = checkGrid.none => the game is continued
     */
    public checkGrid checkDiagonal(){
        if(grid[0][0].getSign() == grid[1][1].getSign()
                && grid[0][0].getSign() == grid[2][2].getSign()
                && grid[0][0].getSign() != Mark.empty){
            if(grid[0][0].getSign() == Mark.cross){
                optionGrid = checkGrid.diagonalCross;
            }else if(grid[0][0].getSign() == Mark.circle){
                optionGrid = checkGrid.diagonalCircle;
            }
        }else{
            optionGrid = checkGrid.none;
        }
        
        return optionGrid;
    }
    
    /**
     * Accessor: checkOppositeDiagonal()
     * @return optionGrid
     * Pre-condition: Apply the enumerated type checkGrid to check the 
     * table is full with 3 consecutive in a opposite diagonal.
     * Post-condition: This method will check the opposite diagonal of
     * the grid is created 3 consecutive in a opposite diagonal or not.
     * If the grid is created 3 consecutive in a opposite diagonal (X)
     * => optionGrid = checkGrid.oppositeDiagonalCross;
     * If the grid is created 3 consecutive in a opposite diagonal (O)
     * => optionGrid = checkGrid.oppositeDiagonalCircle;
     * Otherwise => optionGrid = checkGrid.none => the game is continued
     */
    public checkGrid checkOppositeDiagonal(){
        if(grid[0][2].getSign() == grid[1][1].getSign()
                && grid[0][2].getSign() == grid[2][0].getSign()
                && grid[1][1].getSign() != Mark.empty){
            if(grid[1][1].getSign() == Mark.cross){
                optionGrid = checkGrid.oppositeDiagonalCross;
            }else if(grid[1][1].getSign() == Mark.circle){
                optionGrid = checkGrid.oppositeDiagonalCircle;
            }
        }else{
            optionGrid = checkGrid.none;
        }
        
        return optionGrid;
    }
}
