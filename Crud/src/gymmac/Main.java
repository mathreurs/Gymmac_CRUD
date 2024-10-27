package gymmac;
import java.util.*;
import tabelas.Capoteiro;

public class Main {
    
    public static void main(String[] args) {
        Capoteiro cap = new Capoteiro();
        Scanner inp = new Scanner(System.in);
        
        System.out.println("nome:");
        String nome = inp.nextLine();
        
        System.out.println("senha:");
        String senha = inp.next();
        
        System.out.println("email");
        String email = inp.next();
        
        cap.insertCapoteiro(nome, senha, email);
        
        cap.selectCapoteiro();
        
        cap.deleteCapoteiro(nome);
        
        cap.selectCapoteiro();
    }
}
