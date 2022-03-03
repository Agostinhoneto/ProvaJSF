import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

public class Cliente {
	     int id;
	     String nome;
	     String email;
	     String data_nasc;
	     String rg;
	     String cpf;
	     String celular;
	     String nome_mae;
	     String nome_pai;
	     
	    ArrayList usersList ;
	    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	    Connection connection;
	    
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    public String getNome() {
	        return nome;
	    }
	    public void setNome(String nome) {
	        this.nome = nome;
	    }
	    
	    public String getEmail() {
	        return email;
	    }
	    
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getData_nasc() {
	        return data_nasc;
	    }
	    public void setPassword(String data_nasc) {
	        this.data_nasc = data_nasc;
	    }
	    
	    public String getRg() {
	        return rg;
	    }
	    public void setRg(String rg) {
	        this.rg = rg;
	    }
	    
	    
	    public String getCpf() {
	        return cpf;
	    }
	    public void setCpf(String cpf) {
	        this.cpf = cpf;
	    } 
	    
	    public String getCelular() {
	        return celular;
	    }
	    public void setCelular(String celular) {
	        this.celular = celular;
	    } 
	    
	    public String getNome_mae() {
	        return nome_mae;
	    }
	    public void setNome_mae(String nome_mae) {
	        this.nome_mae = nome_mae;
	    } 
	    
	    public String getNome_pai() {
	        return nome_pai;
	    }
	    public void setNome_pai(String nome_pai) {
	        this.nome_pai = nome_pai;
	    } 
	    
	    public class Conexao {
	    	private String url;
	    	private String usuario;
	    	private String senha;
	    	private Connection con;
	    	
	    	 Conexao(){
	    		url = "jdbc:postgresql://localhost:5432/postgres";
	    		usuario = "postgres";
	    		senha = "1234";
	    		
	    		try {
	    			Class.forName("org.postgresql.Driver");
	    			con = DriverManager.getConnection(url,usuario,senha);  
	    			System.out.println("Conexão realizada com sucesso");
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    
	    
	    public String save(){
	        int result = 0;
	        try{
	            connection = Conexao();
	            PreparedStatement stmt = connection.prepareStatement("insert into prv_cliente(nome,email,data_nasc,rg,cpf,celular,nome_mae,nome_pai) values(?,?,?,?,?,?,?,?)");
	            stmt.setString(1, nome);
	            stmt.setString(2, email);
	            stmt.setString(3, data_nasc);
	            stmt.setString(4, rg);
	            stmt.setString(5, cpf);
	            stmt.setString(6, celular);
	            stmt.setString(7, nome_mae);
	            stmt.setString(7, nome_pai);   
	            result = stmt.executeUpdate();
	            connection.close();
	        }catch(Exception e){
	            System.out.println(e);
	        }
	        if(result !=0)
	            return "index.html?faces-redirect=true";
	        else return "index.html?faces-redirect=true";
	    }
	    
		private Connection Conexao() {
			// TODO Auto-generated method stub
			return null;
		}
}
