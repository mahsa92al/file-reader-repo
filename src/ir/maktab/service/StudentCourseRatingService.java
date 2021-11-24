package ir.maktab.service;

import ir.maktab.repository.StudentCourseRatingDao;

import java.sql.SQLException;

/**
 * @author Mahsa Alikhani m-58
 */
public class StudentCourseRatingService {
    private final StudentCourseRatingDao studentCourseRatingDao;

    public StudentCourseRatingService() throws SQLException, ClassNotFoundException {
        studentCourseRatingDao = new StudentCourseRatingDao();
    }

    public void setNewRateAndComment(int courseId, int studentId, String rating, String comment) throws SQLException {
        if(studentCourseRatingDao.findRatingsById(studentId, courseId)){
            studentCourseRatingDao.saveNewRateAndComment(courseId, studentId, Double.valueOf(rating), comment);
        }
    }
}
