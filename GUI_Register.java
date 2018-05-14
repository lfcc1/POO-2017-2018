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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.table.*;
import java.awt.event.ItemListener;  
import java.awt.event.ItemEvent; 


public class GUI_Register extends JFrame {

    //Registo de individuo
    private JMenuBar menuBar;
    private JButton BRegistar;
    private JTextField REmail;
    private JTextField RMorada;
    private JTextField RNome;
    private JTextField RNumerodedependentes;
    private JTextField RPassword;
    private JLabel Title;
    private JTextField CodigosAtividades;
    private JTextField NumerosFiscais;
    private JLabel label3;
    private JLabel labelEmail;
    private JLabel labelMorada;
    private JLabel labelNome;
    private JLabel labelNumeroDeDependentes;
    private JLabel labelNumerosFiscais;
    private JLabel labelPassword;
    private JButton AdicionarButtonNifs;
    private JButton AdicionarButtonCodigos;
    private JButton removerbotaoNifs;
    private JButton removerbotaoCodigos;
    private JTable table;
    private JTable table2;
    private int nif;
    private int codigoAtividade;
    private boolean visible;
    private boolean flag;
    private JScrollPane scroll;
    private JScrollPane scroll2;
    private JComboBox combobox1;
    private String email;
    private String morada;
    private String nome;
    private int numerodedependentes;
    private String password;
    private ArrayList<Nifs> nifs;
    private ArrayList<CodAtiv> codigos;
    private String[] colunas = {"Nifs"}; 
    private DefaultTableModel dtm = new DefaultTableModel(null,colunas){
        @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};
    private String[] colunas2 = {"Codigos de Atividades"};
    private DefaultTableModel dtm2 = new DefaultTableModel(null,colunas2){
        @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};  //Registo de empresa
    private JTextField RAtividadeEconomica;
    private JTextField REmailE;
    private JTextField RMoradaE;
    private JTextField RNifE;
    private JTextField RNomeE;
    private JTextField RPasswordE;
    private JButton Registar;
    private JLabel Titulo;
    private JLabel labelAtividadeEconomica;
    private JLabel labelEmailE;
    private JLabel labelMoradaE;
    private JLabel labelNif;
    private JLabel labelNomeE;
    private JLabel labelPasswordE;

    //Constructor 
    public GUI_Register(){
        nif = 911;
        codigoAtividade = 112;
        nifs = new ArrayList<Nifs>();
        codigos = new ArrayList<CodAtiv>();
        visible = false; flag = false;
        
        this.setTitle("GUI_project");
        this.setSize(499,480);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(499,480));
        contentPane.setBackground(new Color(192,192,192));


        BRegistar = new JButton();
        BRegistar.setBounds(195,389,90,35);
        BRegistar.setBackground(new Color(214,217,223));
        BRegistar.setForeground(new Color(0,0,0));
        BRegistar.setEnabled(true);
        BRegistar.setFont(new Font("sansserif",0,12));
        BRegistar.setText("Registar");
        BRegistar.setVisible(visible);
        
        /**BRegistar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                OnClickedRegistar(evt);
            }
        });*/

        REmail = new JTextField();
        REmail.setBounds(197,298,90,35);
        REmail.setBackground(new Color(255,255,255));
        REmail.setForeground(new Color(0,0,0));
        REmail.setEnabled(true);
        REmail.setFont(new Font("sansserif",0,12));
        REmail.setText("");
        REmail.setVisible(visible);
        
        REmail.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onKeyReleasedREmail(evt);
            }
        });

        RMorada = new JTextField();
        RMorada.setBounds(197,338,90,35);
        RMorada.setBackground(new Color(255,255,255));
        RMorada.setForeground(new Color(0,0,0));
        RMorada.setEnabled(true);
        RMorada.setFont(new Font("sansserif",0,12));
        RMorada.setText("");
        RMorada.setVisible(visible);
        
        RMorada.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onKeyReleasedRMorada(evt);
            }
        });

        RNome = new JTextField();
        RNome.setBounds(197,258,90,35);
        RNome.setBackground(new Color(255,255,255));
        RNome.setForeground(new Color(0,0,0));
        RNome.setEnabled(true);
        RNome.setFont(new Font("sansserif",0,12));
        RNome.setText("");
        RNome.setVisible(visible);
        
        RNome.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onKeyReleasedRNome(evt);
            }
        });

        RNumerodedependentes = new JTextField();
        RNumerodedependentes.setBounds(197,218,90,35);
        RNumerodedependentes.setBackground(new Color(255,255,255));
        RNumerodedependentes.setForeground(new Color(0,0,0));
        RNumerodedependentes.setEnabled(true);
        RNumerodedependentes.setFont(new Font("sansserif",0,12));
        RNumerodedependentes.setText("");
        RNumerodedependentes.setVisible(visible);
        
        RNumerodedependentes.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onKeyReleasedRNumerodedependentes(evt);
            }
        });

        RPassword = new JPasswordField();
        RPassword.setBounds(197,177,90,35);
        RPassword.setBackground(new Color(255,255,255));
        RPassword.setForeground(new Color(0,0,0));
        RPassword.setEnabled(true);
        RPassword.setFont(new Font("sansserif",0,12));
        RPassword.setText("");
        RPassword.setVisible(visible);
        
        RPassword.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onKeyReleasedRPassword(evt);
            }
        });

        Title = new JLabel();
        Title.setBounds(130,28,220,35);
        Title.setBackground(new Color(214,217,223));
        Title.setForeground(new Color(0,0,0));
        Title.setEnabled(true);
        Title.setFont(new Font("SansSerif",0,30));
        Title.setText("Registo Pessoal");
        Title.setVisible(visible);

        CodigosAtividades = new JTextField();
        CodigosAtividades.setBounds(198,132,90,35);
        CodigosAtividades.setBackground(new Color(214,217,223));
        CodigosAtividades.setForeground(new Color(0,0,0));
        CodigosAtividades.setEnabled(true);
        CodigosAtividades.setFont(new Font("sansserif",0,12));
        CodigosAtividades.setVisible(visible);
        
        CodigosAtividades.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onKeyReleasedCodigosAtividades(evt);
            }
        });

        NumerosFiscais = new JTextField();
        NumerosFiscais.setBounds(197,88,90,35);
        NumerosFiscais.setBackground(new Color(214,217,223));
        NumerosFiscais.setForeground(new Color(0,0,0));
        NumerosFiscais.setEnabled(true);
        NumerosFiscais.setFont(new Font("sansserif",0,12));
        NumerosFiscais.setVisible(visible);
        
        NumerosFiscais.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt){
                onKeyReleasedNif(evt);
            }
        });
        
        removerbotaoNifs = new JButton();
        removerbotaoNifs.setBounds(460,410,90,35);
        removerbotaoNifs.setBackground(new Color(214,217,223));
        removerbotaoNifs.setForeground(new Color(0,0,0));
        removerbotaoNifs.setEnabled(true);
        removerbotaoNifs.setFont(new Font("sansserif",0,12));
        removerbotaoNifs.setText("Remover");
        removerbotaoNifs.setVisible(visible);

        removerbotaoNifs.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                NifRemoved(evt);
            }
        });
        
        removerbotaoCodigos = new JButton();
        removerbotaoCodigos.setBounds(860,410,90,35);
        removerbotaoCodigos.setBackground(new Color(214,217,223));
        removerbotaoCodigos.setForeground(new Color(0,0,0));
        removerbotaoCodigos.setEnabled(true);
        removerbotaoCodigos.setFont(new Font("sansserif",0,12));
        removerbotaoCodigos.setText("Remover");
        removerbotaoCodigos.setVisible(visible);

        removerbotaoCodigos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                CodigoRemoved(evt);
            }
        });

        label3 = new JLabel();
        label3.setBounds(63,132,130,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("sansserif",0,12));
        label3.setText("Codigos de Atividades");
        label3.setVisible(visible);

        labelEmail = new JLabel();
        labelEmail.setBounds(150,299,50,35);
        labelEmail.setBackground(new Color(214,217,223));
        labelEmail.setForeground(new Color(0,0,0));
        labelEmail.setEnabled(true);
        labelEmail.setFont(new Font("sansserif",0,12));
        labelEmail.setText("Email");
        labelEmail.setVisible(visible);

        labelMorada = new JLabel();
        labelMorada.setBounds(141,338,50,35);
        labelMorada.setBackground(new Color(214,217,223));
        labelMorada.setForeground(new Color(0,0,0));
        labelMorada.setEnabled(true);
        labelMorada.setFont(new Font("sansserif",0,12));
        labelMorada.setText("Morada");
        labelMorada.setVisible(visible);

        labelNome = new JLabel();
        labelNome.setBounds(150,259,40,35);
        labelNome.setBackground(new Color(214,217,223));
        labelNome.setForeground(new Color(0,0,0));
        labelNome.setEnabled(true);
        labelNome.setFont(new Font("sansserif",0,12));
        labelNome.setText("Nome");
        labelNome.setVisible(visible);
        labelNumeroDeDependentes = new JLabel();
        labelNumeroDeDependentes.setBounds(45,220,140,35);
        labelNumeroDeDependentes.setBackground(new Color(214,217,223));
        labelNumeroDeDependentes.setForeground(new Color(0,0,0));
        labelNumeroDeDependentes.setEnabled(true);
        labelNumeroDeDependentes.setFont(new Font("sansserif",0,12));
        labelNumeroDeDependentes.setText("Numero de Dependentes");
        labelNumeroDeDependentes.setVisible(visible);

        labelNumerosFiscais = new JLabel();
        labelNumerosFiscais.setBounds(92,88,100,35);
        labelNumerosFiscais.setBackground(new Color(214,217,223));
        labelNumerosFiscais.setForeground(new Color(0,0,0));
        labelNumerosFiscais.setEnabled(true);
        labelNumerosFiscais.setFont(new Font("sansserif",0,12));
        labelNumerosFiscais.setText("Numeros Fiscais");
        labelNumerosFiscais.setVisible(visible);

        labelPassword = new JLabel();
        labelPassword.setBounds(129,177,60,35);
        labelPassword.setBackground(new Color(214,217,223));
        labelPassword.setForeground(new Color(0,0,0));
        labelPassword.setEnabled(true);
        labelPassword.setFont(new Font("sansserif",0,12));
        labelPassword.setText("Password");
        labelPassword.setVisible(visible);
        
        AdicionarButtonNifs = new JButton();
        AdicionarButtonNifs.setBounds(297,88,90,35);
        AdicionarButtonNifs.setBackground(new Color(214,217,223));
        AdicionarButtonNifs.setForeground(new Color(0,0,0));
        AdicionarButtonNifs.setEnabled(true);
        AdicionarButtonNifs.setFont(new Font("sansserif",0,12));
        AdicionarButtonNifs.setText("Adicionar");
        AdicionarButtonNifs.setVisible(visible);
        //  Set methods for mouse events
        //Call defined methods
        AdicionarButtonNifs.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                NifAdded(evt);
            }
        });
        
        AdicionarButtonCodigos = new JButton();
        AdicionarButtonCodigos.setBounds(297,133,90,35);
        AdicionarButtonCodigos.setBackground(new Color(214,217,223));
        AdicionarButtonCodigos.setForeground(new Color(0,0,0));
        AdicionarButtonCodigos.setEnabled(true);
        AdicionarButtonCodigos.setFont(new Font("sansserif",0,12));
        AdicionarButtonCodigos.setText("Adicionar");
        AdicionarButtonCodigos.setVisible(visible);
        //  Set methods for mouse events
        //Call defined methods
        AdicionarButtonCodigos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                CodigoAdded(evt);
            }
        });
        
        table = new JTable(dtm);
        table.setBackground(new Color(255,255,255));
        table.setForeground(new Color(0,0,0));
        table.setEnabled(true);
        table.setFont(new Font("sansserif",0,12));
        table.setVisible(visible);
        table.getTableHeader().setReorderingAllowed(false);

        scroll = new JScrollPane();
        scroll.setViewportView(table);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(379,197,264,196);
        scroll.setVisible(visible);
        
        table2 = new JTable(dtm2);
        table2.setBackground(new Color(255,255,255));
        table2.setForeground(new Color(0,0,0));
        table2.setEnabled(true);
        table2.setFont(new Font("sansserif",0,12));
        table2.setVisible(visible);
        table2.getTableHeader().setReorderingAllowed(false);

        scroll2 = new JScrollPane();
        scroll2.setViewportView(table2);
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setBounds(779,197,264,196);
        scroll2.setVisible(visible);
        
        //Registo de Empresa
        RAtividadeEconomica = new JTextField();
        RAtividadeEconomica.setBounds(199,282,90,35);
        RAtividadeEconomica.setBackground(new Color(255,255,255));
        RAtividadeEconomica.setForeground(new Color(0,0,0));
        RAtividadeEconomica.setEnabled(true);
        RAtividadeEconomica.setFont(new Font("sansserif",0,12));
        RAtividadeEconomica.setText("");
        RAtividadeEconomica.setVisible(!visible);

        REmailE = new JTextField();
        REmailE.setBounds(199,202,90,35);
        REmailE.setBackground(new Color(255,255,255));
        REmailE.setForeground(new Color(0,0,0));
        REmailE.setEnabled(true);
        REmailE.setFont(new Font("sansserif",0,12));
        REmailE.setText("");
        REmailE.setVisible(!visible);
    
        RMoradaE = new JTextField();
        RMoradaE.setBounds(199,242,90,35);
        RMoradaE.setBackground(new Color(255,255,255));
        RMoradaE.setForeground(new Color(0,0,0));
        RMoradaE.setEnabled(true);
        RMoradaE.setFont(new Font("sansserif",0,12));
        RMoradaE.setText("");
        RMoradaE.setVisible(!visible);

        RNifE = new JTextField();
        RNifE.setBounds(199,82,90,35);
        RNifE.setBackground(new Color(255,255,255));
        RNifE.setForeground(new Color(0,0,0));
        RNifE.setEnabled(true);
        RNifE.setFont(new Font("sansserif",0,12));
        RNifE.setText("");
        RNifE.setVisible(!visible);

        RNomeE = new JTextField();
        RNomeE.setBounds(199,162,90,35);
        RNomeE.setBackground(new Color(255,255,255));
        RNomeE.setForeground(new Color(0,0,0));
        RNomeE.setEnabled(true);
        RNomeE.setFont(new Font("sansserif",0,12));
        RNomeE.setText("");
        RNomeE.setVisible(!visible);

        RPasswordE = new JPasswordField();
        RPasswordE.setBounds(199,122,90,35);
        RPasswordE.setBackground(new Color(255,255,255));
        RPasswordE.setForeground(new Color(0,0,0));
        RPasswordE.setEnabled(true);
        RPasswordE.setFont(new Font("sansserif",0,12));
        RPasswordE.setText("");
        RPasswordE.setVisible(!visible);

        Registar = new JButton();
        Registar.setBounds(198,343,90,35);
        Registar.setBackground(new Color(214,217,223));
        Registar.setForeground(new Color(0,0,0));
        Registar.setEnabled(true);
        Registar.setFont(new Font("sansserif",0,12));
        Registar.setText("Registar");
        Registar.setVisible(!visible);

        Titulo = new JLabel();
        Titulo.setBounds(114,18,300,35);
        Titulo.setBackground(new Color(214,217,223));
        Titulo.setForeground(new Color(0,0,0));
        Titulo.setEnabled(true);
        Titulo.setFont(new Font("SansSerif",0,30));
        Titulo.setText("Registo de Empresa");
        Titulo.setVisible(!visible);

        labelAtividadeEconomica = new JLabel();
        labelAtividadeEconomica.setBounds(65,283,120,35);
        labelAtividadeEconomica.setBackground(new Color(214,217,223));
        labelAtividadeEconomica.setForeground(new Color(0,0,0));
        labelAtividadeEconomica.setEnabled(true);
        labelAtividadeEconomica.setFont(new Font("sansserif",0,12));
        labelAtividadeEconomica.setText("AtividadeEconomica");
        labelAtividadeEconomica.setVisible(!visible);

        labelEmailE = new JLabel();
        labelEmailE.setBounds(146,203,90,35);
        labelEmailE.setBackground(new Color(214,217,223));
        labelEmailE.setForeground(new Color(0,0,0));
        labelEmailE.setEnabled(true);
        labelEmailE.setFont(new Font("sansserif",0,12));    
        labelEmailE.setText("Email");
        labelEmailE.setVisible(!visible);

        labelMoradaE = new JLabel();
        labelMoradaE.setBounds(135,242,90,35);
        labelMoradaE.setBackground(new Color(214,217,223));
        labelMoradaE.setForeground(new Color(0,0,0));
        labelMoradaE.setEnabled(true);
        labelMoradaE.setFont(new Font("sansserif",0,12));
        labelMoradaE.setText("Morada");
        labelMoradaE.setVisible(!visible);

        labelNif = new JLabel();
        labelNif.setBounds(167,82,90,35);
        labelNif.setForeground(new Color(0,0,0));
        labelNif.setEnabled(true);
        labelNif.setFont(new Font("sansserif",0,12));
        labelNif.setText("Nif");
        labelNif.setVisible(!visible);

        labelNomeE = new JLabel();
        labelNomeE.setBounds(146,163,90,35);
        labelNomeE.setBackground(new Color(214,217,223));
        labelNomeE.setForeground(new Color(0,0,0));
        labelNomeE.setEnabled(true);
        labelNomeE.setFont(new Font("sansserif",0,12));
        labelNomeE.setText("Nome");
        labelNomeE.setVisible(!visible);

        labelPasswordE = new JLabel();
        labelPasswordE.setBounds(124,122,90,35);
        labelPasswordE.setBackground(new Color(214,217,223));
        labelPasswordE.setForeground(new Color(0,0,0));
        labelPasswordE.setEnabled(true);
        labelPasswordE.setFont(new Font("sansserif",0,12));
        labelPasswordE.setText("Password");
        labelPasswordE.setVisible(!visible);
    
        combobox1 = new JComboBox<String>();
        combobox1.setBounds(18,18,90,35);
        combobox1.setBackground(new Color(214,217,223));
        combobox1.setForeground(new Color(0,0,0));
        combobox1.setEnabled(true);
        combobox1.setFont(new Font("sansserif",0,12));
        combobox1.setVisible(true);
        combobox1.addItem("Empresa");
        combobox1.addItem("Pessoal");
        
        combobox1.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                setvisibility(e);
            }
        });
        
        //adding components to contentPane panel
        contentPane.add(RAtividadeEconomica);
        contentPane.add(REmailE);
        contentPane.add(RMoradaE);
        contentPane.add(RNifE);
        contentPane.add(RNomeE);
        contentPane.add(RPasswordE);
        contentPane.add(Registar);
        contentPane.add(Titulo);
        contentPane.add(labelAtividadeEconomica);
        contentPane.add(labelEmailE);
        contentPane.add(labelMoradaE);
        contentPane.add(labelNif);
        contentPane.add(labelNomeE);
        contentPane.add(labelPasswordE);
        contentPane.add(BRegistar);
        contentPane.add(REmail);
        contentPane.add(RMorada);
        contentPane.add(RNome);
        contentPane.add(RNumerodedependentes);
        contentPane.add(RPassword);
        contentPane.add(Title);
        contentPane.add(CodigosAtividades);
        contentPane.add(NumerosFiscais);
        contentPane.add(label3);
        contentPane.add(labelEmail);
        contentPane.add(labelMorada);
        contentPane.add(labelNome);
        contentPane.add(labelNumeroDeDependentes);
        contentPane.add(labelNumerosFiscais);
        contentPane.add(labelPassword);
        contentPane.add(AdicionarButtonNifs);
        contentPane.add(AdicionarButtonCodigos);
        contentPane.add(removerbotaoNifs);
        contentPane.add(removerbotaoCodigos);
        contentPane.add(scroll);
        contentPane.add(scroll2);
        contentPane.add(combobox1);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }
    
    private void setvisibility (ActionEvent evt) {
        String itemSelecionado = (String) combobox1.getSelectedItem();
        if(itemSelecionado.equals("Empresa")) flag = false;
        else flag = true;
        if (flag!=visible){
            visible = !visible;
            RAtividadeEconomica.setVisible(!visible);
            REmailE.setVisible(!visible);
            RMoradaE.setVisible(!visible);
            RNifE.setVisible(!visible);
            RNomeE.setVisible(!visible);
            RPasswordE.setVisible(!visible);
            Registar.setVisible(!visible);
            Titulo.setVisible(!visible);
            labelAtividadeEconomica.setVisible(!visible);
            labelEmailE.setVisible(!visible);
            labelMoradaE.setVisible(!visible);
            labelNif.setVisible(!visible);
            labelNomeE.setVisible(!visible);
            labelPasswordE.setVisible(!visible);
            BRegistar.setVisible(visible);
            REmail.setVisible(visible);
            RMorada.setVisible(visible);
            RNome.setVisible(visible);
            RNumerodedependentes.setVisible(visible);
            RPassword.setVisible(visible);
            Title.setVisible(visible);
            CodigosAtividades.setVisible(visible);
            NumerosFiscais.setVisible(visible);
            removerbotaoNifs.setVisible(visible);
            removerbotaoCodigos.setVisible(visible);
            label3.setVisible(visible);
            labelEmail.setVisible(visible);
            labelMorada.setVisible(visible);
            labelNome.setVisible(visible);
            labelNumeroDeDependentes.setVisible(visible);
            labelNumerosFiscais.setVisible(visible);
            labelPassword.setVisible(visible);
            AdicionarButtonNifs.setVisible(visible);
            AdicionarButtonCodigos.setVisible(visible);
            table.setVisible(visible);
            table2.setVisible(visible);
            scroll.setVisible(visible);
            scroll2.setVisible(visible);
        }
    }
    
    //Method mouseClicked for AdicionarButton
    private void NifAdded (MouseEvent evt) {
        Nifs h = new Nifs (nif);
        nifs.add(h);
        
        dtm.addRow(new Integer[1]);
        table.setValueAt(nif,table.getRowCount()-1,0);
        NumerosFiscais.setText("");
    }
    
    private void CodigoAdded (MouseEvent evt) {
        CodAtiv h = new CodAtiv (codigoAtividade);
        codigos.add(h);
        
        dtm2.addRow(new Integer[1]);
        table2.setValueAt(codigoAtividade,table2.getRowCount()-1,0);
        CodigosAtividades.setText("");
    }
    
    private void  NifRemoved (MouseEvent evt) {
        int row = table.getSelectedRow();
        int auxnif = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
        Nifs h = new Nifs (auxnif);
        nifs.remove(h);
        dtm.removeRow(row);
    }
    
    private void  CodigoRemoved (MouseEvent evt) {
        int row = table2.getSelectedRow();
        int auxcodigo = Integer.parseInt(table2.getModel().getValueAt(row, 0).toString());
        CodAtiv h = new CodAtiv (auxcodigo);
        codigos.remove(h);
        dtm2.removeRow(row);
    }
    
    private void onKeyReleasedNif (KeyEvent evt) {
            nif = Integer.parseInt(NumerosFiscais.getText());
    }
    
    private void onKeyReleasedCodigosAtividades (KeyEvent evt) {
            codigoAtividade = Integer.parseInt(CodigosAtividades.getText());
    }
    
    private void onKeyReleasedREmail (KeyEvent evt) {
            email = REmail.getText();
    }
    
    private void onKeyReleasedRMorada (KeyEvent evt) {
            morada = RMorada.getText();
    }
    
    private void onKeyReleasedRNome (KeyEvent evt) {
            nome = RNome.getText();
    }
    
    private void onKeyReleasedRNumerodedependentes (KeyEvent evt) {
            numerodedependentes = Integer.parseInt(RNumerodedependentes.getText());
    }
    
        private void onKeyReleasedRPassword (KeyEvent evt) {
            password = RPassword.getText();
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
                new GUI_project();
            }
        });
    }

}