import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;  





public class ClienteServlet extends HttpServlet{  
	   private ClienteDAO clienteDAO;

	    public ClienteServlet() {
	    }

	    public void init() {
	        this.clienteDAO = new ClienteDAO();
	    }
	
		
	
    private void insertCliente(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	String nome = request.getParameter("nome");
	    String email = request.getParameter("email");
	    String data_nasc = request.getParameter("data_nasc");
	    String rg = request.getParameter("rg");
	    String cpf = request.getParameter("cpf");
	    String celular = request.getParameter("celular");
	    String nome_mae = request.getParameter("nome_mae");
	    String nome_pai = request.getParameter("nome_pai");
	    
        Cliente newCliente = new Cliente();
        this.clienteDAO.insertCliente(newCliente);
      
    }
	
	


	 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException  
	 { 
		   String nome = req.getParameter("nome");
		    String email = req.getParameter("email");
		    String data_nasc = req.getParameter("data_nasc");
		    String rg = req.getParameter("rg");
		    String cpf = req.getParameter("cpf");
		    String celular = req.getParameter("celular");
		    String nome_mae = req.getParameter("nome_mae");
		    String nome_pai = req.getParameter("nome_pai");
				    
		    
		        
		 int result = 0;
         try{
            // res.getWriter().print("Chamou o Nome " +nome);
		      //  res.getWriter().print("Chamou o CPF " +cpf);
        	  Connection connection = Conexao();
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
		  
	          res.getWriter().print("Chamou o Nome " +nome);
			   res.getWriter().print("Chamou o CPF " +cpf);
	        	
		
	          
	        }catch(Exception e){
	            System.out.println(e);
	        }
	        
	        return;
	      
	    }
	    
		private Connection Conexao() {
			// TODO Auto-generated method stub
			return null;
		}
	 
	
	 
	    		  
	 
	 
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException  
		{  
	     	res.setContentType("text/html");//setting the content type  
	        PrintWriter pw=res.getWriter();//get the stream to write the data  
		  
				pw.println("<html><body>");  
				pw.println("Welcome to servlet");  
				pw.println("</body></html>");  
				  
				pw.close();//closing the stream  
		}
	
	

}  