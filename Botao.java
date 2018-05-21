import java.awt.*;
import java.awt.event.*;
import javax.swing.*;    

public class Botao
  {
    private JButton Botao;

    public Botao(String name,Fatura fatura, FichaCliente ficha,GUI_FichaCliente gui)
    {
      this.Botao = new JButton(name);
      Botao.addActionListener(new ActionListener()
      {
        @Override
        public void actionPerformed(ActionEvent e)
        {
          GUI_Fatura faturagui = new GUI_Fatura(fatura,ficha,gui);
        }
      });
    }

    public JButton getButton()
    {
      return Botao;
    }

    @Override
    public String toString()
    {
      return Botao.getText();
    }
  }