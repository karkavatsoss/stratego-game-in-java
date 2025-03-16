package model.collections;

import model.Piece.ImmovablePieces.*;
import model.Piece.MovablePieces.*;
import model.Piece.MovablePieces.SpecialMovablePieces.*;
import model.Piece.Piece;

import java.util.ArrayList;

/**
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class PrepareTeams {
    private ArrayList<Piece> IcePieces;
    private ArrayList<Piece> FirePieces;

    private ArrayList<String> IceImage;
    private ArrayList<String> FireImage;

    /**
     * <b>Constructor</b> initialize the four Arraylists(2 with the name of the images and 2 with the pieces)
     * each one with the proper pieces
     * <b>Postcondition</b> initializes the four Arraylists according the value of the variable REDUSEDARMY (30 pieces or 15 for each team)
     * @param REDUSEDARMY tell us if the user choose 30 pieces for each team of 15(redused army==true)
     */
    public PrepareTeams(boolean REDUSEDARMY){
        IcePieces=new ArrayList<Piece>();
        FirePieces=new ArrayList<Piece>();

        IceImage=new ArrayList<String>();
        FireImage=new ArrayList<String>();

        if (REDUSEDARMY==false) {         // gia full strato
            IcePieces.add(new Dragon(1));      //
            IceImage.add("dragonB");
            IcePieces.add(new Mage(1));        //
            IceImage.add("mageB");
            IcePieces.add(new Knight(1));      //
            IceImage.add("knightB");
            IcePieces.add(new Knight(1));
            IceImage.add("knightB");
            IcePieces.add(new BeastRider(1));  //
            IceImage.add("beastRiderB");
            IcePieces.add(new BeastRider(1));
            IceImage.add("beastRiderB");
            IcePieces.add(new BeastRider(1));
            IceImage.add("beastRiderB");
            IcePieces.add(new Sorceress(1));   //
            IceImage.add("sorceressB");
            IcePieces.add(new Sorceress(1));
            IceImage.add("sorceressB");
            IcePieces.add(new Yeti(1));        //
            IceImage.add("yeti");
            IcePieces.add(new Yeti(1));
            IceImage.add("yeti");
            IcePieces.add(new Elf(1));         //
            IceImage.add("elfB");
            IcePieces.add(new Elf(1));
            IceImage.add("elfB");
            IcePieces.add(new Dwarf(1));       //
            IceImage.add("dwarfB");
            IcePieces.add(new Dwarf(1));
            IceImage.add("dwarfB");
            IcePieces.add(new Dwarf(1));
            IceImage.add("dwarfB");
            IcePieces.add(new Dwarf(1));
            IceImage.add("dwarfB");
            IcePieces.add(new Dwarf(1));
            IceImage.add("dwarfB");
            IcePieces.add(new Scout(1));       //
            IceImage.add("scoutB");
            IcePieces.add(new Scout(1));
            IceImage.add("scoutB");
            IcePieces.add(new Scout(1));
            IceImage.add("scoutB");
            IcePieces.add(new Scout(1));
            IceImage.add("scoutB");
            IcePieces.add(new Slayer(1));      //
            IceImage.add("slayerB");
            IcePieces.add(new Bomb(1));        //
            IceImage.add("trapB");
            IcePieces.add(new Bomb(1));
            IceImage.add("trapB");
            IcePieces.add(new Bomb(1));
            IceImage.add("trapB");
            IcePieces.add(new Bomb(1));
            IceImage.add("trapB");
            IcePieces.add(new Bomb(1));
            IceImage.add("trapB");
            IcePieces.add(new Bomb(1));
            IceImage.add("trapB");
            IcePieces.add(new Flag(1));        //
            IceImage.add("flagB");

            FirePieces.add(new Dragon(2));      //
            FireImage.add("dragonR");
            FirePieces.add(new Mage(2));        //
            FireImage.add("mageR");
            FirePieces.add(new Knight(2));      //
            FireImage.add("knightR");
            FirePieces.add(new Knight(2));
            FireImage.add("knightR");
            FirePieces.add(new BeastRider(2));  //
            FireImage.add("beastRiderR");
            FirePieces.add(new BeastRider(2));
            FireImage.add("beastRiderR");
            FirePieces.add(new BeastRider(2));
            FireImage.add("beastRiderR");
            FirePieces.add(new Sorceress(2));   //
            FireImage.add("sorceressR");
            FirePieces.add(new Sorceress(2));
            FireImage.add("sorceressR");
            FirePieces.add(new LavaBeast(2));   //
            FireImage.add("lavaBeast");
            FirePieces.add(new LavaBeast( 2));
            FireImage.add("lavaBeast");
            FirePieces.add(new Elf(2));         //
            FireImage.add("elfR");
            FirePieces.add(new Elf(2));
            FireImage.add("elfR");
            FirePieces.add(new Dwarf(2));       //
            FireImage.add("dwarfR");
            FirePieces.add(new Dwarf(2));
            FireImage.add("dwarfR");
            FirePieces.add(new Dwarf(2));
            FireImage.add("dwarfR");
            FirePieces.add(new Dwarf(2));
            FireImage.add("dwarfR");
            FirePieces.add(new Dwarf(2));
            FireImage.add("dwarfR");
            FirePieces.add(new Scout(2));       //
            FireImage.add("scoutB");
            FirePieces.add(new Scout(2));
            FireImage.add("scoutB");
            FirePieces.add(new Scout(2));
            FireImage.add("scoutB");
            FirePieces.add(new Scout(2));
            FireImage.add("scoutB");
            FirePieces.add(new Slayer(2));      //
            FireImage.add("slayerR");
            FirePieces.add(new Bomb(2));        //
            FireImage.add("trapR");
            FirePieces.add(new Bomb(2));
            FireImage.add("trapR");
            FirePieces.add(new Bomb(2));
            FireImage.add("trapR");
            FirePieces.add(new Bomb(2));
            FireImage.add("trapR");
            FirePieces.add(new Bomb(2));
            FireImage.add("trapR");
            FirePieces.add(new Bomb(2));
            FireImage.add("trapR");
            FirePieces.add(new Flag(2));       //
            FireImage.add("flagR");
        }else{                                                   // gia miso strato
            IcePieces.add(new Dragon( 1));      //
            IceImage.add("dragonB");
            IcePieces.add(new Mage( 1));        //
            IceImage.add("mageB");
            IcePieces.add(new Knight( 1));      //
            IceImage.add("knightB");
            IcePieces.add(new BeastRider( 1));  //
            IceImage.add("beastRiderB");
            IcePieces.add(new Sorceress( 1));   //
            IceImage.add("sorceressB");
            IcePieces.add(new Yeti( 1));        //
            IceImage.add("yeti");
            IcePieces.add(new Elf( 1));         //
            IceImage.add("elfB");
            IcePieces.add(new Dwarf( 1));       //
            IceImage.add("dwarfB");
            IcePieces.add(new Dwarf( 1));
            IceImage.add("dwarfB");
            IcePieces.add(new Scout( 1));       //
            IceImage.add("scoutB");
            IcePieces.add(new Scout( 1));
            IceImage.add("scoutB");
            IcePieces.add(new Slayer( 1));      //
            IceImage.add("slayerB");
            IcePieces.add(new Bomb( 1));        //
            IceImage.add("trapB");
            IcePieces.add(new Bomb(1));
            IceImage.add("trapB");
            IcePieces.add(new Flag(1));        //
            IceImage.add("flagB");


            FirePieces.add(new Dragon( 2));      //
            FireImage.add("dragonR");
            FirePieces.add(new Mage( 2));        //
            FireImage.add("mageR");
            FirePieces.add(new Knight(2));      //
            FireImage.add("knightR");
            FirePieces.add(new BeastRider( 2));  //
            FireImage.add("beastRiderR");
            FirePieces.add(new Sorceress( 2));   //
            FireImage.add("sorceressR");
            FirePieces.add(new LavaBeast( 2));   //
            FireImage.add("lavaBeast");
            FirePieces.add(new Elf( 2));         //
            FireImage.add("elfR");
            FirePieces.add(new Dwarf( 2));       //
            FireImage.add("dwarfR");
            FirePieces.add(new Dwarf(2));
            FireImage.add("dwarfR");
            FirePieces.add(new Scout(2));       //
            FireImage.add("scoutB");
            FirePieces.add(new Scout( 2));
            FireImage.add("scoutB");
            FirePieces.add(new Slayer( 2));      //
            FireImage.add("slayerR");
            FirePieces.add(new Bomb( 2));
            FireImage.add("trapR");
            FirePieces.add(new Bomb( 2));
            FireImage.add("trapR");
            FirePieces.add(new Flag( 2));       //
            FireImage.add("flagR");
        }
    }

    /**
     * <b>Accessor</b> return the arraylist with the pieces of blue
     * @return the arraylist (team) with the pieces of Everwinter(blue) team
     */
    public ArrayList<Piece> getIcePieces(){
        return IcePieces;
    }

    /**
     * <b>Accessor</b> return the arraylist with the images of blue pieces
     * @return the arraylist (team) with the images of Everwinter(blue) team
     */
    public ArrayList<String> getIceImage(){
        return IceImage;
    }

    /**
     * <b>Accessor</b> return the arraylist with the pieces of red
     * @return the arraylist (team) with the pieces of Volcandria(red) team
     */
    public ArrayList<Piece> getFirePieces() {
        return FirePieces;
    }

    /**
     * <b>Accessor</b> return the arraylist with the images of red pieces
     * @return the arraylist (team) with the images of volcandria(red) team
     */
    public ArrayList<String> getFireImage(){ return  FireImage;}
}
