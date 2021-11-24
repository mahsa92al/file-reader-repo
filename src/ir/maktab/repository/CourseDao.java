package ir.maktab.repository;

import java.sql.*;

/**
 * @author Mahsa Alikhani m-58
 */
public class CourseDao extends BaseDao{
    private final Connection connection;

    public CourseDao() throws SQLException, ClassNotFoundException {
        connection = BaseDao.getConnection();
    }

    public boolean findCourseByName(String courseName) throws SQLException {
        boolean isEmpty = true;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("select * from course where name = '%s'", courseName));
        while (resultSet.next()){
            isEmpty = false;
        }
        return isEmpty;
    }

    public int saveNewCourse(String courseName, Timestamp timestamp) throws SQLException {
        String sqlQuery = "insert into course (name, timestamp) values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, courseName);
        statement.setTimestamp(2, timestamp);
        statement.executeUpdate();
        ResultSet autoKey = statement.getGeneratedKeys();
        while (autoKey.next()){
            return autoKey.getInt(1);
        }
        return -1;
    }

    public int findCourseIdByName(String courseName) throws SQLException {
        int courseId = 0;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("select id from course where name = '%s'", courseName));
        while (resultSet.next()){
            courseId = resultSet.getInt("id");
        }
        return courseId;
    }
}
