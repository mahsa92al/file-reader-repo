package ir.maktab.repository;

import ir.maktab.model.Student;

import java.sql.*;

/**
 * @author Mahsa Alikhani m-58
 */
public class StudentDao extends BaseDao{
    private final Connection connection;

    public StudentDao() throws SQLException, ClassNotFoundException {
        this.connection = BaseDao.getConnection();
    }

    public Student findStudentByName(String name) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("select * from student where name = '%s'", name));
        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setFullName(resultSet.getString("name"));
            return student;
        }
        return null;
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
}
