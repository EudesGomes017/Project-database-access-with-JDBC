package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		/* Transaction tem que manter a consistencia do banco de dados */
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();

			conn.setAutoCommit(false); // cada operação que feizer, vai ser confirmada automaticamente se for true, se
										// tiver false (cada transaction não está confirmada só quando eu confirma vc
										// fechar a transaction)

			st = conn.createStatement();

			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

			// int x = 1;
			// if (x < 2) {
			// throw new SQLException("Fake error");
			// }

			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

			conn.commit(); //confirma a transaction

			System.out.println("rows1 = " + rows1);
			System.out.println("rows2 = " + rows2);
		} catch (SQLException e) {
			try {
				conn.rollback(); //desfazer oq ja foi feito até esse momento 
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} finally {
			DB.closeStatement(st);

		}
	}
}
