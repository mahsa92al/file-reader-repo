package ir.maktab.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
