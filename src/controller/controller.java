package controller;

import model.Board.Board;
import model.Fight.fight;
import model.Player.*;
import model.collections.PrepareTeams;
import viewer.Menu;

import java.io.IOException;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */


public class controller {
    private ice player1;
    private fire player2;
    private Board board;
    private initialization initializator ;
    private String[] virtualBoard;

    /**
     * <b>Constructor</b>
     * <b>Postcondition:</b> creates the 2 players , the board ,the virtual board
     * and based on the value of the boolean variable REDUSEARMY initializes the two boards
     * @param REDUSEDARMY return from the viewer if the user choose redused army(15) or the usual Army(30)
     */
    public controller(boolean REDUSEDARMY){
       player1 = new ice();
       player2 = new fire();

       board = new Board();
       virtualBoard = new String[80];

       initializator=new initialization(board,virtualBoard,REDUSEDARMY);

       this.board = initializator.getBoard();
       this.virtualBoard = initializator.getVirtualBoard();

    }


    /**
     * <b>accessor</b> return the board
     * @return the current form of the board
     */
    public Board getBoard(){
        return this.board;
    }

    /**
     *<b>transformer</b> set the board .I don't use that in this implementation because after
     * we get the initialized board all the program continues in the view (i know that is wrong
     * according the mvc model ,but i noticed that the last day i could give for the project)
     * <b>Postcondition:</b> set the new board
     * @param board the new board
     */
    public void setBoard(Board board){
        this.board=board;
    }


    /**
     * <b>accessor<b/> return the virtual board
     * @return the current form of the virtual board
     */
    public String[] getVirtualBoard(){
        return this.virtualBoard;
    }

    /**
     * <b>accessor<b/> return the player1
     * @return the player 1
     */
    public ice getPlayer1(){
        return this.player1;
    }

    /**
     * <b>accessor<b/> return the player2
     * @return the player 2
     */
    public fire getPlayer2(){
        return this.player2;
    }
}
