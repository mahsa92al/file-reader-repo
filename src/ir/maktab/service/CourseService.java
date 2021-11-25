package ir.maktab.service;

import ir.maktab.model.Course;
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
        int courseId;
        Course course = courseDao.findCourseByName(courseName);
        if(course == null){
            courseId = courseDao.saveNewCourse(courseName, Timestamp.valueOf(timestamp));
        }else {
            courseId = course.getId();
        }
        return courseId;
    }
}
