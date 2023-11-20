/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.Conexao;
import java.awt.HeadlessException;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Utilizador;
import view.Login;
import view.telaPrincimpal;

/**
 *
 * @author User
 */
public class UtilizadorDAO {

    public void salvar(Utilizador utilizador) {

        String sql = "INSERT INTO UTILIZADOR(EMAIL, NOME, PASSWORD) VALUES(?,?,?)";

        Connection con = null;

        PreparedStatement pstm = null;

        try {
            con = Conexao.getConnectDB();

            pstm = con.prepareStatement(sql);

            pstm.setString(1, utilizador.getEmail());
            pstm.setString(2, utilizador.getNome());
            pstm.setString(3, utilizador.getPassword());

            pstm.execute();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Insercao deconseguida");
        }

    }

    public void verifiarLogin(String email, String password) {

        Connection con = null;
        PreparedStatement pstm = null;

        String sql = "SELECT EMAIL, PASSWORD FROM UTILIZADOR WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";

        try {
            con = Conexao.getConnectDB();

            pstm = con.prepareStatement(sql);

            ResultSet rst = pstm.executeQuery();

            if (rst.next()) {

                JOptionPane.showMessageDialog(null, "Seja bem viondo ao sistema");
                        new telaPrincimpal().setVisible(true);
                        Login login = new Login();
                        login.dispose();
            } else {

                JOptionPane.showMessageDialog(null, "Dados invalidos, se nao estiver registrado por favor registre-se");
            }
        } catch (HeadlessException | SQLException e) {

            JOptionPane.showMessageDialog(null, "conexao nao conseguida" + e);
        }
    }

}
