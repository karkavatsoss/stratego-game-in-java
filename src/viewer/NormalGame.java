package viewer;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.controller;
import model.Fight.FallenPieces;
import model.Fight.fight;
import model.Piece.ImmovablePieces.ImmovablePieces;
import model.Piece.MovablePieces.SpecialMovablePieces.Scout;

/**
 * here we create tha main panel of the jframe where the game takes place
 * also here the game logic take place and i know is wrong but i noticed that the last day that I could dispose of
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class NormalGame extends JFrame {
    private controller ActualGame ; ////
    private String[] virtualBoard ;   ////

    private String[] tempForHiddenRED;    // for the hidden RED
    private String[] tempForHiddenBLUE;    // for the hidden BLUE

    private boolean iconSelected;
    private JButton selectedButton;

    private Component[] components;// gia meta sto fight

    private JPanel panel;
    private CardListener cl;

    private int[] fallenPiecesForBlue ;
    private int[] fallenPiecesForRed ;
    private sidepanel TheSidePanel ;
    private int Round = 1;
    private boolean REDUSEDARMY,NOSTEPBACK;
    private int redAttack=0,blueAttack=0,redSuccessAttack=0,blueSuccessAttack=0;

    /**
     * It creates the first look of the Jframe when the game start and make the game start
     * <b>postcondition</b> It creates the first look of the Jframe when the game start with the initialized board and the side panel and make the game start
     * @param REDUSEDARMY tell us if the user choose the reduse army gamemode
     * @param NOSTEPBACK tell us if the user choose the no step back gamemode
     * @throws IOException
     */
    public NormalGame(boolean REDUSEDARMY,boolean NOSTEPBACK) throws IOException {
        this.REDUSEDARMY=REDUSEDARMY;
        this.NOSTEPBACK=NOSTEPBACK;
        TheSidePanel =new sidepanel(this,fallenPiecesForBlue,fallenPiecesForRed,REDUSEDARMY,NOSTEPBACK);

        this.setTitle("MovePiece Demo 1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cl = new CardListener();
        panel = new JPanel();
        panel.setLayout(new GridLayout(8,10 ));          //edw


        ActualGame = new controller(REDUSEDARMY);
        virtualBoard = ActualGame.getVirtualBoard();   ////
        tempForHiddenRED = new String[80];
        tempForHiddenBLUE = new String[80];

        int Size =30;
        if (REDUSEDARMY == true){
            Size=15;
        }
        for (int i=0; i<Size; i++){
            JButton b = new JButton();
            //
            b.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/blueHidden.png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH)));     ////
            tempForHiddenBLUE[i] = virtualBoard[i];   // for the hiddens Blue
            virtualBoard[i]="blueHidden";
            //
            b.setName(cardname);
            b.setBorder(BorderFactory.createLineBorder(Color.black));
            b.addMouseListener(cl);
            panel.add(b);

        }

        for (int i = Size; i < 80-Size; i++) {                             //edw
            JButton b = new JButton();
            b.setName(null);
            if (i==32 || i==33 || i==42 || i==43 || i==36 || i==37 || i==46 || i==47){
                b.setBackground(Color.yellow);
                b.setBorder(BorderFactory.createLineBorder(Color.yellow));
            }else {
                b.setBackground(Color.white);
                b.setBorder(BorderFactory.createLineBorder(Color.black));
            }
            b.addMouseListener(cl);
            panel.add(b);

        }


        for (int i=80-Size; i<80; i++){
            JButton b = new JButton();

            b.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/"+virtualBoard[i]+".png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            tempForHiddenRED[i] = virtualBoard[i];

            b.setName(cardname);
            b.setBorder(BorderFactory.createLineBorder(Color.black));
            b.addMouseListener(cl);
            panel.add(b);

        }


        this.add(panel);


        iconSelected = false;
        components = panel.getComponents(); // to thelw gia meta


        fallenPiecesForBlue=TheSidePanel.getFallenPiecesForBlue();
        fallenPiecesForRed=TheSidePanel.getFallenPiecesForRed();


    }

    /**
     *class for when a button pressed
     */
    private class CardListener implements MouseListener {

        /**
         *after we make the jframe and make the game start when a button pressed here we handle the logic of each command
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            JButton but = ((JButton) e.getSource());

            //////////////////////////////////////////////////////
                if (iconSelected && !but.equals(selectedButton/*typou button*/) && !(but.getBackground() == Color.yellow)/*gia ta kitrina*/ ) { // move(swap) buttons
                    ////////////ayto to kanw gia na paizei o kathenas sthn seira tou
                    int tempSelectedButtonLocation = 0;

                    components = panel.getComponents();   // XWRIS AUTO O KWDIKAS DEN DOULEUEI TO COMPONENTS GINETE INVALID
                    int j = 0;
                    for (Component c : components) {

                        if (selectedButton == c) {
                            tempSelectedButtonLocation = j;
                            break;
                        }
                        j++;

                    }
                    System.out.println(ActualGame.getBoard().getFromBoard(tempSelectedButtonLocation).getTeam() +" "+ActualGame.getPlayer1().getTurn());
                    System.out.println(ActualGame.getBoard().getFromBoard(tempSelectedButtonLocation).getTeam() +" "+ActualGame.getPlayer2().getTurn());

                    //////////auto to kanw gia na pane osa bhmata apitreponte kai oxi osa theloun(xrhsimopoiw kai thn temp metablhth ths parapanw)
                    int tempButButtonLocation = 0;

                    components = panel.getComponents();   // XWRIS AUTO O KWDIKAS DEN DOULEUEI TO COMPONENTS GINETE INVALID
                    j = 0;
                    for (Component c : components) {

                        if (but == c) {
                            tempButButtonLocation = j;
                            break;
                        }
                        j++;

                    }


                    if(!((NOSTEPBACK==true && ActualGame.getBoard().getFromBoard(tempSelectedButtonLocation).getTeam()==1 && tempButButtonLocation == tempSelectedButtonLocation-10)  || (NOSTEPBACK==true && ActualGame.getBoard().getFromBoard(tempSelectedButtonLocation).getTeam()==2 && tempButButtonLocation == tempSelectedButtonLocation+10))) { ///// gia to no step back gamemode
                        if ((tempButButtonLocation == tempSelectedButtonLocation + 10) || (tempButButtonLocation == tempSelectedButtonLocation - 10) || tempButButtonLocation == tempSelectedButtonLocation + 1 || tempButButtonLocation == tempSelectedButtonLocation - 1 /*ola ayta gia ta kanonika poionia*/ || /*gia ton scout*/ caseForScout(tempSelectedButtonLocation, tempButButtonLocation)/*h sunarthsh einai apo katw*/) { //periptwseis gia thn kinhsiologia
                            if (((ActualGame.getBoard().getFromBoard(tempSelectedButtonLocation).getTeam() == 1 && ActualGame.getPlayer1().getTurn() == true) || (ActualGame.getBoard().getFromBoard(tempSelectedButtonLocation).getTeam() == 2 && ActualGame.getPlayer2().getTurn() == true)) && !(ActualGame.getBoard().getFromBoard(tempSelectedButtonLocation) instanceof ImmovablePieces)) {

                                //
                                //

                                /*/////////////////*/
                                if (ActualGame.getBoard().getFromBoard(tempButButtonLocation) != null ) {
                                    System.out.println("Pernaeiiiiiiii");
                                    /*/////////////////*/
                                    components = panel.getComponents();
                                    /*/////////////////*/
                                    FallenPieces fallenpieces = new FallenPieces(selectedButton, but, fallenPiecesForBlue, fallenPiecesForRed, components, ActualGame.getBoard());  // to thelw gia sidepanel3
                                    /*/////////////////*/
                                    fallenPiecesForBlue = fallenpieces.getFallenPiecesForBlue();
                                    /*/////////////////*/
                                    fallenPiecesForRed = fallenpieces.getFallenPiecesForRed();
                                    /*/////////////////*/
                                }

                                components = panel.getComponents();   // XWRIS AUTO O KWDIKAS DEN DOULEUEI   META THN PRWTH FORA TO COMPONENTS GINETE INVALID
                                fight TheFight = new fight(selectedButton, but, virtualBoard, tempForHiddenBLUE, tempForHiddenRED, ActualGame.getBoard(), components);   ////
                                if ((TheFight.getAction() == 1)) {

                                    Round++;  //round of the game

                                    JLabel templabel = new JLabel("Διασώσεις : 0                 Γύρος : " + Round);
                                    templabel.setFont(new Font("Arial", Font.BOLD, 15));
                                    TheSidePanel.sidePanel3.remove(2);
                                    TheSidePanel.sidePanel3.add(templabel, 2);


                                    ActualGame.setBoard(TheFight.getBoard()); //girnaw to board allagmeno
                                    virtualBoard = TheFight.getVirtualBoard(); // girnaw to virtual board allagmeno
                                    tempForHiddenBLUE = TheFight.getTempBlueHidden();
                                    tempForHiddenRED = TheFight.getTempRedHidden();


/////////////////////////////////
/////////////////////////////////////////
                                    if (TheFight.getFightResult() == 3) { /////// etsi eftiaksa gia periptwsh 3
                                        but.setIcon(null);
                                        but.setBackground(Color.white);
                                        but.setBorder(BorderFactory.createLineBorder(Color.black));
                                        but.setName(null);
                                    } else {                             //////// edw gia periptwsh 2 1 kai 0
                                        but.setIcon(selectedButton.getIcon());
                                        but.setName(cardname);
                                    }



                                    selectedButton.setIcon(null);


                                    selectedButton.setBackground(Color.white);

                                    selectedButton.setBorder(BorderFactory.createLineBorder(Color.black));
                                    selectedButton.setName(null);
                                    selectedButton = but;  // ayto den kserw ti kanei

                                    iconSelected = false;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                                    if (ActualGame.getPlayer1().getTurn() == true) {          //red hidden
                                        //
                                        //
                                        //EDW TO XW gia na kanei update to side panel
                                        for (int i = 0; i < 9; i++) {
                                            JLabel newlabel = new JLabel();
                                            try {
                                                if (i == 0) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/slayerB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                } else if (i == 1) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/scoutB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                } else if (i == 2) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/dwarfB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                } else if (i == 3) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/elfB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                } else if (i == 4) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/yeti.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                } else if (i == 5) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/sorceressB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                } else if (i == 6) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/beastRiderB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                } else if (i == 7) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/knightB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                } else if (i == 8) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/mageB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForBlue[i]);
                                                }

                                                TheSidePanel.sidePanel5.remove(i);
                                                TheSidePanel.sidePanel5.add(newlabel, i);


                                            } catch (IOException ex) {
                                                throw new RuntimeException(ex);
                                            }
                                        }
                                        int tempCounter = 0;
                                        for (int i = 0; i < 9; i++) {
                                            tempCounter += fallenPiecesForBlue[i];
                                        }
                                        templabel = new JLabel();
                                        templabel.setText("Συνολικές Αιχμαλωτίσεις : " + tempCounter);
                                        TheSidePanel.sidePanel6.add(templabel);
                                        TheSidePanel.sidePanel6.remove(0);
                                        TheSidePanel.sidePanel6.add(templabel, 0);

                                        templabel = new JLabel("Turn : Red");
                                        templabel.setFont(new Font("Arial", Font.BOLD, 25));
                                        TheSidePanel.sidePanel3.remove(0);
                                        TheSidePanel.sidePanel3.add(templabel, 0);

                                        if (TheFight.getFightResult()!=0) {
                                            blueAttack++;
                                        }
                                        if (TheFight.getFightResult()==1) {
                                            blueSuccessAttack++;
                                        }

                                        if (redAttack!=0) {
                                            templabel = new JLabel("Ποσοστό επιτ.επίθεσης : " + ((redSuccessAttack + 0.0) / redAttack) * 100 + "%");
                                            templabel.setFont(new Font("Arial", Font.BOLD, 15));
                                            TheSidePanel.sidePanel3.remove(1);
                                            TheSidePanel.sidePanel3.add(templabel, 1);
                                        }else{
                                            templabel = new JLabel("Ποσοστό επιτ.επίθεσης : 0.0%");
                                            templabel.setFont(new Font("Arial", Font.BOLD, 15));
                                            TheSidePanel.sidePanel3.remove(1);
                                            TheSidePanel.sidePanel3.add(templabel, 1);
                                        }
                                        //
                                        //
                                        for (int i = 0; i < 80; i++) {       // kanw ta red visible
                                            if (virtualBoard[i] == "redHidden") {
                                                virtualBoard[i] = tempForHiddenRED[i];

                                                JButton newComponent;
                                                try {
                                                    newComponent = new JButton((new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/" + virtualBoard[i] + ".png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
                                                } catch (IOException ex) {
                                                    throw new RuntimeException(ex);
                                                }

                                                newComponent.setName(cardname);
                                                newComponent.setBorder(BorderFactory.createLineBorder(Color.black));
                                                newComponent.addMouseListener(cl);

                                                panel.remove(i);
                                                panel.add(newComponent, i);

                                                tempForHiddenRED[i] = "redHidden";
                                            } else {                     //kai ta blue Hidden
                                                if (virtualBoard[i] != null) {
                                                    tempForHiddenBLUE[i] = virtualBoard[i];

                                                    JButton newComponent;
                                                    try {
                                                        newComponent = new JButton((new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/blueHidden.png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
                                                    } catch (IOException ex) {
                                                        throw new RuntimeException(ex);
                                                    }

                                                    newComponent.setName(cardname);
                                                    newComponent.setBorder(BorderFactory.createLineBorder(Color.black));
                                                    newComponent.addMouseListener(cl);

                                                    panel.remove(i);
                                                    panel.add(newComponent, i);

                                                    virtualBoard[i] = "blueHidden";
                                                }
                                            }
                                        }

                                        ActualGame.getPlayer1().setTurn(false);  // allazw tis shres
                                        ActualGame.getPlayer2().setTurn(true); // gia to poios paizei
                                    } else if (ActualGame.getPlayer2().getTurn() == true) {
                                        //
                                        //
                                        //EDW TO XW gia na kanei update to side panel
                                        for (int i = 0; i < 9; i++) {
                                            JLabel newlabel = new JLabel();
                                            try {
                                                if (i == 0) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/slayerR.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                } else if (i == 1) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/scoutB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                } else if (i == 2) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/dwarfR.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                } else if (i == 3) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/elfR.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                } else if (i == 4) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/lavaBeast.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                } else if (i == 5) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/sorceressR.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                } else if (i == 6) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/beastRiderR.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                } else if (i == 7) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/knightR.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                } else if (i == 8) {
                                                    newlabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/mageR.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
                                                    newlabel.setText("" + fallenPiecesForRed[i]);
                                                }

                                                TheSidePanel.sidePanel5.remove(i);
                                                TheSidePanel.sidePanel5.add(newlabel, i);


                                            } catch (IOException ex) {
                                                throw new RuntimeException(ex);
                                            }

                                        }
                                        int tempCounter = 0;
                                        for (int i = 0; i < 9; i++) {
                                            tempCounter += fallenPiecesForRed[i];
                                        }
                                        templabel = new JLabel();
                                        templabel.setText("Συνολικές Αιχμαλωτίσεις : " + tempCounter);
                                        TheSidePanel.sidePanel6.add(templabel);
                                        TheSidePanel.sidePanel6.remove(0);
                                        TheSidePanel.sidePanel6.add(templabel, 0);

                                        templabel = new JLabel("Turn : Blue");
                                        templabel.setFont(new Font("Arial", Font.BOLD, 25));
                                        TheSidePanel.sidePanel3.remove(0);
                                        TheSidePanel.sidePanel3.add(templabel, 0);

                                        if (TheFight.getFightResult()!=0) {
                                            redAttack++;
                                        }
                                        if (TheFight.getFightResult()==1) {
                                            redSuccessAttack++;
                                        }
                                        if (blueAttack!=0) {
                                            templabel = new JLabel("Ποσοστό επιτ.επίθεσης : " + ((blueSuccessAttack + 0.0) / blueAttack) * 100 + "%");
                                            templabel.setFont(new Font("Arial", Font.BOLD, 15));
                                            TheSidePanel.sidePanel3.remove(1);
                                            TheSidePanel.sidePanel3.add(templabel, 1);
                                        }else{
                                            templabel = new JLabel("Ποσοστό επιτ.επίθεσης : 0.0%");
                                            templabel.setFont(new Font("Arial", Font.BOLD, 15));
                                            TheSidePanel.sidePanel3.remove(1);
                                            TheSidePanel.sidePanel3.add(templabel, 1);
                                        }
                                        //
                                        //
                                        //auto idio me to panw sxedon
                                        for (int i = 0; i < 80; i++) {       // kanw ta ble visible
                                            if (virtualBoard[i] == "blueHidden") {
                                                virtualBoard[i] = tempForHiddenBLUE[i];

                                                JButton newComponent;
                                                try {
                                                    newComponent = new JButton((new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/" + virtualBoard[i] + ".png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
                                                } catch (IOException ex) {
                                                    throw new RuntimeException(ex);
                                                }

                                                newComponent.setName(cardname);
                                                newComponent.setBorder(BorderFactory.createLineBorder(Color.black));
                                                newComponent.addMouseListener(cl);

                                                panel.remove(i);
                                                panel.add(newComponent, i);

                                                tempForHiddenBLUE[i] = "blueHidden";
                                            } else {                     //kai ta kokkina Hidden
                                                if (virtualBoard[i] != null) {
                                                    tempForHiddenRED[i] = virtualBoard[i];

                                                    JButton newComponent;
                                                    try {
                                                        newComponent = new JButton((new ImageIcon(ImageIO.read(getClass().getResource("./images/RedPieces/redHidden.png")).getScaledInstance(100, 100, Image.SCALE_SMOOTH))));
                                                    } catch (IOException ex) {
                                                        throw new RuntimeException(ex);
                                                    }
                                                    newComponent.setName(cardname);
                                                    newComponent.setBorder(BorderFactory.createLineBorder(Color.black));
                                                    newComponent.addMouseListener(cl);

                                                    panel.remove(i);
                                                    panel.add(newComponent, i);

                                                    virtualBoard[i] = "redHidden";
                                                }
                                            }
                                        }

                                        ActualGame.getPlayer1().setTurn(true);  // allazw tis shres
                                        ActualGame.getPlayer2().setTurn(false); // gia to poios paizei
                                    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                } else System.out.println("gttttttttttt");
                            } else {// an dialsa lathos omada
                                iconSelected = false;
                                selectedButton.setBorder(BorderFactory.createLineBorder(Color.black));
                                //selectedButton.setName(null);
                            }
                        } else {  //h nea allagh
                            iconSelected = false;
                            selectedButton.setBorder(BorderFactory.createLineBorder(Color.black));
                            //selectedButton.setName(null);
                        }
                    } else {  //h nea allagh
                        iconSelected = false;
                        selectedButton.setBorder(BorderFactory.createLineBorder(Color.black));
                        //selectedButton.setName(null);
                    }
                } else if (!iconSelected && but.getName() != null) {
                    iconSelected = true;
                    selectedButton = but;
                    but.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
                } else { // if already selected or not selected at all or go to yellows
                    if (but.getBackground() == Color.yellow) {
                        System.out.println("den pas ekei morty");
                    } else if (iconSelected) {
                        System.out.println("Already Selected");
                    } else {
                        System.out.println("Not selected");
                    }
                }

        }

            //--------------------------------------------------------------------------------------------------------//

            //--------------------------------------------------------------------------------------------------------//

            @Override
            public void mousePressed (MouseEvent e){
            }

            @Override
            public void mouseReleased (MouseEvent e){
            }

            @Override
            public void mouseEntered (MouseEvent e){
            }

            @Override
            public void mouseExited (MouseEvent e){
            }
    }

    public static String cardname = "My Card";

    /**
     * <b>accessor</b> take the movement case for the scout
     * <b>Postcondition</b> take the movement case of the scout (he can move sidewards,backwards,frontwards and as many blocks he want as long as they are empty of pieces
     * @param tempSelectedButtonLocation the location of the attacker
     * @param tempButButtonLocation the location of the destination square
     * @return true if he can move in the destination square or false if he can't
     */
    public boolean caseForScout(int tempSelectedButtonLocation,int tempButButtonLocation){
        if (ActualGame.getBoard().getFromBoard(tempSelectedButtonLocation) instanceof  Scout){
            if ((tempSelectedButtonLocation-tempButButtonLocation)%10==0){ // an dhladh attack pros ta panw h prws ta katw
                if (tempSelectedButtonLocation<tempButButtonLocation){  // an o attacker einai poio panw sto tamplo apo oti einai o defender
                    int adder1=0,adder2=0;
                    for(int i=tempSelectedButtonLocation+10; i<tempButButtonLocation; i+=10){  // tsekarw ola ta endiamesa kelia pou tha perasei o scout
                        if (ActualGame.getBoard().getFromBoard(i)==null){
                            adder1++;
                        }
                        adder2++;
                    }
                    if(adder1!=0 && adder1==adder2){
                        return true;
                    }else return false;
                }else{// an o defender einai poio katw sto tamplo apo oti einai o attacker
                    int adder1=0,adder2=0;
                    for(int i=tempSelectedButtonLocation-10; i>tempButButtonLocation; i-=10){  // tsekarw ola ta endiamesa kelia pou tha perasei o scout
                        if (ActualGame.getBoard().getFromBoard(i)==null){
                            adder1++;
                        }
                        adder2++;
                    }
                    if(adder1!=0 && adder1==adder2){
                        return true;
                    }else return false;
                }
            }else if((Math.abs(tempButButtonLocation-tempSelectedButtonLocation)/10)==0){ // an dhladh attack pros ta aristera h ta deksia
                if (tempSelectedButtonLocation<tempButButtonLocation){ //an o attacker einai aristera kai o defender deksia
                    int adder1=0,adder2=0;
                    for(int i=tempSelectedButtonLocation+1; i<tempButButtonLocation; i++){  // tsekarw ola ta endiamesa kelia pou tha perasei o scout
                        if (ActualGame.getBoard().getFromBoard(i)==null){
                            adder1++;
                        }
                        adder2++;
                    }
                    if(adder1!=0 && adder1==adder2){
                        return true;
                    }else return false;
                }else {//an o attacker einai deksia kai o defender aristera
                    int adder1=0,adder2=0;
                    for(int i=tempSelectedButtonLocation-1; i>tempButButtonLocation; i--){  // tsekarw ola ta endiamesa kelia pou tha perasei o scout
                        if (ActualGame.getBoard().getFromBoard(i)==null){
                            adder1++;
                        }
                        adder2++;
                    }
                    if(adder1!=0 && adder1==adder2){
                        return true;
                    }else return false;
                }
            }
        }else return false;
        return false; // den xreiazete alla allios den doueleuei
    }

}