package tabelas;
import gymmac.Conexao;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CadastroAcad {
   
    public void insertAcademia(String rs, String nomeF, String resp, int CNPJ, int telefone,int CEP){
        Conexao con = new Conexao();
        
        Statement stmp = con.statSelect();
        
        try{
            stmp.executeUpdate("INSERT INTO academias" + 
                    "(cnpj,telefone, nome_fantasia, razao_social, nome_resp, CEP) values"  +
                    "('"+CNPJ+"','"+telefone+"','"+nomeF+"','"+rs+"','"+resp+"','"+CEP+"')");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO inserir: " + e);
        }finally{
            try{
                stmp.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERRO fechar: " + e);
            }
        }
        
    }
}
