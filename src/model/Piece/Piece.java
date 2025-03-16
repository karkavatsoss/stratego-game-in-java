package model.Piece;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public interface Piece {

     /**
      * <b>Accessor</b> returns the power/rank of the piece
      * @return the power/rank of the piece
      */
     public int getPower();


     //------------------------//
     /**
      * <b>Accessor</b> returns the team of the piece
      * @return the team of the piece(1 for blue , 2 for red)
      */
     public int getTeam();

}
