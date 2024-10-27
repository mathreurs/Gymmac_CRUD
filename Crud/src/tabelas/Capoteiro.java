package tabelas;

import gymmac.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Capoteiro {
    Conexao con = new Conexao();
    
    public void insertCapoteiro(String nome_usuario,String senha,String email){
        Statement stmt = con.statSelect();
        try{
            stmt.executeUpdate("insert into capoteiro" + 
                    "(nome_usuario,senha,email)"+
                    "values('" + nome_usuario + "','" + senha +"','"+email+"')");
            
        }catch(Exception e){
            System.out.println("erro insert: " + e);
        }finally{
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Capoteiro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
