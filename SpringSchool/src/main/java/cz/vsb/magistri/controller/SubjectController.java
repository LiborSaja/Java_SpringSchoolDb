package cz.vsb.magistri.controller;

import cz.vsb.magistri.DTO.SubjectDTO;
import cz.vsb.magistri.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping({"/subjects", "/subjects/"})
    public List<SubjectDTO> getSubjects() {
        return subjectService.getSubjects();
    }

    @GetMapping({"/subjects/{id}", "/subjects/{id}/"})
    public SubjectDTO getSubject(@PathVariable("id") Integer id) {
        return subjectService.getSubject(id);
    }

    @PostMapping({"/subjects", "/subjects/"})
    public SubjectDTO addSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.addSubject(subjectDTO);
    }

    @PutMapping({"/subjects", "/subjects/"})
    public SubjectDTO editSubject(@PathVariable Integer id, @RequestBody SubjectDTO subjectDTO) {
        return subjectService.editSubject(id, subjectDTO);
    }

    @DeleteMapping({"/subjects", "/subjects/"})
    public SubjectDTO deleteSubject(@PathVariable Integer id){
        return subjectService.deleteSubject(id);
    }
}
