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
    
    public boolean selectCapoteiro(String veriEmail, String veriSenha){
        ResultSet res = con.res("select * from capoteiro") ;
        boolean verify = false;
        try{
            while(res.next()){
                int id = res.getInt("id_proprietario");
                String nome = res.getString("nome_usuario");
                String senha = res.getString("senha");
                String email = res.getString("email");
                
                System.out.println("Email:" + email + " Senha: " + senha);
                System.out.println("Email:" + veriEmail + " Senha: " + veriSenha);
                
                if(veriEmail.equals(email) && veriSenha.equals(senha)){
                    verify = true;
                }
            }
        }catch(Exception e){
            System.out.println("ERRO Select: " + e);
            verify = false;
        }finally{
            try{
                res.close();
            }catch(Exception e){
                System.out.println("ERRO finally: " + e);
            }
        }
        System.out.println(verify);
        return verify;
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
