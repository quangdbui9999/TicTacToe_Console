/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, April 5th, 2018
 *  Description: 
 */

package project4;

import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, April 5th, 2018
 * Description: The Game class is the main class to run the UNTicTacToe
 * Game. The Game class will ask the 2 Player's name. 
 * Player One will be assigned to X chess, and 
 * Player Two will be assigned to O chess.
 * The Game class require them roll the dice to choose who will go first.
 * Two players will play UnTicTacToe together. If the player One's face 
 * value is greater than player Two's face values, the player One will 
 * go first;otherwise, player Two will go first. If the face values of 
 * both player are the same value, they will roll a dice until who's 
 * face value is greater than other. When a player takes his or her 
 * turn, he or she should choose a row and a columns to place his or 
 * her chess (X or O) in the grid and try to create the condition make 
 * his or her opponent make one of four the following condition:
 * 1) 3 consecutive in a row.
 * 2) 3 consecutive in a column.
 * 3) 3 consecutive in a diagonal.
 * 4) 3 consecutive in a opposite diagonal.
 * If one of two players can make one of four the above condition, their 
 * opponent will be determined winning and their opponent will get 10 
 * points in their score. If both players are draw, they will get 15 points
 * in their scores(15 points for both players). After the game is finish, 
 * the application will ask two player do they want to play continue. If 
 * they choose "y", they will roll a dice to make who goes first. If 
 * they choose "n", the game will be finish and thank you for taking 
 * their to play Tic_Tac_Toe Game Application of us.
 */
public class Game {
    private LevelThreeMatrix unTicTacToe;
    private Player playerOne, playerTwo;
    private Die dice;
    private Winner whoWon;
    private static final int STARTSCORE = 0;
    private static final int WINSCORE = 10;
    private static final int DRAWSCORE = 15;
    
    /**
     * D E F A U L T  C O N S T R U C T O R
     * Pre-condition: the unTicTacToe, playerOne, playerTwo, dice and 
     * whoWon variables must be declared.
     * Post-condition: Construct an object of Game class with no
     * parameters. Default, playerOne will be assigned to X chess, and
     * playerTwo will be assigned to O chess.
     */
    public Game(){
        unTicTacToe = new LevelThreeMatrix();
        dice = new Die();
        playerOne = new Player(Mark.cross, STARTSCORE);
        playerTwo = new Player(Mark.circle, STARTSCORE);
        whoWon = Winner.none;
    }
    
    /**
     * Mutator: resetGrid()
     * Pre-condition: The LevelThreeMatrix class must be defined.
     * Post-condition: If the players agree to play again, this method
     * will be called: whoWon will be assigned to  Winner.none and
     * the grid will be initialized.
     */
    private void resetGrid(){
        whoWon = Winner.none;
        unTicTacToe.initializeCell();
    }
    
    /**
     * Mutator: rollDice(Player whoRoll)
     * Pre-condition: The Player class must be defined.
     * Post-condition: This method will ask the Player carry out to roll
     * the dice.
     */
    private void rollDice(Player whoRoll){
        Scanner cin = new Scanner(System.in);
        System.out.println("It's your turn "
              + whoRoll.getName() + ", type any key to roll the dice ");
        String junk = cin.nextLine();
        dice.roll();
    }
    
    /**
     * Mutator: resetGrid()
     * Pre-condition: The LevelThreeMatrix and Player classes
     * must be defined.
     * Post-condition: If the Player 1 finished his or her turn, the 
     * Player 2 will take the turn to fill her or his chess in the grid.
     * Otherwise, Player 1 will take the turn to fill her or his chess 
     * in the grid if the Player 2 finished his or her turn.
     */
    private void takeTurn(Player whoPlay){        
        System.out.println("It's your turn "
              + whoPlay.getName());
        unTicTacToe.fillGrid(whoPlay);
    }
    
    /**
     * Mutator: reportWinner()
     * Pre-condition: the whoWon variable must be assigned one of three
     * value: tie, playOneWin, and playTwoWin. If whoWon = Winner.none;
     * this method will be ignored.
     * Post-condition: This method will report the result of the game:
     * who will win the game or the game is draw, and their scores.
     * if whoWon == Winner.tie => the game is DRAW.
     * if whoWon == Winner.playOneWin => playerOne wins the game
     * if whoWon == Winner.playTwoWin => playerTwo wins the game
     */
    private void reportWinner(){
        if(whoWon == Winner.tie){
            System.out.println("Congratulations! " + playerOne.getName()
                + " and " + playerTwo.getName() + " are draws.\n"
                + " " + playerOne.getName() + "'s score are: " 
                + playerOne.getScore()
                + ". " + playerTwo.getName() + "'s score are: " 
                + playerTwo.getScore());
        }else{
            if(whoWon == Winner.playOneWin){
                System.out.println(" Congratulations! "
        + playerOne.getName() + ". You WON!\n"
        + playerOne.getName() + "'s score is: " + playerOne.getScore()
        + "\n"
        + playerTwo.getName() + "'s score is: " + playerTwo.getScore());
            } else if(whoWon == Winner.playTwoWin){
                System.out.println(" Congratulations! "
        + playerTwo.getName() + ". You WON!\n"
        + playerTwo.getName() + "'s score is: " + playerTwo.getScore()
        + "\n"
        + playerOne.getName() + "'s score is: " + playerOne.getScore());
            }
        }
    }
    
    /**
     * Mutator: getPlayerName(Player who)
     * Pre-condition: The Player class must be defined.
     * Post-condition: This method will ask the Player to input his or
     * her name.
     */
    private void getPlayerName(Player who){
        who.setName();
    }
    
    /**
     * Accessor: checkForAWinner()
     * @return flag
     * Pre-condition: The LevelThreeMatrix class must be defined:
     * checkFullTable(), checkRow(), checkColumn(),
     * checkDiagonal(), and checkOppositeDiagonal() methods must be 
     * active correctly.
     * Apply the enumerated type checkGrid to determine who win the
     * game through the status of the Grid.
     * Post-condition: This method will determine who will be won the 
     * game by checking the status of the Grid. The checkForAWinner()
     * method will combine some methods:
     * checkFullTable(), checkRow(), checkColumn(),
     * checkDiagonal(), and checkOppositeDiagonal() methods
     * to determine who won the game
     * If playerOne won the game, playerOne will get 10 points 
     * in her or his score.
     * If playerTwo won the game, playerTwo will get 10 points 
     * in her or his score.
     * If the game is draw, two players will get 15 points 
     * in her or his scores.
     * Otherwise, the game is continued.
     */
    private boolean checkForAWinner(){
        boolean flag = false;
        int scoreForOne = playerOne.getScore();
        int scoreForTwo = playerTwo.getScore();
        
        if(unTicTacToe.checkFullTable() == checkGrid.fullGrid){
            whoWon = Winner.tie;
            scoreForOne += DRAWSCORE;
            scoreForTwo += DRAWSCORE;
            playerOne.setScore(scoreForOne);
            playerTwo.setScore(scoreForTwo);
            flag = true;
        }else if(unTicTacToe.checkRow() == checkGrid.rowCross 
|| unTicTacToe.checkColumn() == checkGrid.columnCross
|| unTicTacToe.checkDiagonal() == checkGrid.diagonalCross
||unTicTacToe.checkOppositeDiagonal()==checkGrid.oppositeDiagonalCross){
            whoWon = Winner.playTwoWin;
            scoreForTwo += WINSCORE;
            playerTwo.setScore(scoreForTwo);
            flag = true;
        }else if(unTicTacToe.checkRow() == checkGrid.rowCircle
|| unTicTacToe.checkColumn() == checkGrid.columnCircle
|| unTicTacToe.checkDiagonal() == checkGrid.diagonalCircle
||unTicTacToe.checkOppositeDiagonal()==checkGrid.oppositeDiagonalCircle){
            whoWon = Winner.playOneWin;
            scoreForOne += WINSCORE;
            playerOne.setScore(scoreForOne);
            flag = true;
        }else if(unTicTacToe.checkRow() == checkGrid.none
                || unTicTacToe.checkColumn() == checkGrid.none
                || unTicTacToe.checkDiagonal() == checkGrid.none
                || unTicTacToe.checkOppositeDiagonal() == checkGrid.none){
            flag = false;
        }
        
        return flag;
    }
    
    /**
     * Mutator: introduction()
     * Pre-condition: none
     * Post-condition: output the introduction of the game
     */
    private void introduction(){
        System.out.println("Welcome to the Tic_Tac_Toe Game Application "
            + "is programmed\nby the Java Programming Language.");
        System.out.println("In this application, there are two players. "
            + "Each player \nshould set their name before the Tic_Tac_Toe "
            + "Game is beginning.");
        System.out.println("After the player set their name,\n"
                + "Player One will be assigned to X chess, and\n"
                + "Player Two will be assigned to O chess.");
        System.out.println("Player One and Two will roll a dice\n"
            + "to take advantage of "
            + "who will go first. If the player One's face value\n"
            + "is greater than player Two's face values, the player "
            + "One will go first;\notherwise, player Two will "
            + "go first. If the face values of\nboth player "
            + "are the same value, they will roll a dice\nuntil "
            + "who's face value is greater than other. When a player "
            + "\n takes his or her turn, he or she "
            + "should choose\na row and a colums to place his or "
            + "her chess (X or O) in the grid\nand try to create the "
            + "condition make his "
            + "or her opponrnt \n make one of four the "
            + "following condition:");
        System.out.println("1) 3 consecutive in a row.");
        System.out.println("2) 3 consecutive in a column.");
        System.out.println("3) 3 consecutive in a diagonal.");
        System.out.println("4) 3 consecutive in a opposite diagonal.");
        System.out.println("If one of two players can make one of four"
            + " the above condition,\ntheir opponent will be "
            + "determined winning and \n"
            + "their opponent will get 10 points in their score.");
        System.out.println("If both players are draw, they will get 15 "
            + "points in their scores.\n"
            + "(15 points for both players).");
        System.out.println("After the game is finish, the application "
            + "will ask two player\ndo they want to play continue.");
        System.out.println("If they choose \"y\", they will roll a dice "
            + "to make who goes first.");
        System.out.println("If they choose \"n\", the game will be finish"
            + " and thank you \nfor taking their to play Tic_Tac_Toe "
            + "Game Application of us.\n\n");
    }
    
    /**
     * Mutator: goodBye()
     * Pre-condition: none
     * Post-condition: if two players don't want to play again,
     * this method will be called.
     * The goodBye() output the information of good bye two players.
     */
    private void goodBye(){
        System.out.println("THANK YOU FOR SPENDING YOUR TIME TO PLAY"
                + " GAME: TIC-TAC-TOE WITH US.\n"
                + " WE WISH YOU AND YOR FRIEND HAVE A GREAT DAY\nWHEN"
                + " COMING TO PLAY GAME WITH US.");
    }
    
    /**
     * Mutator: informationPlayAgain()
     * Pre-condition: none
     * Post-condition: after one round of the game is finished. This
     * method will be called to ask the players do they want to
     * play again.
     * The informationPlayAgain() output the information of 
     * play again.
     */
    private void informationPlayAgain(){
        System.out.println("Do you want to play again?: ");
        System.out.println("Enter \"Y\" or \"y\" to play agian.");
        System.out.println("Enter any key on the keyboard to "
                + "finish game.");
        System.out.print("We choose the character: ");
    }
    
    /**
     * Mutator: goFirst(Player one, Player two)
     * Pre-condition: The LevelThreeMatrix and Player classes 
     * must be defined.
     * Post-condition: The goFirst(Player one, Player two) will run
     * multiple times if the game have not been determined who won the
     * game yet (whoWon == Winner.none). If the do ... while loop,
     * The takeTurn(Player) will called first
     * the showGrid() and checkForAWinner() will be 
     * called two times (2 players) to determine who won the game.
     * Example: if playerOne goes first, they will input his or her
     * position to place his or her chess, after that the showGrid() will
     * be displayed the Grid and check the status of the game does 
     * playerOne win the game by checkForAWinner();, if not, the playerTwo
     * will take his or her turn to place his or her chess in the grid,
     * after that the showGrid() will
     * be displayed the Grid and check the status of the game does 
     * playerOne win the game by checkForAWinner(); if not, the playerOne
     * will take his or her turn to play the Game.
     * This method will be termined if one of two players won the game
     */
    private void goFirst(Player one, Player two){
        do{
            takeTurn(one);
            unTicTacToe.showGrid();
            checkForAWinner();
            if(whoWon == Winner.none){
                takeTurn(two);
                unTicTacToe.showGrid();
                checkForAWinner();
            }
            reportWinner();
        }while(whoWon == Winner.none);
    }
    
    /**
     * Mutator: newGame()
     * Pre-condition: The LevelThreeMatrix, Die and Player classes 
     * must be defined.
     * Post-condition: The newGame() method will ask 2 players to roll
     * the dice who will go first. After two players roll their dice,
     * this method will output the faceUp of the dice of each player
     * and compare the value of the dice. 
     * The newGame() will show the Grid if the value of faceUp's dice of
     * two players are different about the value.
     * If the value of faceUp's dice of playerOne > the value of faceUp's 
     * dice of playerTwo, playerOne will go first; otherwise, playerTwo
     * will go first
     */
    private void newGame(){
        rollDice(playerOne);
        String diceOne = dice.toString();
        int diceValueOne = dice.getFaceUp();
        rollDice(playerTwo);
        String diceTwo = dice.toString();
        int diceValueTwo = dice.getFaceUp();

        System.out.println(playerOne.getName() + " rolls dice "
                + "with result: \n" + diceOne);
        System.out.println(playerTwo.getName() + " rolls dice "
                + "with result: \n" + diceTwo);

        if(diceValueOne != diceValueTwo){
            System.out.println("Display the grid.");
            unTicTacToe.showGrid();
        }

        if(diceValueOne > diceValueTwo){
            goFirst(playerOne, playerTwo);
        }else if(diceValueOne < diceValueTwo){
            goFirst(playerTwo, playerOne);
        }
    }
    
    /**
     * Mutator: playGame()
     * Pre-condition: The LevelThreeMatrix, Die and Player classes 
     * must be defined.
     * Post-condition: The playGame() will check the status of the grid 
     * (is the grid empty or not empty).
     * If the Grid is full with X or O chess, the game will be termined
     * Otherwise, the game will output the introduction to welcome two 
     * players come to TicTacToe game. It will ask two player's name,
     * they will roll the dice to determine who will go first (if the value
     * of faceUp's dice of playerOne == the value of faceUp's dice 
     * of playerTwo => they will roll the dice again until who get the
     * higher faceUp values.).
     * After they finished one round, they will be ask to play again.
     * If they choose "y" or "Y", they play again.
     * Otherwise, the goodBye() will be called to goodbye two players.
     */
    public void playGame(){
        if(unTicTacToe.checkFullTable() == checkGrid.fullO 
                || unTicTacToe.checkFullTable() == checkGrid.fullX){
            System.exit(0);
        }
        
        Scanner cin = new Scanner(System.in);
        String play_again = "";
        introduction();
        getPlayerName(playerOne);
        getPlayerName(playerTwo);
        System.out.println(playerOne);
        System.out.println(playerTwo);
        
        do{
            newGame();
            informationPlayAgain();
            play_again = cin.nextLine();
            if(play_again.equalsIgnoreCase("y")){
                this.resetGrid(); // play agian
            }
        }while(play_again.equalsIgnoreCase("y"));
        goodBye();
    }
}