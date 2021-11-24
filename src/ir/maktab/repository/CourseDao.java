package ir.maktab.repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mahsa Alikhani m-58
 */
public class CourseDao extends BaseDao{
    private final Connection connection;

    public CourseDao() throws SQLException, ClassNotFoundException {
        connection = BaseDao.getConnection();
    }
}
