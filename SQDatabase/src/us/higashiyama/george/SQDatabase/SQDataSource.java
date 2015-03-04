
package us.higashiyama.george.SQDatabase;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class SQDataSource {

	HikariDataSource connectionPool = null;

	public SQDataSource() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/minecraft");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.addDataSourceProperty("useServerPrepStmts", "true");

		connectionPool = new HikariDataSource(config);

	}

	public Connection getConnection() {

		if (connectionPool != null) {
			try {
				return connectionPool.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}
}
