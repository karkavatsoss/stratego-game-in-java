package model.Piece.ImmovablePieces;

import model.Piece.Piece;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class ImmovablePieces implements Piece {
    private int team;   // 1 or 2


    /**
     * <b>Constructor</b> makes the profile of a immovable piece
     */
    public ImmovablePieces(int team){
        this.team=team;
    }



    /**
     * <b>Accessor</b> returns the power/rank of the piece
     * @return the power/rank of the piece
     */
    @Override
    public int getPower() {
        return 0;
    }


    //---------------------------------------------------//
    /**
     * <b>Accessor</b> returns the team of the piece
     * @return the team of the piece (1 for blue , 2 for red)
     */
    @Override
    public int getTeam() {
        return this.team;
    }

}
