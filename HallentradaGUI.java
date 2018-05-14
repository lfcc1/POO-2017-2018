/**
 *Text genereted by Simple GUI Extension for BlueJ
 */
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;

public class HallentradaGUI extends JFrame {
    private JMenuBar menuBar;
    private JButton Forgotten;
    private JButton Login;
    private JButton Register;
    private GestaoFichas gestorfichas;
    
    //Constructor 
    public HallentradaGUI(){

        this.setTitle("GUI_project");
        this.setSize(500,400);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));

        Forgotten = new JButton();
        Forgotten.setBounds(130,295,236,17);
        Forgotten.setBackground(new Color(214,217,223));
        Forgotten.setForeground(new Color(0,0,0));
        Forgotten.setEnabled(true);
        Forgotten.setFont(new Font("sansserif",0,12));
        Forgotten.setText("Have you forgotten your password?");
        Forgotten.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        Forgotten.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    forgottenPass(evt);
                }
            });

        Login = new JButton();
        Login.setBounds(197,160,90,35);
        Login.setBackground(new Color(214,217,223));
        Login.setForeground(new Color(0,0,0));
        Login.setEnabled(true);
        Login.setFont(new Font("sansserif",0,12));
        Login.setText("SIGN IN");
        Login.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        Login.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    gotologin(evt);
                }
            });

        Register = new JButton();
        Register.setBounds(197,227,90,35);
        Register.setBackground(new Color(214,217,223));
        Register.setForeground(new Color(0,0,0));
        Register.setEnabled(true);
        Register.setFont(new Font("sansserif",0,12));
        Register.setText("SIGN UP");
        Register.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        Register.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    gotoregister(evt);
                }
            });
	
        //adding components to contentPane panel
        contentPane.add(Forgotten);
        contentPane.add(Login);
        contentPane.add(Register);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    
    public void setgestorfichas(GestaoFichas a){
        gestorfichas = a;
    }

    //Method mouseClicked for Forgotten
    private void forgottenPass (MouseEvent evt) {

    }

    //Method mouseClicked for Login
    private void gotologin (MouseEvent evt) {
        GUI_Login login = new GUI_Login();
        login.gestorfichas = gestorfichas;
        login.setVisible(true);
        dispose();
    }

    //Method mouseClicked for Register
    private void gotoregister (MouseEvent evt) {
        GUI_Register register = new GUI_Register();
        register.setVisible(true);
        dispose();
    }

    //method for generate menu
    public void generateMenu(){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }

    public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new HallentradaGUI();
                }
            });
    }

}