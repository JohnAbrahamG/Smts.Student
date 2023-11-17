package com.example.Smts.Student.Controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Smts.Student.Model.Student;
import com.example.Smts.Student.Repository.StudentRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/export")
    public void exportAllStudentsToExcel(HttpServletResponse response) throws IOException {
        List<Student> students = studentRepository.findAll();

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=students.xlsx");

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Students");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("name");
        headerRow.createCell(1).setCellValue("id");
        headerRow.createCell(2).setCellValue("age");


        // Populate data
        int rowNum = 1;
        for (Student student : students) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(student.getName());
            row.createCell(1).setCellValue(student.getId());
            row.createCell(2).setCellValue(student.getAge());

        }

        // Auto-size columns
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        workbook.write(response.getOutputStream());
        workbook.close();
    }
}

