/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KUIS_123220098;

/**
 *
 * @author Lenovo
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class NewMain extends JFrame implements ActionListener {

    private JFrame frame1, frame2;
    private JTextField usernameField;
    private JTextField hasilLabel;
    private JTextField alas;
    private JTextField tinggi;
    private JTextField hasil;
    private JPasswordField passwordField;
    private JButton loginButton, hitungButton;

    public NewMain() {
        JLabel usernameLabel = new JLabel("Username :");
        JLabel passwordLabel = new JLabel("Password :");
        JLabel alasLabel = new JLabel("Alas :");
        JLabel tinggiLabel = new JLabel("Tinggi :");
        usernameField = new JTextField(15);
        usernameField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField = new JPasswordField(15);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        alas = new JTextField(15);
        alas.setHorizontalAlignment(SwingConstants.CENTER);
        tinggi = new JTextField(15);
        tinggi.setHorizontalAlignment(SwingConstants.CENTER);
        hasil = new JTextField(" ");
        hasil.setHorizontalAlignment(SwingConstants.CENTER);
        hasilLabel = new JTextField(" ");
        hasilLabel.setHorizontalAlignment(SwingConstants.CENTER);

        loginButton = new JButton("Masuk");
        hitungButton = new JButton("Hitung");

        loginButton.addActionListener(this);
        hitungButton.addActionListener(this);

        frame1 = new JFrame("Login Page PT UKANG");
        frame1.setLayout(new GridLayout(4, 2));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.add(usernameLabel);
        frame1.add(usernameField);
        frame1.add(passwordLabel);
        frame1.add(passwordField);
        frame1.add(loginButton);
        frame1.add(hasilLabel);

        frame1.setSize(400, 200);
        frame1.setVisible(true);

        frame2 = new JFrame("Hitung Siku");
        frame2.setLayout(new GridLayout(4, 2));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame2.add(alasLabel);
        frame2.add(alas);
        frame2.add(tinggiLabel);
        frame2.add(tinggi);
        frame2.add(hitungButton);
        frame2.add(hasil);

        frame2.setSize(400, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {//login password dan username

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if ("tukang_098".equals(username) && password.equals("tukang_098")) {
                hasilLabel.setText("Berhasil");
                frame2.setVisible(true);
            } else {
                hasilLabel.setText("Gagal");
            }
        } else if (e.getSource() == hitungButton) { //Perhitungan segitiga siku
            double nilaiAlas = Double.parseDouble(alas.getText());
            double nilaiTinggi = Double.parseDouble(tinggi.getText());
            double sisiMiring = Math.sqrt(Math.pow(nilaiAlas, 2) + Math.pow(nilaiTinggi, 2)); //sqrt=akar, pow=pangkat
            hasil.setText(String.format("%.2f", sisiMiring)); //%.2f=2 angka belakang koma
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewMain().setVisible(true));
    }
}
