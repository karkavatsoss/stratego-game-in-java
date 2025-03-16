package model.Fight;

import model.Board.Board;
import model.Fight.fight;
import model.Piece.MovablePieces.*;
import model.Piece.MovablePieces.SpecialMovablePieces.Dwarf;
import model.Piece.MovablePieces.SpecialMovablePieces.Scout;
import model.Piece.MovablePieces.SpecialMovablePieces.Slayer;

import javax.swing.*;
import java.awt.*;

/**
 * count the fallen pieces of each team
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class FallenPieces {
    private JButton selectedButton;
    private JButton butButton;
    private int[] fallenPiecesForBlue;
    private int[] fallenPiecesForRed;
    private Component[] components;
    private Board board;


    /**
     * <b>constructor</b> according to the result of the fight count the fallen pieces of each team
     * <b>Precondition</b> the selectedButton refer to a piece and not an empty square
     * <b>Postcondition</b> add to the arrays the piece that had fallen
     * @param selectedButton is the button that refers to the attacker (the piece that will move)
     * @param butButton is the button that refers to the destination square of the attacker
     * @param fallenPiecesForBlue an array that contains how many pieces of blue team had fallen
     * @param fallenPiecesForRed an array that contains how many pieces of red team had fallen
     * @param components are the components of the gridlayout 8*10 that contains the buttons which refer to the pieces
     * @param board is the board that the pieces are
     */
    public FallenPieces(JButton selectedButton, JButton butButton, int[] fallenPiecesForBlue , int[] fallenPiecesForRed , Component[] components , Board board){
        this.selectedButton =selectedButton;
        this.butButton=butButton;
        this.fallenPiecesForBlue=fallenPiecesForBlue;
        this.fallenPiecesForRed=fallenPiecesForRed;
        this.components=components;
        this.board=board;

        ////////////////////////////////////////////////
        int selectedButtonLocation = 0;
        int butButtonLocation = 0;

        int i=0;
        for (Component c : components){

            if (this.selectedButton == c){
                selectedButtonLocation=i;
                break;
            }
            i++;
        }


        i=0;
        for (Component k : components){

            if (this.butButton == k){
                butButtonLocation=i;
                break;
            }
            i++;
        }
        System.out.println(selectedButtonLocation+""+butButtonLocation);
        ////////////////////////////////////////////////
        fight tempfight = new fight();     // thelw thn sumarthsh TheFightBetweenThePieces ths fight
        if(board.getFromBoard(selectedButtonLocation).getTeam() == 1) { // an h omada twn attackers einai 1 dhladh fenontai ta mple kai oxi ta kokkina
            if (tempfight.TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation), board.getFromBoard(butButtonLocation)) == 1) {  //an o attacker nikaei
                if (board.getFromBoard(butButtonLocation) instanceof Slayer) {
                    this.fallenPiecesForRed[0]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Scout){
                    this.fallenPiecesForRed[1]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Dwarf){
                    this.fallenPiecesForRed[2]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Elf){
                    this.fallenPiecesForRed[3]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Yeti){
                    this.fallenPiecesForRed[4]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Sorceress){
                    this.fallenPiecesForRed[5]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof BeastRider){
                    this.fallenPiecesForRed[6]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Knight){
                    this.fallenPiecesForRed[7]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Mage){
                    this.fallenPiecesForRed[8]++;
                }
            }else if (tempfight.TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation), board.getFromBoard(butButtonLocation)) == 2){  //an o defender nikaei
                if (board.getFromBoard(selectedButtonLocation) instanceof Slayer) {
                    this.fallenPiecesForBlue[0]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Scout){
                    this.fallenPiecesForBlue[1]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Dwarf){
                    this.fallenPiecesForBlue[2]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Elf){
                    this.fallenPiecesForBlue[3]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Yeti){
                    this.fallenPiecesForBlue[4]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Sorceress){
                    this.fallenPiecesForBlue[5]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof BeastRider){
                    this.fallenPiecesForBlue[6]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Knight){
                    this.fallenPiecesForBlue[7]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Mage){
                    this.fallenPiecesForBlue[8]++;
                }
            }else if (tempfight.TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation), board.getFromBoard(butButtonLocation)) == 3){
                System.out.println("GINETEEEE");
                if (board.getFromBoard(selectedButtonLocation) instanceof Slayer) {
                    this.fallenPiecesForBlue[0]++;
                    this.fallenPiecesForRed[0]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Scout){
                    this.fallenPiecesForBlue[1]++;
                    this.fallenPiecesForRed[1]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Dwarf){
                    this.fallenPiecesForBlue[2]++;
                    this.fallenPiecesForRed[2]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Elf){
                    this.fallenPiecesForBlue[3]++;
                    this.fallenPiecesForRed[3]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Yeti){
                    this.fallenPiecesForBlue[4]++;
                    this.fallenPiecesForRed[4]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Sorceress){
                    this.fallenPiecesForBlue[5]++;
                    this.fallenPiecesForRed[5]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof BeastRider){
                    this.fallenPiecesForBlue[6]++;
                    this.fallenPiecesForRed[6]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Knight){
                    this.fallenPiecesForBlue[7]++;
                    this.fallenPiecesForRed[7]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Mage){
                    this.fallenPiecesForBlue[8]++;
                    this.fallenPiecesForRed[8]++;
                }
            }
        }else{                                                         // an h omada twn attackers einai 2 dhladh fenontai ta kokkina kai oxi ta mple
            if (tempfight.TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation), board.getFromBoard(butButtonLocation)) == 1) {  //an o attacker nikaei
                if (board.getFromBoard(butButtonLocation) instanceof Slayer) {
                    this.fallenPiecesForBlue[0]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Scout){
                    this.fallenPiecesForBlue[1]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Dwarf){
                    this.fallenPiecesForBlue[2]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Elf){
                    this.fallenPiecesForBlue[3]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof LavaBeast){
                    this.fallenPiecesForBlue[4]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Sorceress){
                    this.fallenPiecesForBlue[5]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof BeastRider){
                    this.fallenPiecesForBlue[6]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Knight){
                    this.fallenPiecesForBlue[7]++;
                }else if (board.getFromBoard(butButtonLocation) instanceof Mage){
                    this.fallenPiecesForBlue[8]++;
                }
            }else if (tempfight.TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation), board.getFromBoard(butButtonLocation)) == 2){  //an o defender nikaei
                if (board.getFromBoard(selectedButtonLocation) instanceof Slayer) {
                    this.fallenPiecesForRed[0]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Scout){
                    this.fallenPiecesForRed[1]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Dwarf){
                    this.fallenPiecesForRed[2]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Elf){
                    this.fallenPiecesForRed[3]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof LavaBeast){
                    this.fallenPiecesForRed[4]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Sorceress){
                    this.fallenPiecesForRed[5]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof BeastRider){
                    this.fallenPiecesForRed[6]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Knight){
                    this.fallenPiecesForRed[7]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Mage){
                    this.fallenPiecesForRed[8]++;
                }
            }else if (tempfight.TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation), board.getFromBoard(butButtonLocation)) == 3){
                if (board.getFromBoard(selectedButtonLocation) instanceof Slayer) {
                    this.fallenPiecesForBlue[0]++;
                    this.fallenPiecesForRed[0]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Scout){
                    this.fallenPiecesForBlue[1]++;
                    this.fallenPiecesForRed[1]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Dwarf){
                    this.fallenPiecesForBlue[2]++;
                    this.fallenPiecesForRed[2]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Elf){
                    this.fallenPiecesForBlue[3]++;
                    this.fallenPiecesForRed[3]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof LavaBeast){
                    this.fallenPiecesForBlue[4]++;
                    this.fallenPiecesForRed[4]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Sorceress){
                    this.fallenPiecesForBlue[5]++;
                    this.fallenPiecesForRed[5]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof BeastRider){
                    this.fallenPiecesForBlue[6]++;
                    this.fallenPiecesForRed[6]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Knight){
                    this.fallenPiecesForBlue[7]++;
                    this.fallenPiecesForRed[7]++;
                }else if (board.getFromBoard(selectedButtonLocation) instanceof Mage){
                    this.fallenPiecesForBlue[8]++;
                    this.fallenPiecesForRed[8]++;
                }
            }

        }
    }

    /**
     * <b>accessor</b> return the array with the fallen pieces of blue team
     * @return the array with the fallen pieces of blue team
     */
    public int[] getFallenPiecesForBlue(){
        return this.fallenPiecesForBlue;
    }

    /**
     * <b>accessor</b> return the array with the fallen pieces of red team
     * @return the array with the fallen pieces of red team
     */
    public int[] getFallenPiecesForRed(){
        return this.fallenPiecesForRed;
    }

}
