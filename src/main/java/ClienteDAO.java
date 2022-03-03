	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;

	import java.sql.SQLException;

	

public class ClienteDAO {

      
		private String jdbcURL = "jdbc:postgresql://localhost:5432/postgres";
		private String jdbcUsername = "postgres";
		private String jdbcPassword = "1234";

		private static final String INSERT_CLIENTE_SQL = "INSERT INTO prv_cliente" + "  (nome,email,data_nasc,rg,cpf,celular,nome_mae,nome_pai) VALUES "
				+ " (?,?,?,?,?,?,?,?);";

	
		protected Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}

		public void insertCliente(Cliente cliente) throws SQLException {
			System.out.println(INSERT_CLIENTE_SQL);
			// try-with-resource statement will auto close the connection.
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENTE_SQL)) {
				preparedStatement.setString(1, cliente.getNome());
				preparedStatement.setString(2, cliente.getEmail());
				preparedStatement.setString(3,cliente.getData_nasc());
				preparedStatement.setString(4, cliente.getRg());
				preparedStatement.setString(5, cliente.getCpf());
				preparedStatement.setString(6, cliente.getCelular());
				preparedStatement.setString(7, cliente.getNome_mae());
				preparedStatement.setString(8, cliente.getNome_pai());  
			
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			}
			 catch (SQLException e) {
				//printSQLException(e);
			}
		}

		public void insertCliente(Cliente newCliente) {
			// TODO Auto-generated method stub
			
		}
	}

