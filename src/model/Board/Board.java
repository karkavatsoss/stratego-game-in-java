package model.Board;
import model.Piece.Piece;
import model.Player.*;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class Board{
    private single_square[] board;

    /**
     * <b>Constructor</b>
     * Creates the board of the game and makes every square empty
     */
    public Board(){
        board=new single_square[80];
        for(int i=0; i<80; i++){
            board[i]= new single_square();
        }
    }

    /**
     * <B>Transformer</B> place the piece that receive in the cordinates that receive also
     * @param piece is a player's piece like scout,flag...ktl
     * @param cordinates refers to a specific square on the board
     */
    public void PlaceInBoard(Piece piece,int cordinates){
        board[cordinates].placeInTheSquare(piece);
    }

    /**
     * <b>Accessor</b> returns the piece from the square that the cordinates refers to
     * @param cordinates refers to a specific square on the board
     * @return the piece that there is in the square that the cordinates refers to
     */
    public Piece getFromBoard(int cordinates){
        return board[cordinates].getFromTheSquare();
    }

    //--------------------------------------//

    /**
     * <b>transformer</b> remove from the given cordinates the piece and make that square empty
     * <b>Postcondition</b> make the square empty that the cordinates show
     * @param cordinates give as the square that we will set empty
     */
    public void removeFromBoard(int cordinates){
        board[cordinates].MakeItEmpty();
    }
}
