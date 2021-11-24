package ir.maktab.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
