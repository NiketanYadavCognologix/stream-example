package org.example.services;

import org.example.model.Student;

import java.util.List;
import java.util.NoSuchElementException;

public class StudentService {
    private List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public Double avaerageMarksForStudentHavingLowestId() {
        try {
            Integer lowestId = getLowestId(students);
            Double averageMarks = getAverageMarks(lowestId, students);
            return averageMarks;
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    private Double getAverageMarks(Integer id, List<Student> students) {
        Double averageMarks = students.stream()
                .filter(student -> student.getId() == id)
                .mapToInt(student -> student.getMarks())
                .average()
                .orElseThrow(NoSuchElementException::new);
        return  averageMarks;
    }
    private Integer getLowestId(List<Student> students) {
        Integer lowestId = students.stream()
                .mapToInt(student -> student.getId())
                .min()
                .orElseThrow(NoSuchElementException::new);
        return lowestId;
    }
}
