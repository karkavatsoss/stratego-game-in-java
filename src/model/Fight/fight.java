package model.Fight;

import model.Board.*;
import model.Piece.ImmovablePieces.*;
import model.Piece.MovablePieces.*;
import model.Piece.MovablePieces.SpecialMovablePieces.Dwarf;
import model.Piece.MovablePieces.SpecialMovablePieces.Scout;
import model.Piece.MovablePieces.SpecialMovablePieces.Slayer;
import model.Piece.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * start the fight between the two pieces
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class fight {
    private JButton selectedButton;
    private JButton but;
    private String[] virtualBoard;
    private String[] tempFBlueH;
    private String[] tempFRedH;

    private Board board;
    private Component[] components;


    private int action;

    int butLocation;
    int selectedButtonLocation;
    int tempFightResult=0;

    /**
     * <b>constructor</b>I use it just to create a fight but i don't want to change the boards.Only to see the results of a fight if it happens
     */
    public fight(){

    }

    /**
     * <b></b>constructor</b> create a fight and according to results change the boards
     * <b>Preconditions</b> the two buttons be different and the selected button be a piece and not an empty square
     * <b>Postconditions</b> this function calls the function "TheFightBetweenThePieces" and according to the result ,changes the boards with the new form of the pieces
     * @param selectedButton the button on the screen that refer to a piece of the attacking team
     * @param but the button on the screen that refer to square (maybe contains a piece maybe not) that the selected button want to go
     * @param virtualBoard the board that contains the names of the images of the pieces ,that according to the results of the fight, we change
     * @param tempFBlueH the board that contains the names of the images of the blue pieces, that according to the results of the fight,we change
     * @param tempFREDH the board that contains the names of the images of the red pieces, that according to the results of the fight,we change
     * @param board the board that contains all the pieces,that according to the results of the fight ,we change
     * @param components are the components of the gridlayout 8*10 that contains the buttons which refer to the pieces
     */
    public fight(JButton selectedButton, JButton but, String[] virtualBoard,String[] tempFBlueH , String[] tempFREDH,Board board , Component[] components){

        this.but = but;
        this.selectedButton = selectedButton;

        this.virtualBoard=virtualBoard;
        this.tempFBlueH=tempFBlueH;
        this.tempFRedH =tempFREDH;

        this.board=board;
        this.components=components;

        int i=0;
        for (Component c : components){

            if (this.but == c){
                butLocation=i;
                break;
            }
            i++;

        }


        
        int j=0;
        selectedButton.setEnabled(true);
        for (Component k : components){

            if (this.selectedButton == k){
                selectedButtonLocation=j;
                break;
            }

            j++;

        }




        if (this.but.getName()!=null) {
            if (board.getFromBoard(butLocation).getTeam() == board.getFromBoard(selectedButtonLocation).getTeam()) {
                action = 0;
                // System.out.println(board.getFromBoard(butLocation).getTeam()+" "+board.getFromBoard(selectedButtonLocation).getTeam());
                //System.out.println(butLocation+ " " +selectedButtonLocation);
            }else {
                action = 1;
                if (TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation),board.getFromBoard(butLocation)) == 1) {
                    tempFightResult=1;
                    //
                    //System.out.println(board.getFromBoard(butLocation).getTeam() + " " + board.getFromBoard(selectedButtonLocation).getTeam());
                    //System.out.println(butLocation + " " + selectedButtonLocation);

                    if (board.getFromBoard(selectedButtonLocation).getTeam() == 1) { // an einai mple
                        this.tempFBlueH[butLocation] = this.tempFBlueH[selectedButtonLocation];
                        this.tempFBlueH[selectedButtonLocation] = null;
                        this.tempFRedH[butLocation] = null;
                    } else {
                        this.tempFRedH[butLocation] = this.tempFRedH[selectedButtonLocation];
                        this.tempFRedH[selectedButtonLocation] = null;
                        this.tempFBlueH[butLocation] = null;
                    }

                    this.board.PlaceInBoard(this.board.getFromBoard(selectedButtonLocation), butLocation); // gia to board
                    this.board.PlaceInBoard(null, selectedButtonLocation);

                    this.virtualBoard[butLocation] = this.virtualBoard[selectedButtonLocation];
                    this.virtualBoard[selectedButtonLocation] = null;

                }else if (TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation),board.getFromBoard(butLocation)) == 2){
                    tempFightResult=2;
                    if (board.getFromBoard(selectedButtonLocation).getTeam() == 1) { // an einai mple
                        this.tempFBlueH[selectedButtonLocation] = null;
                        /////////////////////////////////////////
                        /////////////////////////////////////////
                    } else {
                        this.tempFRedH[selectedButtonLocation] = null;
                        /////////////////////////////////////////
                        ///////////////////////////////////////////

                    }

                    this.board.PlaceInBoard(null, selectedButtonLocation);

                    this.virtualBoard[selectedButtonLocation] = null;
                }else if (TheFightBetweenThePieces(board.getFromBoard(selectedButtonLocation),board.getFromBoard(butLocation)) == 3){//douleuei
                    tempFightResult=3;
                    if (board.getFromBoard(selectedButtonLocation).getTeam() == 1) { // an einai mple
                        this.tempFBlueH[selectedButtonLocation] = null;
                        this.tempFRedH[butLocation] = null;
                        //
                        this.tempFRedH[selectedButtonLocation] = null;
                        this.tempFBlueH[butLocation] = null;
                        //
                    } else {
                        this.tempFRedH[selectedButtonLocation] = null;
                        this.tempFBlueH[butLocation] = null;
                        //
                        this.tempFBlueH[selectedButtonLocation] = null;
                        this.tempFRedH[butLocation] = null;
                        //
                    }

                    this.board.PlaceInBoard(null, selectedButtonLocation); // gia to board
                    this.board.PlaceInBoard(null, butLocation);


                    this.virtualBoard[selectedButtonLocation] = null;

                    this.virtualBoard[butLocation] = null;
                }
            }
        }else {
            action=1;
            System.out.println(butLocation+ " " +selectedButtonLocation);

            if (board.getFromBoard(selectedButtonLocation).getTeam()==1){ // an einai mple
                this.tempFBlueH[butLocation]=this.tempFBlueH[selectedButtonLocation];
                this.tempFBlueH[selectedButtonLocation]=null;

            }
            else {
                this.tempFRedH[butLocation]=this.tempFRedH[selectedButtonLocation];
                this.tempFRedH[selectedButtonLocation]=null;
            }

            this.board.PlaceInBoard(this.board.getFromBoard(selectedButtonLocation),butLocation);
            this.board.PlaceInBoard(null,selectedButtonLocation);


            this.virtualBoard[butLocation]=this.virtualBoard[selectedButtonLocation];
            this.virtualBoard[selectedButtonLocation]=null;
        }
    }

    /**
     *<b>Precondition</b> the piece A not be null
     * <b>Postcondition</b> return if the piece A loose ,won, just moved or if both pieces loose.Also if the A attacked the flag the game ends
     * @param A the piece that attack(makes the move)
     * @param B the piece that defend (makes no move)
     * @return the result of the fight (if attacker won : 1 ,if defender won : 2 ,and if both lose or the piece B is null : 3)
     */
    public int TheFightBetweenThePieces (Piece A , Piece B){
        if (B instanceof Flag && B.getTeam()!=A.getTeam()){

            JFrame frame2 = new JFrame("My JFrame");
            frame2.setSize(400, 100);
            frame2.setLocationRelativeTo(null);
            JLabel label = new JLabel();
            if (A.getTeam()==1) {
                 label.setText("The game is over.The winner is : Blue");
            }else label.setText("The game is over.The winner is : Red");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            label.setForeground(Color.RED);
            label.setHorizontalAlignment(SwingConstants.CENTER);
            frame2.add(label);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setVisible(true);

            if (!frame2.isVisible()) {
                System.exit(0);
            }



        }
        if (A instanceof Dragon){    // periptwseis gia drakous
            if (B instanceof Dragon){
                return 3;
            }else if (B instanceof Bomb){
                return 2;
            }
            else return 1;
        }else if(A instanceof Mage){  // priptwseis gia magous
            if (B instanceof Mage){
                return 3;
            }else if(B instanceof Bomb || B instanceof Dragon){
                return 2;
            }else return 1;
        }else if(A instanceof Knight) {  // priptwseis gia knights
            if (B instanceof Knight) {
                return 3;
            } else if (B instanceof Bomb || B instanceof Dragon || B instanceof Mage) {
                return 2;
            } else return 1;
        }else if(A instanceof BeastRider) {  // priptwseis gia BeastRiders
            if (B instanceof BeastRider) {
                return 3;
            } else if (B instanceof Bomb || B instanceof Dragon || B instanceof Mage || B instanceof Knight) {
                return 2;
            } else return 1;
        }else if(A instanceof Sorceress) {  // priptwseis gia Sorceress
            if (B instanceof Sorceress) {
                return 3;
            } else if (B instanceof Bomb || B instanceof Dragon || B instanceof Mage || B instanceof Knight || B instanceof BeastRider) {
                return 2;
            } else return 1;
        }else if(A instanceof LavaBeast || A instanceof Yeti) {  // priptwseis gia LavaBeasts or Yetiss

            if (B instanceof Yeti || B instanceof LavaBeast) {

                return 3;
            } else if (B instanceof Flag || B instanceof Slayer || B instanceof Scout || B instanceof Dwarf || B instanceof Elf) {
                return 1;
            } else return 2;
        }else if(A instanceof Elf) {  // priptwseis gia Elfs
            if (B instanceof Elf) {
                return 3;
            } else if (B instanceof Flag || B instanceof Slayer || B instanceof Scout || B instanceof Dwarf ) {
                return 1;
            } else return 2;
        }else if(A instanceof Dwarf) {  // priptwseis gia Dwarfs
            if (B instanceof Dwarf) {
                return 3;
            } else if (B instanceof Flag || B instanceof Slayer || B instanceof Scout || B instanceof Bomb) {  // special movement eksoudeterosh bomb
                return 1;
            } else return 2;
        }else if(A instanceof Scout) {  // priptwseis gia Scouts
            if (B instanceof Scout) {
                return 3;
            } else if (B instanceof Flag || B instanceof Slayer) {  // special movement alla den thn bazw edw
                return 1;
            } else return 2;
        }else if(A instanceof Slayer) {  // priptwseis gia Slayers
            if (B instanceof Slayer) {
                return 3;
            } else if (B instanceof Flag || B instanceof Dragon) {  // special movement attack se drako
                return 1;
            } else return 2;
        }
        return 0;
    }

    /**
     * <b>accessor</b> return the action
     * @return the action (0 if the 2 pieces belong to the same team,1 if the 2 pieces belong to different teams or the destination square is empty)
     */
    public int getAction() {
        return action;
    }

    /**
     * <b>accessor</b> return the new board
     * @return the new board
     */
    public Board getBoard(){
        return this.board;
    }

    /**
     * <b>accessor</b> return the new virtual board
     * @return the new virtual board
     */
    public String[] getVirtualBoard(){
        return this.virtualBoard;
    }

    /**
     * <b>accessor</b> return the new virtual board of the blue pieces
     * @return the new virtual board of the blue pieces
     */
    public String[] getTempBlueHidden(){
        return this.tempFBlueH;
    }

    /**
     * <b>accessor</b> return the new virtual board of the red pieces
     * @return the new virtual board of the red pieces
     */
    public String[] getTempRedHidden(){
        return this.tempFRedH;
    }

    /**
     * <b>accessor</b> return the fight result
     * @return the fight result (if attacker won : 1 ,if defender won : 2 ,and if both lose or the piece B is null : 3)
     */
    public int getFightResult(){
        return this.tempFightResult;
    }

}
