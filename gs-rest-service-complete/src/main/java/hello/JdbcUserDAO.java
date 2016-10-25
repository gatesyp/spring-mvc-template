package hello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcUserDAO implements UserDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(User user){

		String sql = "INSERT INTO prescreening_users " +
				"(first, last, email, age, height, weight, bmi) VALUES (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirst());
			ps.setString(2, user.getLast());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAge());
			ps.setDouble(5, user.getHeight());
			ps.setDouble(6, user.getWeight());
			ps.setDouble(7, user.getBmi());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public User findByUserId(int userId){

		String sql = "SELECT * FROM prescreening_users WHERE id = ?";

		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			User user  = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user  = new User(
					rs.getLong("id"),
					rs.getString("first"),
					rs.getString("last"),
					rs.getString("email"),
					rs.getString("age"),
					rs.getDouble("height"),
					rs.getDouble("weight"),
					rs.getDouble("bmi")
				);
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}