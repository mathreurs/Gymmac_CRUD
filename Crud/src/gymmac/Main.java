package gymmac;

import java.sql.ResultSet;
import java.sql.Statement;
import tabelas.Capoteiro;

public class Main {
    
    public static void main(String[] args) {
        Capoteiro cap = new Capoteiro();
        cap.insertcapoteiro("matheus","senha123","matheus@email");
        /*try{
        while (result.next()) {
                int id = result.getInt("id_proprietario");
                String nome = result.getString("nome_usuario");
                String senha = result.getString("senha");
                String email = result.getString("email");
                
                // print the retrieved data
                System.out.println("ID: " + id + ", nome: " + nome + ", senha: " + senha + ", email: " + email);
            }
        con.closeAll();
        }catch(Exception e){
            System.out.println("erro");
        }*/
    }
 
}
