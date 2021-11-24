package ir.maktab.repository;

import java.sql.*;

/**
 * @author Mahsa Alikhani m-58
 */
public class StudentDao extends BaseDao{
    private final Connection connection;

    public StudentDao() throws SQLException, ClassNotFoundException {
        this.connection = BaseDao.getConnection();
    }

    public boolean findStudentByName(String name) throws SQLException {
        boolean isEmpty = true;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("select * from student where name = '%s'", name));
        while (resultSet.next()){
            isEmpty = false;
        }
        return isEmpty;
    }

    public int saveNewStudent(String name) throws SQLException {
        String sqlQuery = "insert into student (name) values (?)";
        PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, name);
        statement.executeUpdate();
        ResultSet autoKey = statement.getGeneratedKeys();
        while (autoKey.next()){
            return autoKey.getInt(1);
        }
        return -1;
    }

    public int findStudentIdByName(String name) throws SQLException {
        int studentId = 0;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("select id from student where name = '%s'", name));
        while (resultSet.next()){
            studentId = resultSet.getInt("id");
        }
        return studentId;
    }
}
