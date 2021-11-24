package ir.maktab.repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mahsa Alikhani m-58
 */
public class StudentCourseRatingDao extends BaseDao{
    private final Connection connection;

    public StudentCourseRatingDao() throws SQLException, ClassNotFoundException {
        connection = BaseDao.getConnection();
    }
}
