package ir.maktab.repository;

import ir.maktab.model.Course;

import java.sql.*;

/**
 * @author Mahsa Alikhani m-58
 */
public class CourseDao extends BaseDao{
    private final Connection connection;

    public CourseDao() throws SQLException, ClassNotFoundException {
        connection = BaseDao.getConnection();
    }

    public Course findCourseByName(String courseName) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("select * from course where name = '%s'", courseName));
        while (resultSet.next()){
            Course course = new Course();
            course.setId(resultSet.getInt("id"));
            course.setName(resultSet.getString("name"));
            course.setTimestamp(resultSet.getTimestamp("timestamp"));
            return course;
        }
        return null;
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
}
