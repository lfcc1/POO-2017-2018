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
import java.util.List;

public class GUI_Login extends JFrame {
    /** Variáveis de Instância. */
    private JMenuBar menuBar;
    private JPasswordField PasswordBox;
    private JTextField TextBox;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private int nif;
    private String password ="";
    private GestaoFichas gestorfichas;
    private GestaoFaturas gestorfaturas;
    private String save = "";
    private JButton buttonvoltar;

    /** Construtor parametrizado da classe GUI_Login.
     *  @param gestorfichas gestorfichas passado da classe interface.
     *  @param gestorfaturas gestorfaturas passado da classe interface.
    */     
    public GUI_Login(GestaoFichas gestorfichas,GestaoFaturas gestorfaturas){

        this.setTitle("GUI_project");
        this.setSize(500,400);
        this.gestorfichas=gestorfichas;
        this.gestorfaturas=gestorfaturas;
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));


        PasswordBox = new JPasswordField(); 
        PasswordBox.setBounds(196,176,110,30);
        PasswordBox.setBackground(new Color(214,217,223));
        PasswordBox.setForeground(new Color(0,0,0));
        PasswordBox.setEnabled(true);
        PasswordBox.setFont(new Font("sansserif",0,12));
        PasswordBox.setVisible(true);
        //Set action for key events
        //Call defined method
        PasswordBox.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                OnPasswordKeyTyped(evt);
            }
        });


        TextBox = new JTextField();
        TextBox.setBounds(196,128,110,30);
        TextBox.setBackground(new Color(255,255,255));
        TextBox.setForeground(new Color(0,0,0));
        TextBox.setEnabled(true);
        TextBox.setFont(new Font("sansserif",0,12));
        TextBox.setText("");
        TextBox.setVisible(true);
        //Set action for key events
        //Call defined method
        TextBox.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onNifKeyTyped(evt);
            }
        });


        button1 = new JButton();
        button1.setBounds(120,229,90,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Login");
        button1.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                onLoginButtonClicked(evt);
            }
        });
        
        
        buttonvoltar = new JButton();
        buttonvoltar.setBounds(260,229,90,35);
        buttonvoltar.setBackground(new Color(214,217,223));
        buttonvoltar.setForeground(new Color(0,0,0));
        buttonvoltar.setEnabled(true);
        buttonvoltar.setFont(new Font("sansserif",0,12));
        buttonvoltar.setText("Voltar");
        buttonvoltar.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        buttonvoltar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                onVoltarButtonClicked(evt);
            }
        });
        
        


        label1 = new JLabel();
        label1.setBounds(153,127,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("NIF:");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(115,173,90,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("sansserif",0,12));
        label2.setText("Password:");
        label2.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(buttonvoltar);
        contentPane.add(PasswordBox);
        contentPane.add(TextBox);
        contentPane.add(button1);
        contentPane.add(label1);
        contentPane.add(label2);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    

    //Method keyTyped for PasswordBox
    private void OnPasswordKeyTyped (KeyEvent evt) {
            password = PasswordBox.getText();
    }
    
    //Method keyTyped for TextBox
        private void onNifKeyTyped (KeyEvent evt) {
            save = TextBox.getText();
    }
    
    /** Metodo que volta para o hall de entrada
     * param evt Clique do rato.
     */
    public void onVoltarButtonClicked (MouseEvent evt){
        HallentradaGUI hall = new HallentradaGUI(gestorfichas,gestorfaturas);
        dispose();
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    /** Metodo que testa se as credenciais introduzaidas estao corretas e abre a aba da ficha correspondente.
     * @param evt Clique do rato.
     */
    private void onLoginButtonClicked (MouseEvent evt) {
            if(save.length() > 9){ 
                infoBox("Nif pode apenas conter 9 numeros.", "Nif Errado!");
                return;
            }
            
            int nif = Integer.parseInt(save);
                FichaCliente fichaEncontrada = gestorfichas.autenticacao(password,nif);

                if(fichaEncontrada != null){
                    infoBox("Login com sucesso!", "Login com sucesso");
                    dispose();
                    if(fichaEncontrada.getfichaType()==3)
                         new GUI_Administrador(gestorfichas, gestorfaturas,fichaEncontrada);
                    else{
                        GUI_FichaCliente fichagui = new GUI_FichaCliente(fichaEncontrada,gestorfichas,gestorfaturas);
                    }
                }
                else{
                    infoBox("Nif/Password inválido!", "Alerta");
                }
            
    }

    public void setgestorfichas(GestaoFichas a){
        gestorfichas = a;
    }
    
    public void setgestorfaturas(GestaoFaturas a){
        gestorfaturas = a;
    }
    
    /** Metodo que cria um toolBar
     */
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
                new GUI_Login(null,null);
            }
        });
    }

}