package controller;
import model.Board.Board;
import model.Piece.Piece;
import model.collections.*;

import java.util.ArrayList;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class initialization{
    private Board board;
    private ArrayList<Piece> IceCollection;
    private ArrayList<Piece> FireCollection;

    private String[] virtualBoard;                       ////
    private ArrayList<String> IceImageCollection;        ////
    private ArrayList<String> FireImageCollection;       ////

    private PrepareTeams teamcollections ;

    /**
     * <b>Constructor</b> initialize the board and the virtualBoard random for each team
     * <b>Postcondition</b> initialize the board and the virtualBoard random for each team according the value of the REDUSEDARMY variable
     * @param board is the board of the game that the constructor initialize with the pieces
     * @param virtualBoard  is the virtual board that the constructor initialize with the names of the images
     * @param REDUSEDARMY says if the board will be initialized with the normal amount of pieces(30 for each team) or the half of them (15 for each team)
     */
    public initialization(Board board,String[] virtualBoard,boolean REDUSEDARMY){
        teamcollections =new PrepareTeams(REDUSEDARMY);

        this.board=board;
        IceCollection=teamcollections.getIcePieces();
        FireCollection=teamcollections.getFirePieces();

        this.virtualBoard = virtualBoard;                       ////
        IceImageCollection=teamcollections.getIceImage();    ////
        FireImageCollection=teamcollections.getFireImage();  ////

        int Size =30;
        if (REDUSEDARMY == true){
            Size=15;
        }
        int temp=Size-1;
        for (int i=0; i<Size; i++){
                int random_int = (int)Math.floor(Math.random()*(temp-0+1)+0);
                board.PlaceInBoard(IceCollection.remove(random_int),i);
                virtualBoard[i] = IceImageCollection.remove(random_int);     ////
                temp--;
        }
        temp=Size-1;
        for (int i=80-Size; i<80; i++){
                int random_int = (int)Math.floor(Math.random()*(temp-0+1)+0);
                board.PlaceInBoard(FireCollection.remove(random_int),i);
                virtualBoard[i] = FireImageCollection.remove(random_int);   ////
                temp--;
        }

    }


    /**
     * <b>accessor</b> return the fresh initialized board
     * @return the fresh initialized board
     */
    public Board getBoard(){
        return this.board;
    }
    /**
     * <b>accessor</b> return the fresh initialized virtual board
     * @return the fresh initialized virtual board
     */
    public String[] getVirtualBoard(){
        return this.virtualBoard;
    }
}

