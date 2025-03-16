package model.Player;

import model.Board.Board;
import model.Piece.MovablePieces.MovablePieces;
import model.Piece.MovablePieces.SpecialMovablePieces.Scout;
import model.Piece.Piece;
import model.collections.PrepareTeams;

import java.util.ArrayList;

/**
 * this class represents a player
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public abstract class Player {
    private String Name;
    private boolean turn;
    private boolean IsThePlayerDefeated;

    /**
     * <b>Constructor</b> makes the profile of a player
     * @param name is the name of the team that the player plays with
     * @param turn is for whose turn is to play in this round
     */
    public Player(String name ,boolean turn){
        this.Name=name;
        this.turn=turn;
        this.IsThePlayerDefeated=false;
    }


    //------------------------------------------//
    /**
     * <b>transformer</b> change the value of the variable turn
     * @param turn shows if it's the turn of the player or not
     */
    public void setTurn(boolean turn){
        this.turn = turn;
    }

    /**
     * <b>Accessor</b> return if it's the turn of the player or not
     * @return  if it's the turn of the player or not
     */
    public boolean getTurn(){
        return this.turn;
    }
}
