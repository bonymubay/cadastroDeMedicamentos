/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import conexao.Conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Medicamento;

/**
 *
 * @author User
 */
public class MedicamentoDAO {
    
    
    public void adionar(Medicamento medicamento){
        
        String sql="INSERT INTO MEDICAMENTOS(CODIGO,NOME, TIPO, QUANTIDADE, PRECO,DESCRICAO) VALUES(?,?,?,?,?,?)";
        
        Connection con=null;
        PreparedStatement pstm= null;
        
            try {
                con= Conexao.getConnectDB();
            pstm= con.prepareStatement(sql);
            
            pstm.setInt(1, medicamento.getCodigo());
            pstm.setString(2,medicamento.getNome() );
            pstm.setString(3, medicamento.getTipo());
            pstm.setInt(4, medicamento.getQuantidade());
            pstm.setDouble(5, medicamento.getPreco());
            pstm.setString(6, medicamento.getDescricao());
            
            pstm.execute();
            
               JOptionPane.showMessageDialog(null, "MEDICAMENTO ADICIONADO COM SUCESSO" );

        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "medicamento nao adicionadao  "+e );
        }
        
    }
    
    
    public void visualisar(){
        
    }
    
    
    public void deletar(){
        
    }
    
    public void actualizar(){
        
    }
    
}
