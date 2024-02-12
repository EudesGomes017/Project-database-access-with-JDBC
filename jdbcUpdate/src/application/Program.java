package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();

			st = conn.prepareStatement(
					"UPDATE seller " + "SET BaseSalary = BaseSalary + ? " + "WHERE " +  "(DepartmentId = ?)");

			/*
			 * "UPDATE seller " + "SET BaseSalary = BaseSalary + ? " + "WHERE " +
			 * "Name IN(?, ?)"); // ATAULIZANDO POR MAIS DE UM NOME
			 */

			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			//st.setString(3, "Maria Green");
			//st.setString(4, "Carl Purple");
			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);

		}
	}
}
