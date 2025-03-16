package viewer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * here we build the main menu
 * @author csd4647 IOANNIS KASTRINAKIS
 */
public class Menu extends JFrame implements ActionListener{
    private JButton startNormal;
    private JButton startReduced;
    private JButton startNoStepBack;
    private JLabel backgroundImage;
    private JButton checkBox1,checkBox2;
    private boolean isTheNoStepBackTrue=false,isTheRedusedGameTrue=false;

    /**
     * <b>constructor</b> construct the final JFrame with the help of the functions menuFrame() and buildMenuPanel()
     * @throws IOException
     */
    public Menu() throws IOException {
        super("Stratego Main Menu");
        menuFrame();
        BackgroungImage();
        this.validate();

    }

    /**
     * initialize tha basic things for the JFrame such as the title,the size etc
     */
    private void menuFrame(){
        this.setTitle("Stratego Main Menu");
        this.setSize(1300,830);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * create the JLabel that we put the background image and the buttons
     * @throws  IOException
     */
    private void BackgroungImage() throws IOException {
        this.backgroundImage = new JLabel();
        this.backgroundImage.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/backGroundImagev2.png")).getScaledInstance(1290, 810, Image.SCALE_SMOOTH)));

        StartNormalGameButton();
        StartReducedGameButton();
        StartNoStepBackGameButton();
        BuildTheCheckBox1();
        BuildTheCheckBox2();

        this.backgroundImage.setSize(1300,830);
        this.add(this.backgroundImage);
    }

    /**
     * create the start normal game button
     * @throws IOException
     */
    private void StartNormalGameButton() throws IOException {
        this.startNormal = new JButton();
        startNormal.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/StartNormalButtonImage.png")).getScaledInstance(305, 50, Image.SCALE_SMOOTH)));
        startNormal.setSize(new Dimension(300,50));
        startNormal.setVisible(true);
        startNormal.setLocation(new Point(500,430));

        startNormal.addActionListener(this);
        this.backgroundImage.add(startNormal);
    }

    /**
     * create the start reduced game button
     * @throws IOException
     */
    private void StartReducedGameButton() throws IOException{
        this.startReduced = new JButton();
        startReduced.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/startRedusedButtonImage.png")).getScaledInstance(325, 50, Image.SCALE_SMOOTH)));
        startReduced.setSize(new Dimension(326,50));
        startReduced.setVisible(true);
        startReduced.setLocation(new Point(487,530));
        startReduced.addActionListener(this);
        this.backgroundImage.add(startReduced);
    }

    /**
     * create the start no step back button
     * @throws IOException
     */
    private void StartNoStepBackGameButton() throws IOException {
        this.startNoStepBack = new JButton();
        startNoStepBack.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/startNoStepBackButtonImage.png")).getScaledInstance(316, 50, Image.SCALE_SMOOTH)));
        startNoStepBack.setSize(new Dimension(316,50));
        startNoStepBack.setVisible(true);
        startNoStepBack.setLocation(new Point(492,630));
        startNoStepBack.addActionListener(this);
        this.backgroundImage.add(startNoStepBack);
    }

    /**
     * create the checkBox button  for the redused army gamemode
     * @throws IOException
     */
    private void BuildTheCheckBox1() throws IOException {
        ////////////////////////
        this.checkBox1 = new JButton();
        checkBox1.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/checkBox.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        checkBox1.setSize(new Dimension(50,50));
        checkBox1.setVisible(true);
        checkBox1.setLocation(new Point(813,530));
        checkBox1.addActionListener(this);
        this.backgroundImage.add(checkBox1);
    }

    /**
     * create the checkBox button  for the no step back gamemode
     * @throws IOException
     */
    private void BuildTheCheckBox2() throws IOException {
        ////////////////////////
        this.checkBox2 = new JButton();
        checkBox2.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/checkBox.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
        checkBox2.setSize(new Dimension(50,50));
        checkBox2.setVisible(true);
        checkBox2.setLocation(new Point(808,630));
        checkBox2.addActionListener(this);
        this.backgroundImage.add(checkBox2);
    }

    /**
     * when the user push a button
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == startNormal){
            try {
                this.dispose();
                NormalGame view = new NormalGame(false,false);
                if (isTheNoStepBackTrue==false){
                    if (isTheRedusedGameTrue==false){
                        view = new NormalGame(false,false);
                    }else{
                        view = new NormalGame(true,false);
                    }
                }else{
                    if (isTheRedusedGameTrue==false){
                        view = new NormalGame(false,true);
                    }else{
                        view = new NormalGame(true,true);
                    }
                }
                view.setSize(1000+400, 1000);                            //edw
                view.setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else if(source == startReduced || source == checkBox1){
            this.isTheRedusedGameTrue=true;
            System.out.println("startredused");
            try {
                checkBox1.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/checkedCheckBox.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            this.isTheNoStepBackTrue=true;
            System.out.println("startnostepback");
            try {
                checkBox2.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("./images/checkedCheckBox.png")).getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
