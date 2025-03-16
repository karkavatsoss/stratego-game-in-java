package model.Piece.MovablePieces.SpecialMovablePieces;

import model.Piece.MovablePieces.MovablePieces;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class SpecialMovablePieces extends MovablePieces {
    /**
     * <b>constructor</b> constructs a specialMovablePiece
     * @param team refers to the team of the piece
     * @param power refers to the power of the team
     */
    public SpecialMovablePieces(int power,int team) {
        super(power,team);
    }
}
