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
import java.util.ArrayList;
import java.util.Arrays;

public class GUI_Administrador extends JFrame {

    private JMenuBar menuBar;
    private JButton dezQueMaisGastam; //10 contribuintes que mais gastam em todo o sistema
    private JButton xempresas; // x empresas com mais faturas  em todo o sistema
    private GestaoFichas gestorfichas;
    private GestaoFaturas gestorfaturas;
    private List<FichaCliente> lista;
    private List<EntidadeEmpresas> lista2;
    private JTextField nempresas;
    private DefaultListModel listModel = new DefaultListModel();
    private DefaultListModel listModel2 = new DefaultListModel();
    private JList list1;
    private JList list2;
    private JScrollPane scroll;
    private JScrollPane scroll2;
    private String numerodeempresas;
    private int flag = 0;
    private int flag2= 0;

    //Constructor 
    public GUI_Administrador(GestaoFichas gestorfichas,GestaoFaturas gestorfaturas){
        numerodeempresas="";
        this.gestorfaturas = gestorfaturas;
        this.gestorfichas = gestorfichas;
        this.setTitle("GUI_project");
        this.setSize(500,400);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));

        dezQueMaisGastam = new JButton();
        dezQueMaisGastam.setBounds(197,160,250,35);
        dezQueMaisGastam.setBackground(new Color(214,217,223));
        dezQueMaisGastam.setForeground(new Color(0,0,0));
        dezQueMaisGastam.setEnabled(true);
        dezQueMaisGastam.setFont(new Font("sansserif",0,12));
        dezQueMaisGastam.setText("10 contribuintes que mais gastam");
        dezQueMaisGastam.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        dezQueMaisGastam.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                gotodezQueMaisGastam(evt);
            }
        });
        
        list1 = new JList(listModel);
        list1.setBackground(new Color(255,255,255));
        //list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list1.setForeground(new Color(0,0,0));
        list1.setEnabled(true);
        list1.setFont(new Font("sansserif",0,12));
        
        scroll = new JScrollPane();
        scroll.setViewportView(list1);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(197,210,264,196);
        scroll.setVisible(true);
        
        list2 = new JList(listModel2);
        list2.setBackground(new Color(255,255,255));
        //list1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list2.setForeground(new Color(0,0,0));
        list2.setEnabled(true);
        list2.setFont(new Font("sansserif",0,12));
        
        scroll2 = new JScrollPane();
        scroll2.setViewportView(list2);
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setBounds(497,210,264,196);
        scroll2.setVisible(true);
        
        xempresas = new JButton();
        xempresas.setBounds(497,160,250,35);
        xempresas.setBackground(new Color(214,217,223));
        xempresas.setForeground(new Color(0,0,0));
        xempresas.setEnabled(true);
        xempresas.setFont(new Font("sansserif",0,12));
        xempresas.setText("X empresas com mais facturas");
        xempresas.setVisible(true);
        
        xempresas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                gotoxempresas(evt);
            }
        });
        
        nempresas = new JTextField();
        nempresas.setBounds(497,120,90,35);
        nempresas.setBackground(new Color(255,255,255));
        nempresas.setForeground(new Color(0,0,0));
        nempresas.setEnabled(true);
        nempresas.setFont(new Font("sansserif",0,12));
        nempresas.setText("");
        nempresas.setVisible(true);
        
        nempresas.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onKeyReleasednempresas(evt);
            }
        });
            
        //adding components to contentPane panel
        contentPane.add(dezQueMaisGastam);
        contentPane.add(scroll);
        contentPane.add(scroll2);
        contentPane.add(xempresas);
        contentPane.add(nempresas);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void gotodezQueMaisGastam (MouseEvent evt) {
        if (flag == 0){ //flag só para nao poder clicar no butao mais do que uma vez
            lista = gestorfichas.gettenUsersMostRich();
            List<FichaCliente> dezmaisgastam = new ArrayList<>();
            dezmaisgastam = lista;
            for(int i = 0; i < dezmaisgastam.size(); i++) {
                //System.out.println("Nif: "+dezmaisgastam.get(i).getnif()+" Total Gasto: "+dezmaisgastam.get(i).getmoneyspent());
                listModel.addElement("Nif: "+dezmaisgastam.get(i).getnif()+" Total Gasto: "+dezmaisgastam.get(i).getmoneyspent());
            }
            flag = 1;
            //lista = gestorfichas.gettenUsersMostRich();             <-
            //System.out.println(Arrays.toString(lista.toArray()));   <- (para ver a lista completa)
        }
    }
    
    private void gotoxempresas (MouseEvent evt) {
        listModel2.removeAllElements();
        if(numerodeempresas.equals("")){
            infoBox("Escreva o numero de empresas a mostrar", "Ação necessária");
        }
        else if(Integer.parseInt(numerodeempresas)>0) {
            lista2 = gestorfichas.getMoneyEmpresas(Integer.parseInt(numerodeempresas));
            List<EntidadeEmpresas> xEmpresas = new ArrayList<>();
            xEmpresas = lista2;
            for(int i = 0; i < xEmpresas.size(); i++) {
                listModel2.addElement("Nif: "+xEmpresas.get(i).getnif()+" Faturas: "+xEmpresas.get(i).getFaturacao()+" Dedução fiscal: "+xEmpresas.get(i).getDeducaoFiscal());
            }
        }
    }
    
    private void onKeyReleasednempresas (KeyEvent evt) {
            numerodeempresas = nempresas.getText();
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
                new GUI_Login();
            }
        });
    }

}
