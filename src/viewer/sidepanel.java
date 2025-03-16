package viewer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * here we create the side panel for the game
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class sidepanel {
    JPanel sidePanel1;
    JPanel sidePanel5;
    JPanel sidePanel6;
    JPanel sidePanel3;
    private int[] fallenPiecesForBlue, fallenPiecesForRed;

    /**
     * <b>constructor</b> construct the side panel
     * <b>postcondition</b>  create a side panel that contain its own 7 panel that each one refers to different things
     * @param frame tha main frame that sidepanel will be placed
     * @param fallenPiecesForBlue contain the names of the images of the pieces that the blue had lost
     * @param fallenPiecesForRed contain the names of the images of the pieces that the red had lost
     * @param REDUSEDARMY shows if the check box 1 will be checked
     * @param NOSTEPBACK shows if the check box 2 wil be checked
     * @throws IOException
     */
    public sidepanel(JFrame frame,int[] fallenPiecesForBlue,int[] fallenPiecesForRed,boolean REDUSEDARMY,boolean NOSTEPBACK) throws IOException {
        this.fallenPiecesForBlue=fallenPiecesForBlue;
        this.fallenPiecesForRed=fallenPiecesForRed;
        //--------------------------//
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(400, 75));

        sidePanel.setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("Ενεργοί Κανόνες");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        sidePanel.add(label);



        //--------------------------//
        sidePanel1 = new JPanel();
        sidePanel1.setLayout(new GridLayout(2,1 )); //new
        sidePanel1.setPreferredSize(new Dimension(400, 200));

        sidePanel1.setBackground(Color.GRAY);

        JCheckBox checkbox1 = new JCheckBox("Μειωμένος στρατός"); //new
        checkbox1.setFont(checkbox1.getFont().deriveFont(20f));
        checkbox1.setPreferredSize(new Dimension(400,100));
        checkbox1.setBackground(Color.GRAY);
        if (REDUSEDARMY==true){
            checkbox1.setSelected(true);
            checkbox1.setEnabled(false);
        }

        JCheckBox checkbox2 = new JCheckBox("Καμια Υποχώριση");
        checkbox2.setPreferredSize(new Dimension(400,100));
        checkbox2.setFont(checkbox2.getFont().deriveFont(20f));
        checkbox2.setBackground(Color.GRAY);
        if (NOSTEPBACK==true){
            checkbox2.setSelected(true);
            checkbox2.setEnabled(false);
        }

        sidePanel1.add(checkbox1);                            //new
        sidePanel1.add(checkbox2);

        //--------------------------//
        JPanel sidePanel2 = new JPanel();
        sidePanel2.setPreferredSize(new Dimension(400, 70));

        sidePanel2.setBackground(Color.LIGHT_GRAY);

        JLabel label2 = new JLabel("Στατιστικά");
        label2.setFont(new Font("Arial", Font.BOLD, 30));
        sidePanel2.add(label2);

        //--------------------------//
        sidePanel3 = new JPanel();
        sidePanel3.setLayout(new GridLayout(3,1 )); //new
        sidePanel3.setPreferredSize(new Dimension(400, 200));

        sidePanel3.setBackground(Color.GRAY);

        JLabel label3 = new JLabel("Turn : Red");
        label3.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel label31 = new JLabel("Ποσοστό επιτ.επίθεσης : 0.0%");
        label31.setFont(new Font("Arial", Font.BOLD, 15));

        JLabel label32 = new JLabel("Διασώσεις : 0                 Γύρος : 1");
        label32.setFont(new Font("Arial", Font.BOLD, 15));

        sidePanel3.add(label3);
        sidePanel3.add(label31);
        sidePanel3.add(label32);

        //--------------------------//
        JPanel sidePanel4 = new JPanel();
        sidePanel4.setPreferredSize(new Dimension(400, 75));

        sidePanel4.setBackground(Color.LIGHT_GRAY);

        JLabel label4 = new JLabel("Αιχμαλωτίσεις");
        label4.setFont(new Font("Arial", Font.BOLD, 30));
        sidePanel4.add(label4);

        //--------------------------//


        this.fallenPiecesForBlue= new int[9];
        this.fallenPiecesForRed= new int[9];
        Arrays.fill(this.fallenPiecesForBlue,0);
        Arrays.fill(this.fallenPiecesForRed,0);

        sidePanel5 = new JPanel();
        sidePanel5.setPreferredSize(new Dimension(400, 350));
        sidePanel5.setBackground(Color.GRAY);
        sidePanel5.setLayout(new GridLayout(3,3 ));
        sidePanel5.setVisible(true);
        for (int i=0; i<9; i++){
        JLabel templabel = new JLabel();
        if (i==0){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/slayerB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }else if(i==1){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/scoutB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }else if(i==2){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/dwarfB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }else if(i==3){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/elfB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }else if(i==4){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/yeti.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }else if(i==5){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/sorceressB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }else if(i==6){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/beastRiderB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }else if(i==7){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/knightB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }else if(i==8){
            templabel.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/bluePieces/mageB.png")).getScaledInstance(90, 90, Image.SCALE_SMOOTH)));
        }
        templabel.setText("0");
        sidePanel5.add(templabel);
        }
        //--------------------------//
        sidePanel6 = new JPanel();
        sidePanel6.setPreferredSize(new Dimension(400, 50));
        sidePanel6.setBackground(Color.GRAY);

        JLabel templabel = new JLabel();
        templabel.setText("Συνολικές Αιχμαλωτίσεις : 0");
        sidePanel6.add(templabel);
        //--------------------------//
        //--------------------------//
        //--------------------------//

        JPanel sidePanelContainer = new JPanel();
        sidePanelContainer.setLayout(new BoxLayout(sidePanelContainer, BoxLayout.Y_AXIS));
        sidePanelContainer.add(sidePanel);
        sidePanelContainer.add(sidePanel1);
        sidePanelContainer.add(sidePanel2);
        sidePanelContainer.add(sidePanel3);
        sidePanelContainer.add(sidePanel4);
        sidePanelContainer.add(sidePanel5);
        sidePanelContainer.add(sidePanel6);

        frame.add(sidePanelContainer, BorderLayout.EAST);
        //--------------------------//
        //--------------------------//
        //--------------------------//
    }

    /**
     * <b>accessor</b> return the fallen pieces for blue
     * @return the fallen pieces for blue
     */
    public int[] getFallenPiecesForBlue() {
        return this.fallenPiecesForBlue;
    }

    /**
     * <b>accessor</b> return the fallen pieces for red
     * @return the fallen pieces for red
     */
    public int[] getFallenPiecesForRed() {
        return fallenPiecesForRed;
    }
}
