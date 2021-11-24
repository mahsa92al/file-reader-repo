package ir.maktab;

import ir.maktab.service.CourseService;
import ir.maktab.service.StudentCourseRatingService;
import ir.maktab.service.StudentService;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @author Mahsa Alikhani m-58
 */
public class Main {
    private static StudentService studentService;
    private static CourseService courseService;
    private static StudentCourseRatingService studentCourseRatingService;
    public static void main(String[] args) throws Exception {
        studentService = new StudentService();
        courseService = new CourseService();
        studentCourseRatingService = new StudentCourseRatingService();
        readFileAndSaveToDBTable();
    }

    private static void readFileAndSaveToDBTable() throws Exception {
        String pathname = "D:\\BootcampSharif\\problemSets\\pset13-designPattern-IO\\IO\\studentCourseRating.txt";
        Path dataFileUrl = Paths.get(pathname);
        if(Files.notExists(dataFileUrl)){
            throw new Exception("File is not exist!");
        }

        try(Scanner scanner = new Scanner(new File(pathname))){
            String headerLine = scanner.nextLine();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] splitLine = line.split(",");
                int courseId = courseService.setNewCourse(splitLine[0], splitLine[2]);
                int studentId = studentService.setNewStudent(splitLine[1]);
                studentCourseRatingService.setNewRateAndComment(courseId, studentId, splitLine[3], splitLine[4]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
