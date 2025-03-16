package model.Board;

import model.Piece.Piece;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class single_square {

    private Piece piece;

    /**
     * <b>Constructor</b> construct a square
     * <b>Postcondition</b> construct a square from the board
     */
    public single_square(){
        this.piece=null;
    }

    /**
     * <b>Transformer</b> put the received piece in the square
     * <b>Postcondition</b> put the received piece in the square
     * @param piece is a player's piece
     */
    public void placeInTheSquare(Piece piece){
           this.piece=piece;
    }

    /**
     * <b>Accessor</b> return the piece from the square
     * @return return the piece from the square and if there isn't a piece,it returns null
     */
    public Piece getFromTheSquare(){
        return this.piece;
    }

    /**
     * <b>Transformer</b>  makes the square empty
     * <b>Postcondition</b>  makes the square empty
     */
    public void MakeItEmpty(){
        this.piece=null;
    }

    /**
     * <b>Observer</b> returns if the square is empty
     * @return true if the square is empty or false if isn't empty
     */
    public boolean IsEmpty(){
        return (piece==null);
    }

}
