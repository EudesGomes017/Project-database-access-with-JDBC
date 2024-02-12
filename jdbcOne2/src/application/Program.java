package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement(); // instanciamos um objeto do tipo Statement
			
			rs =  st.executeQuery("select * from department");
			
			/*ResultSet Ele é um objeto que representa um formato tabela do banco de dadosl, por padrão ele começa na posição zero(antes de ter os dados
			 para percorrer os dados  chamamos a função next ele percorrer as posição da tabela*/
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}		
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeCloseConnection();
		}
	}

}
