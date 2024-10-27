package tabelas;

import gymmac.Conexao;
import java.sql.ResultSet;
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
    
    public void selectCapoteiro(){
        ResultSet res = con.res("select * from capoteiro") ;
        try{
            while(res.next()){
                int id = res.getInt("id_proprietario");
                String nome = res.getString("nome_usuario");
                String senha = res.getString("senha");
                String email = res.getString("email");
                
                // print the retrieved data
                System.out.println("ID: " + id + ", nome: " + nome + ", senha: " + senha + ", email: " + email);
            }
        }catch(Exception e){
            System.out.println("ERRO Select: " + e);
        }finally{
            try{
                res.close();
            }catch(Exception e){
                System.out.println("ERRO finally: " + e);
            }
        }
    }
    
    public void deleteCapoteiro(String nome){
        try {
            Statement stmt = con.conect().createStatement();
            String SQL = "delete from capoteiro where nome_usuario = '"+nome+"'";
            stmt.executeUpdate(SQL);
            
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro delete cap: " + ex);
        }
        
    }
}
