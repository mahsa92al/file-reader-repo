package ir.maktab.service;

import ir.maktab.repository.CourseDao;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author Mahsa Alikhani m-58
 */
public class CourseService {
    private final CourseDao courseDao;

    public CourseService() throws SQLException, ClassNotFoundException {
        courseDao = new CourseDao();
    }

    public int setNewCourse(String courseName, String timestamp) throws SQLException {
        int courseId = 0;
        if(courseDao.findCourseByName(courseName)){
            courseId = courseDao.saveNewCourse(courseName, Timestamp.valueOf(timestamp));
        }
        return courseId;
    }
}
