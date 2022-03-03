package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

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
