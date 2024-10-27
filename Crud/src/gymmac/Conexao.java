
package gymmac;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    private String sql;
    
    private Connection conect(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gymmac","root","root");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRO: " + e,"Erro de conexão", JOptionPane.ERROR_MESSAGE);
        }
        return con;
    }
    
    private Connection con = conect();
    
    public Statement statSelect(){
        
        Statement STMT = null;
        try {
            STMT = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return STMT;
    }
    
    private Statement STMT = statSelect();
    
    public ResultSet res(String sql){
        Statement stmt = STMT;
        ResultSet result = null;
        this.sql = sql;
        try{
           result = stmt.executeQuery(sql);
           return result;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERRO res: " + e,"ERRO", JOptionPane.ERROR_MESSAGE);
            return result;
        }
    }
    
    public void closeAll(){
        try{
            this.con.close();
            this.STMT.close();
        }catch(Exception e){
            System.out.println("Erro: " + e);
        }
    }
}
