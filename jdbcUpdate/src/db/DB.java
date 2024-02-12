package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	// Method para concetar com banco de dados
	public static Connection getConnection() {
		if (conn == null) {

			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props); // para obter a conexão com banco de dados
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

		return conn;
	}

	// Method para fechar a conexão
	public static void closeCloseConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
	}

	// method para buscar as informações do arquivo db.properties
	private static Properties loadProperties() {

		// o arquivo está dentro da pasta raiz do projeto com isso digitando
		// db.properties ele vai buscar
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				
				throw new DbException(e.getMessage());
			}
		}
	}
		
		public static void closeResultSet(ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					
					throw new DbException(e.getMessage());
				}
			}

	}

}
