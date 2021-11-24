package ir.maktab.repository;

import ir.maktab.model.StudentCourseRating;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
public class StudentCourseRatingDao extends BaseDao{
    private final Connection connection;

    public StudentCourseRatingDao() throws SQLException, ClassNotFoundException {
        connection = BaseDao.getConnection();
    }

    public boolean findRatingsById(int studentId, int courseId) throws SQLException {
        boolean isEmpty = true;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("select course_id from course" +
                " where student_id = %d and course_id = %d", studentId, courseId));
        while (resultSet.next()){
            isEmpty = false;
        }
        return isEmpty;
    }

    public void saveNewRateAndComment(int courseId, int studentId, Double rating, String comment) throws SQLException {
        String sqlQuery = "insert into student_course_rating (student_id, course_id, comment, rate)" +
                "values (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sqlQuery);
        statement.setInt(1, courseId);
        statement.setInt(2, studentId);
        statement.setString(3, comment);
        statement.setDouble(4, rating);
        statement.executeUpdate();
    }
}
