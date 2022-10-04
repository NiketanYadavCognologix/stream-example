package org.example.model;

public class Student {
    private Integer id;
    private String name;
    private Integer marks;

    public Student(Integer id, String name, Integer marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(Integer marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        String placeHolder = "id: {0}, name: {1}, marks: {2}";
        return java.text.MessageFormat.format(placeHolder, id, name, marks);
    }
}
