package org.example;

import org.example.mapper.ServerMapper;
import org.example.mapper.StudentMapper;
import org.example.model.Server;
import org.example.model.Student;
import org.example.parser.InputParser;
import org.example.services.StudentService;

import java.util.List;

public class StudentServiceTest {
    public static void main(String[] args) {
        String[] studentsInformation = {
            "22, Data Structures, 45",
            "23, English, 52",
            "22, English, 51",
            "26, Data Structures, 72",
            "23, Data Structures, 61",
            "24, English, 81"
        };
        StudentMapper mapper = new StudentMapper();
        List<Student> students;
        InputParser parser = new InputParser<Server>(new StudentMapper());
        students = parser.parseArray(studentsInformation);
        StudentService service = new StudentService(students);
        Double averageMarks = service.avaerageMarksForStudentHavingLowestId();
        System.out.println("--- servers ---");
        students.forEach(System.out::println);
        System.out.println("---Average Marks for Student Having Lowest Id ---");
        System.out.println(averageMarks);

    }
}
