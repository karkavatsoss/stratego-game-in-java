package model.Piece.MovablePieces;

import model.Piece.Piece;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class MovablePieces implements Piece {
    private int team;
    private  int power;                     //power of the piece


    /**
     * <b>Constructor</b> makes the profile of a movable piece
     * @param power is the power/rank of the piece
     //* @param availability is how many pieces are available to use
     */
    public MovablePieces(int power,int team){
        this.power=power;

        this.team=team;
    }


    /**
     * <b>Accessor</b> returns the power/rank of the piece
     * @return the power/rank of the piece
     */
    @Override
    public int getPower() {
        return power;
    }


    //------------------------------//

    /**
     * <b>accessor</b> returns the team of the piece
     * @return the team of the piece (1 for blue , 2 for red)
     */
    @Override
    public int getTeam() {
        return this.team;
    }

}
