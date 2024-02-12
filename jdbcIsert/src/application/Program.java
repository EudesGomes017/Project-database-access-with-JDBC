package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();

			// EXAMPLE 1:
			// Prepara uma instrução SQL para inserir dados na tabela "seller",
			// especificando os campos e os valores a serem inseridos. A opção
			// interrogação são chamados Especificamente, esses são marcadores de posição ou
			// placeholders.(vai ser preenchido depois)
			// Statement.RETURN_GENERATED_KEYS indica que as chaves geradas devem ser
			// retornadas.
			/*st = conn.prepareStatement("INSERT INTO seller " + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			
			
		

			// Define os valores dos parâmetros na instrução preparada, substituindo os
			// marcadores de posição ? pelos valores correspondentes.
			st.setString(1, "Carl Purple");//n° 1 representa que vai ser primeira interrogação, "nome que vou substituir"
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));// obs: quando colocamos data no jdbc temos que por java.sql.Date
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);*/

			//INSERIDO DEIRETAMENTE E RETORNANDO OS IDS INSERIDOS
			st = conn.prepareStatement("INSERT INTO department (Name) values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS);
			// EXAMPLE 2:
			// st = conn.prepareStatement(
			// "insert into department (Name) values ('D1'),('D2')",
			// Statement.RETURN_GENERATED_KEYS);
			// Executa a instrução SQL preparada e armazena o número de linhas afetadas pela
			// operação.
			int rowsAffected = st.executeUpdate();
			
			System.out.println(" Row: " + rowsAffected);

			// Se a inserção foi bem-sucedida, recupera as chaves geradas automaticamente
			// usando getGeneratedKeys() e itera sobre elas para exibir o resultado.
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);//colocamos n° do id que vai conter só os ids 
					System.out.println("Done! Id: " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} /*catch (ParseException e) {
			e.printStackTrace();
		}*/ finally {
			DB.closeStatement(st);
			// No bloco finally, o recurso do PreparedStatement é fechado para liberar
			// recursos do sistema, independentemente de ocorrer uma exceção ou não.
			// Esse código demonstra a inserção de dados em um banco de dados usando
			// PreparedStatement, recuperação de chaves geradas e tratamento de exceções.

		}
	}
}
