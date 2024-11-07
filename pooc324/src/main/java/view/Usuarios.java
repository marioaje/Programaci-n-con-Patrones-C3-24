package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuarios extends JFrame{
    private JButton cancelarButton;
    private JButton loginButton;
    private JTextField textField1;
    private JPanel panelP;


    public Usuarios() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(loginButton,"");
            }
        });
    }

    public static void main(String[] args) {
        Usuarios uiUsuarios = new Usuarios();
        uiUsuarios.setContentPane(uiUsuarios.panelP);
        uiUsuarios.setTitle("Titulo");
        uiUsuarios.setSize(300 , 400);
        uiUsuarios.setVisible(true);
        uiUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Métodos para obtener los botones
    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public JButton getLoginButton() {
        return loginButton;
    }



}
