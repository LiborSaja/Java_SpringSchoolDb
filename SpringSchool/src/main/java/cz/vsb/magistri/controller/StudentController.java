package cz.vsb.magistri.controller;

import cz.vsb.magistri.DTO.StudentDTO;
import cz.vsb.magistri.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping({"/students", "/students/"})
    public List<StudentDTO> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping({"/students/{id}", "/students/{id}/"})
    public StudentDTO getStudent(@PathVariable("id") Integer id) {
        return studentService.getStudent(id);
    }

    @PostMapping({"/students", "/students/"})
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }

    @PutMapping({"/students/{id}", "/students/{id}/"})
    public StudentDTO editStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDTO) {
        return studentService.editStudent(id, studentDTO);
    }

    @DeleteMapping({"/students/{id}", "/students/{id}/"})
    public StudentDTO deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }
}
