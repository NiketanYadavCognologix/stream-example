package org.example.mapper;

import org.example.model.Student;

public class StudentMapper implements CSVToPojoMapper {
    public Student map(String values[]) {
        if (values == null || values.length == 0) {
            throw new RuntimeException("Invalid input values");
        }
        Integer id = null;
        String name = null;
        Integer marks = null;
        try {
            id = Integer.parseInt(values[0].trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid Student Id", e);
        }
        name = values[1].trim();
        try {
            marks = Integer.parseInt(values[2].trim());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid Marks", e);
        }
        Student student = new Student(id, name, marks);
        return student;
    }
}
