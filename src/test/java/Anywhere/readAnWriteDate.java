package Anywhere;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

public class readAnWriteDate {

    // Method to read data from Excel sheet
    public List<Student> readDataFromExcel(String filePath) {
        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            // Iterate through each row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    // Assuming columns are: Name (String), Courses (String), Fee (String)
                    String name = row.getCell(0).getStringCellValue();
                    String courses = row.getCell(1).getStringCellValue();
                    String fee = row.getCell(2).getStringCellValue();

                    Student student = new Student(name, courses, fee);
                    students.add(student);
                }
            }

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }

        return students;
    }

    // Method to display data in console
    public void displayData(List<Student> students) {
        System.out.println("Name\tCourses\tFee");
        for (Student student : students) {
            System.out.println(student.getName() + "\t" + student.getCourses() + "\t" + student.getFee());
        }
    }

    public static void main(String[] args) {
        readAnWriteDate demo = new readAnWriteDate();
        String filePath = ".\\datafiles\\Students.xlsx"; // Replace with your actual file path

        List<Student> students = demo.readDataFromExcel(filePath);
        demo.displayData(students);
    }

    // Define Student class to hold student data
    private static class Student {
        private String name;
        private String courses;
        private String fee;

        public Student(String name, String courses, String fee) {
            this.name = name;
            this.courses = courses;
            this.fee = fee;
        }

        public String getName() {
            return name;
        }

        public String getCourses() {
            return courses;
        }

        public String getFee() {
            return fee;
        }
    }
}
