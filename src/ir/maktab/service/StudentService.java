package ir.maktab.service;

import ir.maktab.repository.StudentDao;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author Mahsa Alikhani m-58
 */
public class StudentService {
    private final StudentDao studentDao;

    public StudentService() throws SQLException, ClassNotFoundException {
        studentDao = new StudentDao();
    }

    public int setNewStudent(String name) throws SQLException {
        int studentId;
        if(studentDao.findStudentByName(name)){
            studentId = studentDao.saveNewStudent(name);
        }else {
            studentId = studentDao.findStudentIdByName(name);
        }
        return studentId;
    }
}
